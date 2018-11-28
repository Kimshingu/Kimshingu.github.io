<template>
  <div id="search">
    <form @submit.prevent="getResult" method="get">
      <div class="input-group">
        <input ref="kwd" type="text" name="kwd" class="form-control">
        <div class="input-group-append">
          <button class="btn" type="submit" id="btn_search">
            <i class="fas fa-search"></i>
          </button>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  methods:{
    getResult() {
      var self = this;
      this.$http.get('/search?kwd='+self.$refs['kwd'].value)
  .then(function (response) {
      sessionStorage.setItem('result', JSON.stringify(response.data));
      self.$router.push('/search');
  })
  .catch(function (error) {
    console.log(error);
  });
    }
  }
};
</script>

<style scoped>
#btn_search {
  background-color: #cdd4ca;
}

input:focus {
  outline: none;
}
#search{
  margin-top: 80px;
}
</style>
