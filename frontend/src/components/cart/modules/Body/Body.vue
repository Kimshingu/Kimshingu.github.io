<template lang="html">
  <div id="cartBody" >
    <table class="table">
      <thead>
        <tr>
          <th>상품명</th>
          <th>상품가격</th>
          <th>배송비</th>
        </tr>
      </thead>
      <tbody>
        <div v-for="i of length">
        <tr>
          <td> <img src="https://via.placeholder.com/50x50" class="thumbnail"> {{prop.product[i].name}}</td>
          <td rowspan="2">{{prop.product[i].price}}</td>
          <td rowspan="2">{{prop.product[i].deliveryCharge}}</td>
        </tr>
        <tr>
          <td>색상: {{prop.cart[i].cart_color}}| 사이즈: {{prop.cart[i].cart_size}}| 수량:
          <span style="float:right">
          <input name="cartCount" class="cartCount" type="number" v-model="prop.cart[i].cart_count">
          <button class="btn btn-secondary">+</button>
          <button class="btn btn-secondary">-</button>
          <button class="btn btn-secondary">x</button>
          </span>
          </td>
        </tr>
        </div>
      </tbody>
    </table>
</div>
</template>

<script>
export default {
  props: ["prop"],
  computed: {
    length: function() {
      console.log("자식");

      let count = 0;
      for (const i of this.prop) {
        count++;
      }
      return count;
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
