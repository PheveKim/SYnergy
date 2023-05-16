<template>
  <div class="container">
    <div class="text-center">
      <input
        class="view"
        type="text"
        v-model="search"
        placeholder="이름을 입력하세요."
        v-on:keyup.enter="searchReview"
      />
      <button type="button" class="btn btn-warning btn-lg" v-on:click="searchReview">검색</button>
    </div>

    <br />
    <hr />
    <div>
      <h2>검색 결과</h2>
      <div v-if="searchReviewCnt">
        <table class="review-list">
          <colgroup>
            <col style="width: 5%" />
            <col style="width: 20%" />
            <col style="width: 20%" />
            <col style="width: 20%" />
            <col style="width: 15%" />
            <col style="width: 20%" />
          </colgroup>
          <thead>
            <tr>
              <th>번호</th>
              <th>아이디</th>
              <th>작성자 아이디</th>
              <th>운동영상 아이디</th>
              <th>제목</th>
              <th>내용</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(review, index) in searchReviews" :key="index">
              <td>{{ index + 1 }}</td>
              <td>
                <router-link class="review-link" :to="`/review/${review.id}`">{{
                  review.id
                }}</router-link>
              </td>
              <td>{{ review.userid }}</td>
              <td>{{ review.videoid }}</td>
              <td>{{ review.title }}</td>
              <td>{{ review.content }}</td>
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
// import { mapState, ___________, mapGetters } from "vuex";
import { mapState, mapGetters } from "vuex";
export default {
  name: "ReviewSearch",
  data() {
    return {
      search: "",
    };
  },
  methods: {
    searchReview() {
      this.$store.dispatch("searchReview", this.search);
    },
  },
  computed: {
    ...mapState(["searchReviews"]),
    ...mapGetters(["searchReviewCnt"]),
  },
};
</script>
