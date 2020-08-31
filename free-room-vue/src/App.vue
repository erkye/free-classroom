<template>
  <div id="app">
    <!-- 注释掉的为动画效果，效果不佳 -->
    <transition enter-active-class="animate__animated animate__flipInY">
      <router-view/>
    </transition>
  </div>
</template>
<script>
export default {
  data () {
    return {
      /* transitionName: 'fold-left' */
    }
  },
  methods: {
    // 打印信息
    printAppInfo () {
      console.log('--------------------------APP信息------------------------')
      console.log('|        该项目为开源项目，欢迎感兴趣的小伙伴参与           |')
      console.log('|   Gitee地址：https://gitee.com/lifazhan/free-classroom |')
      console.log('|              作者邮箱: lifazhan233@gmail.com           |')
      console.log('|                   任何问题请及时反馈                    |')
      console.log('---------------------------------------------------------')
    }
  },
  mounted () {
    this.printAppInfo()
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
  background-color: #cadcf9;
  /* background-image: linear-gradient(to top, #f3e7e9 0%, #e3eeff 99%, #e3eeff 100%); */
 /*  transition-duration: 2s; */
}
.animate__animated{
  --animate-duration: .8s;
}

</style>
