<template>
  <div>
    <!-- :prop="prop"
        하위 컴포넌트인 ProductBlock, PurchaseInfo에 prop 데이터를 전달한다.
    -->
    <ProductBlock :prop="prop"></ProductBlock>
    <UserBlock></UserBlock>
    <ReceiverBlock @receiver="emitReceiver"></ReceiverBlock>
    <PurchaseInfo :prop="prop"></PurchaseInfo>
    <Method></Method>
  </div>
</template>

<script>
import ProductBlock from "./modules/ProductBlock";
import UserBlock from "./modules/UserBlock";
import ReceiverBlock from "./modules/ReceiverBlock";
import PurchaseInfo from "./modules/PurchaseInfo";
import Method from "./modules/Method";
export default {
  methods: {
    emitReceiver: function(data) {
      this.$emit("receiver", data);
    }
  },
  components: {
    ProductBlock: ProductBlock,
    UserBlock: UserBlock,
    ReceiverBlock: ReceiverBlock,
    PurchaseInfo: PurchaseInfo,
    Method: Method
  },
  props: ["prop"]
};
</script>

<style>
</style>
