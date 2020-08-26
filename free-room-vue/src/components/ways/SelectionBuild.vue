<template>
    <div class="box" :style="{'background-color': colors[(Color-1) %(colors.length)],'color': fontColors[(Color-1) %(fontColors.length)]}">
        <h2>{{BoxName}}</h2>
    </div>
</template>
<script>
export default {
  props: ['BoxName', 'Color'],
  data () {
    return {
      colors: ['#80a8c5', '#edded8', '#9ec183', '#715692', '#c2cec0', '#f7b38e', '#98dd9a'],
      fontColors: ['#efdbd6', '#7d719c', '#715692', '#c4dcc8', '#7864b7', '#6966b3', '#725197']
    }
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
