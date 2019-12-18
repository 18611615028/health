import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import router from './router'
import App from './App.vue';
import axios from 'axios'


Vue.use(ElementUI);
Vue.prototype.axios = axios;
Vue.use( axios);

new Vue({
  el: '#app',
  router,
  render: h => h(App)
});