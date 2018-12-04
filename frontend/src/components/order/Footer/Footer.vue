<template>
  <div id="orderFooter" class="text-center">
    <Button id="buyButton" type="button" class="btn btn-color1" v-b-modal.modal1>결제하기</Button>
    <Modal :prop="prop"></Modal>
  </div>
</template>

<script>
import Modal from "../Modal/Modal";
export default {
  props: ["prop"],
  components: {
    Modal: Modal
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
