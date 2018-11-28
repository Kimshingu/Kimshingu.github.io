<template lang="html">
  <div class="">
    <Header></Header>
    <Result></Result>
    <div v-for="block of result">
      <Block :prop="block"></Block>
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
  // methods:{
  //
  // },
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
  created() {
    this.result = JSON.parse(sessionStorage.getItem("result"));
  }
};
</script>

<style lang="css">
</style>
