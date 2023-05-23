<template>
  <div>
    <section class="gradient-form" style="background-color: #eee;">
      <br>
      <div class="container py-5" style="height:auto;">
        <div class="row d-flex justify-content-center align-items-center">
          <div class="" style="width:66%;">
            <div class="card rounded-3 text-black">
              <div class="card-body p-md-5 mx-md-4">

                <div class="text-center">
                  <img src="../assets/logo2.jpg"
                    style="width: 185px; border-radius: 15%;" alt="logo">
                  <!-- <h4 class="mt-1 mb-5 pb-1">We are SYnergy</h4> -->
                </div>

                <br>

                <form style="text-align: center;">
                  <p style="text-align: center; margin-top:10px; margin-bottom:10px;"><font style="background-color:#e1e1e1; padding:5px; padding-right:10px; padding-left:10px; border-radius:5px;">계정 정보를 입력하세요</font></p>
                  <br>

                  <div class="form-outline mb-4">
                    <input placeholder="아이디" type="text" id="id" v-model="id" class="view" v-on:keyup.enter="login" />
                  </div>
                  <div class="form-outline mb-4">
                    <input
                      placeholder="비밀번호"
                      type="password"
                      id="password"
                      v-model="password"
                      class="view"
                      v-on:keyup.enter="login" />
                  </div>

                  <div class="text-center" style="margin-bottom:15px;">
                    <button class="btn btn-primary btn-block fa-lg gradient-custom-2 btn-lg" style="width:150px;" type="button" @click="login">로그인</button>
                  </div>

                  <div class="d-flex align-items-center justify-content-center" style="margin-bottom:15px;">
                    <p class="mb-0 me-2">계정이 없으신가요?</p>
                  </div>
                  <div >
                    <router-link :to="{ name: 'UserRegist' }" ><button type="button" class="btn btn-outline-danger btn-lg" style="width:150px;">회원 가입</button></router-link>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
      <br>
    </section>
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

      // this.$store.dispatch("setLoginUser", user);
      this.$store.dispatch("loginUser",user);
    },

  },
};
</script>
<style></style>
