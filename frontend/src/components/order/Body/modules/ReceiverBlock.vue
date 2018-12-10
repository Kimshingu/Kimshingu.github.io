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
          <th>주소</th>
          <td>
            <input v-model="data.address" type="text">
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
    // 세션에 저장된 user 데이터를 data에 저장한다.
    this.data = JSON.parse(sessionStorage.getItem("user"));
    // 이벤트버스로  this.data를 receiver란 이름으로 방출한다.
    this.$emit("receiver", this.data);
  }
};
</script>

<style>
</style>
