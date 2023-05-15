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
      message: "사용자 정보 사이트에 오신것을 환영합니다.",
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
