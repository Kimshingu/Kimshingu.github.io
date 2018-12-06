<template lang="html">
  <div class="search">
    <!-- 아래에서 선언한것 에서 쓸려면 태그 형식으로 쓴다. -->
    <Header></Header>
    <Result></Result>
    <!-- result를 for문 할 것을 block에 딤겠다. -->
    <div v-for="block of result" class="searchblock">
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

<style>
.search {
  font-size: 16px;
}
.searchblock {
  float:left;
  padding-right: 50px;
  margin-bottom: 50px;
}
</style>
