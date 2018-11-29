<template lang="html">
  <div id="cartBody" >
    <table class="table">
      <thead>
        <tr>
          <th>상품명</th>
          <th>상품금액</th>
          <th>배송비</th>
        </tr>
      </thead>
      <tbody v-for="i in 3">
        <tr>
          <td> <img src="https://via.placeholder.com/50x50" class="thumbnail"> 나이키1</td>
          <td rowspan="2">40000</td>
          <td rowspan="2">2500</td>
        </tr>
        <tr>
          <td>색상: Black| 사이즈: L| 수량:
          <span style="float:right">
          <input name="cartCount" class="cartCount" type="number" value="2">
          <button>+</button>
          <button>-</button>
          <button>x</button>
          </span>
          </td>
        </tr>
      </tbody>
    </table>
</div>
</template>

<script>
export default {
}
</script>

<style lang="css">
  .thumbnail {
    margin-right: 1em;
  }
  .cartCount {
    width: 50px;
  }
</style>
