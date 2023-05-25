<template>
  <div class="container" style="font-family: 'Cyber';">
    <br>
    <h2>REVIEW DETAIL</h2>
    <fieldset class="text-center">
      <label for="id">ID</label>
      <input
        readonly
        type="text"
        id="id"
        v-model="review.id"
        class="view"
      /><br />
      <label for="id">USER ID</label>
      <input
        readonly
        type="text"
        id="userid"
        v-model="review.userid"
        class="view"
      /><br />
      <label for="id">VIDEO ID</label>
      <input
        readonly
        type="text"
        id="videoid"
        v-model="review.videoid"
        class="view"
      /><br />

      <label for="title">TITLE</label>
      <input type="text" id="title" v-model="review.title" class="view" /><br />
      <label for="content">CONTENT</label>
      <input type="text" id="content" v-model="review.content" class="view" /><br />
      <button class="btn btn-lg" style="background-color:greenyellow; font-weight:bold;" @click="updateReview">EDIT</button>
      <button class="btn btn-lg" style="background-color:greenyellow; font-weight:bold;" @click="deleteReview">DELETE</button>
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
