<template>
  <div>
    <h2>결제방법</h2>
    <table class="table">
      <thead>
        <b-form-group>
          <tr>
            <b-form-radio-group v-model="selected" name="method">
              <th>
                <b-form-radio value="card">신용카드</b-form-radio>
              </th>
              <th>
                <b-form-radio value="mutong">무통장입금</b-form-radio>
              </th>
              <th>
                <b-form-radio value="account">실시간 계좌이체</b-form-radio>
              </th>
              <th>
                <b-form-radio value="phone">휴대폰결제</b-form-radio>
              </th>
            </b-form-radio-group>
          </tr>
        </b-form-group>
      </thead>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selected: "card"
      // options: [
      //   { text: "신용카드", value: "card" },
      //   { text: "무통장입금", value: "mutong" },
      //   { text: "실시간 계좌이체", value: "account" },
      //   { text: "휴대폰결제", value: "phone" }
      // ]
    };
  }
};
</script>

<style>
</style>
