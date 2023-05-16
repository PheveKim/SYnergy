<template>
  <div class="container">
    <div class="text-center">
      <input
        class="view"
        type="text"
        v-model="search"
        placeholder="이름을 입력하세요."
        v-on:keyup.enter="searchVideo"
      />
      <button type="button" class="btn btn-warning btn-lg" v-on:click="searchVideo">검색</button>
    </div>


   

    <br />
    <hr />
    <div>
      <h2>검색 결과</h2>
      <div v-if="searchVideoCnt">
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
              <th>운동영상 아이디</th>
              <th>제목</th>
              <th>내용</th>
              <th>url</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(video, index) in searchVideos" :key="index">
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
      <div v-else>검색 결과가 없습니다.</div>
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
    };
  },
  methods: {
    searchVideo() {
      this.$store.dispatch("searchVideo", this.search);
    },
  },
  computed: {
    ...mapState(["searchVideos"]),
    ...mapGetters(["searchVideoCnt"]),
  },
};
</script>
