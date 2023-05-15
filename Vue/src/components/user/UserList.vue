<template>
  <div class="container">
    <h2>사용자 목록</h2>
    <h4>등록된 사용자의 수 : {{ userCnt }}</h4>
    <div v-if="userCnt">
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
          <tr v-for="(user, index) in users" :key="index">
            <td>{{ index + 1 }}</td>
            <td>
              <router-link class="user-link" :to="`/${user.id}`">{{
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
    <div v-else>등록된 사용자가 없습니다.</div>
  </div>
</template>
<script>
import { mapState, mapGetters } from "vuex";
export default {
  name: "UserList",
  methods: {},
  computed: {
    ...mapState(["users"]),
    ...mapGetters(["userCnt"]),
  },
  created() {
   this.$store.dispatch("setUsers");
  },
};
</script>
