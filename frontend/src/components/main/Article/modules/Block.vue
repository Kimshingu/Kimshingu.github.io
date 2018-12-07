<template>
  <div class="detail" @click="goDetail">
    <div class="text-center">
      <img :src="getImgUrl(prop.id)" alt width="200" height="200">
    </div>
    <div class="rdProductName">{{ModifProductName}}</div>
    <div class="rdProductPrice">{{localePrice}} 원</div>
  </div>
</template>

<script>
export default {
  methods: {
    goDetail() {
      sessionStorage.setItem("p_id", this.prop.id);
      this.$router.push("/product");
    },
    getImgUrl: function(id) {
      var images = require.context("../../../productimg/", false, /\.jpg$/);
      return images("./" + id + ".jpg");
    }
  },
  props: ["prop"],
  computed: {
    localePrice() {
      return Number(this.prop.price).toLocaleString("en");
    },

    ModifProductName() {
      if (this.prop.name.length >= 13) {
        return this.prop.name.slice(0, 12) + "...";
      } else {
        return this.prop.name;
      }
    }
  }
};
</script>

<style>
.detail {
  padding: 10px;
  margin-top: 10px;
  margin-left: 37px;
  width: 230px;
  height: 280px;
}

.rdProductName {
  margin: 5px;
  margin-left: 20px;
}

.rdProductPrice {
  margin: 5px;
  margin-left: 20px;
  font-weight: bold;
}
</style>
