<template>
  <div>
    <el-row style="position: fixed;height:100%;bottom: 0px;">
        <el-menu
        style="height:100%;width:200px"
          default-active="4"
          class="el-menu-vertical-demo"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b"
        >
          <el-menu-item index="3" @click="goNav('/admin/knowledgeList')">
            <i class="el-icon-s-management"></i>
            <span slot="title">知识审核</span>
          </el-menu-item>
          <el-menu-item index="4" @click="goNav('/admin/qualificationList')">
            <i class="el-icon-s-check"></i>
            <span slot="title">资质审核</span>
          </el-menu-item>
          <el-menu-item index="6"  @click="goNav('/login')">
            <i class="el-icon-s-custom"></i>
            <span slot="title">退出</span>
          </el-menu-item>
        </el-menu>

    </el-row>
  </div>
</template>

<script>
  export default {
    methods: {
        goNav(path){
          if(path=='/login'){
            window.localStorage.clear()
          }
            this.$router.push(path)
        }
    }
  }
</script>