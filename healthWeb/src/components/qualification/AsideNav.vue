<template>
  <div>
    <el-row class="tac" style="position: fixed;height:100%;bottom: 0px;">
      <el-col :span="12" style="position: fixed;height:100%;bottom: 0px;">
        <el-menu
        style="height:100%;width:200px"
          default-active="4"
          class="el-menu-vertical-demo"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b"
        >
          <el-menu-item index="1" @click="goNav('/appointment')">
            <i class="el-icon-menu"></i>
            <span slot="title">体检预约</span>
          </el-menu-item>
          <!-- <el-menu-item index="2" @click="goNav('/report')">
            <i class="el-icon-document"></i>
            <span slot="title">体检报告</span>
          </el-menu-item> -->
          <el-menu-item index="3" @click="goNav('/knowledge')">
            <i class="el-icon-s-management"></i>
            <span slot="title">健康知识</span>
          </el-menu-item>
          <el-menu-item index="4" @click="goNav('/qualification')">
            <i class="el-icon-s-check"></i>
            <span slot="title">资质信息</span>
          </el-menu-item>
          <el-menu-item index="5"  @click="goNav('/information')">
            <i class="el-icon-s-custom"></i>
            <span slot="title">账号信息</span>
          </el-menu-item>
          <el-menu-item index="6"  @click="goNav('/login')">
            <i class="el-icon-s-custom"></i>
            <span slot="title">退出</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  export default {
    methods: {
        goNav(path){
            this.$router.push(path)
        }
    }
  }
</script>