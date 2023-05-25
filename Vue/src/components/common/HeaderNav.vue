<template>
  <header style="background-color:transparent;">
    <nav class="header-nav" style="padding-right:10px; padding-left:10px;">
      <div>
        <router-link  to="/" class="logo">
          <img src="@/assets/synlogo.png" style="width:220px; height:18px; margin-top:5px; margin-bottom:10px; margin-right:10px;" >
        </router-link>
      </div>
      <div style="margin-top:10px;">
        <router-link to="/recommend" style="color:black;">
          <button class="cybr-btn">
            Bard AI<span aria-hidden>_</span>
            <span aria-hidden class="cybr-btn__glitch">SYnergy_</span>
            <span aria-hidden class="cybr-btn__tag">R25</span>
          </button>
        </router-link>
        <!-- <router-link to="/recommend" style="color:black;">AI 추천</router-link> -->
        <router-link to="/video" style="color:black;">
          <button class="cybr-btn">
            Videos<span aria-hidden>_</span>
            <span aria-hidden class="cybr-btn__glitch">SYnergy_</span>
            <span aria-hidden class="cybr-btn__tag">R25</span>
          </button>
        </router-link>
        <router-link to="/user" style="color:black;" v-if="getUser === true">
          <button class="cybr-btn">
            Users<span aria-hidden>_</span>
            <span aria-hidden class="cybr-btn__glitch">SYnergy_</span>
            <span aria-hidden class="cybr-btn__tag">R25</span>
          </button>
        </router-link>
        <a style="color:black; cursor:pointer;" data-toggle="modal" data-target="#loginUserNullModal" v-else>
          <button class="cybr-btn">
            Users<span aria-hidden>_</span>
            <span aria-hidden class="cybr-btn__glitch">SYnergy_</span>
            <span aria-hidden class="cybr-btn__tag">R25</span>
          </button>
        </a>
        <router-link style="color:black;" to="/review" v-if="getUser === true">
          <button class="cybr-btn">
            Reviews<span aria-hidden>_</span>
            <span aria-hidden class="cybr-btn__glitch">SYnergy_</span>
            <span aria-hidden class="cybr-btn__tag">R25</span>
          </button>
        </router-link>
        <a style="color:black; cursor:pointer;" data-toggle="modal" data-target="#loginUserNullModal" v-else>
          <button class="cybr-btn">
            Reviews<span aria-hidden>_</span>
            <span aria-hidden class="cybr-btn__glitch">SYnergy_</span>
            <span aria-hidden class="cybr-btn__tag">R25</span>
          </button>
        </a>
        <span v-if="loginUser===null">
        <router-link style="color:black;" :to="{ name: 'UserRegist' }">
          <button class="cybr-btn">
            REGIST<span aria-hidden>_</span>
            <span aria-hidden class="cybr-btn__glitch">SYnergy_</span>
            <span aria-hidden class="cybr-btn__tag">R25</span>
          </button>
        </router-link>
      </span>
        <div v-if="getUser" class="btn-group" style="padding-bottom:5px; padding-left:10px;">
          <button class="cybr-btn " data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            {{ loginUser.name }}<span aria-hidden>_</span>
            <span aria-hidden class="cybr-btn__glitch">SYnergy_</span>
            <span aria-hidden class="cybr-btn__tag">R25</span>
          </button>
          <div class="dropdown-menu text-center" style="background-color:; border-radius:px; font-family: 'Cyber';">
            <router-link class="user-link" :to="`/user/${loginUser.id}`" style="text-decoration-line: none;">PROFILE</router-link>
            <div class="dropdown-divider"></div>
            <a class="" href="#" v-if="getUser" @click="logout" style="color:black;">LOGOUT</a>
          </div>
          <!-- <button type="button" class="cybr-btn dropdown-toggle" style="border-radius:3px; background-color:#e1e1e1; font-weight:;" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            {{ loginUser.name }}
          </button>
          <div class="dropdown-menu text-center" style="background-color:transparent; border-radius:px;">
            <router-link class="user-link" :to="`/user/${loginUser.id}`" style="text-decoration-line: none;">나의 정보</router-link>
            <div class="dropdown-divider"></div>
            <a class="" href="#" v-if="getUser" @click="logout" style="color:black;">로그아웃</a>
          </div> -->
        </div>
        
        <router-link style="color:black;" to="/login" v-else>
          <button class="cybr-btn">
            LOGIN<span aria-hidden>_</span>
            <span aria-hidden class="cybr-btn__glitch">SYnergy_</span>
            <span aria-hidden class="cybr-btn__tag">R25</span>
          </button>
        </router-link>
      </div>
    </nav>
    
    
    <!-- Modal -->
    <div class="modal fade" style="font-family: 'Cyber';" id="loginUserNullModal" tabindex="-1" role="dialog" aria-labelledby="loginUserNullModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="loginUserNullModalLabel"><font style="font-weight:bold;">NOT ALLOWED</font></h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="text-center" style="margin-top:10px;">
            <font style="font-size:25px;">PLEASE LOGIN</font>
          </div>
          <div class="text-center" style="margin-bottom:10px;">
            <router-link to="/login">
              <button type="button" class="btn btn-primary btn-lg" style="border-radius:5px; font-weight:bold; width:100px;" data-dismiss="modal">LOGIN</button>
            </router-link>
          </div>
        </div>
      </div>
    </div>

  </header>
