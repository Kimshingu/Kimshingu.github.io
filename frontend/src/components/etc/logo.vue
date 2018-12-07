<template>
  <div class="text-center" id="test">
    <span id="logotxt" @click="goMain"> 수진스컴퍼니</span>
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
#logotxt {
 font-family: 'Gugi';
 font-size: 2.3rem;
 cursor: pointer;
}
#test{
  margin-top: 50px;
}
</style>
