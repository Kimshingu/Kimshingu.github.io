<template lang="html">
  <div class="">
    <cartHeader></cartHeader>

    <cartBody :prop="data"></cartBody>

    <cartFooter :prop="data"></cartFooter>
  </div>



</template>

<script>
import body from "./modules/Body/Body";
import footer from "./modules/Footer/Footer";
import header from "./modules/Header/Header";
export default {
  data() {
    return {
      data: null
    };
  },
  components: {
    cartHeader: header,
    cartBody: body,
    cartFooter: footer
  },
  created() {
    var self = this;
    this.$http
      .get("/cart?id=" + JSON.parse(sessionStorage.getItem("user")).email)
      .then(function(response) {
        for (let product of response.data.product) {
          product.price = self.localePrice(product.price);
        }

        self.data = response.data;
      })
      .catch(function(error) {
        console.log(error);
      });
  },
  methods: {
    localePrice(price) {
      return Number(price).toLocaleString("en");
    }
  }
};
</script>

<style lang="css">
</style>
