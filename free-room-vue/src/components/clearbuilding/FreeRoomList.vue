<template>
  <div>
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
          <!-- stripe 斑马纹  -->
          <el-table :data="freeRoomList" stripe style="width: 100%">
            <el-table-column label="节次" prop="session"/>
            <el-table-column label="空闲教室" prop="roomlist">
                <template slot-scope="scope">
                    <el-tag v-for="(room, index) in scope.row.roomlist" :key="index" type="success">{{room.name}}</el-tag>
                </template>
            </el-table-column>
          </el-table>
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
      freeRoomList: [

      ]
    }
  },
  methods: {
    /* 获取扫楼的结果 */
    async getClearRoomList () {
      const result = await this.$http.get('/freeRoom/clearBuilding?buildingId=' + this.buildingId + '&buildingName=' + this.buildingName)
      // console.log(result)
      if (result.code === 1000) {
        this.freeRoomList = result.data
      } else {
        this.$message.error(result.message)
      }
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
</style>
