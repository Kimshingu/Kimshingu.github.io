<template lang="html">
  <div class="">

    <logo class="text-center" id="logo"></logo>
    <h4><i class="fas fa-shopping-cart"></i> 장바구니</h4>
  </div>
</template>

<script>
import logo from "@/components/etc/logo.vue";
export default {
  components: {
    logo : logo
  }
}
</script>
<style lang="css">
  #logo{
    margin-bottom: 20px;
  }
</style>
