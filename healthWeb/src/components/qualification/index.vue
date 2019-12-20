<template>
  <div>
    <el-container>
      <el-aside style="width:200px">
        <aside-nav></aside-nav>
      </el-aside>
      <el-main>
        <el-form
          style="margin-top:20px"
          ref="ruleForm"
          :rules="rules"
          :model="form"
          label-width="80px"
        >
        <el-form-item label="表单状态" prop="" style="width:300px">
            <el-select disabled v-model="form.status">
              <!-- 1 2 3 -->
                <el-option label="未提交" :value="0"></el-option>
                <el-option label="已提交" :value="1"></el-option>
                <el-option label="被驳回" :value="2"></el-option>
                <el-option label="已录入" :value="3"></el-option>
              </el-select>
          </el-form-item>
          <el-form-item label="姓名" prop="name" style="width:300px;">
            <el-input :disabled="!update" v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="编号" prop="docCId" style="width:300px">
            <el-input :disabled="!update" v-model="form.docCId"></el-input>
          </el-form-item>
          <el-form-item :disabled="!update" label="科室" prop="office" style="width:300px">
            <el-select :disabled="!update" v-model="form.office">
                <el-option label="眼科" value="眼科"></el-option>
                <el-option label="内科" value="内科"></el-option>
                <el-option label="外科" value="外科"></el-option>
              </el-select>
          </el-form-item>
          <el-form-item :disabled="!update" label="职称" prop="title" style="width:300px">
            <el-select :disabled="!update" v-model="form.title">
              <el-option label="医生" value="医生"></el-option>
                <el-option label="副主任" value="副主任"></el-option>
                <el-option label="主任" value="主任"></el-option>
                <el-option label="副教授" value="副教授"></el-option>
                <el-option label="教授" value="教授"></el-option>
              </el-select>
          </el-form-item>
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
  name: "qualification",
  data() {
    return {
      update: false,
      form: {
        name:"",
        docCId:null,
        office:"",
        title:"",
        status:0
      },
      rules: {
        name: [
          { required: true, message: "请输入姓名", trigger: "blur" },
          { min: 1, max: 20, message: "长度在 1 到 20 个字符", trigger: "blur" }
        ],
        docCId: [
          { required: true, message: "请输入编号", trigger: "blur" },
          // { min: 1,max: 20, message: "长度为11个字符", trigger: "blur" }
        ],
        title: [
          { required: true, message: "请选择职称", trigger: "blur" }
        ],
        office: [
          { required: true, message: "请选择科室", trigger: "blur" }
        ]
      }
    };
  },
  components: { AsideNav },
  computed: {},
  created() {},
  mounted() {
    this.getDocQua();
  },
  methods: {
    getDocQua() {
      DocService.getDocQua(Number(window.localStorage.getItem("docId")))
        .then(res => {
          if (res.status == 200) {
            this.form.title = res.data.title;
            this.form.office = res.data.office;
            this.form.docCId = res.data.docCId;
            this.form.status = res.data.status || 0;
            this.form.name = res.data.name;
          }
        })
        .catch(err => {
          this.$message.error("服务器异常");
        });
    },

    willUpdate() {
      this.update = true;
    },

    back() {
      this.update = false;
    },

    updateDoc(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          this.form.docId = Number(window.localStorage.getItem("docId"))
          this.form.docCId = Number(this.form.docCId)
          this.form.status=1
          DocService.updateDocQua(this.form)
            .then(res => {
              if (res.status == 200) {
                this.$notify({
                  title: "成功",
                  message: "提交成功",
                  type: "success"
                });
                this.update = false;
                this.getDocQua();
              }
            })
            .catch(err => {
              this.$message.error("提交信息有误");
            });
        }
      });
    }
  }
};
</script>
<style >
</style>