</template>
<script>
import { mapState } from "vuex";
export default {
  name: "HeaderNav",
  methods: {
    logout() {
      this.$store.commit("LOGOUT");
    },
    reset_state() {
      this.$store.commit("RESET_STATE");
    },
    openModal() {
      this.$bvModal.show('loginUserNullModal');
    },
  },
  computed: {
    ...mapState(["loginUser"]),
    getUser() {
      if (this.loginUser) {
        return true;
      } else {
        return false;
      }
    },
  },
};
</script>
<style>
@font-face {
  font-family: Cyber;
  src: url("https://assets.codepen.io/605876/Blender-Pro-Bold.otf");
  font-display: swap;
}


body {
  font-family: 'Cyber', sans-serif;
}

.cybr-btn {
  --primary: #a1a1a1;
  --shadow-primary: black;
  /* --primary: hsl(var(--primary-hue), 85%, calc(var(--primary-lightness, 50) * 1%));
  --shadow-primary: hsl(var(--shadow-primary-hue), 90%, 50%); */
  --primary-hue: 0;
  --primary-lightness: 50;
  --color: hsl(0, 0%, 100%);
  --font-size: 26px;
  --shadow-primary-hue: 180;
  --label-size: 9px;
  --shadow-secondary-hue: 60;
  --shadow-secondary: hsl(var(--shadow-secondary-hue), 90%, 60%);
  --clip: polygon(0 0, 100% 0, 100% 100%, 95% 100%, 95% 90%, 85% 90%, 85% 100%, 8% 100%, 0 70%);
  --border: 4px;
  --shimmy-distance: 5;
  --clip-one: polygon(0 2%, 100% 2%, 100% 95%, 95% 95%, 95% 90%, 85% 90%, 85% 95%, 8% 95%, 0 70%);
  --clip-two: polygon(0 78%, 100% 78%, 100% 100%, 95% 100%, 95% 90%, 85% 90%, 85% 100%, 8% 100%, 0 78%);
  --clip-three: polygon(0 44%, 100% 44%, 100% 54%, 95% 54%, 95% 54%, 85% 54%, 85% 54%, 8% 54%, 0 54%);
  --clip-four: polygon(0 0, 100% 0, 100% 0, 95% 0, 95% 0, 85% 0, 85% 0, 8% 0, 0 0);
  --clip-five: polygon(0 0, 100% 0, 100% 0, 95% 0, 95% 0, 85% 0, 85% 0, 8% 0, 0 0);
  --clip-six: polygon(0 40%, 100% 40%, 100% 85%, 95% 85%, 95% 85%, 85% 85%, 85% 85%, 8% 85%, 0 70%);
  --clip-seven: polygon(0 63%, 100% 63%, 100% 80%, 95% 80%, 95% 80%, 85% 80%, 85% 80%, 8% 80%, 0 70%);
  font-family: 'Cyber', sans-serif;
  color: var(--color);
  cursor: pointer;
  background: transparent;
  text-transform: uppercase;
  font-size: var(--font-size);
  outline: transparent;
  letter-spacing: 2px;
  position: relative;
  font-weight: 700;
  border: 0;
  min-width: 130px;
  height: 60px;
  line-height: 60px;
  transition: background 0.2s;
}

