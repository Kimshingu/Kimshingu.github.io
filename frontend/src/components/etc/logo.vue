<template>
  <div id="logobox" class="text-center">
    <div id="logotxt" @click="goMain">수진스컴퍼니</div>
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
  font-family: "Gugi";
  font-size: 2.3rem;
  cursor: pointer;
  margin-top: 48px;
}
</style>
