<template>
  <div
    v-loading="loading"
    element-loading-text="我是个害羞的人，尤其是看到屏幕前的你😳，你有点像天上的月亮，也像那闪烁的星星，可惜我不是诗人，否则，当写一万首诗来形容你的美丽，如果你看到这了，那么Good Luck Today！"
  >
    <el-row>
      <!-- 显示当前显示的教学楼 -->
      <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
        <Building :BoxName="buildingName" :Color="buildingId" />
      </el-col>
    </el-row>
    <!-- 显示教学楼当天空闲教室的结果 -->
    <el-row>
      <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
        <el-card>
          <el-card class="card">
            <div v-if="luckRoomList.length > 0">
              <div class="tip">
                Lucky Room全天没课哦！
                <br />尽情的加油吧！
                <br />努力的人运气从来都不会差
                <br />Good Luck！
                <br />
                <br />
                {{buildingName}}今天的Lucky Room如下:
                <br />
                <br />
              </div>

              <el-tag :key="room.id" v-for="room in luckRoomList" type="success">{{room.name}}</el-tag>
            </div>
            <div v-else>哎呀！{{buildingName}}今天没有Lucky Room 哦！但是你的Luck一点都不会少！Good Luck！</div>
          </el-card>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>
<script>
/* 引入教学楼的组件 */
import Building from '../ways/SelectionBuild'
export default {
  data () {
    return {
      /* 当前教学楼id */
      buildingId: -1,
      /* 当前教学楼的名称 */
      buildingName: '',
      /* 当前教学楼的空闲教室列表 */
      luckRoomList: [],
      /* 加载中标记 */
      loading: false
    }
  },
  methods: {
    /* 获取扫楼的结果 */
    async getClearRoomList () {
      // 加载中
      this.loading = true
      const result = await this.$http.get(
        '/freeRoom/luckyroom?buildingId=' +
          this.buildingId +
          '&buildingName=' +
          this.buildingName
      )
      // console.log(result)
      if (result.code === 1000) {
        this.luckRoomList = result.data
      } else {
        this.$message.error(result.message)
      }
      this.loading = false
    }
  },
  mounted () {
    this.buildingId = this.$route.params.id
    this.buildingName = this.$route.params.name
    /* 获取扫楼的结果 */
    this.getClearRoomList()
  },
  components: {
    Building
  }
}
</script>
<style scoped>
.card {
  background-image: linear-gradient(to top, #fff 0%, #fff 100%);
  border: 0;
}
.tip {
  text-align: center;
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  font-size: 14px;
  font-weight: 600;
  color:#635992;
}
</style>
