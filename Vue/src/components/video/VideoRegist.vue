<template>
  <div class="container">
    <br>
    <font style="font-weight:bold; font-size:30px; font-family: 'Cyber';">VIDEO REGIST</font><br>
    <fieldset class="text-center">
      <label for="youtubeurl" style="font-family: 'Cyber';">YOUTUBE URL : </label>
      <input type="text" id="youtubeurl" v-model="youtubeurl" class="view" /><br />
      <button style="font-family: 'Cyber'; border-radius:5px; " type="button" class="btn btn-lg btn-primary" onClick="this.disabled=true; this.value='Sending…';" @click="regist">REGIST</button>
    </fieldset>
  </div>
</template>
<script>
export default {
  name: "VideoList",
  data() {
    return {
      youtubeurl: "",
    };
  },
  methods: {
    regist() {
      if (
        this.youtubeurl === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      }

      let video = {
        youtubeurl: this.youtubeurl,
      };

      this.$store.dispatch("createVideo", video);
    },
  },
};
</script>