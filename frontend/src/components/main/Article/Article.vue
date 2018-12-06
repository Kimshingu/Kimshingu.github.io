<template>
<div>
  <Carousel></Carousel>
  <div class="row">
    <div class="col-3">
      <Block></Block>
    </div>
    <div class="col-3">
      <Block></Block>
    </div>
    <div class="col-3">
      <Block></Block>
    </div>
    <div class="col-3">
      <Block></Block>
    </div>
  </div>
</div>
</template>

<script>
import Carousel from "./modules/Carousel";
import Block from "./modules/Block";
export default {
  components: {
    Carousel: Carousel,
    Block: Block
  }
};
</script>

<style>
</style>
