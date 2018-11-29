<template lang="html">
<div>
  <img @click="goDetail" src="@/components/etc/250x300.png" alt="">
    <ul>
      <li>{{data.deliveryCharge}}</li>
      <li>{{data.name}}</li>
      <li>{{data.price}}</li>
    </ul>
</div>
</template>

<script>
export default {
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
