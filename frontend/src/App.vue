<template>
  <div id="app">
    <div class="container">
      <!--라우터 뷰를 사용한다.-->
      <router-view/>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
::selection {
  color: white;
  background-color: #bf1011;
}
.bg-color1 {
  background-color: #06591e;
}
.text-color1 {
  color: #06591e;
}
.bg-color2 {
  background-color: #014014;
}
.bg-color3 {
  background-color: #efeadd;
}
.bg-color4 {
  background-color: #8c0803;
}
.bg-color5 {
  background-color: #bf1011;
}

.btn-color1 {
  color: white;
  background-color: #bf1011;
}
.btn-color1:hover {
  background-color: #8c0803;
}

.btn-color2 {
  background-color: #cdd4ca;
}

.btn-color2:hover {
  background-color: #999e97;
}
</style>
