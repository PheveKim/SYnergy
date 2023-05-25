<template>
  <div class="container" style="font-family: 'Cyber';">
    <div class="text-center">
      <div class="input-group rounded" style="font-family: 'Cyber';">
        <input 
          type="text" 
          class="form-control" 
          placeholder="USER NAME" 
          aria-label="Search"
          v-model="search" 
          aria-describedby="search-addon" 
          v-on:keyup.enter="searchUser"/>
        <button class="input-group-text border-0" id="search-addon" v-on:click="searchUser" >
          <font style="font-family: 'Cyber';">SEARCH</font>
        </button>
      </div>
    </div>
    <br>
    <div>
      <div v-if="searchUserCnt">
        <div v-if="loginUser.id == 'admin'">
          <h2 style="font-family: 'Cyber';">RESULTS</h2>
          <table class="table">
            <colgroup>
              <col style="width: 5%" />
              <col style="width: 40%" />
              <col style="width: 20%" />  
              <col style="width: 20%" />
              <col style="width: 15%" />
            </colgroup>
            <thead class="thead-dark">
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
          <h2 style="font-family: 'Cyber';">RESULTS</h2>
          <table class="table">
            <colgroup>
              <col style="width: 10%" />
              <col style="width: 45%" />
              <col style="width: 45%" />
            </colgroup>
            <thead class="thead-dark">
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
                  <router-link class="user-link" :to="`/user/${user.id}`" style="text-decoration-line: none;" v-if="loginUser.id === `${user.id}`">
                  {{ user.id }}
                  </router-link>
                  <font v-else>{{ user.id }}</font>
                </td>
                <td>{{ user.name }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <div v-else-if="this.fl">
        <h2 style="font-family: 'Cyber';">RESULTS</h2>
        No Results
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
