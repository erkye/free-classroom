<template>
    <div>
      <br>
        <br>
        <!-- 钟表组件显示行 -->
        <el-row>
          <el-col :md="8" :lg="8" :xl="8" hidden-md-and-down>
            .
          </el-col>
          <el-col :xs="24" :sm="24" :md="8" :lg="8" :xl="8">
            <Clock/>
          </el-col>
          <el-col :md="8" :lg="8" :xl="8" hidden-md-and-down>
          </el-col>
        </el-row>

        <!-- 功能组件行 -->
          <el-row class="button">
            <el-col :xs="24" :sm="24" :md="8" :lg="8" :xl="8">
                <Selection BoxName='扫楼' Color='#e7c7be' FontColor='#7e6c97' @click.native="clickSelection('ClearBuilding')"/>
              </el-col>
            <el-col :xs="24" :sm="24" :md="8" :lg="8" :xl="8">
                <Selection BoxName='查教室' Color='#8ebf87' FontColor='#e6fccb' @click.native="clickSelection('QueryRoom')"/>
              </el-col>
            <el-col :xs="24" :sm="24" :md="8" :lg="8" :xl="8">
                <Selection BoxName='Lucky Room' Color='#dbdca4' FontColor='#7c5ca0' @click.native="clickSelection('LuckyRoom')"/>
              </el-col>
          </el-row>
    </div>
</template>
<script>
import Selection from './ways/Selection'
import Clock from './util/Clock'
export default {
  data () {
    return {
      date: new Date()
    }
  },
  methods: {
    clickSelection (value) {
      this.$router.push('/' + value)
    }
  },
  components: {
    Selection,
    Clock
  }
}
</script>
<style scoped>
.button{
  position: absolute;
  top: 280px;
  width: 100%;
}
.clock{
  background-color: #cadcf9;
  /* background-image: linear-gradient(to top, #f3e7e9 0%, #e3eeff 99%, #e3eeff 100%); */

}

</style>
