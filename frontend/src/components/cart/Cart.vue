<template lang="html">
  <div class="">
    <cartHeader></cartHeader>
    <!-- 하위 컴포넌트인 cartBody, cartFooter로 data인 데이터를 전달한다. -->
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
  // spring CartController @GetMapping("/cart")
	// public Object getCart(@RequestParam(value="id") String user_email) 데이터를 가져온다.
  created() {
    var self = this;
    this.$http
      .get("/cart?id=" + JSON.parse(sessionStorage.getItem("user")).email)
      .then(function(response) {
        for (let product of response.data.product) {
          product.price = self.localePrice(product.price);
          product.deliveryCharge = self.localePrice(product.deliveryCharge);
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
