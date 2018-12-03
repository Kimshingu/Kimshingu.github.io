<template>
  <div>
    <OrderHeader></OrderHeader>
    <OrderBody :prop="data"></OrderBody>
    <OrderFooter></OrderFooter>
  </div>
</template>

<script>
import Header from "./Header/Header";
import Body from "./Body/Body";
import Footer from "./Footer/Footer";
export default {
  data() {
    return {
      data: null
    };
  },
  components: {
    OrderHeader: Header,
    OrderBody: Body,
    OrderFooter: Footer
  },
  created() {
    this.data = JSON.parse(sessionStorage.getItem("order"));
    // sessionStorage.removeItem("order");
  }
};
</script>

<style>
</style>
