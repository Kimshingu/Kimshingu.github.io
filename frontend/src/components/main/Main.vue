<template>
  <div>
    <div id="main" class="align-middle">
      <div class="row">
        <div class="col-12">
          <Header></Header>
        </div>
      </div>
      <div class="row">
        <div class="col-12">
          <Article></Article>
        </div>
      </div>
      <div class="row">
        <div class="col-12">
          <Footer></Footer>
        </div>
      </div>
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

  ,
  // 테스트용 아이디
  // created() {
  //   sessionStorage.setItem(
  //     "user",
  //     JSON.stringify({
  //       address: "aaa",
  //       email: "test@test.com",
  //       name: "Tom",
  //       password:
  //         "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4",
  //       phone: "1234"
  //     })
  //   );
  // }

};
</script>
<style>
@import url("https://fonts.googleapis.com/css?family=Nanum+Gothic");
.align-middle {
  font-family: "Noto Serif KR", sans-serif;
}
</style>
