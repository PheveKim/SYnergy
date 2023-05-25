<template>
  <div style="background-color:#eee;">
    <div class="container" style="padding-bottom:100px;">
      <br>
      <div class="card rounded-3" style="margin-top:; margin-bottom:20px;">
        <div class="card-body row">
          <div class="col-8"><font style="font-weight:bold; font-size:20px;">{{ video.title }}</font></div>
          <div class="col-4" style="text-align:right; padding-right:20px;"><font style="font-weight:bold; font-size:20px; color:blue;">{{ video.channelname }}</font></div>
        </div>
      </div>
      <div class="text-center">
        <iframe
          style="border-radius:10px;"
          width="1296" 
          height="563" :src="`https://www.youtube.com/embed/${ video.youtubeurl }`"
          frameborder="0" 
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
          allowfullscreen>
        </iframe>
      </div>
      <div class="card rounded-3" style="background-color:white; margin-top:20px; margin-bottom:10px;">
        <div class="card-body row">
          <div class="col-8">
            <a style="font-weight:; font-size:18px; color:blue; font-family: 'Cyber'; text-decoration-line: none;" :href="`https://www.youtube.com/watch?v=${video.youtubeurl}`">GO TO YOUTUBE</a><br>
            <font style="font-weight:bold; font-size:18px;">운동부위 : {{ video.fitpartname }}</font><br>
            <font style="font-weight:bold; font-size:18px;">{{ video.content }} </font>
            <div ><button type= "button" class="Like btn btn-danger" style ="border-radius:3px; font-weight: bold; width: fit-content; font-family: 'Cyber';" @click="clickLike" >LIKE {{ video.videolike }}</button></div>
          </div>
          <div class="col-4" style="text-align:right;" v-if="loginUser != null && loginUser.id === 'admin'">
            <button class="btn btn-primary btn-lg" style="width:150px; border-radius:5px; font-family: 'Cyber';" type="button" data-toggle="collapse" data-target="#collapseVideoDetail" aria-expanded="false" aria-controls="collapseVideoDetail">
              EDIT
            </button>
          </div>
        </div>
      </div>

      <div class="collapse" id="collapseVideoDetail" style="margin-top:15px; font-family: 'Cyber';">
        <div class="card rounded-3" style="background-color:white; margin-top:20px; margin-bottom:10px;">
          <div class="card-body">
            <fieldset class="text-center">
              <label for="id">ID</label>
              <input
                readonly
                type="text"
                id="id"
                v-model="video.id"
                class="view"
              /><br />
              <label for="title">TITLE</label>
              <input type="text" id="title" v-model="video.title" class="view" /><br />
              <label for="content">CONTENT</label>
              <input type="text" id="content" v-model="video.content" class="view" /><br />
              <label for="fitpartname">FITPARTNAME</label>
              <input type="text" id="fiatpartname" v-model="video.fitpartname" class="view" /><br />
              <label for="youtubeurl">URL</label>
              <input type="text" id="youtubeurl" v-model="video.youtubeurl" class="view" /><br />
              <label for="channelname">CHANNELNAME</label>
              <input type="text" id="channelname" v-model="video.channelname" class="view" /><br />
              
              <button class="btn btn-lg" style="background-color:greenyellow; font-weight:bold;" @click="updateVideo">EDIT</button>
              <button class="btn btn-lg" style="background-color:greenyellow; font-weight:bold;" @click="deleteVideo">DELETE</button>
            </fieldset>
          </div>
        </div>
      </div>

      <div v-if="searchReviewCnt" style="padding-bottom:20px;">
        <div class="card rounded-3" style="background-color:white; margin-top:20px;">
          <font class="card-body" style="font-weight:bold; font-size:20px; border-bottom:1px solid #e1e1e1; font-family: 'Cyber'">REVIEWS</font>
          <div class="card-body" v-for="(searchReview, index) in searchReviews" :key="index" style="border-bottom:1px solid #e1e1e1;">
            <div class="row">
              <div class="col-1" style="padding-left:30px; padding-top:5px;">
                <img src="@/assets/logo2.png" style="border-radius:100%; width:50px;">
              </div>
              <div class="col-11">
                <font style="font-weight:bold; font-size:18px; color:blue;">{{ searchReview.userid }}</font><br>
                <font style="font-weight:bold; font-size:18px;">{{ searchReview.title }}</font><br>
                <font style="font-weight:; font-size:18px;">{{ searchReview.content }}</font>
              </div>
            </div>
          </div>
        </div>
      </div>
      
      <div class="row" style="padding-left:5px; padding-right:20px;" v-if="loginUser != null">
        <button class="btn btn-primary btn-lg" style="width:100%;" type="button" data-toggle="collapse" data-target="#collapseReviewRegist" aria-expanded="false" aria-controls="collapseReviewRegist">
          <font style="font-family: 'Cyber';">ADD REVIEWS</font>
        </button>
      </div>
      <div class="row" style="padding-left:5px; padding-right:20px;" v-else-if="loginUser == null">
        <router-link to="/login">
          <button class="btn btn-lg" style="width:100%; background-color:black; color:white;" type="text">
            <font style="font-family: 'Cyber';">PLEASE LOGIN</font>
          </button>
        </router-link>
      </div>
      <div class="collapse" id="collapseReviewRegist" style="margin-top:15px; margin-bottom:20px;">
        <div class="card card-body">
          
          <fieldset class="text-center">
            <label for="title" style="font-family: 'Cyber';">TITLE</label>
            <input type="text" id="title" v-model="title" class="view" /><br />
            <label for="content" style="font-family: 'Cyber';">CONTENT</label>
            <input type="text" id="content" v-model="content" class="view" style="height:300px;"/><br />
            <button type="button" class="btn btn-primary btn-lg" style="border-radius:5px; font-family: 'Cyber';" @click="ReviewRegist" onClick="this.disabled=true; this.value='Sending…';">REGIST</button>
          </fieldset>
        
        </div>
      </div>
    </div>

    
  </div>
