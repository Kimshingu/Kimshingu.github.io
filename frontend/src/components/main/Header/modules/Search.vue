<template>
  <div id="search">
    <form action method="POST">
      <div class="input-group">
        <input type="text" name="search" class="form-control">
        <div class="input-group-append">
          <button class="btn" type="submit" id="btn_search">
            <i class="fas fa-search"></i>
          </button>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
#btn_search {
  background-color: #cdd4ca;
}

input:focus {
  outline: none;
}
#search{
  margin-top: 80px;
}
</style>
