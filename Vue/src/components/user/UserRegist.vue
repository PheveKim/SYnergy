<template>
  <div class="">

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
                <p style="text-align: center; margin-top:10px; margin-bottom:10px;"><font style="background-color:#eee; padding:5px; padding-right:10px; padding-left:10px; border-radius:5px; font-family: 'Cyber'; font-size:20px;">INPUT INFORMATION</font></p>
                <br>

                <fieldset class="text-center" style="font-family: 'Cyber';">
                  <label for="id">ID</label>
                  <input type="text" id="id" v-model="id" class="view" /><br />
                  <label for="password">PASSWORD</label>
                  <input
                    type="password"
                    id="password"
                    v-model="password"
                    class="view"
                  /><br />
                  <label for="name">NAME</label>
                  <input type="text" id="name" v-model="name" class="view" /><br />
                  <label for="email">EMAIL</label>
                  <input type="email" id="email" v-model="email" class="view" /><br />
                  <label for="age">AGE</label>
                  <input type="number" id="age" v-model="age" class="view" /><br />
                  <br>
                  <button class="btn btn-primary btn-block fa-lg gradient-custom-2 btn-lg" style="width:150px; border-radius:5px;" type="button" @click="regist">REGIST</button>
                  <button class="btn btn-outline-danger btn-block fa-lg gradient-custom-2 btn-lg" style="width:150px; border-radius:5px;" type="button" @click="getInfoFromAPI">RANDOM</button>
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
