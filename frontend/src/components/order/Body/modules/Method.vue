<template>
  <div>
    <h2>결제방법</h2>
    <!--라디오 버튼 생성 신용카드, 무통장입금, 실시간 계좌이체, 휴대폰결제-->
    <div id="radio">
      <b-form-radio-group v-model="radioSelected" name="method" class="radio">
        <div class="row">
          <div class="col-3">
            <b-form-radio value="card">신용카드</b-form-radio>
          </div>
          <div class="col-3">
            <b-form-radio value="mutong">무통장입금</b-form-radio>
          </div>
          <div class="col-3">
            <b-form-radio value="account">실시간 계좌이체</b-form-radio>
          </div>
          <div class="col-3">
            <b-form-radio value="phone">휴대폰결제</b-form-radio>
          </div>
        </div>
      </b-form-radio-group>
    </div>

    <!-- 해당 radio 버튼을 선택할 경우에 나오는 table-->
    <table class="table" id="methodTable">
      <tbody v-if="radioSelected=='card'">
        <tr>
          <th>
            <label for="card">카드종류</label>
          </th>
          <td>
            <b-form-select id="card" v-model="cardSelected" :options="cardOptions" class="mb-3"/>
          </td>
        </tr>
        <tr>
          <th>
            <label for="halbu">할부기간</label>
          </th>
          <td>
            <b-form-select id="halbu" v-model="halbuSelected" :options="halbuOptions" class="mb-3"/>
          </td>
        </tr>
      </tbody>
      <tbody v-if="radioSelected=='mutong'">
        <tr>
          <th>
            <label for="bank">입금은행</label>
          </th>
          <td>
            <b-form-select id="bank" v-model="bankSelected" :options="bankOptions" class="mb-3"/>
          </td>
        </tr>
        <tr>
          <th>
            <label>입금기한</label>
          </th>
          <td>
            <span>{{date}}</span>
          </td>
        </tr>
      </tbody>
      <tbody v-if="radioSelected=='account'">
        <tr>
          <th>
            <label>은행선택</label>
          </th>
          <td>
            <b-form-select id="bank" v-model="bankSelected" :options="bankOptions" class="mb-3"/>
          </td>
        </tr>
      </tbody>
      <tbody v-if="radioSelected=='phone'">
        <tr>
          <th>
            <label>통신사 종류</label>
          </th>
          <td>
            <b-form-select id="phone" v-model="phoneSelected" :options="phoneOptions" class="mb-3"/>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import moment from "moment";
export default {
  data() {
    return {
      date: null,
      radioSelected: "card",
      cardSelected: null,
      halbuSelected: "All",
      bankSelected: null,
      phoneSelected: null,

      cardOptions: [
        { value: null, text: "선택" },
        { value: "shinhan", text: "신한카드" },
        { value: "samsung", text: "삼성카드" },
        { value: "hyundai", text: "현대카드" },
        { value: "lotte", text: "롯데카드" }
      ],
      halbuOptions: [
        { value: "All", text: "일시불" },
        { value: 2, text: "2개월(무이자)" },
        { value: 4, text: "4개월(무이자)" },
        { value: 6, text: "6개월" },
        { value: 8, text: "8개월" },
        { value: 10, text: "10개월" },
        { value: 12, text: "12개월" }
      ],
      bankOptions: [
        { value: null, text: "선택" },
        { value: "shinhan", text: "신한은행" },
        { value: "kb", text: "국민은행" },
        { value: "nh", text: "농협은행" },
        { value: "woori", text: "우리은행" },
        { value: "hana", text: "하나은행" },
        { value: "ibk", text: "기업은행" }
      ],
      phoneOptions: [
        { value: null, text: "선택" },
        { value: "skt", text: "SKT" },
        { value: "kt", text: "KT" },
        { value: "lg", text: "LG" }
      ]
    };
  },
  created() {
    // 초기값:: 변화가 없을 시 this.radioSelected를 method란 이름으로 방출한다.
    this.$bus.$emit("method", this.radioSelected);
    // 현재 시각을 가져와서 1일을 더한다.
    this.date = moment()
      .add(1, "days")
      .format("YYYY[년] MM[월] Do h[시] mm[분 까지]");
  },
  watch: {
    // 해당 데이터변화를 감지하여 함수를 실행한다.
    // 변화가 있을 시 select를 method란 이름으로 방출한다.
    radioSelected: function() {
      let select = {
        radioSelected: this.radioSelected,
        cardSelected: this.cardSelected,
        halbuSelected: this.halbuSelected,
        bankSelected: this.bankSelected,
        phoneSelected: this.phoneSelected
      };
      this.$bus.$emit("method", select);
    },
    cardSelected: function() {
      let select = {
        radioSelected: this.radioSelected,
        cardSelected: this.cardSelected,
        halbuSelected: this.halbuSelected,
        bankSelected: this.bankSelected,
        phoneSelected: this.phoneSelected
      };
      this.$bus.$emit("method", select);
    },
    halbuSelected: function() {
      let select = {
        radioSelected: this.radioSelected,
        cardSelected: this.cardSelected,
        halbuSelected: this.halbuSelected,
        bankSelected: this.bankSelected,
        phoneSelected: this.phoneSelected
      };
      this.$bus.$emit("method", select);
    },
    bankSelected: function() {
      let select = {
        radioSelected: this.radioSelected,
        cardSelected: this.cardSelected,
        halbuSelected: this.halbuSelected,
        bankSelected: this.bankSelected,
        phoneSelected: this.phoneSelected,
        // 입금기한
        date: this.date
      };
      this.$bus.$emit("method", select);
    },
    phoneSelected: function() {
      let select = {
        radioSelected: this.radioSelected,
        cardSelected: this.cardSelected,
        halbuSelected: this.halbuSelected,
        bankSelected: this.bankSelected,
        phoneSelected: this.phoneSelected
      };
      this.$bus.$emit("method", select);
    }
  }
};
</script>

<style>
#radio {
  margin: 30px;
}

.custom-control-input:checked ~ .custom-control-label::before {
  background-color: #bf1011;
}

.custom-radio .custom-control-input:checked ~ .custom-control-label::before {
  background-color: #bf1011;
}
</style>
