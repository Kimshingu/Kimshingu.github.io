<template>
  <div>
    <div id="main" class="align-middle">
      <Header></Header>
      <Article></Article>
      <Footer></Footer>
    </div>
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
  /* 테스트용 로그인
  ,
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
  */
};
</script>
<style>

@import url("https://fonts.googleapis.com/css?family=Nanum+Gothic");
.align-middle {
  font-family: 'Noto Serif KR', sans-serif;
	} 

</style>
