import Vue from 'vue'
import App from './App'
import router from './router'

// false로 설정하면 배포에 대한 팁을 출력하지 않습니다.
Vue.config.productionTip = false

new Vue({
  el: '#app',
  // 뷰 인스턴스 생성 객체에는 router 속성이 있다.
  // 뷰 라우터를 사용하려면 이 속성으로 뷰 라우터 객체를 넘겨줘야 한다.
  router,
  components: { App },
  template: '<App/>'
})
