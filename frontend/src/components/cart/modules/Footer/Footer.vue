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
          <td v-if="this.prop.product.length>0">{{totalDelivery!='0'?totalDelivery+' 원':'무료배송'}}</td>
          <td v-else></td>
          <td>{{totalResult}} 원</td>
        </tr>
      </tbody>
    </table>
    <div class="text-center">
      <button @click="goIndex" type="button" class="btn btn-color2">계속 쇼핑하기</button>
      <button v-if="prop.cart.length!==0" @click="goOrder" type="button" class="btn btn-color1">주문하기</button>
      </div>  
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

    totalDelivery: function() {
      let charge = 0;

      for (let index = 0; index < this.prop.product.length; index++) {
        const product = this.prop.product[index];
        charge += Number(product.deliveryCharge.split(",").join(""));
      }
      return this.localize(charge);
    },

    totalResult: function() {
      let price = 0;
      let charge = 0;
      for (let index = 0; index < this.prop.cart.length; index++) {
        const cart = this.prop.cart[index];
        const product = this.prop.product[index];
        price += Number(product.price.split(",").join("")) * cart.cart_count;
      }

      for (const product of this.prop.product) {
        charge += Number(product.deliveryCharge.split(",").join(""));
      }
      let result = price + charge;
      return this.localize(result);
    }
  },
  methods: {
    localize(money) {
      return Number(money).toLocaleString("en");
    },
    goIndex() {
      this.$router.push("/");
    },
    goOrder() {
      for (let index = 0; index < this.prop.cart.length; index++) {
        this.prop.product[index].size = this.prop.cart[index].cart_size;
        this.prop.product[index].color = this.prop.cart[index].cart_color;
        this.prop.product[index].hitcount = this.prop.cart[index].cart_count;

        this.prop.product[index].price = Number(
          this.prop.product[index].price.split(",").join("")
        );
        this.prop.product[index].deliveryCharge = Number(
          this.prop.product[index].deliveryCharge.split(",").join("")
        );
      }

      sessionStorage.setItem("order", JSON.stringify(this.prop.product));
      this.$router.push("/order");
    }
  }
};
</script>

<style lang="css">
</style>
