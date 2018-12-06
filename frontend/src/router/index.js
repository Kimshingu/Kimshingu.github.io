import Vue from 'vue'
import Router from 'vue-router'

// BootstrapVue import
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

// Components import
import Main from '@/components/main/Main'
import Login from '@/components/login/Login'
import Signup from '@/components/signup/Signup'
import NotFound from '@/components/etc/NotFound'
import Search from '@/components/search/Search'
import Product from '@/components/product/Product'
import Cart from '@/components/cart/Cart'
import Order from '@/components/order/Order'

// Date Library import, 한국시간으로 설정
import moment from 'moment'
moment.locale('ko');

// axios import, vue 앱의 전역으로 사용할 수 있도록 메소드를 추가
import axios from 'axios'
Vue.prototype.$http = axios;

// Vue.use() 함수를 이용해서 등록한다. BootstrapVue,Router...
Vue.use(BootstrapVue);
Vue.use(Router)

// eventBus 인스턴스 생성
Vue.prototype.$bus = new Vue();

// Router 함수로 라우터 객체를 생성한다.
export default new Router({
  mode: 'hash',
  // 경로와 컴포넌트으로 이뤄진 컬렉션이다.
  // 실제 이 맵을 보고 라우터가 경로에 따라 그에 맞는 컴포넌트를 렌더링한다.
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/signup',
      name: 'Signup',
      component: Signup
    },
    {
      path: '/search',
      name: 'Search',
      component: Search
    },
    {
      path: '/product',
      name: 'Product',
      component: Product
    },
    {
      path: '/cart',
      name: 'Cart',
      component: Cart
    },
    {
      path: '/order',
      name: 'Order',
      component: Order
    },
    {
      path: '*',
      name: 'NotFound',
      component: NotFound
    },

    { path: '/signout', redirect: '/' },
    { path: '/home', redirect: '/' }
  ]
})
