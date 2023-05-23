<template>
  <div class="container">
    <h2>영상 등록</h2>
    <fieldset class="text-center">
      <!-- <label for="id">아이디</label>
      <input type="text" id="id" v-model="id" class="view" /><br /> -->
      <!-- <label for="title">제목</label>
      <input type="text" id="title" v-model="title" class="view" /><br />
      <label for="content">내용</label>
      <input type="text" id="content" v-model="content" class="view" /><br /> -->
      <!-- <label for="fitpartname">운동 부위</label>
      <input type="text" id="fitpartname" v-model="fitpartname" class="view" /><br /> -->
      <label for="youtubeurl">youtubeurl</label>
      <input type="text" id="youtubeurl" v-model="youtubeurl" class="view" /><br />
      <!-- <label for="channelname">channelname</label>
      <input type="text" id="channelname" v-model="channelname" class="view" /><br /> -->
      <button type="button" class="btn btn-lg" onClick="this.disabled=true; this.value='Sending…';" style="background-color:greenyellow; font-weight:bold;" @click="regist">등록</button>
    </fieldset>
  </div>
</template>
<script>
// import { mapState } from "vuex";
export default {
  name: "VideoList",
  data() {
    return {
      // id: "",
      // title: "",
      // content: "",
      // fitpartname: "",
      youtubeurl: "",
      // channelname: "",
    };
  },
  methods: {
    regist() {
      if (
        // this.id === "" ||
        // this.title === "" ||
        // this.content === "" ||
        // this.fitpartname === "" ||
        this.youtubeurl === ""
        // this.channelname === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      }

      let video = {
        // id: this.id,
        // title: this.title,
        // content: this.content,
        // fitpartname: this.fitpartname,
        youtubeurl: this.youtubeurl,
        // channelname: this.channelname,
      };

      this.$store.dispatch("createVideo", video);
    },
  },
};
</script>