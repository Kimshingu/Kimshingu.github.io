<template>

  <div id="product">
    <div v-if="product" class="row">
      <div class="col-5">
        <img :src="getImgUrl(product.id)" alt="" width="400" height="400">
      </div>
      <div class="col-7">
        <Detail :prop="product"></Detail>
      </div>
    </div>
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
  },
  methods:{
    getImgUrl: function(id) {
      var images = require.context("../productimg/", false, /\.jpg$/);
      return images("./" + id + ".jpg");
    }
  }
};
</script>


<style>
#product {
  margin-top: 30px;
}
</style>
