<template>
  <div id="nf" class="text-center">
    <!-- <logo ></logo> -->
    <img @click="goMain" src="./NotFound.jpg">
    <h1>404 Not Found</h1>
    <p>페이지가 존재 하지 않습니다. :&lt;</p>
  </div>
</template>

<script>
// import logo from "./logo.vue";
export default {
  // components: {
  //   logo: logo
  // }
 methods: {
      goMain() {
        this.$router.push("/");
      }
    }
};
</script>

<style scoped>
#nf {
  margin-top: 50px;
}
p {
  font-size: 2rem;
}
</style>
