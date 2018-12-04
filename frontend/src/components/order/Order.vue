<template>
  <div>
    <OrderHeader></OrderHeader>
    <OrderBody @receiver="getReceiver" :prop="data"></OrderBody>
    <OrderFooter :prop="receiver"></OrderFooter>
  </div>
</template>

<script>
import Header from "./Header/Header";
import Body from "./Body/Body";
import Footer from "./Footer/Footer";
export default {
  methods: {
    getReceiver: function(data) {
      this.receiver = data;
    }
  },
  data() {
    return {
      receiver: null,
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
