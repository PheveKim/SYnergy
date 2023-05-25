<template>
  <div class="" v-if="loginUser.id === `${user.id}`">
    <!-- <h2>회원 정보</h2>
    <fieldset class="text-center">
      <label for="id">아이디</label>
      <input
        readonly
        type="text"
        id="id"
        v-model="user.id"
        class="view"
      /><br />
      <label for="password">비밀번호</label>
      <input
        type="password"
        id="password"
        v-model="user.password"
        class="view"
      /><br />
      <label for="name">이름</label>
      <input type="text" id="name" v-model="user.name" class="view" /><br />
      <label for="email">이메일</label>
      <input type="email" id="email" v-model="user.email" class="view" /><br />
      <label for="age">나이</label>
      <input type="number" id="age" v-model="user.age" class="view" /><br />
      <button class="btn btn-lg" style="background-color:greenyellow; font-weight:bold;" @click="updateUser">수정</button>
      <button class="btn btn-lg" style="background-color:greenyellow; font-weight:bold;" @click="deleteUser">삭제</button>
    </fieldset> -->



    <section class="gradient-form" style="background-color: #eee; height:900px;">
      <br>
      <div class="container py-5" style="height:auto;">
        <div class="row d-flex justify-content-center align-items-center">
          <div class="" style="width:66%;">
            <div class="card rounded-3 text-black">
              <div class="card-body p-md-5 mx-md-4">

                <!-- <div class="text-center">
                  <img src="@/assets/logo2.jpg"
                    style="width: 185px; border-radius: 15%;" alt="logo">
                </div> -->

                <br>
                <p style="text-align: center; margin-top:10px; margin-bottom:10px;"><font style="background-color:#eee; padding:5px; padding-right:10px; padding-left:10px; border-radius:5px; font-size:20px; font-family: 'Cyber';">EDIT PROFILE</font></p>
                <br>

                <fieldset class="text-center" style="font-family: 'Cyber';">
                  <label for="id">ID</label>
                  <input
                    readonly
                    type="text"
                    id="id"
                    v-model="user.id"
                    class="view"
                  /><br />
                  <label for="password">PASSWORD</label>
                  <input
                    type="password"
                    id="password"
                    v-model="user.password"
                    class="view"
                  /><br />
                  <label for="name">NAME</label>
                  <input type="text" id="name" v-model="user.name" class="view" /><br />
                  <label for="email">EMAIL</label>
                  <input type="email" id="email" v-model="user.email" class="view" /><br />
                  <label for="age">AGE</label>
                  <input type="number" id="age" v-model="user.age" class="view" /><br /><br>
                  <button class="btn btn-primary btn-block fa-lg gradient-custom-2 btn-lg" style="width:150px; border-radius:5px;" type="button" @click="updateUser">EDIT</button>
                  <button class="btn btn-outline-danger btn-block fa-lg gradient-custom-2 btn-lg" style="width:150px; border-radius:5px;" type="button" @click="deleteUser">DELETE</button>
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
  name: "UserDetail",
  methods: {
    updateUser() {
      this.$store.dispatch("updateUser", this.user);
    },
    deleteUser() {
      this.$store.dispatch("deleteUser", this.user.id);
    },
    async setUser(id) {
     await this.$store.dispatch("setUser", id);
    },
    
  },
  computed: {
    ...mapState(["user"]),
    ...mapState(["loginUser"]),
  },
  created() {
    const pathName = new URL(document.location).pathname.split("/");
    const id = pathName[pathName.length - 1];
    this.setUser(id);
  },
};
</script>
