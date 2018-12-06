<template>
  <div>
    <form @submit.prevent="doPost" method="POST">
      <!-- 로고 -->
      <div class="row">
        <div class="col-5"></div>
        <div class="col-2">
          <logo></logo>
        </div>
        <div class="col-5"></div>
      </div>

      <!-- 아이디 -->
      <div class="row">
        <div class="col-3"></div>
        <div class="col-6">
          <div class="input-group">
            <div class="input-group-prepend">
              <label class="btn btn-outline-secondary" id="button-addon1" for="mailbox">
                <i class="far fa-envelope"></i>
              </label>
            </div>
            <input
              ref="email"
              id="mailbox"
              type="email"
              name="email"
              class="form-control"
              placeholder="아이디(E-Mail)"
              required
            >
          </div>
        </div>
        <div class="col-3"></div>
      </div>

      <!-- 비밀번호 -->
      <div class="row">
        <div class="col-3"></div>
        <div class="col-6">
          <div class="input-group">
            <div class="input-group-prepend">
              <label class="btn btn-outline-secondary" id="button-addon1" for="pwbox">
                <i class="fas fa-lock"></i>
              </label>
            </div>
            <input
              ref="password"
              id="pwbox"
              type="password"
              name="password"
              class="form-control"
              placeholder="비밀번호"
              required
            >
          </div>
        </div>
        <div class="col-3"></div>
      </div>

      <!-- 로그인 버튼 -->
      <div class="row">
        <div class="col-3"></div>
        <div class="col-6">
          <button type="submit" class="btn btn-color1 btn-block">로그인</button>
        </div>
        <div class="col-3"></div>
      </div>

      <!-- 폼 끝 -->
    </form>
    <div class="row">
      <div class="col-3"></div>
      <div class="col-6">
        <hr>
      </div>
      <div class="col-3"></div>
    </div>

    <!-- 회원가입 버튼 -->
    <div class="row">
      <div class="col-3"></div>
      <div class="col-6">
        <button @click="clickSignup" class="btn btn-color2 btn-block">회원가입</button>
      </div>
      <div class="col-3"></div>
    </div>

    <!-- 컨테이너 끝 -->
  </div>
</template>

<script>
import logo from "../etc/logo.vue";
export default {
  components: {
    logo: logo
  },
  methods: {
    doPost: function() {
      var self = this;
      // spring LoginController.java @PostMapping으로 입력한 email, password value를 전달한다.
      this.$http
        .post("/login", {
          email: self.$refs["email"].value,
          password: self.$refs["password"].value
        })
        .then(function(response) {
          sessionStorage.setItem("user", JSON.stringify(response.data));
          self.$router.push("/");
        })
        .catch(function(error) {
          alert('아이디, 비밀번호를 다시 확인해 주세요.');
          console.log(error);
        });
    },
    clickSignup: function() {
      this.$router.push("/signup");
    }
  }
};
</script>

<style>
.logo {
  margin: 10px;
  font-size: 2em;
  padding: 1.2em;
}

label i {
  width: 20px;
}

.form-control:focus {
  border-color: none;
  box-shadow: none;
  /* border-color: #FF0000; */
}
a {
  text-decoration: none;
}
a:hover {
  text-decoration: none;
}
.bg-color1 {
  background-color: #f2be54;
}
.btn-color1 {
  background-color: #4ec989;
}

.btn-color1:hover {
  background-color: #3d8e64;
}

.btn-color2 {
  background-color: #cdd4ca;
}

.btn-color2:hover {
  background-color: #999e97;
}

textarea:focus,
input:focus {
  outline: red;
}
</style>
