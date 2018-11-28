<template lang="html">
  <div class="">
    <Result></Result>
    <div v-for="block of result">
      <Block :prop="block"></Block>
    </div>
  </div>
</template>

<script>
import Result from "./modules/Result";
import Block from "./modules/Block";
export default {
  // methods:{
  //
  // },
  components: {
    Result: Result,
    Block: Block
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
