<template>
  <div class="container" style="font-family: 'Cyber';">
    <div class="text-center">
      <div class="input-group rounded" style="font-family: 'Cyber';">
        <input 
          type="text" 
          class="form-control" 
          placeholder="VIDEO ID" 
          aria-label="Search"
          v-model="search" 
          aria-describedby="search-addon" 
          v-on:keyup.enter="searchReview"/>
        <button class="input-group-text border-0" id="search-addon" v-on:click="searchReview" >
          SEARCH
        </button>
      </div>
    </div>
    
    <div>
      <div v-if="searchReviewCnt">
        <br>
        <h2 style="font-family: 'Cyber';">RESULTS</h2>
        <table class="table text-center">
          <colgroup>
            <col style="width: 5%" />
            <col style="width: 10%" />
            <col style="width: 15%" />
            <col style="width: 30%" />
            <col style="width: 30%" />
            <col style="width: 5%" />
          </colgroup>
          <thead class="thead-dark">
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
            <tr v-for="(review, index) in searchReviews" :key="index">
              <td>{{ index + 1 }}</td>
              <td>{{ review.userid }}</td>
              <td>{{ review.videoid }}</td>
              <td>{{ review.title }}</td>
              <td>{{ review.content }}</td>
              <td>
              <router-link class="review-link" :to="`/review/${review.id}`">
                <button class="btn" style="width:90px; background-color:gold;">수정하기</button>
              </router-link>
            </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div v-else-if="this.fl">
        <br>
        <h2 style="font-family: 'Cyber';">RESULTS</h2>
        No results
      </div>
    </div>
    <br />
  </div>
</template>
<script>
import { mapState, mapGetters } from "vuex";
export default {
  name: "ReviewSearch",
  data() {
    return {
      search: "",
      fl:false,
    };
  },
  methods: {
    searchReview() {
      if(this.search==="") {
        alert("운동영상 아이디를 입력해주세요.");
        return;
      }
      else {
        this.$store.dispatch("searchReviewVideoid", this.search);
        this.fl=true;
      }
    },
  },
  computed: {
    ...mapState(["searchReviews"]),
    ...mapGetters(["searchReviewCnt"]),
  },
};
</script>
