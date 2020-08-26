<template>
    <div class="clock">
        <div class="flip">
            <div class="digital front" :data-number="nextTimes[0]"></div>
            <div class="digital back" :data-number="nowTimes[0]"></div>
        </div>
        <div class="flip">
            <div class="digital front" :data-number="nextTimes[1]"></div>
            <div class="digital back" :data-number="nowTimes[1]"></div>
        </div>
        <em class="divider">:</em>
        <div class="flip">
            <div class="digital front" :data-number="nextTimes[2]"></div>
            <div class="digital back" :data-number="nowTimes[2]"></div>
        </div>
        <div class="flip">
            <div class="digital front" :data-number="nextTimes[3]"></div>
            <div class="digital back" :data-number="nowTimes[3]"></div>
        </div>
        <em class="divider" v-show="false">:</em>
        <div class="flip" v-show="false">
            <div class="digital front" :data-number="nextTimes[4]"></div>
            <div class="digital back" :data-number="nowTimes[4]"></div>
        </div>
        <div class="flip" v-show="false">
            <div class="digital front" :data-number="nextTimes[5]"></div>
            <div class="digital back" :data-number="nowTimes[5]"></div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'ClockData',
  data () {
    return {
      duration: 650,
      nowTimes: [],
      nextTimes: [],
      timer: {}
    }
  },
  mounted () {
    this.initDate()
    this.timer = setInterval(() => {
      this.updateTime()
    }, 1000)
  },
  methods: {
    initDate () {
      const now = new Date()
      this.nowTimes = this.getTimeFromDate(new Date(now.getTime() - 1000))
      this.nextTimes = this.getTimeFromDate(now)
    },
    updateTime () {
      const now = new Date()
      const nowTimes = this.getTimeFromDate(new Date(now.getTime() - 1000))
      const nextTimes = this.getTimeFromDate(now)
      for (let i = 0; i < 6; i++) {
        if (nowTimes[i] !== nextTimes[i]) {
          this.setSpin(i, nowTimes[i], nextTimes[i])
        }
      }
    },
    setSpin (index, nowTime, nextTime) {
      const nodes = document.querySelectorAll('.flip')
      nodes[index].classList.add('running')
      this.nowTimes.splice(index, 1, nowTime)
      this.nextTimes.splice(index, 1, nextTime)
      setTimeout(() => {
        nodes[index].classList.remove('running')
        this.nowTimes.splice(index, 1, nextTime)
      }, this.duration)
    },
    getTimeFromDate (date) {
      const numTime = []
      const timeStr = date
        .toTimeString()
        .slice(0, 8)
        .split(':')
        .join('')
      for (let i = 0; i < timeStr.length; i++) {
        numTime.push(parseInt(timeStr[i]))
      }
      return numTime
    }
  },
  destroyed () {
    // 销毁定时器
    clearInterval(this.timer)
  }
}
</script>

<style scoped>
    .clock {
        display: flex;
    }
    .clock .divider {
        font-size: 66px;
        line-height: 102px;
        font-style: normal;
        color: #696094;
    }
    .clock .flip {
        position: relative;
        width: 80px;
        height: 100px;
        margin: 2px;
        font-size: 66px;
        line-height: 100px;
        text-align: center;
        background: white;
        border: 1px solid #675d99;
        border-radius: 12px;
    }
    .clock .flip .digital::before, .clock .flip .digital::after {
        position: absolute;
        content: attr(data-number);
        left: 0;
        right: 0;
        color: #696094;
        background: #cadcf9;
        /* background: linear-gradient(to bottom, #323232 0%, #3F3F3F 40%, #1C1C1C 150%), linear-gradient(to top, rgba(255,255,255,0.40) 0%, rgba(0,0,0,0.25) 200%);
        background-blend-mode: multiply; */
        overflow: hidden;
        -webkit-perspective: 160px;
        perspective: 160px;
    }
    .clock .flip .digital::before {
        top: 0;
        bottom: 50%;
        border-bottom: 1px solid #666;
        border-radius: 10px 10px 0 0;
    }
    .clock .flip .digital::after {
        top: 50%;
        bottom: 0;
        line-height: 0;
        border-radius: 0 0 10px 10px;
    }
    .clock .flip .back::before,
    .clock .flip .front::after {
        z-index: 1;
    }
    .clock .flip .back::after {
        z-index: 2;
    }
    .clock .flip .front::before {
        z-index: 3;
    }
    .clock .flip .back::after {
        -webkit-transform-origin: center top;
        transform-origin: center top;
        -webkit-transform: rotateX(0.5turn);
        transform: rotateX(0.5turn);
    }
    .clock .flip.running .front::before {
        -webkit-transform-origin: center bottom;
        transform-origin: center bottom;
        -webkit-animation: frontFlipDown 0.6s ease-in-out;
        animation: frontFlipDown 0.6s ease-in-out;
        -webkit-backface-visibility: hidden;
        backface-visibility: hidden;
    }
    .clock .flip.running .back::after {
        -webkit-animation: backFlipDown 0.6s ease-in-out;
        animation: backFlipDown 0.6s ease-in-out;
    }
    @-webkit-keyframes frontFlipDown {
        to {
            -webkit-transform: rotateX(0.5turn);
            transform: rotateX(0.5turn);
        }
    }
    @keyframes frontFlipDown {
        to {
            -webkit-transform: rotateX(0.5turn);
            transform: rotateX(0.5turn);
        }
    }
    @-webkit-keyframes backFlipDown {
        to {
            -webkit-transform: rotateX(0);
            transform: rotateX(0);
        }
    }
    @keyframes backFlipDown {
        to {
            -webkit-transform: rotateX(0);
            transform: rotateX(0);
        }
    }
</style>
