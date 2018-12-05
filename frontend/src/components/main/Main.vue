<template>
  <div>
    <div id="main" class="align-middle">
      <Header></Header>
    </div>
    <Article></Article>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "./Header/Header";
import Article from "./Article/Article";
import Footer from "./Footer/Footer";
export default {
  components: {
    Header: Header,
    Article: Article,
    Footer: Footer
  },
  created() {
    sessionStorage.setItem(
      "user",
      JSON.stringify({
        address: "aaa",
        email: "test@test.com",
        name: "Tom",
        password:
          "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4",
        phone: "1234"
      })
    );
  }
};
</script>

<style>

</style>
