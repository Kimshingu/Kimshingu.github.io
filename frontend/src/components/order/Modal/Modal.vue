<template>
  <div>
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
      {{select}}
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
    this.data = JSON.parse(sessionStorage.getItem("user"));
    this.info = JSON.parse(sessionStorage.getItem("info"));
    this.select = JSON.parse(sessionStorage.getItem("select"));
    console.log(this.select);
  }
};
</script>

<style>
</style>
