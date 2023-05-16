<template>
  <div class="container">
    <h2>영상 정보</h2>
    <fieldset class="text-center">
      <label for="id">아이디</label>
      <input
        readonly
        type="text"
        id="id"
        v-model="video.id"
        class="view"
      /><br />
      <label for="title">제목</label>
      <input type="text" id="title" v-model="video.title" class="view" /><br />
      <label for="content">내용</label>
      <input type="text" id="content" v-model="video.content" class="view" /><br />
      <label for="url">url</label>
      <input type="text" id="url" v-model="video.url" class="view" /><br />
      <button class="btn" @click="updateVideo">수정</button>
      <button class="btn" @click="deleteVideo">삭제</button>
    </fieldset>
  </div>
</template>
<script>
import { mapState } from "vuex";
export default {
  name: "VideoDetail",
  methods: {
    updateVideo() {
      this.$store.dispatch("updateVideo", this.video);
    },
    deleteVideo() {
      this.$store.dispatch("deleteVideo", this.video.id);
    },
    async setVideo(id) {
      await this.$store.dispatch("setVideo", id);
    },
  },
  computed: {
    ...mapState(["video"]),
  },
  created() {
    const pathName = new URL(document.location).pathname.split("/");
    const id = pathName[pathName.length - 1];
    this.setVideo(id);
  },
};
</script>
