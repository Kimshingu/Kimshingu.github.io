<template>
  <div id="orderFooter" class="text-center">
    <Button
      v-if="isSelected"
      id="buyButton"
      type="button"
      class="btn btn-color1"
      v-b-modal.modal1
    >결제하기</Button>
    <Button id="buyButton_fake" v-else type="button" class="btn btn-color1">결제하기</Button>
    <Modal :prop="prop"></Modal>
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
  computed: {
    isSelected() {
      if (this.Selected) {
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
#buyButton_fake {
  width: 500px;
}
</style>
