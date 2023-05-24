<template>
  <div class="container">
    <br>
    <font style="font-weight:bold; font-size:30px;">영상 등록</font><br>
    <fieldset class="text-center">
      <label for="youtubeurl">유튜브 URL : </label>
      <input type="text" id="youtubeurl" v-model="youtubeurl" class="view" /><br />
      <button type="button" class="btn btn-lg btn-primary" onClick="this.disabled=true; this.value='Sending…';" @click="regist">등록</button>
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