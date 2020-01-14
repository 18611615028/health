<template>
  <div>
    <el-container>
      <el-aside style="width:200px">
        <aside-nav></aside-nav>
      </el-aside>
      <el-main>
        <el-form
          :model="ruleForm"
          :rules="rules"
          ref="ruleForm"
          label-width="100px"
          class="demo-ruleForm"
        >
          <div style="display:flex">
            <el-form-item label="姓名" prop="name">
              <el-input style="width:220px" disabled v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="ID" prop="name">
              <el-input style="width:220px" disabled v-model="ruleForm.userId"></el-input>
            </el-form-item>
          </div>
          <div style="display:flex">
            <el-form-item label="性别" prop="sex">
              <el-select style="width:220px" disabled v-model="ruleForm.sex">
                <el-option label="男" value="男"></el-option>
                <el-option label="女" value="女"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="预约时间" prop="time">
              <el-date-picker
                v-model="ruleForm.appTime"
                disabled
                type="datetime"
                placeholder="选择日期时间"
              ></el-date-picker>
            </el-form-item>
          </div>
          <el-form-item label="体检备注" prop="appNote">
            <el-input
              style="width:540px"
              type="textarea"
              disabled
              :autosize="{ minRows: 1, maxRows: 10}"
              v-model="ruleForm.appNote"
            ></el-input>
          </el-form-item>
          <el-form-item v-if="status==1 && !show">
            <el-button :disabled="this.docStatus == null" type="primary" @click="create()">已体检</el-button>
            <el-button @click="goBack()">返回</el-button>
          </el-form-item>
          <div v-if="status==2 || status==3 ||show ||status==4">
            <el-form-item v-if="status!=4" label="体检项目">
              <el-select :disabled="true" style="width:220px" v-model="docStatus">
                <el-option label="外科" value="外科"></el-option>
                <el-option label="内科" value="内科"></el-option>
                <el-option label="眼科" value="眼科"></el-option>
              </el-select>
            </el-form-item>
            <div v-if="docStatus=='眼科' ||status==4">
              <el-form-item label="左眼视力">
                <el-input-number
                  :disabled="eDisable"
                  v-model="ruleForm.eyeL"
                  :precision="1"
                  :step="0.1"
                  :min="3.5"
                  :max="5.3"
                ></el-input-number>D
              </el-form-item>
              <el-form-item label="右眼视力">
                <el-input-number
                  :disabled="eDisable"
                  v-model="ruleForm.eyeR"
                  :precision="1"
                  :step="0.1"
                  :min="3.5"
                  :max="5.3"
                ></el-input-number>D
              </el-form-item>
              <el-form-item label="眼睛检查">
                <el-input
                  :disabled="eDisable"
                  type="textarea"
                  maxlength="100"
                  show-word-limit
                  style="width:540px"
                  v-model="ruleForm.color"
                ></el-input>
              </el-form-item>
            </div>
            <div v-if="docStatus=='外科' ||status==4">
              <el-form-item label="身高">
                <el-input
                  :disabled="wDisable"
                  maxlength="3"
                  show-word-limit
                  style="width:220px"
                  v-model="ruleForm.shenGao"
                ></el-input>cm
              </el-form-item>
              <el-form-item label="体重">
                <el-input
                  :disabled="wDisable"
                  maxlength="3"
                  show-word-limit
                  style="width:220px"
                  v-model="ruleForm.tiZhong"
                ></el-input>g
              </el-form-item>
              <el-form-item label="肺活量">
                <el-input
                  :disabled="wDisable"
                  maxlength="4"
                  show-word-limit
                  style="width:220px"
                  v-model="ruleForm.feiHuo"
                ></el-input>ml
              </el-form-item>
              <el-form-item label="外伤检查">
                <el-input
                  :disabled="wDisable"
                  type="textarea"
                  maxlength="100"
                  show-word-limit
                  style="width:540px"
                  v-model="ruleForm.waiShang"
                ></el-input>
              </el-form-item>
            </div>
            <div v-if="docStatus=='内科' ||status==4">
              <el-form-item label="收缩压">
                <el-input-number
                  :disabled="nDisable"
                  v-model="xueYa1"
                  :precision="0"
                  :step="1"
                  :min="1"
                  :max="200"
                ></el-input-number>mmHg
              </el-form-item>
              <el-form-item label="舒张压">
                <el-input-number
                  :disabled="nDisable"
                  v-model="xueYa2"
                  :precision="0"
                  :step="1"
                  :min="1"
                  :max="200"
                ></el-input-number>mmHg
              </el-form-item>
              <el-form-item label="血糖">
                <el-input-number
                  :disabled="nDisable"
                  v-model="ruleForm.xueTang"
                  :precision="3"
                  :step="0.1"
                  :min="1"
                  :max="10"
                ></el-input-number>mmol/L
              </el-form-item>
              <el-form-item label="肺部检查">
                <el-input
                  :disabled="nDisable"
                  type="textarea"
                  maxlength="100"
                  show-word-limit
                  style="width:540px"
                  v-model="ruleForm.fei"
                ></el-input>
              </el-form-item>
              <el-form-item label="心脏检查">
                <el-input
                  :disabled="nDisable"
                  type="textarea"
                  maxlength="100"
                  show-word-limit
                  style="width:540px"
                  v-model="ruleForm.xinZang"
                ></el-input>
              </el-form-item>
              <el-form-item label="腹部检查">
                <el-input
                  :disabled="nDisable"
                  type="textarea"
                  maxlength="100"
                  show-word-limit
                  style="width:540px"
                  v-model="ruleForm.fuBu"
                ></el-input>
              </el-form-item>
              <el-form-item label="肾脏检查">
                <el-input
                  :disabled="nDisable"
                  type="textarea"
                  maxlength="100"
                  show-word-limit
                  style="width:540px"
                  v-model="ruleForm.shenZang"
                ></el-input>
              </el-form-item>
            </div>
            <el-form-item>
              <el-button type="primary" v-if="status!=4" @click="save()">录入</el-button>
              <el-button @click="goBack()">返回</el-button>
            </el-form-item>
          </div>
        </el-form>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import AsideNav from "./AsideNav";
