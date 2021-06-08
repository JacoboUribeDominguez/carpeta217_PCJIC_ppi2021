<template>
  <div class="home">
    <!--Abajo de aquí va todo el código de la página principal-->
    <AddRoute @alternateShowAddRoute="alternateShowAddRoute" v-if="showAddRoute" />
    <AddRouteResponsive @alternateShowAddRoute="alternateShowAddRoute" v-if="showAddRoute"/>
    <Navbar />
    <div id="Peatones">
      <div class="">
        <div
          class="row justify-content-center"
          style="width: 100%; margin: 0px"
        >
          <div class="col-md-5 col-sm-8" style="padding: 0">
            <div>
              <h1 style="font-family: 'Raleway', sans-serif;">
                Reporta y ayuda 
                <svg @click="alternateShowAddRoute" xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-plus-circle iconAdd" viewBox="0 0 16 16">
                  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                  <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                </svg>
              </h1>
            </div>
            <div class="m-4 d-flex justify-content-center align-items-center" v-if="rutas.length === 0" style="height:250px;">
              <h1 class="text-muted" style="font-size:20px;">Algo esta mal, intentenlo mas tarde</h1>
            </div>
            <div class="publicaciones" v-for="(ruta, index) in rutas" :key="index" v-else>
              <div class="publicacionDestacada" v-if="index < 3">
                <p class="autor d-flex align-items-center">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="25"
                    height="25"
                    fill="currentColor"
                    class="bi bi-person-circle mr-2"
                    viewBox="0 0 16 16"
                  >
                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                    <path
                      fill-rule="evenodd"
                      d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"
                    />
                  </svg>
                  {{ruta.id_usuario}}
                </p>
                <p class="descripcion">{{ruta.ubicacion}}</p>
                <div class="d-flex align-items-center justify-content-center" style="background:black;min-height:auto;max-height:500px;overflow:hidden;width:100%;">
                  <div class="my-5" v-if="!showImgs">
                    <div class="spinner-border text-success" role="status">
                      <span class="sr-only">Loading...</span>
                    </div>
                  </div>
                  <img
                    @click="$router.push(`/ruta/${(index+1)}`)"
                    class="imagenes"
                    :src="ruta.multimedia"
                    alt="800x800"
                    v-else
                  />
                </div>
                <p class="descripcionMeGusta">{{ruta.me_gusta}}</p>
                <div class="ml-2 d-flex">
                  <button @click="like(ruta, index)" class="meGusta">
                    <font-awesome-icon
                      v-if="!ruta.liked"
                      class="up"
                      icon="thumbs-up"
                      style="font-size: 1.5rem"
                    />
                    <font-awesome-icon
                      v-else
                      class="down"
                      icon="thumbs-up"
                      style="font-size: 1.5rem"
                    />
                  </button>
                </div>
              </div>
              <div class="publicacion" @click="$router.push(`/ruta/${(index+1)}`)" v-else>
                <p class="autor d-flex align-items-center">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="25"
                    height="25"
                    fill="currentColor"
                    class="bi bi-person-circle mr-2"
                    viewBox="0 0 16 16"
                  >
                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                    <path
                      fill-rule="evenodd"
                      d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"
                    />
                  </svg>
                  {{ruta.id_usuario}}
                </p>
                <p class="descripcion">{{ruta.ubicacion}}</p>
                <div class="d-flex align-items-center justify-content-center" style="background:black;min-height:auto;max-height:500px;overflow:hidden;width:100%;">
                  <div class="my-5" v-if="!showImgs">
                    <div class="spinner-border text-success" role="status">
                      <span class="sr-only">Loading...</span>
                    </div>
                  </div>
                  <img
                    class="imagenes"
                    :src="ruta.multimedia"
                    alt="800x800"
                    v-else
                  />
                </div>
                <p class="descripcionMeGusta">{{ruta.me_gusta}}</p>
                <div class="ml-2 d-flex">
                  <button @click="like(ruta, index)" class="meGusta">
                    <font-awesome-icon
                      v-if="!ruta.liked"
                      class="up"
                      icon="thumbs-up"
                      style="font-size: 1.5rem"
                    />
                    <font-awesome-icon
                      v-else
                      class="down"
                      icon="thumbs-up"
                      style="font-size: 1.5rem"
                    />
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--Arriba de aquí va todo el código de la página principal-->
  </div>
</template>

