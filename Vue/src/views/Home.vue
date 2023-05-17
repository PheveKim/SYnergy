<template>
  <div class="container">
    <br />
    <div class="text-center">
      <h1>{{ message }}</h1>
    </div>
    <video-list></video-list>
  </div>
</template>

<script>
// import UserSearch from "@/components/user/UserSearch.vue";
import VideoList from "@/components/video/VideoList.vue";

export default {
  name: "Home",
  data() {
    return {
      // message: "Greetings",
    };
  },
  components: {
    // UserSearch,
    VideoList,
  },
};
</script>
<style>
.text-center {
  text-align: center;
}
</style>
