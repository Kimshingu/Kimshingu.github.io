<template lang="html">
  <div class="">
    검색결과 : {{result.length}} 건
  </div>
</template>

<script>
export default {
  data() {
    return {
      result : null
    }
  },
  created() {
  this.result = JSON.parse(sessionStorage.getItem('result'));
  }
}
</script>

<style lang="css">
</style>
