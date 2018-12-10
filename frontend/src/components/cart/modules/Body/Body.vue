<template lang="html">
  <div v-if="prop" id="cartBody" >
<table class="table">
  <thead>
    <tr>
      <th>상품명</th>
      <th>상품가격</th>
      <th>배송비</th>
    </tr>
  </thead>

  <tbody>
    <tr v-for="(i,index) in prop.cart" :key="index">
      <td> <img :src="getImgUrl(prop.product[index].id)" alt="" width="50" height="50"  class="thumbnail">
           {{prop.product[index].name}}<br>
           색상: {{i.cart_color}} | 사이즈: {{i.cart_size}} |
           수량: <input name="cartCount" class="cartCount" type="number" v-model="i.cart_count" min="1" max="20">
      </td>
      <td>{{prop.product[index].price}} 원</td>
      <td>{{prop.product[index].deliveryCharge!='0'?prop.product[index].deliveryCharge+' 원':'무료배송'}}
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button @click="deleteCart(i)" class="btn btn-secondary">&times;</button>
      </td>

    </tr>
  </tbody>
</table>
</div>
</template>

<script>
export default {
  props: ["prop"],
  methods: {
    // spring CartController @DeleteMapping("/cart")
    // 해당 cart 정보를 삭제한 후 새로고침을 한다.
    deleteCart(cart) {
      var self = this;
      this.$http
        .delete("/cart", { data: cart })
        .then(function(response) {
          self.reload();
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    getImgUrl: function(id){
      var images = require.context("../../../productimg/", false, /\.jpg$/);
      return images("./" + id + ".jpg");
    },
    reload() {
      location.reload();
    }
  }
};
</script>

<style lang="css">
.thumbnail {
  margin-right: 1em;
}
.cartCount {
  width: 50px;
}
</style>