import * as DocService from "@/api/doc";

export default {
  data() {
    return {
      show: false,
      ruleForm: {
        userId: "",
        name: "",
        sex: "",
        appTime: "",
        appNote: "",
        shenGao: "",
        tiZhong: "",
        feiHuo: "",
        waiShang: "",
        wDocId: "",
        eyeL: "",
        eyeR: "",
        color: "",
        eDocId: "",
        xueYa: [],
        xueTang: "",
        fei: "",
        xinZang: "",
        fuBu: "",
        shenZang: "",
        nDocId: ""
      },
      docStatus: "",
      status: null,
      xueYa1: "",
      xueYa2: "",
      rules: {},
      nDisable: false,
      wDisable: false,
      eDisable: false
    };
  },
  components: { AsideNav },
  mounted() {
    this.status = this.$route.query.finish;
    this.load();
    this.getOffice()
  },
  methods: {
    getOffice(){
      DocService.selectOffice(Number(this.$route.query.id)).then(res => {
              if (res.status == 200){
                this.docStatus = res.data.office
              }
            })
    },

    load() {
      if (this.status == 1) {
        //未体检
        var a = {
          userId: Number(this.$route.query.id),
          time: this.$route.query.time
        };
        DocService.getAppointmentList(a)
          .then(res => {
            if (res.status == 200) {
              this.ruleForm = res.data[0];
            }
          })
          .catch(err => {
            this.$message.error("服务器异常");
          });
      } else if (this.status == 2 || this.status == 3) {
        var a = {
          userId: Number(this.$route.query.id),
          time: this.$route.query.time
        };
        DocService.getAppointmentList(a)
          .then(res => {
            if (res.status == 200) {
              this.ruleForm = res.data[0];
            }
          })
          .catch(err => {
            this.$message.error("服务器异常");
          });
        DocService.getHealth(a)
          .then(res => {
            if (res.status == 200) {
              if (res.data.nDocId != 0) {
                this.ruleForm.xueYa = res.data.xueYa;
                this.ruleForm.xueTang = res.data.xueTang;
                this.ruleForm.fei = res.data.fei;
                this.ruleForm.xinZang = res.data.xinZang;
                this.ruleForm.fuBu = res.data.fuBu;
                this.ruleForm.shenZang = res.data.shenZang;
                this.xueYa1 = this.ruleForm.xueYa.slice(
                  0,
                  this.ruleForm.xueYa.indexOf("|")
                );
                this.xueYa2 = this.ruleForm.xueYa.slice(
                  this.ruleForm.xueYa.indexOf("|") + 1,
                  this.ruleForm.xueYa.length
                );
                this.nDisable = true;
              }
              if (res.data.wDocId != 0) {
                this.ruleForm.shenGao = res.data.shenGao;
                this.ruleForm.tiZhong = res.data.tiZhong;
                this.ruleForm.feiHuo = res.data.feiHuo;
                this.ruleForm.waiShang = res.data.waiShang;
                this.wDisable = true;
              }
              if (res.data.eDocId != 0) {
                this.ruleForm.eyeL = res.data.eyeL;
                this.ruleForm.eyeR = res.data.eyeR;
                this.ruleForm.color = res.data.color;
                this.eDisable = true;
              }
              this.$forceUpdate()
            }
          })
          .catch(err => {
            this.$message.error("服务器异常");
          });
      } else if (this.status == 4) {
        //不可更改
        var a = {
          userId: Number(this.$route.query.id),
          time: this.$route.query.time
        };
        DocService.getAppointmentList(a)
          .then(res => {
            if (res.status == 200) {
              this.ruleForm = res.data[0];


              DocService.getHealth(a)
          .then(res => {
            if (res.status == 200) {
              if (res.data.nDocId != 0) {
                this.ruleForm.xueYa = res.data.xueYa;
                this.ruleForm.xueTang = res.data.xueTang;
                this.ruleForm.fei = res.data.fei;
                this.ruleForm.xinZang = res.data.xinZang;
                this.ruleForm.fuBu = res.data.fuBu;
                this.ruleForm.shenZang = res.data.shenZang;
                this.xueYa1 = this.ruleForm.xueYa.slice(
                  0,
                  this.ruleForm.xueYa.indexOf("|")
                );
                this.xueYa2 = this.ruleForm.xueYa.slice(
                  this.ruleForm.xueYa.indexOf("|") + 1,
                  this.ruleForm.xueYa.length
                );
                this.nDisable = true;
              }
              if (res.data.wDocId != 0) {
                this.ruleForm.shenGao = res.data.shenGao;
                this.ruleForm.tiZhong = res.data.tiZhong;
                this.ruleForm.feiHuo = res.data.feiHuo;
                this.ruleForm.waiShang = res.data.waiShang;
                this.wDisable = true;
              }
              if (res.data.eDocId != 0) {
                this.ruleForm.eyeL = res.data.eyeL;
                this.ruleForm.eyeR = res.data.eyeR;
                this.ruleForm.color = res.data.color;
                this.eDisable = true;
              }
              this.$forceUpdate()
            }
            
          })
          .catch(err => {
            this.$message.error("服务器异常");
          });
            }
          })
          .catch(err => {
            this.$message.error("服务器异常");
          });
        
      }
    },

    goBack() {
      this.$router.back(-1);
    },

    create() {
      this.show = true;
      this.docStatus = "外科";
    },

    save() {
      var a = {};
      if (this.docStatus == "外科") {
        a = {
          userId: this.ruleForm.userId,
          time: this.ruleForm.appTime,
          status: this.status,
          shenGao: this.ruleForm.shenGao,
          tiZhong: this.ruleForm.tiZhong,
          feiHuo: this.ruleForm.feiHuo,
          waiShang: this.ruleForm.waiShang,
          wDocId: Number(window.localStorage.getItem("docId"))
        };
      } else if (this.docStatus == "眼科") {
        a = {
          userId: this.ruleForm.userId,
          time: this.ruleForm.appTime,
          status: this.status,
          color: this.ruleForm.color,
          eyeR: this.ruleForm.eyeR,
          eyeL: this.ruleForm.eyeL,
          eDocId: Number(window.localStorage.getItem("docId"))
        };
      } else if (this.docStatus == "内科") {
        a = {
          userId: this.ruleForm.userId,
          time: this.ruleForm.appTime,
          status: this.status,
          xueYa: this.xueYa1 + "|" + this.xueYa2,
          xueTang: this.ruleForm.xueTang,
          fei: this.ruleForm.fei,
          xinZang: this.ruleForm.xinZang,
          fuBu: this.ruleForm.fuBu,
          shenZang: this.ruleForm.shenZang,
          nDocId: Number(window.localStorage.getItem("docId"))
        };
      }
      DocService.updateHealth(a)
        .then(res => {
          if (res.status == 200) {
            this.$router.back(-1);
          }
        })
        .catch(err => {
          this.$message.error("服务器异常");
        });
    }
  }
};
</script>