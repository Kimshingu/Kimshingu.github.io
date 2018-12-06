<template lang="html">
  <div class="">
    <Header></Header>
    <Result></Result>
    <div v-for="block of result" >
      <!-- Block components에 data이름으로 block 객체를 바인드 한다. 상위 -> 하위컴포넌트 -->
      <Block v-bind:data="block"></Block>
    </div>
    <div v-if="result.length==0">
      검색결과가 없습니다.
    </div>
  </div>
</template>

<script>
import Header from "../main/Header/Header";
import Result from "./modules/Result";
import Block from "./modules/Block";
export default {
  components: {
    Result: Result,
    Block: Block,
    Header: Header
  },
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

<style lang="css">
</style>
