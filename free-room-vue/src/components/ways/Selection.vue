<template>
    <div class="box" :style="{'background-color': Color}">
        <h1>{{BoxName}}</h1>
    </div>
</template>
<script>
export default {
  props: ['BoxName', 'Color'],
  data () {
    return {}
  }
}
</script>
<style scoped>
.box{
    width: 100%;
    height: 280px;
    text-align: center;
    line-height: 280px;
    border-radius: 10%;
}
</style>
