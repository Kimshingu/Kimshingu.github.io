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
    this.data = JSON.parse(sessionStorage.getItem("user"));
    this.$emit("receiver", this.data);
  }
};
</script>

<style>
</style>
