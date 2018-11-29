<template>
  <div>
    <h3>{{prop.name}}</h3>
    <li>{{localePrice}} 원</li>
    <li>{{prop.deliveryCharge}}</li>
    <!-- <li>{{prop.seller}}</li> -->
    <form @submit.prevent method="post" class="form-group">
      <b-form-select value="null" id="size" :options="sizeOp" class="mb-3"/>
      <b-form-select value="null" id="color" :options="colorOp" class="mb-3"/>

      <b-form-input type="number" value="1"></b-form-input>
      <br>
      <button class="btn btn-secondary">장바구니에 담기</button>
      <button class="btn btn-primary">바로구매</button>
    </form>
  </div>
</template>

<script>
export default {
  computed: {
    localePrice() {
      return Number(this.prop.price).toLocaleString("en");
    }
  },
  data() {
    return {
      sizeOp: [
        { value: null, text: "사이즈" },
        { value: "S", text: "S" },
        { value: "M", text: "M" },
        { value: "L", text: "L" }
      ],
      colorOp: [
        { value: null, text: "색상" },
        { value: "charcoal", text: "챠콜" },
        { value: "black", text: "블랙" },
        { value: "white", text: "화이트" }
      ]
    };
  },
  props: ["prop"]
};
</script>

<style>
li {
  list-style: none;
}
</style>
