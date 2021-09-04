import Vue from "vue";
import Croppa from "vue-croppa";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vueCookies from "vue-cookies";
import { library } from "@fortawesome/fontawesome-svg-core";
import { faThumbsUp } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import "vue-croppa/dist/vue-croppa.css";

/**
 * Funcion para añadir un item de font awesome
 * @param faThumbsUp
 */
library.add(faThumbsUp);
/**
 * Funcion para el uso de vue
 * @param Croppa
 */
Vue.use(Croppa, { componentName: "imagen" });
/**
 * Funcion para llamado de cookies en el aplicativo
 * @param vueCookies
 */
Vue.use(vueCookies);
/**
 * Funcion para el uso de font awesome como componente
 * @param FontAwesomeIcon
 */
Vue.component("font-awesome-icon", FontAwesomeIcon);

Vue.config.productionTip = false;
/**
 * Llamado de un objeto en vue que se le pasa como parametro un objeto
 * @param router
 * @param store
 */
new Vue({
  router,
  store,
  render: (h) => h(App)
}).$mount("#app");
