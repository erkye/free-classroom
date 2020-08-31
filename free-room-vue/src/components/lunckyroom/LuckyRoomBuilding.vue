<template>
    <div>
        <el-row>
          <!-- 遍历教学楼 添加点击事件 子组件出发要使用 native 修饰 -->
           <el-col :xs="24" :sm="24" :md="4" :lg="4" :xl="4" v-for="building in buildings" :key="building.id">
               <Building :BoxName='building.name' :Color=building.id @click.native="clickSelection(building.id,building.name)"/>
            </el-col>
        </el-row>
    </div>
</template>
<script>
/* 楼层显示组件 */
import Building from '../ways/SelectionBuild'
export default {
  data () {
    return {
      /* 教学楼列表 */
      buildings: [

      ]
    }
  },
  methods: {
    clickSelection (id, name) {
      /* 跳转到 扫楼的空闲教室列表页面 同时携带教学楼的id和名称 */
      this.$router.push({
        name: 'LuckyRoomList',
        params: {
          id: id,
          name: name
        }
      })
    },
    /* 获取教学楼数据 */
    async getBuildingList () {
      const result = await this.$http.get('/building/all')
      // console.log(result)
      if (result.code === 1000) {
        this.buildings = result.data
      } else {
        this.$message.error(result.message)
      }
    }
  },
  components: {
    Building
  },
  mounted () {
    /* 获取教学楼数据 */
    this.getBuildingList()
  }
}
</script>
<style scoped>

</style>
