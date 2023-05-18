<template>
  <div>
  <!-- <div class="container">
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
      <button type="button" class="btn btn-lg" style="background-color:greenyellow; font-weight:bold;" @click="login">로그인</button>
    </fieldset>
  </div> -->


  <section class="gradient-form" style="background-color: #eee;">
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
                  <p style="text-align: center;">계정 정보를 입력하세요</p>
                  <br>

                  <div class="form-outline mb-4">
                    <label class="form-label" for="form2Example11">아이디 :</label>
                    <input type="text" id="id" v-model="id" class="view" v-on:keyup.enter="login" />
                    
                  </div>
                  <div class="form-outline mb-4">
                    <label class="form-label" for="form2Example22">비밀번호 :</label>
                    <input
                      type="password"
                      id="password"
                      v-model="password"
                      class="view"
                      v-on:keyup.enter="login" />
                  </div>

                  <div class="text-center" style="margin-bottom:15px;">
                    <button class="btn btn-primary btn-block fa-lg gradient-custom-2 btn-lg" style="width:100px;" type="button" @click="login">로그인</button>
                  </div>

                  <div class="d-flex align-items-center justify-content-center" style="margin-bottom:15px;">
                    <p class="mb-0 me-2">계정이 없으신가요?</p>
                  </div>
                  <div >
                  <router-link :to="{ name: 'UserRegist' }" ><button type="button" class="btn btn-outline-danger btn-lg" style="width:150px;">회원 가입</button></router-link>
                </div>
                </form>

            <!-- <div class="col-lg-6 d-flex align-items-center gradient-custom-2">
              <div class="text-white px-3 py-4 p-md-5 mx-md-4">
                <h4 class="mb-4">We are more than just a company</h4>
                <p class="small mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                  tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
                  exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
              </div>
            </div> -->
          </div>
        </div>
      </div>
    </div>
  </div>
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

      this.$store.dispatch("setLoginUser", user);
    },

  },
};
</script>
<style></style>
