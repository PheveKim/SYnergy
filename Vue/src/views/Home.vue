<template>
  <div class="container">
    <br />
    <div class="text-center">
      <h1>{{ message }}</h1>
    </div>
    <br />
    <user-search></user-search>
  </div>
</template>

<script>
import UserSearch from "@/components/user/UserSearch.vue";

export default {
  name: "Home",
  data() {
    return {
      message: "Greetings",
    };
  },
  components: {
    UserSearch,
  },
};
</script>
<style>
.text-center {
  text-align: center;
}
</style>
