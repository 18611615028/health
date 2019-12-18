<template>
  <div>
    <div style="margin:150px 0 50px 0">
    <div style="width:500px;font-size:50px;margin:auto">
      <span>健康体检系统管理平台</span>
    </div>
    </div>
    <div style="width:400px;margin:auto">
      <div style="margin-bottom:15px">
        <div style="display: inline-block;width:65px">
          <span>用户名：</span>
        </div>
        <el-input v-model="userName" style="width:300px"></el-input>
      </div>
      <div style="margin-bottom:15px">
        <div style="display: inline-block;width:65px">
          <span>密码：</span>
        </div>
        <el-input v-model="passWord" style="width:300px"></el-input>
      </div>
      <div>
        <div style="display: inline-block;width:65px">
          <span>角色：</span>
        </div>
        <el-select v-model="roles" style="width:300px">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
      </div>
      <el-button @click="login()" type="primary" round style="width:300px;margin:15px 0 0 70px">登陆</el-button>
      <el-button @click="logon()" plain style="border-width:0;margin-left:50px">注册</el-button>
    </div>
  </div>
</template>
<script>
import * as DocService from "@/api/doc";

export default {
  name: "login",
  data() {
    return {
      options: [
        {
          value: "医生",
          label: "医生"
        },
        {
          value: "管理员",
          label: "管理员"
        }
      ],
      userName: "",
      passWord: "",
      roles: ""
    };
  },

  methods: {
    login() {
      if (!this.roles) {
        this.$message.error("请选择角色");
      }
      if (this.roles == "医生") {
          var data = {
              userName: this.userName,
              passWord: this.passWord,
          }
        DocService.login(data).then(res => {
          if (res.status == 200) {
            window.localStorage.setItem("docId", res.data)
            this.$router.push("/appointment")
          }
        }).catch(err=>{
          this.$message.error("用户名或密码错误");
        })
      }
    },

    logon(){
        this.$router.push("/logon")
    }
  }
};
</script>

<style scoped>
</style>
