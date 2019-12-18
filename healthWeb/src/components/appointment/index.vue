<template>
  <div>
    <el-container>
      <el-aside style="width:200px">
        <aside-nav></aside-nav>
      </el-aside>
      <el-main>
        <div style="text-align:right;margin:0px auto 0px auto;margin:30px 0 20px 0">
          <el-form :inline="true" :model="formInline" class="demo-form-inline">
            <el-form-item label="状态">
              <el-select clearable v-model="formInline.finish" placeholder="状态">
                <el-option label="未体检" :value="1"></el-option>
                <el-option label="待录入" :value="2"></el-option>
                <el-option label="已录入" :value="4"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="姓名">
              <el-input v-model="formInline.name" placeholder="姓名"></el-input>
            </el-form-item>
            <el-form-item label="性别">
              <el-select clearable v-model="formInline.sex" placeholder="性别">
                <el-option label="男" value="男"></el-option>
                <el-option label="女" value="女"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="预约日期">
              <div class="block">
                <el-date-picker
                value-format="yyyy-MM-dd hh:mm:ss"
                  v-model="formInline.appTime"
                  type="datetimerange"
                  :picker-options="pickerOptions"
                  range-separator="至"
                  start-placeholder="开始日期"
                  end-placeholder="结束日期"
                  align="right"
                ></el-date-picker>
              </div>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="onSubmit">查询</el-button>
            </el-form-item>
          </el-form>
        </div>
        <el-table :data="tableData" stripe style="margin:40px 20px 0 20px;padding-right:40px">
          <el-table-column prop="appTime" label="预约时间" width="360"></el-table-column>
          <el-table-column prop="name" label="姓名" width="220"></el-table-column>
          <el-table-column prop="sex" label="性别" width="180"></el-table-column>
          <el-table-column prop="appNote" label="体检备注"></el-table-column>
          <el-table-column prop="finish" label="体检报告">
            <template slot-scope="scope">
              <el-button
                v-if="scope.row.finish==1"
                type="text"
                @click="checkAppointment(scope.row)"
              >查看预约信息</el-button>
              <el-button
                v-if="scope.row.finish==2 || scope.row.finish==3"
                type="text"
                @click="checkAppointment(scope.row)"
              >录入体检报告</el-button>
              <el-button
                v-if="scope.row.finish==4"
                type="text"
                @click="checkAppointment(scope.row)"
              >查看体检报告</el-button>
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
  name: "appointment",
  data() {
    return {
      tableData: [],
      formInline: {
        finish: null,
        name: "",
        sex: "",
        appTime: ["", ""],
        startTime: null,
        endTime: null
      },
      pickerOptions: {
        shortcuts: [
          {
            text: "未来一周",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              end.setTime(end.getTime() + 3600 * 1000 * 24 * 7);
              picker.$emit("pick", [start, end]);
            }
          },
          {
            text: "最近一周",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit("pick", [start, end]);
            }
          },
          {
            text: "最近一个月",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
              picker.$emit("pick", [start, end]);
            }
          },
          {
            text: "最近三个月",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
              picker.$emit("pick", [start, end]);
            }
          }
        ]
      }
    };
  },
  components: { AsideNav },
  computed: {},
  created() {},
  mounted() {
    this.onSubmit();
  },
  methods: {
    //跳转查看
    checkAppointment(row) {
      this.$router.push({
        path: "/appointment/check",
        query: { id: row.userId, time: row.time, finish: row.finish }
      });
    },
    //查询
    onSubmit() {
      if (this.formInline.appTime != null) {
        this.formInline.startTime = this.formInline.appTime[0];
        this.formInline.endTime = this.formInline.appTime[1];
      } else {
        this.formInline.startTime = null;
        this.formInline.endTime = null;
      }
      DocService.getAppointmentList(this.formInline)
        .then(res => {
          if (res.status == 200) {
            this.tableData = res.data;
            for (let q of this.tableData) {
              q.time = q.appTime;
              q.appTime =
                q.appTime.slice(0, 4) +
                "年" +
                q.appTime.slice(5, 7) +
                "月" +
                q.appTime.slice(8, 10) +
                "日" +
                q.appTime.slice(11, 16);
            }
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