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
  }
};
</script>

<style>
</style>
