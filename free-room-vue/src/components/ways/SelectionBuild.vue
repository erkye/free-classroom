<template>
    <div class="box" :style="{'background-color': colors[(Color-1) %(colors.length)]}">
        <h3>{{BoxName}}</h3>
    </div>
</template>
<script>
export default {
  props: ['BoxName', 'Color'],
  data () {
    return {
      colors: ['#f6e58d', '#ffbe76', '#ff7979', '#ff9a76', '#badc58', '#7ed6df', '#e056fd', '#ffa372']
    }
  }
}
</script>
<style scoped>
.box{
    width: 100%;
    height: 180px;
    text-align: center;
    line-height: 180px;
    border-radius: 50%;
}
</style>