</template>
<style>
  .heart {
    width: 500px;
    height: 500px;
    background: #ea2027;
    position: relative;
    transform: rotate(45deg);
  }
  .heart::before,
  .heart::after {
    content: "";
    width: 500px;
    height: 500px;
    position: absolute;
    border-radius: 50%;
    background: #ea2027;
  }
  .heart::before {
    left: -50%;
  }
  .heart::after {
    top: -50%;
  }
</style>
<script>
import { mapState, mapGetters } from "vuex";
export default {
  name: "VideoDetail",
  methods: {
    clickLike(){
      this.$store.dispatch("addLike",this.video);
    },
    updateVideo() {
      this.$store.dispatch("updateVideo", this.video);
    },
    deleteVideo() {
      this.$store.dispatch("deleteVideo", this.video.id);
    },
    async setVideo(id) {
      await this.$store.dispatch("setVideo", id);
    },
    async searchReview(id) {
      await this.$store.dispatch("searchReviewVideoid", id);
    },

    ReviewRegist() {
      if (
        this.title === "" ||
        this.content === ""
      ) {
        alert("제목과 내용을 모두 입력해주세요");
        return;
      }

      let review = {
        userid: this.loginUser.id,
        videoid: this.video.id,
        title: this.title,
        content: this.content,
      };

      this.$store.dispatch("createReview", review);
      // this.$router.go(this.$router.currentRoute);
    },

  },
  computed: {
    ...mapState(["video"]),
    ...mapState(["searchReviews"]),
    ...mapGetters(["searchReviewCnt"]),
    ...mapState(["loginUser"]),
  },
  created() {
    const pathName = new URL(document.location).pathname.split("/");
    const id = pathName[pathName.length - 1];
    this.setVideo(id);
    this.searchReview(id);
  },
};
</script>
