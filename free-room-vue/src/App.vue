<template>
  <div id="app">
    <!-- 注释掉的为动画效果，效果不佳 -->
    <!-- <transition :name="transitionName"> -->
      <router-view/>
    <!-- </transition> -->
  </div>
</template>
<script>
export default {
  data () {
    return {
      /* transitionName: 'fold-left' */
    }
  }
/*   beforeRouteUpdate (to, from, next) {
    const toDepth = to.path.split('/').length
    const fromDepth = from.path.split('/').length
    this.transitionName = toDepth < fromDepth ? 'fold-right' : 'fold-left'
    next()
  },
  watch: {
    // 监听路由对象，决定使用哪种过渡效果
    '$route' (to, from) {
      const toDepth = to.path.split('/').length
      const fromDepth = from.path.split('/').length
      this.transitionName = toDepth < fromDepth ? 'fold-right' : 'fold-left'
    }
  } */
}
</script>
<style>
#app{
  height: 100%;
  min-height: 100vh;
  background-color: #f6f5f5;
 /*  transition-duration: 2s; */
}

</style>
