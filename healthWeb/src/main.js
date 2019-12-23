import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import router from './router'
import App from './App.vue';
import axios from 'axios'



Vue.use(ElementUI);
Vue.prototype.axios = axios;
Vue.use(axios);


new Vue({
  el: '#app',
  router,
  render: h => h(App)
});
router.beforeEach((to, from, next) => {
  if (to.path == '/login') {
    console.info(1)
    next()
  }
  if (to.path == '/appointment' || to.path == '/appointment/check' || to.path == '/report' || to.path == '/knowledge' || to.path == '/checkKnowledge' || to.path == '/knowledgeList' || to.path == '/qualification' || to.path == '/information') {
    if (!window.localStorage.getItem("docId")) {
      console.info(2)
      next('/login')
    }
  }
  if (to.path == '/admin/knowledgeList' || to.path == '/admin/knowledge' || to.path == '/admin/qualificationList') {
    if (!window.localStorage.getItem("adminId")) {
      console.info(2)
      next('/login')
    }
  }
  next()
})