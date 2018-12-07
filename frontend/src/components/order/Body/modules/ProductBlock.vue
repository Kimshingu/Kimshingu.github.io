<template>
  <div v-if="prop">
    <table class="table">
      <thead>
        <tr>
          <th colspan="2" class="text-center">상품정보</th>
          <th>수량</th>
          <th>배송비</th>
          <th>가격</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(i,index) in prop" :key="index">
          <td>
          <img :src="getImgUrl(i.id)" alt="" width="180" height="150">
          </td>
          <td>{{i.name}} | {{i.size}} | {{i.color}}</td>
          <td>{{i.hitcount}}</td>
          <td>{{charge(i)!='0'?charge(i)+' 원':'무료배송'}}</td>
          <td>{{price(i)}} 원</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  methods: {
    charge: function(context) {
      return Number(context.deliveryCharge).toLocaleString("en");
    },
    price: function(context) {
      return Number(context.price).toLocaleString("en");
    },
    getImgUrl: function(id){
      var images = require.context("../../../productimg", false, /\.jpg$/);
      return images("./"+id+".jpg");
    }

  },
  props: ["prop"]
};
</script>

<style>
</style>
