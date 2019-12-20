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
          ref="ruleForm"
          label-width="100px"
          class="demo-ruleForm"
        >
          <el-form-item label="标题" prop="title" style="width:300px;">
            <el-input disabled v-model="form.title"></el-input>
          </el-form-item>
          <el-form-item label="时间" prop="title" style="width:300px;">
            <el-input disabled v-model="form.time"></el-input>
          </el-form-item>
          <el-form-item label="医生编号" prop="title" style="width:300px;">
            <el-input disabled v-model="form.docCId"></el-input>
          </el-form-item>
          <el-form-item label prop="knowledge">
            <div style="line-height:.4rem">
              <span v-html="form.knowledge"></span>
            </div>
          </el-form-item>
          <el-form-item>
            <!-- <el-button type="primary">通过</el-button> -->
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

export default {
  name: "checkKnowledge",
  data() {
    return {
      form: {}
    };
  },
  components: { AsideNav },
  computed: {},
  created() {},
  mounted() {
    this.load();
  },
  methods: {
    goBack() {
      this.$router.back(-1);
    },

    load() {
      DocService.checkKnowledge(this.$route.query.id)
        .then(res => {
          if (res.status == 200) {
            this.form = res.data;
          }
        })
        .catch(err => {
          this.$message.error("服务器异常");
        });
    }
  }
};
</script>
<style >
</style>