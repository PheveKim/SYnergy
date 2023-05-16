<template>
  <div class="container">
    <h2>영상 등록</h2>
    <fieldset class="text-center">
      <label for="id">아이디</label>
      <input type="text" id="id" v-model="id" class="view" /><br />
      <label for="title">제목</label>
      <input type="text" id="title" v-model="title" class="view" /><br />
      <label for="content">내용</label>
      <input type="text" id="content" v-model="content" class="view" /><br />
      <label for="url">url</label>
      <input type="text" id="url" v-model="url" class="view" /><br />
      <button type="button" class="btn btn-warning btn-lg" @click="regist">등록</button>
    </fieldset>
  </div>
</template>
<script>
// import { mapState } from "vuex";
export default {
  name: "VideoList",
  data() {
    return {
      id: "",
      title: "",
      content: "",
      url: "",
    };
  },
  methods: {
    regist() {
      if (
        this.id === "" ||
        this.title === "" ||
        this.content === "" ||
        this.url === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      }

      let video = {
        id: this.id,
        title: this.title,
        content: this.content,
        url: this.url,
      };

      this.$store.dispatch("createVideo", video);
    },
  },
};
</script>
