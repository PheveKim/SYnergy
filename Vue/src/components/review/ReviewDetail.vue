<template>
  <div class="container">
    <h2>리뷰 정보</h2>
    <fieldset class="text-center">
      <label for="id">아이디</label>
      <input
        readonly
        type="text"
        id="id"
        v-model="review.id"
        class="view"
      /><br />
      <label for="id">작성자 아이디</label>
      <input
        readonly
        type="text"
        id="userid"
        v-model="review.userid"
        class="view"
      /><br />
      <label for="id">운동영상 아이디</label>
      <input
        readonly
        type="text"
        id="videoid"
        v-model="review.videoid"
        class="view"
      /><br />

      <label for="title">제목</label>
      <input type="text" id="title" v-model="review.title" class="view" /><br />
      <label for="content">내용</label>
      <input type="text" id="content" v-model="review.content" class="view" /><br />
      <button class="btn" @click="updateReview">수정</button>
      <button class="btn" @click="deleteReview">삭제</button>
    </fieldset>
  </div>
</template>
<script>
import { mapState } from "vuex";
export default {
  name: "ReviewDetail",
  methods: {
    updateReview() {
      this.$store.dispatch("updateReview", this.review);
    },
    deleteReview() {
      this.$store.dispatch("deleteReview", this.review.id);
    },
    async setReview(id) {
      await this.$store.dispatch("setReview", id);
    },
  },
  computed: {
    ...mapState(["review"]),
  },
  created() {
    const pathName = new URL(document.location).pathname.split("/");
    const id = pathName[pathName.length - 1];
    this.setReview(id);
  },
};
</script>
