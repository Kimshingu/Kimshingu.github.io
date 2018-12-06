<template lang="html">
<div @click="goDetail" id="searchBlock">
  <div class="text-center">
  <img :src="getImgUrl(data.id)" alt="" width="200" height="200">
  </div>
      <li class="deliveryCharge">{{localeCharge!='0'?localeCharge+' 원':'무료배송'}}</li>
      <li>{{data.name}}</li>
      <li class="productPrice">{{localePrice}} 원</li>
</div>
</template>

<script>
export default {
  computed: {
    localePrice() {
      return Number(this.data.price).toLocaleString("en");
    },
    localeCharge() {
      return Number(this.data.deliveryCharge).toLocaleString("en");
    }
  },
  methods: {
    getImgUrl: function(id) {
      var images = require.context("../../productimg/", false, /\.jpg$/);
      return images("./" + id + ".jpg");
    },
    goDetail() {
      sessionStorage.setItem("p_id", this.data.id);
      this.$router.push("/product");
    }
  },
  props: ["data"]
};
</script>

<style>
#searchBlock {
  margin: 10px;
  margin-left: 30px;
  padding: 10px;
  width: 230px;
  height: 380px;
  border: 1px solid black;
}
#searchBlock li {
  list-style: none;
}
.productPrice {
  font-weight: bold;
  color: #963636;
}

.deliveryCharge {
  font-weight: bold;
  color: #5b9b86;
}
</style>
