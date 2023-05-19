import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from "../router";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    users: [],
    searchUsers: [],
    user: {},
    loginUser: null,
    randomUser: null,
    videos: [],
    searchVideos: [],
    video: {},
    reviews: [],
    searchReviews: [],
    review: {},
  },
  getters: {
    userCnt: function (state) {
      return state.users.length;
    },
    searchUserCnt: function (state) {
      return state.searchUsers.length > 0 ? state.searchUsers.length : null;
    },
    videoCnt: function (state) {
      return state.videos.length;
    },
    searchVideoCnt: function (state) {
      return state.searchVideos.length > 0 ? state.searchVideos.length : null;
    },
    reviewCnt: function (state) {
      return state.reviews.length;
    },
    searchReviewCnt: function (state) {
      return state.searchReviews.length > 0 ? state.searchReviews.length : null;
    },
  },
  mutations: {
    CREATE_USER: function (state, user) {
      state.users.push(user);
    },
    SET_USERS: function (state, users) {
      state.users = users;
    },
    SET_USER: function (state, user) {
      state.user = user;
    },
    SEARCH_NAME: function (state, users) {
      state.searchUsers = users;
    },
    SET_LOGIN_USER: function (state, user) {
      state.loginUser = user;
    },
    LOGOUT: function (state) {
      state.loginUser = null;
      alert("로그아웃 되었습니다.");
      router.push("/");
    },
    SET_RANDOM_USER: function (state, user) {
      state.randomUser = user;
    },
    CREATE_VIDEO: function (state, video) {
      state.videos.push(video);
    },
    SET_VIDEOS: function (state, videos) {
      state.videos = videos;
    },
    SET_VIDEO: function (state, video) {
      state.video = video;
    },
    SEARCH_VIDEO_TITLE: function (state, videos) {
      state.searchVideos = videos;
    },
    CREATE_REVIEW: function (state, review) {
      state.reviews.push(review);
    },
    SET_REVIEWS: function (state, reviews) {
      state.reviews = reviews;
    },
    SET_REVIEW: function (state, review) {
      state.review = review;
    },
    SEARCH_REVIEW_VIDEOID: function (state, reviews) {
      state.searchReviews = reviews;
    },
    RESET_STATE: function (state) {
      state.searchUsers = [];
      state.searchVideos = [];
      state.searchReviews = [];
    },
  },
  actions: {
    createUser: function ({ commit }, user) {
      console.log(user)
      const API_URL = `http://localhost:9999/userapi/user`;
      axios({
        url: API_URL,
        method: "POST",
        data: user,
      })
        .then(() => {
          commit("CREATE_USER", user);
          alert("등록되었습니다.");
          router.push("/login");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setUsers: function ({ commit }) {
      const API_URL = `http://localhost:9999/userapi/user`;
      return axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log("user setting...");
          console.log(res.data);
          commit("SET_USERS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    updateUser: function ({commit}, user) {
      console.log(commit);
      const API_URL = `http://localhost:9999/userapi/user`;
      axios({
        url: API_URL,
        method: "PUT",
        data: user,
      })
        .then(() => {
          alert("수정 완료!");
          router.push("/user");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    deleteUser: function ({ state }, id) {
      const API_URL = `http://localhost:9999/userapi/user/${id}`;
      axios({
        url: API_URL,
        method: "DELETE",
      })
        .then(() => {
          alert("삭제 완료!");
          let index;
          for (let i = 0; i < state.users.length; i++) {
            if (state.users[i].id === id) {
              index = i;
            }
          }
          state.users.splice(index, 1);
          router.push("/user");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setUser: function ({ commit }, id) {
      const API_URL = `http://localhost:9999/userapi/user/${id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("SET_USER", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    searchName: function ({ commit }, name) {
      const API_URL = `http://localhost:9999/userapi/user/search`;
      axios({
        url: API_URL,
        method: "GET",
        params: {
          key: "name",
          word: name,
        },
      })
        .then((res) => {
          commit("SEARCH_NAME", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    // searchName2: function ({ commit }, name) {
    //   const API_URL = `http://localhost:9999/userapi/user/search`;
    //   axios({
    //     url: API_URL,
    //     method: "POST",
    //     data: {
    //       key: "name",
    //       word: name,
    //     },
    //   })
    //     .then((res) => {
    //       commit("SEARCH_NAME", res.data);
    //     })
    //     .catch((err) => {
    //       console.log(err);
    //     });
    // },
    setLoginUser: function ({ commit }, user) {
      const API_URL = `http://localhost:9999/userapi/user/${user.id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          let resUser = res.data;
          if (resUser.id === user.id && resUser.password === user.password) {
            alert("로그인 성공!");
            commit("SET_LOGIN_USER", res.data);
            router.push("/");
          } else {
            alert("로그인 실패");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setRandomUser: async function ({ commit }) {
      const API_URL = `https://random-data-api.com/api/users/random_user`;

      try {
        const res = await axios.get(API_URL);
        let user = {
          id: res.data.username,
          password: res.data.password,
          name: res.data.first_name,
          email: res.data.email,
          age: Math.floor(Math.random() * (99 - 20)) + 20,
        };
        commit("SET_RANDOM_USER", user);
      } catch (err) {
        console.log(err);
      }
    },

    createVideo: function ({ commit }, video) {
      console.log(video)
      const API_URL = `http://localhost:9999/userapi/video`;
      axios({
        url: API_URL,
        method: "POST",
        data: video,
      })
        .then(() => {
          commit("CREATE_VIDEO", video);
          alert("등록되었습니다.");
          router.push("/video");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setVideos: function ({ commit }) {
      const API_URL = `http://localhost:9999/userapi/video`;
      return axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log("video setting...");
          console.log(res.data);
          commit("SET_VIDEOS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    updateVideo: function ({commit}, video) {
      console.log(commit);
      const API_URL = `http://localhost:9999/userapi/video`;
      axios({
        url: API_URL,
        method: "PUT",
        data: video,
      })
        .then(() => {
          alert("수정 완료!");
          router.push("/video");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    deleteVideo: function ({ state }, id) {
      const API_URL = `http://localhost:9999/userapi/video/${id}`;
      axios({
        url: API_URL,
        method: "DELETE",
      })
        .then(() => {
          alert("삭제 완료!");
          let index;
          for (let i = 0; i < state.videos.length; i++) {
            if (state.videos[i].id === id) {
              index = i;
            }
          }
          state.videos.splice(index, 1);
          router.push("/video");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setVideo: function ({ commit }, id) {
      const API_URL = `http://localhost:9999/userapi/video/${id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("SET_VIDEO", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    searchVideoTitle: function ({ commit }, title) {
      const API_URL = `http://localhost:9999/userapi/video/search`;
      axios({
        url: API_URL,
        method: "GET",
        params: {
          key: "title",
          word: title,
        },
      })
        .then((res) => {
          commit("SEARCH_VIDEO_TITLE", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    createReview: function ({ commit }, review) {
      console.log(review)
      const API_URL = `http://localhost:9999/userapi/review`;
      axios({
        url: API_URL,
        method: "POST",
        data: review,
      })
        .then(() => {
          commit("CREATE_REVIEW", review);
          alert("등록되었습니다.");
          // router.push(`/video/${review.videoid}`);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setReviews: function ({ commit }) {
      const API_URL = `http://localhost:9999/userapi/review`;
      return axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log("review setting...");
          console.log(res.data);
          commit("SET_REVIEWS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    updateReview: function ({commit}, review) {
      console.log(commit);
      const API_URL = `http://localhost:9999/userapi/review`;
      axios({
        url: API_URL,
        method: "PUT",
        data: review,
      })
        .then(() => {
          alert("수정 완료!");
          router.push("/review");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    deleteReview: function ({ state }, id) {
      const API_URL = `http://localhost:9999/userapi/review/${id}`;
      axios({
        url: API_URL,
        method: "DELETE",
      })
        .then(() => {
          alert("삭제 완료!");
          let index;
          for (let i = 0; i < state.reviews.length; i++) {
            if (state.reviews[i].id === id) {
              index = i;
            }
          }
          state.reviews.splice(index, 1);
          router.push("/review");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setReview: function ({ commit }, id) {
      const API_URL = `http://localhost:9999/userapi/review/${id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("SET_REVIEW", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    searchReviewVideoid: function ({ commit }, videoid) {
      const API_URL = `http://localhost:9999/userapi/review/search`;
      axios({
        url: API_URL,
        method: "GET",
        params: {
          key: "videoid",
          word: videoid,
        },
      })
        .then((res) => {
          commit("SEARCH_REVIEW_VIDEOID", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  modules: {},
});
