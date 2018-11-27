<template>
  <div id="main" class="align-middle">
    <div class="row">
      <div class="col-3">
        <logo></logo>
      </div>
      <div class="col-6">
        <Search></Search>
      </div>
      <div class="col-3">
        <Login></Login>
      </div>
    </div>
  </div>
</template>

<script>
import logo from "../etc/logo.vue";
import Search from "./modules/Search";
import Login from "./modules/Login";
export default {
  components: {
    logo: logo,
    Search: Search,
    Login: Login
  }
};
</script>

<style>
#main {
  background-color: #dae5de;
  margin-top: 40px;
}

</style>
