<template>
  <div>
    <img @click="goMain" src="./logo.png" alt="">
  </div>
</template>

<script>
export default {
  methods: {
    goMain() {
      this.$router.push("/");
    }
  }
};
</script>

<style>
img {
  cursor: pointer;
}
</style>
