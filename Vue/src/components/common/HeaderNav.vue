<template>
  <header style="margin-bottom:;">
    <nav class="header-nav container">
      <div>
        <router-link  to="/" class="logo" style="margin-top:5px;">
          <img src="@/assets/logo2.png" style="width:70px; height:70px; margin-top:5px; margin-bottom:10px; margin-right:20px;" >
          <img src="@/assets/logo_word.png" style="width:140px; height:40px; margin-top:5px; margin-bottom:10px; margin-right:10px;" >
        </router-link>
      </div>
      <div style="margin-top:10px;">
        <router-link to="/recommend">AI 추천</router-link>
        <router-link to="/user" v-if="getUser === true">회원목록</router-link>
        <a style="color:white; cursor:pointer;" data-toggle="modal" data-target="#loginUserNullModal" v-else>회원목록</a>
        <router-link to="/review">운동리뷰</router-link>
        <span v-if="loginUser===null">
        <router-link :to="{ name: 'UserRegist' }">회원가입</router-link>
      </span>
        <div v-if="getUser" class="btn-group">
          <button type="button" class="btn dropdown-toggle" style="background-color:greenyellow; font-weight:;" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            {{ loginUser.name }}님
          </button>
          <div class="dropdown-menu text-center">
            <router-link class="user-link" :to="`/user/${loginUser.id}`" style="text-decoration-line: none;">나의 정보</router-link>
            <div class="dropdown-divider"></div>
            <a class="" href="#" v-if="getUser" @click="logout" style="color:black;">로그아웃</a>
          </div>
        </div>
        
        <router-link to="/login" v-else>로그인</router-link>
      </div>
    </nav>
    
    
    <!-- Modal -->
    <div class="modal fade" id="loginUserNullModal" tabindex="-1" role="dialog" aria-labelledby="loginUserNullModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="loginUserNullModalLabel"><font style="font-weight:bold;">권한이 없습니다.</font></h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="text-center">
            <font style="font-size:17px;">열람하시려면 로그인해주세요.</font>
          </div>
          <div class="text-center" style="margin-bottom:10px;">
            <router-link to="/login">
              <button type="button" class="btn btn-lg" style="background-color:greenyellow; font-weight:bold; width:100px;" data-dismiss="modal">로그인</button>
            </router-link>
          </div>
        </div>
      </div>
    </div>

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
    },
    openModal() {
      this.$bvModal.show('loginUserNullModal');
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
