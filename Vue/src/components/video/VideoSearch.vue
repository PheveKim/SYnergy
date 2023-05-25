<template>
  <div class="container" style="font-family: 'Cyber';">
    <div class="text-center">
      <div class="input-group rounded">
        <input 
          style="border:1px solid #e1e1e1;"
          type="text" 
          class="form-control" 
          placeholder="VIDEO TITLE" 
          aria-label="Search"
          v-model="search" 
          aria-describedby="search-addon" 
          v-on:keyup.enter="searchVideo"/>
        <button class="input-group-text border-0" id="search-addon" v-on:click="searchVideo" >
          <font style="font-family: 'Cyber'">SEARCH</font>
        </button>
      </div>
    </div>

    <br />
    <div>
      <div v-if="searchVideoCnt">
      <h2 style="font-family: 'Cyber';">RESULTS</h2>
        <div class="row">
          <b-row align-v="center" align-h="center">
        <b-pagination v-model="currentPage"
          :total-rows="this.searchVideos.length"
          :per-page="perPage">
        </b-pagination>
      
          <div class="col" v-for="(video, index) in paginatedBoardList" :key="index">
            <!-- <div>{{ index + 1 }}</div> -->
            <!-- <div>
              <router-link class="video-link" :to="`/video/${video.id}`">{{
                video.id
              }}</router-link>
            </div> -->
            <div style="border-radius:100px; margin-top:20px; margin-bottom:5px;">
              <iframe
                style="border-radius:15px;"
                width="350" 
                height="200" :src="`https://www.youtube.com/embed/${ video.youtubeurl }`"
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
          </b-row>
        </div>
        </div>
      <div v-else-if="this.fl">
        <h2 style="font-family: 'Cyber';">RESULTS</h2>
         No Results
      </div>
    </div>
    <br />
  </div>
</template>
<script>
import { mapState, mapGetters } from "vuex";

export default {
  name: "VideoSearch",
  data() {
    return {
      search: "",
      fl:false,
      perPage:3,
      currentPage:1,
    };
  },
  methods: {
    searchVideo() {
      if(this.search===""){
        alert("제목을 입력해주세요.");
        return;
      }
      else{
        this.$store.dispatch("searchVideoTitle", this.search);
        this.fl=true;
      }
    },
  },
  computed: {
    ...mapState(["searchVideos"]),
    ...mapGetters(["searchVideoCnt"]),
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
      

        return this.searchVideos.slice(start, end);

      },
  },
};
</script>
