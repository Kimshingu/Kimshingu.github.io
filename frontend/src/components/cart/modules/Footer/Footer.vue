<template lang="html">
  <div v-if="prop">
    <table class="table">
      <thead>
        <tr>
          <th>주문금액</th>
          <th>배송비</th>
          <th>결제 예정금액</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>{{totalPrice}} 원</td>
          <td>무료배송</td>
          <td>{{totalPrice}} 원</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  props: ["prop"],
  computed: {
    totalPrice: function() {
      let price = 0;
      for (let index = 0; index < this.prop.cart.length; index++) {
        const cart = this.prop.cart[index];
        const product = this.prop.product[index];
        price += Number(product.price.split(",").join("")) * cart.cart_count;
      }
      return this.localize(price);
    },
    totalDelivery: function() {},
    totalResult: function() {}
  },
  methods: {
    localize(money) {
      return Number(money).toLocaleString("en");
    }
  }
};
</script>

<style lang="css">
</style>