<script>
// @ is an alias to /src
// Aquí esta el css
import "../styles/home.css";
import Navbar from "../components/Navbar.vue";
import AddRoute from "../components/AddRoute.vue";
import AddRouteResponsive from "../components/AddRouteResponsive.vue";
import { storage } from '../utils/firebase'
const refStorage = storage.ref()
// import Publicacion from "../components/Publicacion"

import { mapState } from 'vuex'

export default {
  name: "Home",
  components: { 
    Navbar,
    AddRoute,
    AddRouteResponsive,
    // Publicacion
  },
  data() {
    return {
      showAddRoute: false
    };
  },
  methods: {
    alternateShowAddRoute(){
      this.showAddRoute = !this.showAddRoute;
    },
    like(ruta, index){

      const oldMe_gusta = this.rutas[index].me_gusta

      if(!ruta.liked){
        this.rutas[index].me_gusta = this.rutas[index].me_gusta + 1;
        this.rutas[index].liked = !this.rutas[index].liked
        const { id_ruta } = ruta
        fetch('http://localhost:8081/likes/ruta', {
          method: 'POST',
          body: JSON.stringify({
            id_ruta,
            id_usuario : this.$cookies.get('token')
          }),
          headers : {
            'Content-Type' : 'application/json'
          }
        })
        .then(res => res.json())
        .then(result => {
          if(result.error === 0){
            fetch('http://localhost:8081/rutas', {
              method:'PUT',
              body: JSON.stringify({
                ...ruta,
                me_gusta : oldMe_gusta + 1
              }),
              headers : {
                'Content-Type' : 'application/json'
              }
            })
          }
        })
      } else {
        this.rutas[index].me_gusta = this.rutas[index].me_gusta - 1;
        this.rutas[index].liked = !this.rutas[index].liked
        const { id_ruta } = ruta
        fetch('http://localhost:8081/likes/ruta', {
          method: 'DELETE',
          body: JSON.stringify({
            id_ruta,
            multimedia : '',
            id_usuario : this.$cookies.get('token')
          }),
          headers : {
            'Content-Type' : 'application/json'
          }
        })
        .then(res => res.json())
        .then(result => {
          if(result.error === 0){
            fetch('http://localhost:8081/rutas', {
              method:'PUT',
              body: JSON.stringify({
                ...ruta,
                multimedia : '',
                me_gusta : oldMe_gusta - 1
              }),
              headers : {
                'Content-Type' : 'application/json'
              }
            })
          }
        })
      }
    }
  },
  mounted(){
    if(this.showImgs){
      this.$store.dispatch('changeShowImgsAction')
    }
    if(this.$cookies.get('token')){
      this.$store.dispatch('mountRutasAction', { refStorage, id : this.$cookies.get('token')})
    } else {
      this.$store.dispatch('mountRutasAction', { refStorage, id : "notoken"})
    }
  },
  computed : {
    ...mapState({
      rutas : 'rutas',
      showImgs : 'showImgs'
    })
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Raleway:wght@100&display=swap');

#Peatones {
  background-color: #212121;
}

h1 {
  color: white;
  margin: 60px 0px 0px;
}

img {
  width: 100%;
  height: auto;
}

.publicacion {
  background: #312e2e;
  border-radius: 10px;
  margin: 1rem 0px;
}

.publicacionDestacada {
  background-color: #312e2e;
  box-shadow: 0px 0px 25px 1px rgb(253, 194, 0);
  margin: 4rem 0px;
}

.publicacionDestacada:hover, .publicacion:hover {
  border:1px solid #575151;
  cursor:pointer;
  transform: scale(1.1);
}

.autor {
  border-bottom:2px solid #535353;
  text-align: start;
  padding: 10px;
  color: white;
}

.descripcion {
  text-align: start;
  color: white;
  padding: 0px 10px 0px;
}

.meGusta {
  background: dodgerblue;
  border-color: dodgerblue;
  color: white;
  border-radius: 10px;
  padding: 0.5rem 0.5rem;
  width: 20%;
  margin-bottom: 1rem;
}

.meGusta .down {
  transform : rotate(180deg)
}

.descripcionMeGusta {
  padding: 10px 10px 10px;
  margin: 0px 0px;
  text-align: start;
  color: white;
}

.btnNavegacion1 {
  background-color: #ad9f1c;
  border: none;
  width: 43%;
  height: 1.5rem;
}

.btnNavegacion2 {
  background-color: #fff279;
  border: none;
  width: 43%;
  height: 1.5rem;
}

.botones {
  margin-top: 50px;
}

.iconAdd {
  color:#37f185;
}

.iconAdd:hover {
  cursor:pointer;
  color:rgb(27, 141, 74);
}

</style>
