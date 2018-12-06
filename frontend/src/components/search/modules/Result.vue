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
  /*
  동일한 컴포넌트의 params 변경 사항에 반응하려면 $route 객체를 보면된다.
     watch: {
       '$route' (to, from) {
         // 경로 변경에 반응하여...
       }
     }
  */
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
