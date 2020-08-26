<template>
    <div>
      <!-- 遍历显示当前教学楼的教室 -->
        <el-row>
           <el-col :xs="12" :sm="12" :md="4" :lg="4" :xl="4" v-for="room in roomlist" :key="room.id">
               <Room :BoxName='room.name' :Color=room.id @click.native="clickSelection(room.id,room.name)"/>
            </el-col>
        </el-row>
    </div>
</template>
<script>
/* 使用建筑组件作为教室显示组件 */
import Room from '../ways/SelectionBuild'
export default {
  data () {
    return {
      /* 教学楼的id 路由携带过来 */
      buildingId: -1,
      /* 教学楼名称 路由携带过来 */
      buildingName: '',
      /* 当前教学楼的教室列表 */
      roomlist: [

      ]
    }
  },
  methods: {
    /* 点击对应的教室触发 */
    clickSelection (id, name) {
      /* 路由到当前教室的查询结果页面 携带参数：教室id 教室名 教学楼名称 */
      this.$router.push({
        name: 'RoomStatus',
        params: {
          roomId: id,
          roomName: name,
          buildingName: this.buildingName
        }
      })
    },
    /* 根据教学楼的id获取所有教室 */
    async getRoomsByBuildId () {
      const result = await this.$http.get('/room/findRooms?id=' + this.buildingId)
      // console.log(result)
      if (result.code === 1000) {
        this.roomlist = result.data
      } else {
        this.$message.error(result.message)
      }
    }
  },
  components: {
    Room
  },
  mounted () {
    /* 提取路由携带的教学楼id和名称 */
    this.buildingId = this.$route.params.id
    this.buildingName = this.$route.params.name
    /* 根据教学楼的id获取所有教室 */
    this.getRoomsByBuildId()
  }
}
</script>
<style scoped>

</style>
