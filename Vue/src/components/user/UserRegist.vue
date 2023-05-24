<template>
  <div class="">

    <section class="gradient-form" style="background-color: #eee;">
      <br>
      <div class="container py-5" style="height:auto;">
        <div class="row d-flex justify-content-center align-items-center">
          <div class="" style="width:66%;">
            <div class="card rounded-3 text-black">
              <div class="card-body p-md-5 mx-md-4">

                <div class="text-center">
                  <img src="@/assets/logo2.jpg"
                    style="width: 185px; border-radius: 15%;" alt="logo">
                  <!-- <h4 class="mt-1 mb-5 pb-1">We are SYnergy</h4> -->
                </div>

                <br>
                <p style="text-align: center; margin-top:10px; margin-bottom:10px;"><font style="background-color:#eee; padding:5px; padding-right:10px; padding-left:10px; border-radius:5px;">회원 가입을 위해 계정 정보를 입력하세요</font></p>
                <br>

                <fieldset class="text-center">
                  <label for="id">아이디</label>
                  <input type="text" id="id" v-model="id" class="view" /><br />
                  <label for="password">비밀번호</label>
                  <input
                    type="password"
                    id="password"
                    v-model="password"
                    class="view"
                  /><br />
                  <label for="name">이름</label>
                  <input type="text" id="name" v-model="name" class="view" /><br />
                  <label for="email">이메일</label>
                  <input type="email" id="email" v-model="email" class="view" /><br />
                  <label for="age">나이</label>
                  <input type="number" id="age" v-model="age" class="view" /><br />

                  <button class="btn btn-primary btn-block fa-lg gradient-custom-2 btn-lg" style="width:150px;" type="button" @click="regist">등록</button>
                  <button class="btn btn-outline-danger btn-block fa-lg gradient-custom-2 btn-lg" style="width:150px;" type="button" @click="getInfoFromAPI">랜덤</button>
                </fieldset>


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
import { mapState } from "vuex";
export default {
  name: "UserList",
  data() {
    return {
      id: "",
      password: "",
      name: "",
      email: "",
      age: 0,
      img: "",
    };
  },
  methods: {
    async getInfoFromAPI() {
      await this.$store.dispatch("setRandomUser");
      this.id = this.randomUser.id;
      this.password = this.randomUser.password;
      this.name = this.randomUser.name;
      this.email = this.randomUser.email;
      this.age = this.randomUser.age;
    },
    regist() {
      if (
        this.id === "" ||
        this.password === "" ||
        this.name === "" ||
        this.email === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      }

      let user = {
        id: this.id,
        password: this.password,
        name: this.name,
        email: this.email,
        age: this.age,
        img: "#",
      };

      this.$store.dispatch("createUser", user);
    },
  },
  computed: {
    ...mapState(["randomUser"]),
  },
};
</script>
