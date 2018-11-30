<template lang="html">
  <div class="">
    <cartHeader>
    </cartHeader>
    <cartBody>
    </cartBody>
    <cartFooter>
    </cartFooter>

  </div>



</template>

<script>
import body from "./modules/Body/Body";
import footer from "./modules/Footer/Footer";
import header from "./modules/Header/Header";
export default {
  components: {
    cartHeader: header,
    cartBody: body,
    cartFooter: footer

  }
}
console.log('123');
</script>

<style lang="css">
</style>
