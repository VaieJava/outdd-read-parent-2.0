import Vue from 'vue'
import App from './App'
import router from './router'
import iView from 'iview'
import axios from 'axios'
import qs from 'qs'
import 'iview/dist/styles/iview.css'
Vue.config.productionTip = false
Vue.use(iView)

// 设置基础URL
axios.defaults.baseURL = "http://localhost:8081"
// 设置请求超时时间
axios.defaults.timeout = 5000
//----------------------------
axios.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
axios.defaults.withCredentials = true
// http request 拦截器
axios.interceptors.request.use(
  config => {
    config.headers = {
      'Content-Type': 'application/json;charset=UTF-8' // 设置很关键
    }
    return config
  },
  err => {
    return Promise.reject(err)
  }
)
//-----------------
Vue.prototype.$qs=qs
Vue.prototype.$axios = axios

new Vue({
    el: '#app',
    router,
    components: { App },
    template: '<App/>'
})
