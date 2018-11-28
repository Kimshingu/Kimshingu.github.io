<template lang="html">
<div id="target">
    <img :src="getImage" alt="">
    <ul>
      <li>{{prop.deliveryCharge}}</li>
      <li>{{prop.name}}</li>
      <li>{{prop.price}}</li>
    </ul>
</div>
</template>

<script>

export default {
  methods:{
    getImage() {
      return '../../etc/product_img/'+prop.image;
    }
  },
  props:['prop']
}
</script>

<style lang="css">
</style>
