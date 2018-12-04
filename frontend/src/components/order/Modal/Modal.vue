<template>
  <div v-if="select">
    <b-modal id="modal1" title="결제정보" hide-footer>
      <h3 class="text-left">구매자 정보</h3>
      <table class="table" v-if="data">
        <thead>
          <tr>
            <th>주문자</th>
            <th>휴대폰</th>
            <th>이메일</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{{data.name}}</td>
            <td>{{data.phone}}</td>
            <td>{{data.email}}</td>
          </tr>
        </tbody>
      </table>

      <h3 class="text-left">받는 사람 정보</h3>
      <table class="table" v-if="prop">
        <thead>
          <tr>
            <th>받는사람</th>
            <th>휴대폰</th>
            <th>주소</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{{prop.name}}</td>
            <td>{{prop.phone}}</td>
            <td>{{prop.address}}</td>
          </tr>
        </tbody>
      </table>

      <h3 class="text-left">결제정보</h3>
      <table class="table" v-if="info">
        <thead>
          <tr>
            <th>주문금액</th>
            <th>배송비</th>
            <th>결제 예정금액</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{{info.price}} 원</td>
            <td>{{info.charge!='0'?info.charge+' 원':'무료배송'}}</td>
            <td>{{info.total}} 원</td>
          </tr>
        </tbody>
      </table>

      <h3 class="text-left">결제방법 : {{select.radioSelected}}</h3>
      <table class="table" v-if="select.radioSelected=='card'">
        <thead>
          <tr>
            <th>종류</th>
            <th>할부기간</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{{select.cardSelected}}</td>
            <td>{{select.halbuSelected}}</td>
          </tr>
        </tbody>
      </table>

      <table class="table" v-if="select.radioSelected=='mutong'">
        <thead>
          <tr>
            <th>입금은행</th>
            <th>입금기한</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{{select.bankSelected}}</td>
            <td>{{select.date}}</td>
          </tr>
        </tbody>
      </table>

      <table class="table" v-if="select.radioSelected=='account'">
        <thead>
          <tr>
            <th>입금은행</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{{select.bankSelected}}</td>
          </tr>
        </tbody>
      </table>

      <table class="table" v-if="select.radioSelected=='phone'">
        <thead>
          <tr>
            <th>통신사 종류</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{{select.phoneSelected | uppercase}}</td>
          </tr>
        </tbody>
      </table>
    </b-modal>
  </div>
</template>

<script>
export default {
  props: ["prop"],
  data() {
    return {
      info: null,
      data: null,
      select: null
    };
  },
  created() {
    this.$bus.$on("method", data => {
      this.select = data;
    });
    this.data = JSON.parse(sessionStorage.getItem("user"));
    this.info = JSON.parse(sessionStorage.getItem("info"));
  },
  filters: {
    uppercase: function(v) {
      if (v) {
        return v.toUpperCase();
      }
    }
  }
};
</script>

<style>
</style>
