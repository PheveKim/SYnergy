<template>
  <div class="container">
    <div class="text-center">
      <div class="input-group rounded">
        <input 
          type="text" 
          class="form-control" 
          placeholder="이름을 검색하세요." 
          aria-label="Search"
          v-model="search" 
          aria-describedby="search-addon" 
          v-on:keyup.enter="searchUser"/>
        <button class="input-group-text border-0" id="search-addon" v-on:click="searchUser" >
          검색
        </button>
      </div>
    </div>
    <br>
    <div>
      <div v-if="searchUserCnt">
        <div v-if="loginUser.id == 'admin'">
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
                  <router-link class="user-link" :to="`/user/${user.id}`" style="text-decoration-line: none;" v-if="loginUser.id === `${user.id}`">
                  {{ user.id }}
                  </router-link>
                  <font v-else>{{ user.id }}</font>
                </td>
                <td>{{ user.name }}</td>
                <td>{{ user.email }}</td>
                <td>{{ user.age }} 세</td>
              </tr>
            </tbody>
          </table>
        </div>
        <div v-else-if="loginUser.id != 'admin'">
          <h2>검색 결과</h2>
          <table class="user-list">
            <colgroup>
              <col style="width: 10%" />
              <col style="width: 45%" />
              <col style="width: 45%" />
            </colgroup>
            <thead>
              <tr>
                <th>번호</th>
                <th>아이디</th>
                <th>이름</th>
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
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <div v-else-if="this.fl">
        <h2>검색 결과</h2>
        검색 결과가 없습니다.
      </div>
    </div>
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
    ...mapState(["loginUser"]),
  },
};
</script>
