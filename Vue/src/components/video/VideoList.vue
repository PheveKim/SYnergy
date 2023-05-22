<template>
  <div class="container">
    <video-search></video-search>
    <div class="row">
      <div class="col">
        <font style="font-weight:bold; font-size:30px;">운동 영상 목록 ({{ videoCnt }})</font>
      </div> 
      <div class="col" style="text-align:right;" >
        <router-link :to="{ name: 'VideoRegist' }"  v-if="loginUser">
          <button class="btn btn-lg" style="width:120px; background-color:greenyellow; font-weight:bold;">
            영상등록
          </button>
        </router-link>
      </div>
      <!-- Example single danger button -->
      <div class="btn-group" style="width:200px;">
        <button type="button" class="btn btn-danger dropdown-toggle btn-lg" style="font-weight:bold;" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          운동 부위
        </button>
        <div class="dropdown-menu ">
          <a class="dropdown-item" href="#">등</a>
          <a class="dropdown-item" href="#">가슴</a>
          <a class="dropdown-item" href="#">하체</a>
          <a class="dropdown-item" href="#">어깨</a>
          <a class="dropdown-item" href="#">복근</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">기타</a> 
        </div>
      </div>
    </div>
    <div v-if="videoCnt">

      <div class="row">
        <div class="col" v-for="(video, index) in videos" :key="index">
          <div style="border-radius:100px; margin-top:20px; margin-bottom:5px;">
            <iframe
              style="border-radius:15px;"
              width="400" 
              height="250" :src="`https://www.youtube.com/embed/${ video.youtubeurl }`"
              frameborder="0" 
              allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
              allowfullscreen>
            </iframe>
          </div>
          <router-link class="video-link" :to="`/video/${video.id}`" style="text-decoration-line: none;">
            <div><font style="font-weight:bold; font-size:25px; ">{{ video.title.substring(0,20) }}</font></div>
            <div><font style="font-weight:; font-size:15px; color:black;">{{ video.content.substring(0, 30) }}</font></div>
          </router-link>
        </div>
      </div>
    </div>
    <div v-else>등록된 영상이 없습니다.</div>
  </div>
</template>
<script>
import { mapState, mapGetters } from "vuex";
import VideoSearch from "@/components/video/VideoSearch.vue";
export default {
  name: "VideoList",
  methods: {},
  computed: {
    ...mapState(["videos"]),
    ...mapGetters(["videoCnt"]),
    ...mapState(["loginUser"]),
  },
  created() {
   this.$store.dispatch("setVideos");
  },
  components: {
    VideoSearch,
  }
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
</style>
