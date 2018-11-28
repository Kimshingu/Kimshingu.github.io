<template lang="html">
<div>
  <img @click="goDetail" src="https://via.placeholder.com/250x300" alt="">
    <ul>
      <li>{{prop.deliveryCharge}}</li>
      <li>{{prop.name}}</li>
      <li>{{prop.price}}</li>
    </ul>
</div>
</template>

<script>
export default {
  methods: {
    goDetail() {
      sessionStorage.setItem("id", prop.id);
      this.$router.push("/product");
    }
  },
  props: ["prop"]
};
</script>

<style lang="css">
</style>
