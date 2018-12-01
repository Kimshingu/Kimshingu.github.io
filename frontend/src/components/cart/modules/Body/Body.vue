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
    <tr v-for="(i,index) in prop.cart" :key="index">
      <td> <img src="https://via.placeholder.com/50x50" class="thumbnail"> {{prop.product[index].name}}<br> 색상: {{i.cart_color}}| 사이즈: {{i.cart_size}}| 수량:
        <input name="cartCount" class="cartCount" type="number" v-model="i.cart_count"></td>
      <td>{{prop.product[index].price}}</td>
      <td>{{prop.product[index].deliveryCharge}} &nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-secondary">&times;</button></td>
    </tr>
  </tbody>
</table>

</div>
</template>

<script>
export default {
  props: ["prop"]
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
