import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Ruta2Ejemplo from "../views/Ruta2Ejemplo";
import Register from "../views/Register";
import Peatones from "../views/Peatones";
import Login from "../views/Login";
import Metricas from "../views/Metricas";
import Hurtos from "../views/Hurtos"
import Ruta from "../views/Ruta.vue"
import Results from "../views/Results"

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
    path: "/register",
    name: "Register",
    component: Register
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
  {
    path: "/Hurtos",
    name: "Hurtos",
    component: Hurtos
  },
  {
    path: "/ruta/:id",
    name: "Ruta",
    component: Ruta
  },
  {
    path: "/results",
    name: "Results",
    component: Results
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
