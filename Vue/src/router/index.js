import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import LoginForm from "@/components/LoginForm.vue";
import User from "../views/User.vue";
import UserList from "@/components/user/UserList.vue";
import UserRegist from "@/components/user/UserRegist.vue";
import UserDetail from "@/components/user/UserDetail.vue";
import Video from "../views/Video.vue";
import VideoList from "@/components/video/VideoList.vue";
import VideoRegist from "@/components/video/VideoRegist.vue";
import VideoDetail from "@/components/video/VideoDetail.vue";
import Review from "../views/Review.vue";
import ReviewList from "@/components/review/ReviewList.vue";
import ReviewRegist from "@/components/review/ReviewRegist.vue";
import ReviewDetail from "@/components/review/ReviewDetail.vue";
import Recommend from "../views/Recommend.vue";
import OneRM from "@/components/recommend/OneRM.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/login",
    name: "Login",
    component: LoginForm,
  },
  {
    path: "/user",
    component: User,
    children: [
      {
        path: "regist",
        name: "UserRegist",
        component: UserRegist,
      },
      {
        path: "",
        name: "UserList",
        component: UserList,
      },
      {
        path: ":id",
        name: "UserDetail",
        component: UserDetail,
      },
    ],
  },
  {
    path: "/video",
    component: Video,
    children: [
      {
        path: "regist",
        name: "VideoRegist",
        component: VideoRegist,
      },
      {
        path: "",
        name: "VideoList",
        component: VideoList,
      },
      {
        path: ":id",
        name: "VideoDetail",
        component: VideoDetail,
      },
    ],
  },
  {
    path: "/review",
    component: Review,
    children: [
      {
        path: "regist",
        name: "ReviewRegist",
        component: ReviewRegist,
      },
      {
        path: "",
        name: "ReviewList",
        component: ReviewList,
      },
      {
        path: ":id",
        name: "ReviewDetail",
        component: ReviewDetail,
      },
    ],
  },
  {
    path: "/recommend",
    component: Recommend,
    children: [
      {
        path: "",
        name: "OneRM",
        component: OneRM,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
