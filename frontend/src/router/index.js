import Vue from 'vue'
import Router from 'vue-router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import axios from 'axios'
import Main from '@/components/main/Main'
import Login from '@/components/login/Login'
import Signup from '@/components/signup/Signup'
import NotFound from '@/components/etc/NotFound'
import Search from '@/components/search/Search'
import Product from '@/components/product/Product'
import Cart from '@/components/cart/Cart'
import Order from '@/components/order/Order'
import moment from 'moment'
moment.locale('ko');

Vue.prototype.$bus = new Vue();
Vue.prototype.$http = axios;
Vue.use(BootstrapVue);
Vue.use(Router)


export default new Router({
  mode: 'hash',
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
