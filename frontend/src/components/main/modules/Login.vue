<template>
  <div id="login">
    <div class="login text-center">
      <div v-if="!user" class="login">
        <router-link to="/login">로그인</router-link>
      </div>
      <div v-if="user" class="logout">
        <span class="name">{{user.name}}</span> 님
        <br>
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
    this.user = JSON.parse(sessionStorage.getItem("user"));
  }
};
</script>

<style>
.login,
.login a {
  margin-top: 80px;
  color: gray;
  font-size: 1.5rem;
}


.name {
  color: #3d8e64;
}

a:hover {
  cursor: pointer;
  text-decoration: none;
  color: black;
}
.logout{
}
.logout .btn{
  color:gray;
}

.logout .btn:hover{
  cursor: pointer;
  color: black;
}

</style>
