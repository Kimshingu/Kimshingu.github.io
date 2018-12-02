<template lang="html">
<div>
  <img @click="goDetail" src="https://via.placeholder.com/180x200" alt="">
      <li>{{data.deliveryCharge}}</li>
      <li>{{data.name}}</li>
      <li>{{localePrice}} 원</li>
</div>
</template>

<script>
export default {
  computed: {
    localePrice() {
      return Number(this.data.price).toLocaleString("en");
    }
  },
  methods: {
    goDetail: function() {
      sessionStorage.setItem("p_id", this.data.id);
      this.$router.push("/product");
    }
  },
  props: ["data"]
};
</script>

<style lang="css">
</style>
