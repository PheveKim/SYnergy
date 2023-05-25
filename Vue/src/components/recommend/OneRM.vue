<template>
  <div class="container">
    <div class="text-center" style="margin-top:100px; margin-bottom:100px;">
      <font class="" style="font-family: 'Cyber'; font-weight:bold; font-size:90px;">CALCULATE 1RM</font>

      <fieldset class="text-center" style="margin-top:50px;">
        <div class="row">
          <div class="col">

          </div>
        </div>
        <br>
        <div class="row">
          <div class="col-1"></div>
          <div class="col-4">
            <font style="font-family: 'Cyber'; font-weight:bold; font-size:50px;">Bench Press</font>
          </div>
          <div class="col-3">
            <input style="width:200px; height:65px;" type="text" id="benchpress_weight" v-model="benchpress_weight" class="view" /><font style="font-family: 'Cyber', cursive; font-weight:bold; font-size:50px;">   kg</font><br />
          </div>
          <div class="col-3">
            <input style="width:200px; height:65px;" type="text" id="benchpress_rep" v-model="benchpress_rep" class="view" /><font style="font-family: 'Cyber', cursive; font-weight:bold; font-size:50px;">     reps</font><br />
          </div>
          <div class="col-2"></div>
        </div>
        <br>
        <div class="row">
          <div class="col-1"></div>
          <div class="col-4">
            <font style="font-family: 'Cyber', cursive; font-weight:bold; font-size:50px;">Deadlift</font>
          </div>
          <div class="col-3">
            <input style="width:200px; height:65px;" type="text" id="deadlift_weight" v-model="deadlift_weight" class="view" /><font style="font-family: 'Cyber', cursive; font-weight:bold; font-size:50px;">   kg</font><br />
          </div>
          <div class="col-3">
            <input style="width:200px; height:65px;" type="text" id="deadlift_rep" v-model="deadlift_rep" class="view" /><font style="font-family: 'Cyber', cursive; font-weight:bold; font-size:50px;">     reps</font><br />
          </div>
          <div class="col-1"></div>
        </div>
        <br>
        <div class="row">
          <div class="col-1"></div>
          <div class="col-4">
            <font style="font-family: 'Cyber', cursive; font-weight:bold; font-size:50px;">Squat</font>
          </div>
          <div class="col-3">
            <input for="squat_weight" style="width:200px; height:65px;" type="text" id="squat_weight" v-model="squat_weight" class="view" /><font style="font-family: 'Cyber', cursive; font-weight:bold; font-size:50px;">   kg</font><br />
          </div>
          <div class="col-3">
            <input style="width:200px; height:65px;" type="text" id="squat_rep" v-model="squat_rep" class="view" /><font style="font-family: 'Cyber', cursive; font-weight:bold; font-size:50px;">     reps</font><br />
          </div>
          <div class="col-1"></div>
        </div>
        
        <br><br>
        <button class="btn btn-primary btn-block fa-lg gradient-custom-2 btn-lg" style="border-radius:5px; font-family: 'Cyber', cursive; font-size:25px; width:150px;" type="button" @click="searchOneRM2">CALCULATE</button>
      </fieldset>

    </div>
    <div class="row">
      <div class="col-2"></div>
      <div class="col-8">
        <div style="margin-top:px; margin-bottom:;" v-if="searchOneRMOutput.length > 1">
          <div style="background-color:#e5e5e5; padding:40px; border-radius:5px;">
            <!-- <font style="font-size:60px;">🧞💬</font><br><br> -->
            <div v-text="searchOneRMOutput" style="white-space:pre-line; font-weight:bold; font-size:20px;"></div>
          </div>
        </div>
      </div>
      <div class="col-2"></div>
    </div>
    
    <div class="text-center" style="margin-top:100px;" v-if="searchOneRMOutput.length > 1">
      <font class="" style="font-family: 'Cyber'; font-weight:bold; font-size:90px;">NOW</font><br>
      <font class="" style="font-family: 'Cyber'; font-weight:bold; font-size:90px;">PLAN YOUR</font><br>
      <font class="" style="font-family: 'Cyber'; font-weight:bold; font-size:90px;">ROUTINES</font>

      <fieldset class="text-center" style="margin-top:50px;">
        <div class="row">
          <div class="col">

          </div>
        </div>
        <br>
        <div class="row">
          <div class="col-2"></div>
          <div class="col">
            <font style="font-family: 'Cyber', cursive; font-weight:bold; font-size:50px;">Weight</font>
          </div>
          <div class="col">
            <input style="height:65px;" type="text" id="person_weight" v-model="person_weight" class="view" /><font style="font-family: 'Cyber', cursive; font-weight:bold; font-size:50px;">   kg</font><br />
          </div>
          <div class="col-2"></div>
        </div>
        <br>
        <div class="row">
          <div class="col-2"></div>
          <div class="col">
            <font style="font-family: 'Cyber', cursive; font-weight:bold; font-size:50px;">Height</font>
          </div>
          <div class="col">
            <input style="height:65px;" type="text" id="person_height" v-model="person_height" class="view" /><font style="font-family: 'Cyber', cursive; font-weight:bold; font-size:50px;">     cm</font><br />
          </div>
          <div class="col-2"></div>
        </div>
        
        <br><br>
        <button class="btn btn-primary btn-block fa-lg gradient-custom-2 btn-lg" onClick="this.disabled=true; this.value='Sending…';" style="border-radius:5px; font-family: 'Cyber', cursive; font-size:25px; width:150px;" type="button" @click="searchRoutine">PLAN</button>
        <br>
      </fieldset>

    </div>
    <div class="row" style="margin-bottom:100px;">
      <div class="col-2"></div>
      <div class="col-8">
        <div style="margin-top:50px; margin-bottom:;" v-if="searchRoutineOutput.length > 1">
          <div style="background-color:#e5e5e5; padding:40px; border-radius:5px;">
            <!-- <font style="font-size:60px;">🧞💬</font> -->
            <div v-text="searchRoutineOutput" style="white-space:pre-line; font-weight:bold; font-size:20px;"></div>
          </div>
        </div>
      </div>
      <div class="col-2"></div>
    </div>

    <div class="text-center" style="margin-top:100px; margin-bottom:50px;" v-if="searchRoutineOutput.length > 1">
      <font class="" style="font-family: 'Cyber'; font-weight:bold; font-size:90px;">PLAN YOUR</font><br>
      <font class="" style="font-family: 'Cyber'; font-weight:bold; font-size:90px;">DIETS</font>

      <fieldset class="text-center" style="margin-top:50px;">
        <button class="btn btn-primary btn-block fa-lg gradient-custom-2 btn-lg" onClick="this.disabled=true; this.value='Sending…';" style="border-radius:5px; font-family: 'Cyber', cursive; font-size:25px; width:150px;" type="button" @click="searchFood">PLAN</button>
        
      </fieldset>

    </div>
    <div class="row" style="margin-bottom:100px;">
      <div class="col-2"></div>
      <div class="col-8">
        <div style="margin-top:50px; margin-bottom:200px;" v-if="searchFoodOutput.length > 1">
          <div style="background-color:#e5e5e5; padding:40px; border-radius:5px;">
            <!-- <font style="font-size:60px;">🧞💬</font> -->
            <div v-text="searchFoodOutput" style="white-space:pre-line; font-weight:bold; font-size:20px;"></div>
          </div>
        </div>
      </div>
      <div class="col-2"></div>
    </div>

  </div>
