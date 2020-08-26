<template>
  <div>
    <!-- 显示当前页面显示的教学楼的房间 -->
    <el-row>
      <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
        <Building :BoxName="buildingName + '-' + roomName" :Color="roomId" />
      </el-col>
    </el-row>
    <!-- 显示查询的房间当天的情况 -->
    <el-row>
      <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
        <el-card>

          <el-table :data="roomStatus" stripe style="width: 100%">
            <el-table-column label="节次" prop="session" />
            <el-table-column label="是否空闲" prop="free">
              <template slot-scope="scope">
                <el-badge is-dot v-show="scope.row.free" type="success"/>
                <el-badge is-dot v-show="!scope.row.free"/>
              </template>
            </el-table-column>
          </el-table>
          <br>
          <br>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>
<script>
/* 引入教学楼教室显示组件 */
import Building from '../ways/SelectionBuild'
export default {
  data () {
    return {
      /* 教学楼名称 路由携带 */
      buildingName: '',
      /* 房间id 路由携带 */
      roomId: -1,
      /* 房间名称 路由携带 */
      roomName: '',
      /* 教室情况 */
      roomStatus: [

      ]
    }
  },
  methods: {
    /* 查询该教室当天的状态 */
    async getRoomStatus () {
      const result = await this.$http.get('/freeRoom/queryRoom?buildingName=' + this.buildingName + '&roomName=' + this.roomName)
      // console.log(result)
      if (result.code === 1000) {
        this.roomStatus = result.data
      } else {
        this.$message.error(result.message)
      }
    }
  },
  mounted () {
    /* 提取路由参数中携带的房间id 房间名称 教学楼名称 */
    this.roomId = this.$route.params.roomId
    this.roomName = this.$route.params.roomName
    this.buildingName = this.$route.params.buildingName
    /* 查询该教室当天的状态 */
    this.getRoomStatus()
  },
  components: {
    Building
  }
}
</script>
<style scoped>

</style>
