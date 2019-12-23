<template>
  <div>
    <el-container>
      <el-aside style="width:200px">
        <aside-nav></aside-nav>
      </el-aside>
      <el-main>
        <el-table :data="tableData" style="margin:40px 20px 0 20px;padding-right:40px">
          <el-table-column prop="docCId" label="职工编号" width="180"></el-table-column>
          <el-table-column prop="name" label="姓名" width="180"></el-table-column>
          <el-table-column prop="office" label="科室">
          </el-table-column>
          <el-table-column prop="title" label="职称"></el-table-column>
          <el-table-column>
            <template slot-scope="scope">
              <el-button @click="save(scope.row,3)">通过</el-button>
              <el-button @click="save(scope.row,2)">驳回</el-button>
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
  name: "adminQualificationList",
  data() {
    return {
      tableData:[],
    };
  },
  components: { AsideNav },
  computed: {},
  created() {},
  mounted() {
    this.load()
  },
  methods: {
    load(){
      DocService.getDocQuaList().then(res =>{
        if (res.status == 200) {
            this.tableData = res.data;
          }
      }).catch(err => {
          this.$message.error("服务器异常");
        });
    },
    save(row,status){
      DocService.updateDocQua({docId:row.docId,status:status}).then(res =>{
        if (res.status == 200) {
            this.load()
          }
      }).catch(err => {
          this.$message.error("服务器异常");
        });
    }
  }
};
</script>
<style >
</style>