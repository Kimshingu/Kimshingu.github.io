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
  methods: {
    getResult() {
      var self = this;
      this.$http
        .get("/search?kwd=" + self.$refs["kwd"].value)
        .then(function(response) {
          sessionStorage.setItem("result", JSON.stringify(response.data));
          self.$router.push("/search?kwd=" + self.$refs["kwd"].value);
        })
        .catch(function(error) {
          console.log(error);
        });
      // var response = {
      //   data: {
      //     color: null,
      //     deliveryCharge: "무료 배송",
      //     detail: "보기",
      //     hitcount: 0,
      //     id: 1,
      //     image: "ho1.jpg",
      //     name: "나이키",
      //     price: 100000,
      //     size: ""
      //   }
      // };
      // sessionStorage.setItem("result", JSON.stringify(response));
      // this.$router.push("/search");
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
#search {
  margin-top: 80px;
}
</style>
