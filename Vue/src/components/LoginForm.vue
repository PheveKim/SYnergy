<template>
  <div class="container">
    <h2>로그인</h2>
    <fieldset class="text-center">
      <label for="id">아이디</label>
      <input type="text" id="id" v-model="id" class="view" v-on:keyup.enter="login"/><br />
      <label for="password">비밀번호</label>
      <input
        type="password"
        id="password"
        v-model="password"
        class="view"
        v-on:keyup.enter="login"
      /><br />
      <button type="button" class="btn btn-warning btn-lg" @click="login">로그인</button>
    </fieldset>
  </div>
</template>
<script>
export default {
  name: "LoginForm",
  data() {
    return {
      id: "",
      password: "",
    };
  },
  methods: {
    login() {
      let user = {
        id: this.id,
        password: this.password,
      };

      this.$store.dispatch("setLoginUser", user);
    },
  },
};
</script>
<style></style>
