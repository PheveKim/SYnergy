<template>
  <header>
    <nav class="header-nav">
      <div>
        <router-link to="/" class="logo">SSAFY USERS</router-link>
      </div>
      <div>
        <a href="#" v-if="getUser" @click="logout">로그아웃</a>
        <router-link to="/login" v-else>로그인</router-link>
        <router-link :to="{ name: 'Regist' }">회원가입</router-link>
        <router-link to="/user">사용자목록</router-link>
      </div>
    </nav>
  </header>
</template>
<script>
import { mapState } from "vuex";
export default {
  name: "HeaderNav",
  methods: {
    logout() {
      this.$store.commit("LOGOUT");
    },
  },
  computed: {
    ...mapState(["loginUser"]),
    getUser() {
      if (this.loginUser) {
        return true;
      } else {
        return false;
      }
    },
  },
};
</script>
<style>
header {
  height: 70px;
  background-color: #53e3a6;
  line-height: 70px;
  padding: 0px 30px;
}

header a {
  margin: 10px;
  text-decoration: none;
  color: white;
}

.header-nav {
  display: flex;
  justify-content: space-between;
}

.logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: white;
  margin: 0;
}
</style>
