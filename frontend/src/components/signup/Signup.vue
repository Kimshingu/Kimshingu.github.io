<template>
  <div>
    <form @submit.prevent="doPost" method="post">
      <!-- 로고 -->
      <div class="row">
        <div class="col-4"></div>
        <div class="col-4">
          <logo></logo>
          <br>
        </div>
        <div class="col-4"></div>
      </div>

      <!-- 아이디 -->
      <div class="form-row">
        <div class="col-3"></div>
        <div class="col-6">
          <div class="input-group">
            <div class="input-group-prepend">
              <label ref="mlabel" class="btn btn-outline-secondary" for="mailbox">
                <i class="far fa-envelope"></i>
              </label>
            </div>
            <input
              @change="isValidAccount"
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
      <div class="form-row">
        <div class="col-3"></div>
        <div class="col-6">
          <div class="input-group">
            <div class="input-group-prepend">
              <label ref="pwlabel" id="pwlabel" class="btn btn-outline-secondary" for="pwbox">
                <i class="fas fa-lock"></i>
              </label>
            </div>
            <input
              @change="isValid"
              ref="pwbox"
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

      <!-- 비밀번호 확인 -->
      <div class="form-row">
        <div class="col-3"></div>
        <div class="col-6">
          <div id="target">
            <div class="input-group">
              <div class="input-group-prepend">
                <label
                  ref="pwlabel_c"
                  id="pwlabel_c"
                  class="btn btn-outline-secondary"
                  for="pwbox_c"
                >
                  <i class="fas fa-unlock"></i>
                </label>
              </div>
              <input
                @change="isValid"
                ref="pwbox_c"
                id="pwbox_c"
                type="password"
                name="password_c"
                class="form-control"
                placeholder="비밀번호 확인"
                required
              >
            </div>
          </div>
        </div>
        <div class="col-3"></div>
      </div>

      <!-- 이름 -->
      <div class="form-row">
        <div class="col-3"></div>
        <div class="col-6">
          <div class="input-group">
            <div class="input-group-prepend">
              <label class="btn btn-outline-secondary" for="namebox">
                <i class="fas fa-user"></i>
              </label>
            </div>
            <input
              ref="name"
              id="namebox"
              type="text"
              name="name"
              class="form-control"
              placeholder="이름"
              required
            >
          </div>
        </div>
        <div class="col-3"></div>
      </div>

      <!-- 전화번호 -->
      <div class="form-row">
        <div class="col-3"></div>
        <div class="col-6">
          <div class="input-group">
            <div class="input-group-prepend">
              <label class="btn btn-outline-secondary" for="phonebox">
                <i class="fas fa-mobile-alt"></i>
              </label>
            </div>
            <input
              ref="phone"
              id="phonebox"
              type="text"
              name="phone"
              class="form-control"
              placeholder="전화번호"
              required
            >
          </div>
        </div>
        <div class="col-3"></div>
      </div>

      <!-- 주소 -->
      <div class="form-row">
        <div class="col-3"></div>
        <div class="col-6">
          <div class="input-group">
            <div class="input-group-prepend">
              <label class="btn btn-outline-secondary" for="address">
                <i class="fas fa-map-marker-alt"></i>
              </label>
            </div>
            <input
              ref="address"
              id="address"
              type="text"
              name="address"
              class="form-control"
              placeholder="주소"
            >
          </div>
        </div>
        <div class="col-3"></div>
      </div>

      <!-- 폼 끝 / 가로 선 -->
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
          <button type="submit" class="btn btn-color1 btn-block">가입하기</button>
        </div>
        <div class="col-3"></div>
      </div>
    </form>

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
    isValid: function() {
      if (this.$refs["pwbox"].value == this.$refs["pwbox_c"].value) {
        this.$refs["pwbox"].className = "form-control is-valid";
        this.$refs["pwbox_c"].className = "form-control is-valid";
        this.$refs["pwlabel"].className = "btn btn-outline-success";
        this.$refs["pwlabel_c"].className = "btn btn-outline-success";
        return true;
      } else {
        this.$refs["pwbox"].className = "form-control is-invalid";
        this.$refs["pwbox_c"].className = "form-control is-invalid";
        this.$refs["pwlabel"].className = "btn btn-outline-danger";
        this.$refs["pwlabel_c"].className = "btn btn-outline-danger";
        return false;
      }
    },
    doPost: function() {
      var self = this;

      if (
        this.$refs["pwbox"].className.includes("is-valid") &&
        this.$refs["pwbox_c"].className.includes("is-valid") &&
        this.$refs["email"].className.includes("is-valid")
      ) {
        this.$http
          .post("/signup", {
            email: self.$refs["email"].value,
            password: self.$refs["pwbox"].value,
            name: self.$refs["name"].value,
            phone: self.$refs["phone"].value,
            address: self.$refs["address"].value
          })
          .then(function(response) {
            self.$router.push("/login");
          })
          .catch(function(error) {
            console.log(error);
          });
      } else {
        alert("정보를 제대로 입력했는지 확인 해 주십시오.");
      }
    },
    isValidAccount() {
      var self = this;
      this.$http
        .get("/signup?email=" + this.$refs["email"].value)
        .then(function(response) {
          self.$refs["email"].className = "form-control is-valid";
          self.$refs["mlabel"].className = "btn btn-outline-success";
        })
        .catch(function(error) {
          self.$refs["email"].className = "form-control is-invalid";
          self.$refs["mlabel"].className = "btn btn-outline-danger";
        });
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
</style>
