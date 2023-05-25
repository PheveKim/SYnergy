<template>
  <div class="container" style="margin-top:20px; font-family: 'Cyber';">
    <font style="font-weight:bold; font-size:30px; font-family: 'Cyber';">SEARCH USERS</font><br>
    <user-search style="margin-top:20px;"></user-search>
    <hr>
    <br>
    <font style="font-weight:bold; font-size:30px; font-family: 'Cyber';">USER LIST</font>
    <h4 style="font-family: 'Cyber';">REGISTERED : {{ userCnt }}</h4><br>
    <div v-if="userCnt">
      <div v-if="loginUser.id == 'admin'">
        <table class="table text-center">
          <colgroup>
            <col style="width: 5%" />
            <col style="width: 20%" />
            <col style="width: 15%" />
            <col style="width: 25%" />
            <col style="width: 15%" />
            <col style="width: 20%" />
          </colgroup>
          <thead class="thead-dark">
            <tr>
              <th>번호</th>
              <th>아이디</th>
              <th>이름</th>
              <th>이메일</th>
              <th>나이</th>
              <th>관리</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(user, index) in users" :key="index">
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
              <td>
                <!-- <button class="btn btn-sm" :id=user.id @click="deleteUser" style="background-color:gold; width:80px;" v-if="user.id != 'admin'">회원탈퇴</button> -->
                <!-- <button :id=user.id data-toggle="modal" data-target="#RemoveCheckModal" class="btn btn-sm" style="background-color:gold; width:80px;" v-if="user.id != 'admin'">회원탈퇴</button> -->
                <button :data-id=user.id data-toggle="modal" data-target="#RemoveCheckModal" class="delUser btn btn-sm" style="background-color:gold; width:80px;" v-if="user.id != 'admin'">DELETE</button>
                <button class="btn btn-sm" style="background-color:silver; width:80px;" v-if="user.id === 'admin'">DELETE</button>
              </td>
            </tr>
          </tbody>
        </table> 
      </div>

      <div v-else-if="loginUser.id != 'admin'">
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
            <tr v-for="(user, index) in users" :key="index">
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
    <div v-else>No users</div>
    <br>
    <br>
    <!-- Modal -->
    <div class="modal fade" id="RemoveCheckModal" tabindex="-1" role="dialog" aria-labelledby="RemoveCheckModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="RemoveCheckModalLabel"><font style="font-weight:bold;">CAUTION</font></h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body text-center">
            <input readonly id="deleteTargetId" value="" class="text-center" style="width:130px;">
            <br><br>
            <font style="font-size:17px;">DELETE USER?</font>
          </div>
          <div class="text-center" style="margin-bottom:10px;">
            <button type="button" class="btn btn-lg btn-primary" style="font-weight:bold; width:100px;" data-dismiss="modal" @click="deleteUser">DELETE</button>
          </div>
        </div>
      </div>
    </div>
    
  </div>
  
</template>
<script>
import { mapState, mapGetters } from "vuex";
import UserSearch from "@/components/user/UserSearch.vue";
import $ from 'jquery';
export default {
  name: "UserList",
  methods: {
    deleteUser() {
      let user_id = $(".modal-body #deleteTargetId").val();
      this.$store.dispatch("deleteUser", user_id);
    },
  },
  computed: {
    ...mapState(["users"]),
    ...mapGetters(["userCnt"]),
    ...mapState(["loginUser"]),
  },
  created() {
   this.$store.dispatch("setUsers");
  },
  components: {
    UserSearch,
  }
};
$(document).on("click", ".delUser", function () {
     var deleteTargetId = $(this).data('id');
     $(".modal-body #deleteTargetId").val( deleteTargetId );
     
});
</script>
