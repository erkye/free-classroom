import Vue from 'vue'
import ElementUI, { Message } from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import './style/gobal.css'

Vue.config.productionTip = false
Vue.prototype.$message = Message

// 'http://192.168.43.231:3000'

axios.defaults.baseURL = ''
/* 统一相应处理 */
axios.interceptors.response.use(response => {
// 正常的时候返回数据中 data
  return response.data
}, error => {
// 异常是提示
  console.log('网络开小差了')
  return Promise.reject(error)
})
Vue.prototype.$http = axios

Vue.use(ElementUI)

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
