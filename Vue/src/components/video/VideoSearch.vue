<template>
  <div class="container">
    <div class="text-center">
      <div class="input-group rounded" style="height:50px;">
        <input 
          type="text" 
          class="form-control" 
          placeholder="제목을 검색하세요" 
          aria-label="Search"
          v-model="search" 
          aria-describedby="search-addon" 
          v-on:keyup.enter="searchVideo" />
        <button class="input-group-text border-0" id="search-addon" v-on:click="searchVideo" >
          검색
        </button>
      </div>
    </div>


   

    <br />
    <div>
      <div v-if="searchVideoCnt">
      <h2>검색 결과</h2>
        <div class="row">
          <div class="col" v-for="(video, index) in searchVideos" :key="index">
            <!-- <div>{{ index + 1 }}</div> -->
            <!-- <div>
              <router-link class="video-link" :to="`/video/${video.id}`">{{
                video.id
              }}</router-link>
            </div> -->
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
      <div v-else-if="this.fl">
        <h2>검색 결과</h2>
        검색 결과가 없습니다.
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
    };
  },
  methods: {
    searchVideo() {
      this.$store.dispatch("searchVideoTitle", this.search);
      this.fl = true;
    },
  },
  computed: {
    ...mapState(["searchVideos"]),
    ...mapGetters(["searchVideoCnt"]),
  },
};
</script>
