<template>
  <div id="footer">
    <div class="row">
      <div class="col-3">
        <info1></info1>
      </div>
      <div class="col-6">
        <info2></info2>
      </div>
      <div class="col-3">
        <info3></info3>
      </div>
    </div>
  </div>
</template>

<script>
import info1 from "./modules/info_1";
import info2 from "./modules/info_2";
import info3 from "./modules/info_3";
export default {
  components: {
    info1: info1,
    info2: info2,
    info3: info3
  }
};
</script>

<style>
#footer {
  font-size: 1.2rem;
  margin: 40px;
}
</style>
