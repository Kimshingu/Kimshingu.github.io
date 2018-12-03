<template>
  <div>
    <ProductBlock :prop="prop"></ProductBlock>
    <UserBlock></UserBlock>
    <ReceiverBlock></ReceiverBlock>
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
