<template>
  <div class="container">
    <div class="text-center" style="margin-top:100px;">
      <font class="animated" style="font-family: 'Poor Story', cursive; font-weight:bold; font-size:100px;">1RM 을 측정하세요!</font>

      <fieldset class="text-center" style="margin-top:50px;">
        <div class="row">
          <div class="col">

          </div>
        </div>
        <br>
        <div class="row">
          <div class="col">
            <font style="font-family: 'Poor Story', cursive; font-weight:bold; font-size:50px;">👊 벤치프레스</font>
          </div>
          <div class="col">
            <input style="height:65px;" type="text" id="benchpress_weight" v-model="benchpress_weight" class="view" /><font style="font-family: 'Poor Story', cursive; font-weight:bold; font-size:50px;">   kg</font><br />
          </div>
          <div class="col">
            <input style="height:65px;" type="text" id="benchpress_rep" v-model="benchpress_rep" class="view" /><font style="font-family: 'Poor Story', cursive; font-weight:bold; font-size:50px;">     회</font><br />
          </div>
        </div>
        <br>
        <div class="row">
          <div class="col">
            <font style="font-family: 'Poor Story', cursive; font-weight:bold; font-size:50px;">👊 데드리프트</font>
          </div>
          <div class="col">
            <input style="height:65px;" type="text" id="deadlift_weight" v-model="deadlift_weight" class="view" /><font style="font-family: 'Poor Story', cursive; font-weight:bold; font-size:50px;">   kg</font><br />
          </div>
          <div class="col">
            <input style="height:65px;" type="text" id="deadlift_rep" v-model="deadlift_rep" class="view" /><font style="font-family: 'Poor Story', cursive; font-weight:bold; font-size:50px;">     회</font><br />
          </div>
        </div>
        <br>
        <div class="row">
          <div class="col">
            <font style="font-family: 'Poor Story', cursive; font-weight:bold; font-size:50px;">👊 스쿼트</font>
          </div>
          <div class="col">
            <input for="squat_weight" style="height:65px;" type="text" id="squat_weight" v-model="squat_weight" class="view" /><font style="font-family: 'Poor Story', cursive; font-weight:bold; font-size:50px;">   kg</font><br />
          </div>
          <div class="col">
            <input style="height:65px;" type="text" id="squat_rep" v-model="squat_rep" class="view" /><font style="font-family: 'Poor Story', cursive; font-weight:bold; font-size:50px;">     회</font><br />
          </div>
        </div>
        
        <br><br>
        <button class="btn btn-primary btn-block fa-lg gradient-custom-2 btn-lg" onClick="this.disabled=true; this.value='Sending…';" style="font-family: 'Poor Story', cursive; width:150px;" type="button" @click="searchOneRM2">검색</button>
      </fieldset>

    </div>

    <div style="margin-top:50px; margin-bottom:200px;" v-if="searchOneRMOutput.length > 1">
      <div style="background-color:#e5e5e5; padding:40px; border-radius:20px;">
        <font style="font-size:60px;">🧞💬</font>
        <div v-text="searchOneRMOutput" style="white-space:pre-line; font-weight:bold; font-size:20px;"></div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapState } from "vuex";
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

      let searchOneRMInput = {
        benchpress_weight: this.benchpress_weight,
        benchpress_rep: this.benchpress_rep,
        deadlift_weight: this.deadlift_weight,
        deadlift_rep: this.deadlift_rep,
        squat_weight: this.squat_weight,
        squat_rep: this.squat_rep,
      };

      this.$store.dispatch("searchOneRM", searchOneRMInput);
    },
  },
  computed: {
    ...mapState(["searchOneRMOutput"]),
    ...mapState(["loginUser"]),
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
