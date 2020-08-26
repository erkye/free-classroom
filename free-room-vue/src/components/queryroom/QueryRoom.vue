<template>
    <div>
      <!-- 遍历显示可查询教学楼 -->
        <el-row>
           <el-col :xs="24" :sm="24" :md="4" :lg="4" :xl="4" v-for="building in buildings" :key="building.id">
               <Building :BoxName='building.name' :Color=building.id @click.native="clickSelection(building.id,building.name)"/>
            </el-col>
        </el-row>
    </div>
</template>
<script>
/* 引入教学楼组件 */
import Building from '../ways/SelectionBuild'
export default {
  data () {
    return {
      buildings: [

      ]
    }
  },
  methods: {
    /* 点击教学楼出发的事件 */
    clickSelection (id, name) {
      /* 跳转到选择教学楼具体教室的页面 携带参数：教学楼id 教学楼名称 */
      this.$router.push({
        name: 'Rooms',
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
