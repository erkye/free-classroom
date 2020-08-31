import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../components/index.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/Index'
  },
  /* 首页 */
  {
    path: '/Index',
    name: 'Index',
    component: Index,
    meta: {
      title: '🌺首页'
    }
  },
  /* 扫楼 */
  {
    path: '/ClearBuilding',
    name: 'ClearBuilding',
    component: () => import('../components/clearbuilding/ClearBuilding.vue'),
    meta: {
      title: '🌸选择教学楼'
    }
  },
  /* 扫楼显示空闲教室生活 */
  {
    path: '/FreeRoomList/:id/:name',
    name: 'FreeRoomList',
    component: () => import('../components/clearbuilding/FreeRoomList.vue'),
    meta: {
      title: '🌼扫楼结果'
    }
  },
  /* 查询教室--用户选择查询的教学楼 */
  {
    path: '/QueryRoom',
    name: 'QueryRoom',
    component: () => import('../components/queryroom/QueryRoom.vue'),
    meta: {
      title: '🌱查询教室-选择教学楼'
    }
  },
  /* 查询教室--显示用户选择教学楼的教室 */
  /* 将参数添加到路由中，方式返回时没有路由中的数据 页面加载失败 */
  {
    path: '/Rooms/:id/:name',
    name: 'Rooms',
    component: () => import('../components/queryroom/Rooms.vue'),
    meta: {
      title: '🌻查询教室-选择教室'
    }
  },
  /* 查询教室--显示用户选择教室当天的使用情况 */
  {
    path: '/RoomStatus/:roomId/:roomName/:buildingName',
    name: 'RoomStatus',
    component: () => import('../components/queryroom/RoomStatus.vue'),
    meta: {
      title: '💐教室结果'
    }
  },
  /* LuckRoom--用户选择查询的教学楼 */
  {
    path: '/LuckyRoom',
    name: 'LuckyRoom',
    component: () => import('../components/lunckyroom/LuckyRoomBuilding.vue'),
    meta: {
      title: '🌹LuckyRoom-选择教学楼'
    }
  },
  /* LuckyRoom生活 */
  {
    path: '/LuckyRoomList/:id/:name',
    name: 'LuckyRoomList',
    component: () => import('../components/lunckyroom/LuckyRoomList.vue'),
    meta: {
      title: '🌜LuckyRoom'
    }
  }
]

const router = new VueRouter({
  routes
})

router.beforeEach((to, from, next) => {
  /* 将路由的标题设置到页面上 */
  const title = to.meta && to.meta.title
  if (title) {
    document.title = title
  }
  next()
})

export default router
