<template>
  <div id="orderFooter" class="text-center">
    <Button id="buyButton" type="button" class="btn btn-color1" v-b-modal.modal1>결제하기</Button>
    <div v-if="isSelected">
      <Modal :prop="prop"></Modal>
    </div>
  </div>
</template>

<script>
import Modal from "../Modal/Modal";
export default {
  data() {
    return {
      Selected: null
    };
  },
  props: ["prop"],
  components: {
    Modal: Modal
  },
  methods: {
    isSelected() {
      if (this.Selected.radioSelected == "card") {
        if (this.Selected.cardSelected) {
          return true;
        } else {
          return false;
        }
      } else if (this.Selected.radioSelected == "mutong") {
        if (this.Selected.bankSelected) {
          return true;
        } else {
          return false;
        }
      } else if (this.Selected.radioSelected == "account") {
        if (this.Selected.bankSelected) {
          return true;
        } else {
          return false;
        }
      } else if (this.Selected.radioSelected == "phone") {
        if (this.Selected.phoneSelected) {
          return true;
        } else {
          return false;
        }
      }
    }
  },
  created() {
    this.$bus.$on("method", data => {
      this.Selected = data;
    });
  }
};
</script>

<style>
.btn-color1 {
  background-color: #4ec989;
}

.btn-color1:hover {
  background-color: #3d8e64;
}
#orderFooter {
  margin-top: 40px;
  margin-bottom: 50px;
}
#buyButton {
  width: 500px;
}
</style>
