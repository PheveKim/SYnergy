<template>
  <div class="container">
    <h2>운동 영상</h2>
    <h4>등록된 영상 수 : {{ videoCnt }}</h4>
    <div v-if="videoCnt">
      <table class="video-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 40%" />
          <col style="width: 20%" />
          <col style="width: 20%" />
          <col style="width: 15%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>아이디</th>
            <th>제목</th>
            <th>내용</th>
            <th>url</th>
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
            <td>{{ video.url }}</td>
          </tr>
        </tbody>
      </table>
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
