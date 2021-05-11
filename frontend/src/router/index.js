import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Ruta2Ejemplo from "../views/Ruta2Ejemplo";
import Peatones from "../views/Peatones";
import Login from "../views/Login";
import Metricas from "../views/Metricas";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/Ruta2Ejemplo",
    name: "Ruta2Ejemplo",
    component: Ruta2Ejemplo
  },
  {
    path: "/Peatones",
    name: "Peatones",
    component: Peatones
  },
  {
    path: "/Login",
    name: "Login",
    component: Login
  },
  {
    path: "/Metricas",
    name: "Metricas",
    component: Metricas
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
