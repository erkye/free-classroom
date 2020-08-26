import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../components/index.vue'

Vue.use(VueRouter)

const routes = [

  /*   {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/About.vue')
  } */
  {
    path: '/',
    redirect: '/Index'
  },
  /* 首页 */
  {
    path: '/Index',
    name: 'Index',
    component: Index
  },
  /* 扫楼 */
  {
    path: '/ClearBuilding',
    name: 'ClearBuilding',
    component: () => import('../components/clearbuilding/ClearBuilding.vue')
  },
  /* 扫楼显示空闲教室生活 */
  {
    path: '/FreeRoomList/:id/:name',
    name: 'FreeRoomList',
    component: () => import('../components/clearbuilding/FreeRoomList.vue')
  },
  /* 查询教室--用户选择查询的教学楼 */
  {
    path: '/QueryRoom',
    name: 'QueryRoom',
    component: () => import('../components/queryroom/QueryRoom.vue')
  },
  /* 查询教室--显示用户选择教学楼的教室 */
  /* 将参数添加到路由中，方式返回时没有路由中的数据 页面加载失败 */
  {
    path: '/Rooms/:id/:name',
    name: 'Rooms',
    component: () => import('../components/queryroom/Rooms.vue')
  },
  /* 查询教室--显示用户选择教室当天的使用情况 */
  {
    path: '/RoomStatus/:roomId/:roomName/:buildingName',
    name: 'RoomStatus',
    component: () => import('../components/queryroom/RoomStatus.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
