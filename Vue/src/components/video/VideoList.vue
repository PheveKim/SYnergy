<template>
  <div class="container">
    <!-- <h2>운동 영상</h2> -->
    <!-- <h4>등록된 영상 수 : {{ videoCnt }}</h4> -->
    <font style="font-weight:bold; font-size:30px;">운동 영상 목록 ({{ videoCnt }})</font>
    <div v-if="videoCnt">

      <div class="row">
        <div class="col" v-for="(video, index) in videos" :key="index">
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

      <!-- <table class="video-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 5%" />
          <col style="width: 35%" />
          <col style="width: 40%" />
          <col style="width: 15%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>아이디</th>
            <th>제목</th>
            <th>내용</th>
            <th>youtubeurl</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(video, index) in videos" :key="index">
            <td>{{ index + 1 }}</td>
            <td>
              <router-link class="video-link" :to="`/video/${video.id}`">{{
                video.id
              }}</router-link>
            </td>
            <td>{{ video.title }}</td>
            <td>{{ video.content }}</td>
            <td>
              <iframe
                width="560" 
                height="315" :src="`https://www.youtube.com/embed/${ video.youtubeurl }`"
                frameborder="0" 
                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
                allowfullscreen>
              </iframe>
            </td>
          </tr>
        </tbody>
      </table> -->
    </div>
    <div v-else>등록된 영상이 없습니다.</div>
  </div>
</template>
<script>
import { mapState, mapGetters } from "vuex";
export default {
  name: "VideoList",
  methods: {},
  computed: {
    ...mapState(["videos"]),
    ...mapGetters(["videoCnt"]),
  },
  created() {
   this.$store.dispatch("setVideos");
  },
};
</script>
