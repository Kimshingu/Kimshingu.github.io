<template lang="html">
  <div id="result">
    검색결과 : {{result.length}} 건
  </div>
</template>

<script>
export default {
  data() {
    return {
      result: null
    };
  },
  watch: {
    $route(to, from) {
      this.result = JSON.parse(sessionStorage.getItem("result"));
    }
  },
  created() {
    this.result = JSON.parse(sessionStorage.getItem("result"));
  }
};
</script>

<style>
#result {
  margin-top: 30px;
  margin-bottom: 50px;
  font-size: 20px;
}
</style>
