<template lang="html">
  <div class="search">
    <Header></Header>
    <Result></Result>
    <div v-for="(block,index) of result" :key="index" class="searchblock">
          <!-- Block components에 data이름으로 block 객체를 바인드 한다. 상위 -> 하위컴포넌트 -->
          
           <Block v-bind:data="block" class="searchblock_c"></Block>
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
  ( 주소창에 변화가 있을경우에 watch를 실행 )
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
.search {
  font-size: 16px;
}
.searchblock {
  float: left;
}

.searchblock_c {
  cursor: pointer;
}

.searchblock_c:hover {
  box-shadow: 1px 1px 30px #bab8b8;
}
</style>
