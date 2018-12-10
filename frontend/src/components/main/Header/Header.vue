<template>
  <div id="header">
    <div class="row">
      <div class="col-3">
        <logo></logo>
      </div>
      <div class="col-5">
        <Search></Search>
      </div>
      <div class="col-4">
        <Login></Login>
      </div>
    </div>
  </div>
</template>

<script>
import logo from "../../etc/logo";
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
#header{
  margin-bottom: 40px;
}
</style>
