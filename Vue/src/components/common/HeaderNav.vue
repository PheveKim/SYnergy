<template>
  <header style="margin-bottom:30px;">
    <nav class="header-nav container">
      <div>
        
        <a href="/" class="logo" style="">
          <img src="@/assets/SYnergy_logo.png" style="width:50px; height:50px; margin-bottom:10px; margin-right:5px;" >
          SYnergy

        </a>
      </div>
      <div>
        <router-link to="/user">회원목록</router-link>
        <router-link to="/video">운동영상</router-link>
        <router-link to="/review">운동리뷰</router-link>
        <router-link :to="{ name: 'UserRegist' }">회원가입</router-link>
        <a href="#" v-if="getUser" @click="logout">로그아웃</a>
        <router-link to="/login" v-else>로그인</router-link>
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
  height: 75px;
  background-color:#444444;
  line-height: 70px;
  padding: 0px 30px;
}

header a:hover{
  background-color:transparent;
  color:grey;
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
