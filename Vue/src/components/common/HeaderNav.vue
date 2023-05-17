<template>
  <header style="margin-bottom:30px;">
    <nav class="header-nav container">
      <div>
        <router-link  to="/" class="logo" style="margin-top:5px;">
          <img src="@/assets/logo2.png" style="width:70px; height:70px; margin-top:5px; margin-bottom:10px; margin-right:20px;" >
          <img src="@/assets/logo_word.png" style="width:140px; height:40px; margin-top:5px; margin-bottom:10px; margin-right:10px;" >
          <!-- SYnergy -->
        </router-link>
      </div>
      <div style="margin-top:10px;">
        <router-link to="/user">회원목록</router-link>
        <!-- <router-link to="/video">운동영상</router-link> -->
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
    reset_state() {
      this.$store.commit("RESET_STATE");
    }
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
  height: 90px;
  background-color: black;
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
