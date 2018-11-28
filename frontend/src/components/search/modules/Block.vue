<template lang="html">
<div>
  <img src="https://via.placeholder.com/250x300" alt="">
    <ul>
      <li>{{prop.deliveryCharge}}</li>
      <li>{{prop.name}}</li>
      <li>{{prop.price}}</li>
    </ul>
</div>
</template>

<script>
export default {
  props: ["prop"]
};
</script>

<style lang="css">
</style>
