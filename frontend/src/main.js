import Vue from "vue";
import Croppa from 'vue-croppa';
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vueCookies from "vue-cookies";
import { library } from '@fortawesome/fontawesome-svg-core'
import { faThumbsUp } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import 'vue-croppa/dist/vue-croppa.css';

library.add(faThumbsUp)

Vue.use(Croppa, { componentName:'imagen'});
Vue.use(vueCookies);

Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
