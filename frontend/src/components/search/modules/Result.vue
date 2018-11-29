<template lang="html">
  <div>
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

<style lang="css">
</style>
