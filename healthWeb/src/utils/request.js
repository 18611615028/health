import axios from 'axios'
import { Message } from 'element-ui'
import router from '../router'

const service = axios.create({
  baseURL: '/api',
  timeout: 180000
})

function addGlobalParam(config, key, value){
  // assign extra params to request url
  let isExists = (config.data && config.data[key]) || (config.params && config.params[key]) || (config.url.indexOf(key) != -1)
  if (isExists){
    return 
  }
  
  if (config.data){
    if (!config.data[key]){
      config.data[key] = value
    }
  }
  else if (config.params){
    if (!config.params[key]){
      config.params[key] = value
    }
  }
  else if (config.url.indexOf(key) == -1){
    if (config.url.indexOf('?') == -1 ){
      config.url += `?${key}=${value}`
    } else {
      config.url += `&${key}=${value}`
    }
  }
}

// request拦截器
service.interceptors.request.use(config => {
  // add clientId query param globally
  if(!window.localStorage.getItem("docId")){
    this.$router.push('/login')
  }
  let user = JSON.parse(sessionStorage.getItem('user') || '{}')
  if (!user.client){
    return config
  }
  addGlobalParam(config, 'clientId', user.client.id)
  return config
}, error => {
  Message({
    message: error.message,
    type: 'error',
    duration: 5 * 1000
  })
  return Promise.reject(error)
})

// response拦截器
service.interceptors.response.use(response => {

 
// 根据response code 做一些报错等处理
  return response
}, error => {
    if (error.response.status == 401 && router.history.current.name !== 'Login'){
      router.replace({name:'Login', query:{timeout: true}});
      return;
    }
    let tmpMsg = error.response.data.code
    if (!tmpMsg) {
      tmpMsg = error.response.data.message
    }
    Message({
      message: $i18n.t(tmpMsg),
      type: 'error',
      dangerouslyUseHTMLString:true,
      duration: 4 * 1000,
      showClose: true
    })
    return Promise.reject(error)
})

export default service

