<template>
  <div>
    <Carousel></Carousel>
    <div v-for="(product,index) in Products" :key="index" class="randomProducts">
      <Block :prop="product" class="randomProducts_c"></Block>
    </div>
  </div>
</template>

<script>
import Carousel from "./modules/Carousel";
import Block from "./modules/Block";
export default {
  data() {
    return {
      Products: null
    };
  },
  components: {
    Carousel: Carousel,
    Block: Block
  },
  created() {
    var self = this;
    this.$http
      .get("/getproduct")
      .then(function(response) {
        self.Products = response.data;
      })
      .catch(function(error) {
        console.log(error);
      });
  }
};
</script>

<style>
.randomProducts {
  float: left;
}
.randomProducts_c:hover {
  cursor: pointer;
  border: 1px solid #3d8e64;
}
</style>
