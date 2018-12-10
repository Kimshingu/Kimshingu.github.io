<template>
  <div id="orderFooter" class="text-center">
    <!--옵션을 선택 해야만 해당 버튼이 실행된다.-->
    <Button
      v-if="isSelected"
      id="buyButton"
      type="button"
      class="btn btn-color1"
      v-b-modal.modal1
    >결제하기</Button>

    <!--옵션을 선택하지 않으면 버튼만 활성화 된다. 아무 작동하지 않는다.-->
    <Button id="buyButton_fake" v-else type="button" class="btn btn-color1">결제하기</Button>
    <!-- Modal components에  prop 데이터를 전달한다.-->
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
    // Method.vue의 select 데이터를 가져와서 Selected에 저장한다.
    this.$bus.$on("method", data => {
      this.Selected = data;
    });
  }
};
</script>

<style>
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
