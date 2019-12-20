import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'login',
      component: () => import("@/components/login")
    },
    {
      path: '/logon',
      name: 'logon',
      component: () => import("@/components/logon")
    },
    {
      path: '/appointment',
      name: 'appointment',
      component: () => import("@/components/appointment"),
    },
    {
      path: '/appointment/check',
      name: 'appointment',
      component: () => import("@/components/appointment/check"),
    },
    {
      path: '/report',
      name: 'report',
      component: () => import("@/components/report")
    },
    {
      path: '/knowledge',
      name: 'knowledge',
      component: () => import("@/components/knowledge")
    },
    {
      path: '/checkKnowledge',
      name: 'checkKnowledge',
      component: () => import("@/components/checkKnowledge")
    },
    {
      path: '/knowledgeList',
      name: 'knowledgeList',
      component: () => import("@/components/knowledgeList")
    },
    {
      path: '/qualification',
      name: 'qualification',
      component: () => import("@/components/qualification")
    },
    {
      path: '/information',
      name: 'information',
      component: () => import("@/components/information")
    },
  ]
})

