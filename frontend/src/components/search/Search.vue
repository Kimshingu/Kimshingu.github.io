<template lang="html">
  <div class="">
    <Header></Header>
    <Result></Result>
    <div v-for="block of result" >
      <Block :data="block"></Block>
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
