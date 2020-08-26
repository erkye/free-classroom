<template>
    <div class="box" :style="{'background-color': Color,'color': FontColor}">
        <h1>{{BoxName}}</h1>
    </div>
</template>
<script>
export default {
  props: ['BoxName', 'Color', 'FontColor'],
  data () {
    return {}
  }
}
</script>
<style scoped>
.box{
    width: 100%;
    height: 80px;
    text-align: center;
    line-height: 80px;
    border-radius: 10%;
}
</style>
