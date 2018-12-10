<template>
  <div>
    <Carousel></Carousel>
    <div v-for="(product,index) in Products" :key="index" class="randomProducts">
      <!--하위 Block components에 product 데이터를 전달한다. -->
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

  // MainController에서 데이터를 가져온다.
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
