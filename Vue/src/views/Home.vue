<template>
  <div class="container">
    <br />
    <div class="text-center">
      <h1>{{ message }}</h1>
    </div>
    <first-page></first-page>
  </div>
</template>

<script>
// import UserSearch from "@/components/user/UserSearch.vue";
import FirstPage from "@/components/FirstPage.vue";

export default {
  name: "Home",
  data() {
    return {
      // message: "Greetings",
    };
  },
  components: {
    FirstPage,
  },
};
</script>
<style>
.text-center {
  text-align: center;
}
</style>
