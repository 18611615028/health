<template>
  <div>
    <el-container>
      <el-aside style="width:200px">
        <aside-nav></aside-nav>
      </el-aside>
      <el-main>
        <el-table :data="tableData" style="margin:40px 20px 0 20px;padding-right:40px">
          <el-table-column prop="title" label="标题" width="180"></el-table-column>
          <el-table-column prop="time" label="提交时间" width="180"></el-table-column>
          <el-table-column prop="status" label="状态">
            <template slot-scope="scope">
              <span v-if="scope.row.status ==1">提交</span>
              <span v-if="scope.row.status ==2">驳回</span>
              <span v-if="scope.row.status ==3">通过</span>
            </template>
          </el-table-column>
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
  name: "adminKnowledgeList",
  data() {
    return {
      tableData: [],
    };
  },
  components: { AsideNav },
  computed: {},
  created() {},
  mounted() {
    this.load();
  },
  methods: {
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

    check(row) {
      this.$router.push({
        path: "/admin/knowledge",
        query: { id: row.id }
      });
    }
  }
};
</script>
<style >
</style>