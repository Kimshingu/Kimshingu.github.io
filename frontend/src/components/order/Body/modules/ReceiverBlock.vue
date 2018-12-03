<template>
  <div v-if="data">
    <h2>받는사람 정보</h2>
    <table class="table">
      <tbody>
        <tr>
          <th>주문자</th>
          <td>
            <input v-model="data.name" type="text">
          </td>
        </tr>
        <tr>
          <th>휴대폰</th>
          <td>
            <input v-model="data.phone" type="text">
          </td>
        </tr>
        <tr>
          <th>이메일</th>
          <td>
            <input v-model="data.email" type="text">
          </td>
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
