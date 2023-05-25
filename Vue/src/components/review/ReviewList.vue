<template>
  <div class="container" style="font-family: 'Cyber';">
    <br>
    <font style="font-weight:bold; font-size:25px;">SEARCH REVIEWS</font><br>
    <review-search style="margin-top:20px;"></review-search>
    <hr>
    <br>
    <font style="font-weight:bold; font-size:30px;">REVIEW LIST</font><br>
    <h4>REGISTERED : {{ reviewCnt }}</h4><br>
    <div v-if="reviewCnt">
      <table class="table text-center">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 10%" />
          <col style="width: 15%" />
          <col style="width: 30%" />
          <col style="width: 30%" />
          <col style="width: 5%" />
        </colgroup>
        <thead class="table-dark">
          <tr>
            <th>번호</th>
            <th>작성자 아이디</th>
            <th>운동영상 아이디</th>
            <th>제목</th>
            <th>내용</th>
            <th>비고</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(review, index) in reviews" :key="index">
            <td>{{ index + 1 }}</td>
            <td>{{ review.userid }}</td>
            <td>{{ review.videoid }}</td>
            <td>{{ review.title }}</td>
            <td>{{ review.content }}</td>
            <td>
              <router-link class="review-link" :to="`/review/${review.id}`" v-if="loginUser.id === 'admin'">
                <button class="btn" style="width:90px; background-color:gold;">EDIT</button>
              </router-link>
              <button class="btn" style="width:90px; background-color:silver;" v-else-if="loginUser.id != 'admin'">EDIT</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <div v-else>등록된 리뷰가 없습니다.</div>
  </div>
</template>
<script>
import { mapState, mapGetters } from "vuex";
import ReviewSearch from "@/components/review/ReviewSearch.vue";
export default {
  name: "ReviewList",
  methods: {},
  computed: {
    ...mapState(["reviews"]),
    ...mapState(["loginUser"]),
    ...mapGetters(["reviewCnt"]),
  },
  created() {
   this.$store.dispatch("setReviews");
  },
  components: {
    ReviewSearch,
  }
};
</script>
