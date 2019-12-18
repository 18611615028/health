<template>
  <div>
    <el-container>
      <el-aside style="width:200px">
        <aside-nav></aside-nav>
      </el-aside>
      <el-main>
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
    return {};
  },
  components: { AsideNav },
  computed: {},
  created() {},
  mounted() {
  },
  methods: {}
};
</script>
<style >
</style>