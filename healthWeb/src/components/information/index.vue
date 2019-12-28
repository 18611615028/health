<template>
  <div>
    <el-container>
      <el-aside style="width:200px">
        <aside-nav></aside-nav>
      </el-aside>
      <el-main>
        <el-form style="margin-top:20px" ref="ruleForm" :rules="rules" :model="form" label-width="80px">
        <el-form-item label="用户名" prop="userName" style="width:300px;">
          <el-input :disabled="true" v-model="form.userName"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="passWord" style="width:300px">
          <el-input :disabled="!update" v-model="form.passWord"></el-input>
        </el-form-item>
        <!-- <el-form-item label="生日" porp="birth" style="width:300px">
          <el-date-picker :disabled="!update" v-model="form.birth" type="date" placeholder="选择日期" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item> -->
        <el-form-item>
          <el-button v-if="!update" type="primary" @click="willUpdate()">修改</el-button>
          <el-button v-if="update" type="primary" @click="updateDoc('ruleForm')">保存</el-button>
          <el-button v-if="update" @click="back()">取消</el-button>
        </el-form-item>
      </el-form>
      </el-main>
    </el-container>
  </div>
</template>
<script>
import AsideNav from "./AsideNav";
import * as DocService from "@/api/doc";
export default {
  name: "information",
  data() {
    return {
      update:false,
      form:{
        userName: "",
        passWord: "",
        birth: ""
      },
      rules: {
        userName: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 1, max: 20, message: "长度在 1 到 20 个字符", trigger: "blur" }
        ],
        passWord: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 1, max: 20, message: "长度在 1 到 20 个字符", trigger: "blur" }
        ]
      }
    };
  },
  components: { AsideNav },
  computed: {},
  created() {},
  mounted() {
    this.getDoc();
  },
  methods: {
    getDoc(){
      DocService.getDoc(Number(window.localStorage.getItem("docId"))).then(res => {
        if (res.status == 200) {
         this.form = res.data
        }
      }).catch(err => {
          this.$message.error("服务器异常");
        });
    },

    willUpdate(){
      this.update = true;
    },

    back(){
      this.update = false;
    },

    updateDoc(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          DocService.updateDoc(this.form)
            .then(res => {
              if (res.status == 200) {
                this.$notify({
                  title: "成功",
                  message: "修改成功",
                  type: "success"
                });
                this.update = false
                this.getDoc();
              }
            })
            .catch(err => {
              this.$message.error("账号信息有误");
            });
        }
      });
    },
  }
};
</script>
<style >
</style>