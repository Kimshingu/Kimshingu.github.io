<template>
  <div>
    <h3>{{prop.name}}</h3>
    <ul>
      <li>{{prop.price}}</li>
      <li>{{prop.deliveryCharge}}</li>
      <!-- <li>{{prop.seller}}</li> -->
    </ul>
    <form @submit.prevent method="post">
      <b-form-select id="size" :options="sizeOp" class="mb-3"/>
      <b-form-select id="color" :options="colorOp" class="mb-3"/>

      <input type="number">
      <button class="btn btn-secondary">장바구니에 담기</button>
      <button class="btn btn-primary">바로구매</button>
    </form>
  </div>
</template>

<script>
export default {
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
</style>
