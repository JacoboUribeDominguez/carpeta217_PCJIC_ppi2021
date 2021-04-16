import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Ruta2Ejemplo from "../views/Ruta2Ejemplo";
import LagaView from '../views/LagaView';

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/Ruta2Ejemplo",
    name: "Ruta2Ejemplo",
    component: Ruta2Ejemplo
  },
  {
    path: "/LagaView",
    name: "LagaView",
    component: LagaView
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
