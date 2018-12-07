<template>
  <div id="login">
    <div class="login text-center">
      <div v-if="!user" class="login">
        <router-link to="/login" class="text-color1"><i class="fas fa-air-freshener"></i>&nbsp;로그인</router-link>
      </div>
      <div v-if="user" class="logout">
        <span class="name">{{user.name}}</span>님
        <br>
        <router-link to="/cart" class="txtCart">
          <i class="fas fa-shopping-cart"></i> 장바구니
        </router-link>
        <!--클릭시 sessionStorage에서 user 정보를 지우고, 새로고침을 한다. -->
        <div class="logout btn" @click="logout">로그아웃</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: null
    };
  },
  methods: {
    logout() {
      sessionStorage.removeItem("user");
      location.reload();
    }
  },
  created() {
    // data속성과 methods 속성이 정의되었기 때문에 값을 정의할 수 있다.
    // sessionStorage user 객체를 json객체 형식으로 만든다.
    this.user = JSON.parse(sessionStorage.getItem("user"));
  }
};
</script>

<style>
.login,

.login a {
  margin-top: 40px;
  margin-bottom: 30px;
  font-size: 1.5rem;
}

a:hover {
  cursor: pointer;
  text-decoration: none;
  color: #014014;
}
.name {
  color: #3d8e64;
  font-size: 1.5 rem;
}

.logout {
}
.logout .btn {
  color: black;
}

.logout a {
  color: #f20b04;
  font-size: 1.2rem;
}

.logout .btn:hover {
  cursor: pointer;
  color: black;
}

</style>
