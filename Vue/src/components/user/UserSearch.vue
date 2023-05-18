<template>
  <div class="container">
    <div class="text-center">
      <input
        class="view"
        type="text"
        v-model="search"
        placeholder="이름을 입력하세요."
        v-on:keyup.enter="searchUser"

      />
      
      <button type="button" class="btn btn-lg" style="background-color:greenyellow; font-weight:bold;" v-on:click="searchUser">검색</button>
    </div>


   

    <br />
    <hr />
    <div>
      <div v-if="searchUserCnt">
      <h2>검색 결과</h2>
        <table class="user-list">
          <colgroup>
            <col style="width: 5%" />
            <col style="width: 40%" />
            <col style="width: 20%" />  
            <col style="width: 20%" />
            <col style="width: 15%" />
          </colgroup>
          <thead>
            <tr>
              <th>번호</th>
              <th>아이디</th>
              <th>이름</th>
              <th>이메일</th>
              <th>나이</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(user, index) in searchUsers" :key="index">
              <td>{{ index + 1 }}</td>
              <td>
                <router-link class="user-link" :to="`/user/${user.id}`">{{
                  user.id
                }}</router-link>
              </td>
              <td>{{ user.name }}</td>
              <td>{{ user.email }}</td>
              <td>{{ user.age }} 세</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div v-else-if="this.fl">
        <h2>검색 결과</h2>
        검색 결과가 없습니다.
      </div>
    </div>
    <br />
  </div>
</template>
<script>
import { mapState, mapGetters } from "vuex";
export default {
  name: "UserSearch",
  data() {
    return {
      search: "",
      fl:false,
    };
  },
  methods: {
    searchUser() {
      if(this.search===""){
        alert("이름을 입력해주세요.");
        return;
      }
      else{
        this.$store.dispatch("searchName", this.search);
        this.fl=true;
      }
    },
  },
  computed: {
    ...mapState(["searchUsers"]),
    ...mapGetters(["searchUserCnt"]),
  },
};
</script>
