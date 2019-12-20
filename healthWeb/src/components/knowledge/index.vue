<template>
  <div>
    <el-container>
      <el-aside style="width:200px">
        <aside-nav></aside-nav>
      </el-aside>
      <el-main>
        <el-form
          style="margin-top:20px"
          :model="form"
          :rules="rules"
          ref="ruleForm"
          label-width="100px"
          class="demo-ruleForm"
        >
          <el-form-item label="标题" prop="title" style="width:300px;">
            <el-input v-model="form.title"></el-input>
          </el-form-item>
          <el-form-item label="内容" prop="knowledge">
            <div v-loading="loading">
              <!--上传图片时得加载画面-->
              <VueEditor
                style="width: 80%"
                useCustomImageHandler
                :editorToolbar="customToolbar"
                v-model="form.knowledge"
              ></VueEditor>
            </div>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="save('ruleForm')">提交</el-button>
            <el-button @click="goBack()">返回</el-button>
          </el-form-item>
        </el-form>
      </el-main>
    </el-container>
  </div>
</template>
<script>
import AsideNav from "./AsideNav";
import * as DocService from "@/api/doc";
import { VueEditor } from "vue2-editor";

export default {
  name: "knowledge",
  data() {
    return {
      form: {
        title: "",
        knowledge: ""
      },
      rules: {
        title: [{ required: true, message: "请填写标题", trigger: "blur" }],
        knowledge: [{ required: true, message: "请填写内容", trigger: "blur" }]
      },
      loading: false,
      customToolbar: [
        [{ header: [false, 1, 2, 3, 4, 5, 6] }],
        // ["bold", "italic", "underline", "strike"], // toggled buttons
        [{ align: ["", "center", "right", "justify"] }],
        // ["blockquote"],
        [{ list: "ordered" }, { list: "bullet" }, { list: "check" }],
        [{ script: "sub" }, { script: "super" }], // superscript/subscript
        [{ indent: "-1" }, { indent: "+1" }], // outdent/indent
        [{ color: [] }, { background: [] }], // dropdown with defaults from theme
        ["link"],
        ["clean"]
      ]
    };
  },
  components: { AsideNav, VueEditor },
  computed: {},
  created() {},
  mounted() {},
  methods: {
    save(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          let yy = new Date().getFullYear();
          let mm = new Date().getMonth() + 1;
          let dd = new Date().getDate();
          let hh = new Date().getHours();
          let mf =
            new Date().getMinutes() < 10
              ? "0" + new Date().getMinutes()
              : new Date().getMinutes();
          let ss =
            new Date().getSeconds() < 10
              ? "0" + new Date().getSeconds()
              : new Date().getSeconds();
          var t = yy + "-" + mm + "-" + dd + " " + hh + ":" + mf + ":" + ss;
          var a = {
            title: this.form.title,
            knowledge: this.form.knowledge,
            status: 1,
            docCId: Number(window.localStorage.getItem("docId")),
            time: t
          };
          DocService.createKnowledge(a)
            .then(res => {
              if (res.status == 200) {
                this.$notify({
                  title: "成功",
                  message: "提交成功",
                  type: "success"
                });
               this.$router.back(-1);
              }
            })
            .catch(err => {
              this.$message.error("提交信息有误");
            });
        }
      });
    },

    goBack() {
      this.$router.back(-1);
    }
  }
};
</script>
<style >
</style>