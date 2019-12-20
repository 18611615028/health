<template>
  <div>
    <el-container>
      <el-aside style="width:200px">
        <aside-nav></aside-nav>
      </el-aside>
      <el-main>
        <div style="text-align:left;margin:0px auto 0px auto;margin:30px 0 20px 0">
          <el-button type="primary" style="margin-left:50px" @click="newKnowledge()">新建</el-button>
        </div>
        <el-table :data="tableData" style="margin:40px 20px 0 20px;padding-right:40px">
          <el-table-column prop="title" label="标题" width="180"></el-table-column>
          <el-table-column prop="time" label="提交时间" width="180"></el-table-column>
          <el-table-column prop="status" label="状态"></el-table-column>
          <el-table-column prop="docCId" label="职工编号"></el-table-column>
          <el-table-column>
              <template slot-scope="scope">
            <el-button @click="check(scope.row)">查看</el-button>
              </template>
          </el-table-column>
        </el-table>
      </el-main>
    </el-container>
  </div>
</template>
<script>
import AsideNav from "./AsideNav";
import * as DocService from "@/api/doc";

export default {
  name: "knowledgeList",
  data() {
    return {
      tableData: []
    };
  },
  components: { AsideNav },
  computed: {},
  created() {},
  mounted() {
    this.load();
  },
  methods: {
    newKnowledge() {
      this.$router.push("/knowledge");
    },

    load() {
      DocService.getKnowledgeList()
        .then(res => {
          if (res.status == 200) {
            this.tableData = res.data;
          }
        })
        .catch(err => {
          this.$message.error("服务器异常");
        });
    },

    check(row){
        this.$router.push({
        path: "/checkKnowledge",
        query: { id: row.id }
      });
    }
  }
};
</script>
<style >
</style>