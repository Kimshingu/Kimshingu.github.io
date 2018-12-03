<template>
  <div>
    <h2>구매자 정보</h2>
    <table class="table">
      <tbody>
        <tr>
          <th>주문자</th>
          <td>{{data.name}}</td>
        </tr>
        <tr>
          <th>휴대폰</th>
          <td>{{data.phone}}</td>
        </tr>
        <tr>
          <th>이메일</th>
          <td>{{data.email}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      data: null
    };
  },
  created() {
    this.data = JSON.parse(sessionStorage.getItem("user"));
  }
};
</script>

<style>
</style>