.cybr-btn:hover {
  --primary: hsl(var(--primary-hue), 85%, calc(var(--primary-lightness, 50) * 0.8%));
}
.cybr-btn:active {
  --primary: hsl(var(--primary-hue), 85%, calc(var(--primary-lightness, 50) * 0.6%));
}

.cybr-btn:after,
.cybr-btn:before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  clip-path: var(--clip);
  z-index: -1;
}

.cybr-btn:before {
  background: var(--shadow-primary);
  transform: translate(var(--border), 0);
}

.cybr-btn:after {
  background: var(--primary);
}

.cybr-btn__tag {
  position: absolute;
  padding: 1px 4px;
  letter-spacing: 1px;
  line-height: 1;
  bottom: -5%;
  right: 5%;
  font-weight: normal;
  color: hsl(0, 0%, 0%);
  font-size: var(--label-size);
}

.cybr-btn__glitch {
  position: absolute;
  top: calc(var(--border) * -1);
  left: calc(var(--border) * -1);
  right: calc(var(--border) * -1);
  bottom: calc(var(--border) * -1);
  background: var(--shadow-primary);
  text-shadow: 2px 2px var(--shadow-primary), -2px -2px var(--shadow-secondary);
  clip-path: var(--clip);
  animation: glitch 2s infinite;
  display: none;
}

.cybr-btn:hover .cybr-btn__glitch {
  display: block;
}

.cybr-btn__glitch:before {
  content: '';
  position: absolute;
  top: calc(var(--border) * 1);
  right: calc(var(--border) * 1);
  bottom: calc(var(--border) * 1);
  left: calc(var(--border) * 1);
  clip-path: var(--clip);
  background: var(--primary);
  z-index: -1;
}

@keyframes glitch {
  0% {
    clip-path: var(--clip-one);
  }
  2%, 8% {
    clip-path: var(--clip-two);
    transform: translate(calc(var(--shimmy-distance) * -1%), 0);
  }
  6% {
    clip-path: var(--clip-two);
    transform: translate(calc(var(--shimmy-distance) * 1%), 0);
  }
  9% {
    clip-path: var(--clip-two);
    transform: translate(0, 0);
  }
  10% {
    clip-path: var(--clip-three);
    transform: translate(calc(var(--shimmy-distance) * 1%), 0);
  }
  13% {
    clip-path: var(--clip-three);
    transform: translate(0, 0);
  }
  14%, 21% {
    clip-path: var(--clip-four);
    transform: translate(calc(var(--shimmy-distance) * 1%), 0);
  }
  25% {
    clip-path: var(--clip-five);
    transform: translate(calc(var(--shimmy-distance) * 1%), 0);
  }
  30% {
    clip-path: var(--clip-five);
    transform: translate(calc(var(--shimmy-distance) * -1%), 0);
  }
  35%, 45% {
    clip-path: var(--clip-six);
    transform: translate(calc(var(--shimmy-distance) * -1%));
  }
  40% {
    clip-path: var(--clip-six);
    transform: translate(calc(var(--shimmy-distance) * 1%));
  }
  50% {
    clip-path: var(--clip-six);
    transform: translate(0, 0);
  }
  55% {
    clip-path: var(--clip-seven);
    transform: translate(calc(var(--shimmy-distance) * 1%), 0);
  }
  60% {
    clip-path: var(--clip-seven);
    transform: translate(0, 0);
  }
  31%, 61%, 100% {
    clip-path: var(--clip-four);
  }
}

.cybr-btn:nth-of-type(2) {
  --primary-hue: 260;
}

header {
  height: 90px;
  /* background-color: transparent; */
  /* opacity: 0%; */
  line-height: 70px;
  padding: 0px 30px;
  
}

header a:hover{
  background-color:transparent;
  color:black;

}

header a {
  margin: 10px;
  text-decoration: none;
  color: black;
}

.header-nav {
  display: flex;
  justify-content: space-between;

}

.logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: black;
  margin: 0;
  /* opacity: 100%; */
}
</style>
