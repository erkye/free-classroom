<template>
    <div>
        <el-row>
           <el-col :xs="24" :sm="24" :md="4" :lg="12" :xl="12">
              <Selection BoxName='扫楼' Color='coral' @click.native="clickSelection('ClearBuilding')"/>
            </el-col>
           <el-col :xs="24" :sm="24" :md="4" :lg="12" :xl="12">
               <Selection BoxName='查教室' Color='cornflowerblue' @click.native="clickSelection('QueryRoom')"/>
            </el-col>
        </el-row>
    </div>
</template>
<script>
import Selection from './ways/Selection'
export default {
  data () {
    return {
    }
  },
  methods: {
    clickSelection (value) {
      this.$router.push('/' + value)
    }
  },
  components: {
    Selection
  }
}
</script>
<style scoped>
</style>