</template>
<script>
import { mapState } from "vuex";
// import $ from 'jquery';
export default {
  name: "OneRM",
  data() {
    return {
      benchpress_weight: "",
      benchpress_rep: "",
      deadlift_weight: "",
      deadlift_rep: "",
      squat_weight: "",
      squat_rep: "",
    };
  },
  methods: {
    searchOneRM2() {
      if (
        this.benchpress_weight === "" ||
        this.benchpress_rep === "" ||
        this.deadlift_weight === "" ||
        this.deadlift_rep === "" ||
        this.squat_weight === "" ||
        this.squat_rep === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      }

      let Input = {
        benchpress_weight: this.benchpress_weight,
        benchpress_rep: this.benchpress_rep,
        deadlift_weight: this.deadlift_weight,
        deadlift_rep: this.deadlift_rep,
        squat_weight: this.squat_weight,
        squat_rep: this.squat_rep,
      };

      const BW = Input.benchpress_weight;
      const BR = Input.benchpress_rep;
      const DW = Input.deadlift_weight;
      const DR = Input.deadlift_rep;
      const SW = Input.squat_weight;
      const SR = Input. squat_rep;

      let B,D,S = 1;
      if(BR != 1) B = Math.round((((BW*(1+(BR/30))) + (BW*(36/(37-BR))) + (100*BW / (101.3-2.67123*BR))) / 3)*100)/100;
      else B = BW;
      if(DR != 1) D = Math.round((((DW*(1+(DR/30))) + (DW*(36/(37-DR))) + (100*DW / (101.3-2.67123*DR))) / 3)*100)/100;
      else D = DW;
      if(SR != 1) S = Math.round((((SW*(1+(SR/30))) + (SW*(36/(37-SR))) + (100*SW / (101.3-2.67123*SR))) / 3)*100)/100;
      else S = SW;


      let str = "1RM 계산 결과값은 다음과 같습니다. \n\n" + "벤치프레스 1RM = " + B + "kg\n데드리프트 1RM = " + D + "kg\n스쿼트 1RM = " + S + "kg\n";

      this.$store.commit("SEARCH_ONE_RM", str);

      // this.$store.dispatch("searchOneRM", searchOneRMInput);
    },
    searchRoutine() {
      if (
        this.person_weight === "" ||
        this.person_height === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      }

      const BW = this.benchpress_weight;
      const BR = this.benchpress_rep;
      const DW = this.deadlift_weight;
      const DR = this.deadlift_rep;
      const SW = this.squat_weight;
      const SR = this. squat_rep;

      let B,D,S = 1;
      if(BR != 1) B = Math.round((((BW*(1+(BR/30))) + (BW*(36/(37-BR))) + (100*BW / (101.3-2.67123*BR))) / 3)*100)/100;
      else B = BW;
      if(DR != 1) D = Math.round((((DW*(1+(DR/30))) + (DW*(36/(37-DR))) + (100*DW / (101.3-2.67123*DR))) / 3)*100)/100;
      else D = DW;
      if(SR != 1) S = Math.round((((SW*(1+(SR/30))) + (SW*(36/(37-SR))) + (100*SW / (101.3-2.67123*SR))) / 3)*100)/100;
      else S = SW;

      let searchRoutineInput = {
        person_weight: this.person_weight,
        person_height: this.person_height,
        B: B,
        D: D,
        S: S,
      };

      this.$store.dispatch("searchRoutine", searchRoutineInput);
    },
    searchFood() {

      const BW = this.benchpress_weight;
      const BR = this.benchpress_rep;
      const DW = this.deadlift_weight;
      const DR = this.deadlift_rep;
      const SW = this.squat_weight;
      const SR = this. squat_rep;

      let B,D,S = 1;
      if(BR != 1) B = Math.round((((BW*(1+(BR/30))) + (BW*(36/(37-BR))) + (100*BW / (101.3-2.67123*BR))) / 3)*100)/100;
      else B = BW;
      if(DR != 1) D = Math.round((((DW*(1+(DR/30))) + (DW*(36/(37-DR))) + (100*DW / (101.3-2.67123*DR))) / 3)*100)/100;
      else D = DW;
      if(SR != 1) S = Math.round((((SW*(1+(SR/30))) + (SW*(36/(37-SR))) + (100*SW / (101.3-2.67123*SR))) / 3)*100)/100;
      else S = SW;

      let searchFoodInput = {
        person_weight: this.person_weight,
        person_height: this.person_height,
        B: B,
        D: D,
        S: S,
      };

      this.$store.dispatch("searchFood", searchFoodInput);
    },
  },
  computed: {
    ...mapState(["searchOneRMOutput"]),
    ...mapState(["loginUser"]),
    ...mapState(["searchRoutineOutput"]),
    ...mapState(["searchFoodOutput"]),
  },
  // created() {

  // },
  // components: {

  // }
};





</script>
<style>
.content {
  white-space: pre-line
}
@import url('https://fonts.googleapis.com/css2?family=Poor+Story&display=swap');
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


</style>
