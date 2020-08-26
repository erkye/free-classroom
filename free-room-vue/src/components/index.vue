<template>
    <div>
      <br>
        <br>
        <Clock/>
          <el-row class="button">
            <el-col :xs="24" :sm="24" :md="4" :lg="12" :xl="12">
                <Selection BoxName='扫楼' Color='#e7c7be' FontColor='#7e6c97' @click.native="clickSelection('ClearBuilding')"/>
              </el-col>
            <el-col :xs="24" :sm="24" :md="4" :lg="12" :xl="12">
                <Selection BoxName='查教室' Color='#8ebf87' FontColor='#e6fccb' @click.native="clickSelection('QueryRoom')"/>
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
  top: 300px;
  width: 100%;
}
.clock{
  background-color: #cadcf9;
  /* background-image: linear-gradient(to top, #f3e7e9 0%, #e3eeff 99%, #e3eeff 100%); */

}

</style>
