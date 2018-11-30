<template>
  <div>
    <h3>{{prop.name}}</h3>
    <li>{{localePrice}} 원</li>
    <li>{{prop.deliveryCharge}}</li>
    <!-- <li>{{prop.seller}}</li> -->
    <form method="post" class="form-group">
      <b-form-select v-model="selectedSize" value="null" id="size" :options="sizeOp" class="mb-3"/>
      <b-form-select
        v-model="selectedColor"
        value="null"
        id="color"
        :options="colorOp"
        class="mb-3"
      />

      <b-form-input v-model="selectedCount" type="number"></b-form-input>
      <br>
      <button @click="goCart" type="button" class="btn btn-secondary">장바구니에 담기</button>
      <button @click="goOrder" type="button" class="btn btn-primary">바로구매</button>
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
      selectedCount: null,
      selectedSize: null,
      selectedColor: null,
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
  methods: {
    goCart() {
      var self = this;
      if (sessionStorage.getItem("user") === null) {
        this.$router.push("/login");
      }
      this.$http
        .post("/cart", {
          user_email: JSON.parse(sessionStorage.getItem("user")).email,
          product_id: self.prop.id,
          cart_size: self.selectedSize,
          cart_color: self.selectedColor,
          cart_count: Number(self.selectedCount)
        })
        .then(function(response) {
          self.$router.push("/cart");
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    goOrder() {
      var self = this;
      this.$http
        .post("/order", {
          email: self.$refs["email"].value,
          password: self.$refs["password"].value
        })
        .then(function(response) {
          sessionStorage.setItem(
            "user",
            JSON.stringify({ name: response.data.name })
          );
          self.$router.push("/");
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  },
  props: ["prop"]
};
</script>

<style>
li {
  list-style: none;
}
</style>
