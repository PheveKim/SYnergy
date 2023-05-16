<template>
  <div class="container">
    <h2>리뷰 등록</h2>
    <fieldset class="text-center">
      <label for="id">아이디</label>
      <input type="text" id="id" v-model="id" class="view" /><br />
      <label for="userid">작성자 아이디</label>
      <input type="text" id="userid" v-model="userid" class="view" /><br />
      <label for="videoid">운동영상 아이디</label>
      <input type="text" id="videoid" v-model="videoid" class="view" /><br />
      <label for="title">제목</label>
      <input type="text" id="title" v-model="title" class="view" /><br />
      <label for="content">내용</label>
      <input type="text" id="content" v-model="content" class="view" /><br />
      <button type="button" class="btn btn-warning btn-lg" @click="regist">등록</button>
    </fieldset>
  </div>
</template>
<script>
// import { mapState } from "vuex";
export default {
  name: "ReviewList",
  data() {
    return {
      id: "",
      userid: "",
      videoid: "",
      title: "",
      content: "",
    };
  },
  methods: {
    regist() {
      if (
        this.id === "" ||
        this.userid === "" ||
        this.videoid === "" ||
        this.title === "" ||
        this.content === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      }

      let review = {
        id: this.id,
        userid: this.userid,
        videoid: this.videoid,
        title: this.title,
        content: this.content,
      };

      this.$store.dispatch("createReview", review);
    },
  },
};
</script>
