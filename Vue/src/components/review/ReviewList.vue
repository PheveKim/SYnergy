<template>
  <div class="container">
    <h2>리뷰 목록</h2>
    <h4>등록된 리뷰 수 : {{ reviewCnt }}</h4>
    <div v-if="reviewCnt">
      <table class="review-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 5%" />
          <col style="width: 10%" />
          <col style="width: 10%" />
          <col style="width: 15%" />
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
          <tr v-for="(review, index) in reviews" :key="index">
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
    <div v-else>등록된 리뷰가 없습니다.</div>
  </div>
</template>
<script>
import { mapState, mapGetters } from "vuex";
export default {
  name: "ReviewList",
  methods: {},
  computed: {
    ...mapState(["reviews"]),
    ...mapGetters(["reviewCnt"]),
  },
  created() {
   this.$store.dispatch("setReviews");
  },
};
</script>
