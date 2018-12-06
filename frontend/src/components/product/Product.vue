<template>

  <div id="product">
    <img src="https://via.placeholder.com/200x200" alt="">
    <Detail :prop="product"></Detail>
  </div>
</template>

<script>
import Detail from "./modules/Detail";

export default {
  data() {
    return {
      product: null
    };
  },
  components: {
    Detail: Detail
  },
  created() {
    var self = this;
    this.$http
      .get("/product?id=" + sessionStorage.getItem("p_id"))
      .then(function(response) {
        self.product = response.data;
      })
      .catch(function(error) {
        console.log(error);
      });
  }
};
</script>


<style>
#product {
  margin-top: 30px;
}
</style>
