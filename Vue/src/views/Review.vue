<template>
  <div>
    <router-view />
  </div>
</template>

<script>
export default {
  name: "Review",
};
</script>

<style>
.review-link {
  color: black;
}

.view {
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}

label {
  display: inline-block;
  width: 130px;
}

.btn {
  width: 8%;
  background-color: #d0d3d0;
  color: rgb(80, 82, 79);
  padding: 14px 20px;
  margin: 8px;
  border: 1px solid #787878;
  border-radius: 4px;
  font-size: large;
  cursor: pointer;
}

/* 테이블 CSS */
.review-list {
  border-collapse: collapse;
  width: 100%;
  text-align: center;
  margin: auto;
}

.review-list td,
.review-list th {
  border: 1px solid black;
}
</style>
