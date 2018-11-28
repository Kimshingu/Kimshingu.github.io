<template>
  <div>
    <Detail :prop="product"></Detail>
  </div>
</template>

<script>
import Detail from "./modules/Detail";

export default {
  data() {
    return { product: null };
  },
  components: {
    Detail: Detail
  },
  created() {
    var self = this;
    this.$http
      .get("/product?id=" + sessionStorage.getItem("id"))
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
</style>
