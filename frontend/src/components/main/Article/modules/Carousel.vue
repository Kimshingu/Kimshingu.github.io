<template>
  <div>
    <b-carousel
      id="carousel1"
      style="text-shadow: 1px 1px 2px #333;"
      controls
      indicators
      background="#ababab"
      :interval="4000"
      img-width="1024"
      img-height="480"
      v-model="slide"
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >
  
      <!-- Slides with img slot -->
      <!-- Note the classes .d-block and .img-fluid to prevent browser default image alignment -->
      <b-carousel-slide>
        <img
          slot="img"
          width="1024"
          height="480"
          class="d-block img-fluid w-100"
          src="./carousel2.jpg"
          alt="image slot"
        >
      </b-carousel-slide>
      
      <b-carousel-slide>
        <img
          slot="img"
          width="1024"
          height="480"
          class="d-block img-fluid w-100"
          src="./carousel1.jpg"
          alt="image slot"
        >
      </b-carousel-slide>
      
      <b-carousel-slide>
        <img
          slot="img"
          width="1024"
          height="480"
          class="d-block img-fluid w-100"
          src="./carousel4.jpg"
          alt="image slot"
        >
      </b-carousel-slide>
      
      <b-carousel-slide>
        <img
          slot="img"
          width="1024"
          height="480"
          class="d-block img-fluid w-100"
          src="./carousel3.jpg"
          alt="image slot"
        >
      </b-carousel-slide>

      <b-carousel-slide>
        <img
          slot="img"
          width="1024"
          height="480"
          class="d-block img-fluid w-100"
          src="./carousel5.jpg"
          alt="image slot"
        >
      </b-carousel-slide>
    
    </b-carousel>
  </div>
</template>

<script>
export default {};
</script>

<style>

</style>
