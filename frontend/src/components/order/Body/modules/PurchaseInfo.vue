<template>
  <div>
    <h2>결제정보</h2>
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
          <td>{{price}} 원</td>
          <td>{{charge!='0'?charge+' 원':'무료배송'}}</td>
          <td>{{total}} 원</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  props: ["prop"],
  computed: {
    price: function() {
      let result = 0;
      for (const product of this.prop) {
        let price = product.price;
        let count = product.hitcount;
        result += price * count;
      }

      return Number(result).toLocaleString("en");
    },
    charge: function() {
      let result = 0;
      for (const product of this.prop) {
        result += product.deliveryCharge;
      }

      return Number(result).toLocaleString("en");
    },
    total: function() {
      let result =
        Number(this.price.split(",").join("")) +
        Number(this.charge.split(",").join(""));

      return Number(result).toLocaleString("en");
    }
  },
  created() {
    let info = { price: this.price, charge: this.charge, total: this.total };
    sessionStorage.setItem("info", JSON.stringify(info));
  }
};
</script>

<style>
tbody {
  vertical-align :middle;
}
</style>
