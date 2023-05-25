<template>
  <div class="container">
    <br>
    <video-search></video-search>
    <div class="row" style="margin-bottom:20px;">
      <div class="col">
        <font style="font-family: 'Cyber'; font-weight:bold; font-size:40px;">VIDEOS</font>
      </div> 
      <div class="col" style="text-align:right;" >
        <router-link :to="{ name: 'VideoRegist' }"  v-if="loginUser">
          <button class="btn btn-primary btn-lg" style="font-family: 'Cyber'; font-size:20px; border-radius:5px; width:120px;">
            REGIST
          </button>
        </router-link>
      </div>
      <!-- Example single danger button -->
      <div class="btn-group" style="width:200px;">
        <button type="button" class="btn btn-danger dropdown-toggle btn-lg" style="font-family: 'Cyber'; font-size:20px; border-radius:5px;" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" :part="part">
          <!-- {{ part }} -->
      
          <font v-if="part === '등'">BACK</font>
          <font v-else-if="part === '가슴'">CHEST</font>
          <font v-else-if="part === '하체'">LEG</font>
          <font v-else-if="part === '어깨'">SHOULDER</font>
          <font v-else-if="part === '팔'">ARM</font>
          <font v-else-if="part === '전신'">BODY</font>
          <font v-else>ALL</font>
        </button>
        <div class="dropdown-menu" style="font-family: 'Cyber';">
          <a class="dropdown-item" @click="part='등'">BACK</a>
          <a class="dropdown-item"  @click="part='가슴'">CHEST</a>
          <a class="dropdown-item"  @click="part='하체'">LEG</a>
          <a class="dropdown-item"  @click="part='어깨'">SHOULDER</a>
          <a class="dropdown-item"  @click="part='팔'">ARM</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item"  @click="part='전신'">BODY</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item"  @click="part='ALL'">ALL</a>
        </div>
      </div>
    </div>
    <div v-if="videoCnt">
    <div class="row">
      <b-row align-v="center" align-h="center">
        <b-pagination v-model="currentPage"
          :total-rows="this.videos.length"
          :per-page="perPage">
        </b-pagination>
      
          
      <div class="col" v-for="(video, index) in paginatedBoardList" :key="index" >
        <div v-if="video.fitpartname===part"  >
          <div  style="border-radius:100px; margin-top:20px; margin-bottom:5px;">
            <iframe
              style="border-radius:15px;"
              width="400" 
              height="220" :src="`https://www.youtube.com/embed/${ video.youtubeurl }`"
              frameborder="0" 
              allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
              allowfullscreen>
            </iframe>
          
          <router-link class="video-link" :to="`/video/${video.id}`" style="text-decoration-line: none;">
            <div><font style="font-weight:bold; font-size:25px; ">{{ video.title.substring(0,20) }}</font></div>
            <div><font style="font-weight:; font-size:15px; color:black;">{{ video.content.substring(0, 30) }}</font></div>
          </router-link>
        </div>
        </div>
        <div v-else-if="part==='ALL'">
          <div style="border-radius:100px; margin-top:20px; margin-bottom:5px;">
            <iframe
              style="border-radius:15px;"
              width="400" 
              height="220" :src="`https://www.youtube.com/embed/${ video.youtubeurl }`"
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
        </b-row>
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
  data(){
    return{
      part:"ALL",
      perPage: 6,
      currentPage:1,
    }
  },
  methods: {
    
  },
  
  computed: { 
    ...mapState(["videos"]),
    ...mapGetters(["videoCnt"]),
    ...mapState(["loginUser"]), 
    paginatedBoardList() {
        const start = (this.currentPage - 1) * this.perPage;
        const end = start + this.perPage;
        // let list=[];
        // for(let video in this.videos){
        //   if(video.fitpartname===this.part){
        //     list.push(video);
        //   }
        // }
        // console.log(this.part);
      

        return this.videos.slice(start, end);

      },
  },
  created() {
   this.$store.dispatch("setVideos");
  },
  components: {
    VideoSearch,
  }
};
// $(document).on("click", ".Like", function () {
//     let like = $(this).data('id');
//     let video = this.videos[D];
//     console.log(video);
     
// });
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
