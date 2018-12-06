<template lang="html">
<div class="block">
  <img @click="goDetail" :src="getImgUrl(data.id)" alt="" width="200" height="200">
      <li>{{localeCharge!='0'?localeCharge+' 원':'무료배송'}}</li>
      <li>{{data.name}}</li>
      <li>{{localePrice}} 원</li>
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
    goDetail: function() {
      sessionStorage.setItem("p_id", this.data.id);
      this.$router.push("/product");
    },
    getImgUrl: function(id) {
      var images = require.context("../../productimg/", false, /\.jpg$/);
      return images("./" + id + ".jpg");
    }
  },
  props: ["data"]
};
</script>

<style>
</style>
