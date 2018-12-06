<template>
  <div id="search">
    <!--
    @submit.prevent="getResult" : form이 서버로 요청하면 "getResult"메소드가 작동
    .prevent : (데이터를 받아오고) 화면갱신 하지않는다.
    method="get" -> get방식 : 서버가 우리한테 줌
   -->
    <form @submit.prevent="getResult" method="get">
      <div class="input-group">
        <!-- ref = kwd : input박스의 입력값을 받아오기 위해 -->
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
      // this는 vue를 가르킨다. 즉 vue를 self로 부르겠다.
      var self = this;
      // this.$http : 라우터에 (index.js) axios 정의
      // axios : 동적으로 데이터를 가져오기 위한 라이브러리
      this.$http
      // 위에 input박스의 값을 URL로 보여줌
        .get("/search?kwd=" + self.$refs["kwd"].value)
        .then(function(response) {
          // response가 돌려받은 데이터를 문자열로 바꿔서 'result'로 저장
          sessionStorage.setItem("result", JSON.stringify(response.data));
          // 여기서는 밖에 있는 vue를 가르키지 못하기 때문에 self로 호출
          self.$router.push("/search?kwd=" + self.$refs["kwd"].value);
        })
        .catch(function(error) {
          console.log(error);
        });
      // 테스트용 로직
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
