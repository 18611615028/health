<template>
  <div>
    <div style="margin-top:150px">
    <div style="text-align:center;width:300px;margin:0 auto">
      <div style="font-size:30px;margin-bottom:20px">
        <span>医生注册</span>
      </div>
      <el-form ref="ruleForm" :rules="rules" :model="form" label-width="80px">
        <el-form-item label="用户名" prop="userName" style="width:300px;">
          <el-input v-model="form.userName"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="passWord" style="width:300px">
          <el-input v-model="form.passWord"></el-input>
        </el-form-item>
        <!-- <el-form-item label="生日" prop="birth" style="width:300px">
          <el-date-picker v-model="form.birth" type="date" placeholder="选择日期" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item> -->
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">注册</el-button>
          <el-button @click="goBack()">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
    </div>
  </div>
</template>
<script>
import * as DocService from "@/api/doc";

export default {
  name: "logon",
  data() {
    return {
      form: {
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
  components: {},
  computed: {},
  created() {},
  mounted() {},
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          DocService.logon(this.form)
            .then(res => {
              if (res.status == 200) {
                this.$notify({
                  title: "成功",
                  message: "注册成功",
                  type: "success"
                });
                this.$router.push("/login");
              }
            })
            .catch(err => {
              this.$message.error("用户名已被注册");
            });
        } else {
          this.$message.error("注册信息有误");
        }
      });
    },

    goBack() {
      this.$router.back(-1);
    }
  }
};
</script>

<style scoped>
</style>
