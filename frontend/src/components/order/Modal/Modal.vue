<template>
  <div v-if="select">
    <b-modal id="modal1" title="결제정보" hide-footer>
      <h3 class="text-left">상품정보</h3>
      <hr>
      <div class="row">
        <div class="col-4">
          <img :src="getImgUrl(product[0].id)" alt width="100" height="100">
        </div>
        <div class="col-8">{{productView}}</div>
      </div>
      <hr>
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

      <h3 class="text-left">결제방법 : {{methodView}}</h3>

      <table class="table" v-if="select.radioSelected=='card'">
        <thead>
          <tr>
            <th>종류</th>
            <th>할부기간</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{{cardView}}</td>
            <td>{{halbuView}}</td>
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
            <td>{{bankView}}</td>
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
            <td>{{bankView}}</td>
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
      select: null,
      product: null
    };
  },
  created() {
    // 세션에 저장된 order 객체를 this.product에 저장한다.
    this.product = JSON.parse(sessionStorage.getItem("order"));

    // 세션에 저장된 user 객체를 this.data 저장한다.
    this.data = JSON.parse(sessionStorage.getItem("user"));

    // 세션에 저장된 info 객체를 this.info 저장한다.
    this.info = JSON.parse(sessionStorage.getItem("info"));

    // Method.vue의 select 데이터를 가져와서 Selected에 저장한다.
    this.$bus.$on("method", data => {
      this.select = data;
    });
  },

  filters: {
    uppercase: function(v) {
      if (v) {
        return v.toUpperCase();
      }
    }
  },

  computed: {
    methodView: function() {
      let result = "";
      switch (this.select.radioSelected) {
        case "card":
          result = "신용카드";
          break;
        case "mutong":
          result = "무통장입금";
          break;
        case "account":
          result = "실시간 계좌이체";
          break;
        case "phone":
          result = "휴대폰결제";
          break;
        default:
          break;
      }
      return result;
    },
    cardView: function() {
      let result = "";
      switch (this.select.cardSelected) {
        case "shinhan":
          result = "신한카드";
          break;
        case "samsung":
          result = "삼성카드";
          break;
        case "hyundai":
          result = "현대카드";
          break;
        case "lotte":
          result = "롯데카드";
          break;
        default:
          break;
      }
      return result;
    },
    bankView: function() {
      let result = "";
      switch (this.select.bankSelected) {
        case "shinhan":
          result = "신한은행";
          break;
        case "kb":
          result = "국민은행";
          break;
        case "nh":
          result = "농협은행";
          break;
        case "woori":
          result = "우리은행";
          break;
        case "hana":
          result = "하나은행";
          break;
        case "ibk":
          result = "기업은행";
          break;
        default:
          break;
      }
      return result;
    },
    halbuView: function() {
      let result = "";
      switch (this.select.halbuSelected) {
        case "All":
          result = "일시불";
          break;
        case 2:
          result = "2개월(무이자)";
          break;
        case 4:
          result = "4개월(무이자)";
          break;
        case 6:
          result = "6개월";
          break;
        case 8:
          result = "8개월";
          break;
        case 10:
          result = "10개월";
          break;
        case 12:
          result = "12개월";
          break;
        default:
          break;
      }
      return result;
    },

    // 여러 건을 구매할 경우 '외 #건' 으로 표기한다.
    productView: function() {
      if (this.product.length > 1) {
        return `${this.product[0].name} | ${this.product[0].size} | ${
          this.product[0].color
        } 외 ${this.product.length - 1}건`;
      } else {
        return `${this.product[0].name} | ${this.product[0].size} | ${
          this.product[0].color
        }`;
      }
    }
  },
  methods: {
    getImgUrl: function(id) {
      var images = require.context("../../productimg", false, /\.jpg$/);
      return images("./" + id + ".jpg");
    }
  }
};
</script>

<style>
.modal-header {
  color: white;
  background-color: #bf1011;
}
</style>
