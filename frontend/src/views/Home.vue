<template>
  <div class="home">
    <AddMetrica 
      v-if="addMetrica.show" 
    />
    <!--Abajo de aquí va todo el código de la página principal-->
    <AddRoute 
      @alternateShowAddRoute="alternateShowAddRoute" 
      v-if="showAddRoute" />
    <AddRouteResponsive 
      @alternateShowAddRoute="alternateShowAddRoute" 
      v-if="showAddRoute"/>
    <Navbar />
    <div id="Peatones">
      <div class="">
        <div
          class="row justify-content-center"
          style="width: 100%; margin: 0px"
        >
          <div class="col-md-5 col-sm-8" style="padding: 0">
            <div>
              <h1 className="d-flex" style="font-family: 'Raleway', sans-serif;text-align:left" v-if="$cookies.get('token')">
                <div class="d-flex justify-content-center">Agrega una ruta</div>
                <div class="mt-3 p-3 containerIconAdd">
                  <svg v-if="$cookies.get('token')" @click="alternateShowAddRoute" xmlns="http://www.w3.org/2000/svg" width="38" height="38" fill="currentColor" class="bi bi-plus-circle iconAdd" viewBox="0 0 16 16">
                    <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                    <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                  </svg>
                </div>
              </h1>
              <h1 style="font-family: 'Raleway', sans-serif;" v-else>
                Rutas
              </h1>
            </div>
            <div class="m-4 d-flex justify-content-center align-items-center errorNoPublications" v-if="rutas.length === 0" style="height:250px;">
              <h1 class="text-muted" style="font-size:20px;">Algo esta mal, intentenlo mas tarde</h1>
            </div>
            <div class="publicaciones" v-for="(ruta, index) in rutas" :key="index" v-else>
              <FeaturedPublication 
                v-if="index < 3"
                :ruta="ruta"
                :index="index"
                @like="like"
                :showImgs="showImgs" 
              />
              <Publication 
                v-else
                :index="index"
                @like="like"
                :ruta="ruta"
                :showImgs="showImgs" 
              />
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

//components
import FeaturedPublication from "../components/rutes/FeaturedPublication.vue"
import Publication from "../components/rutes/Publication.vue"
import Navbar from "../components/Navbar.vue";
import AddMetrica from "../components/rutes/addMetrica.vue"
import AddRoute from "../components/AddRoute.vue";
import AddRouteResponsive from "../components/AddRouteResponsive.vue";

//librerias
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
    FeaturedPublication,
    Publication,
    AddMetrica
    // Publicacion
  },
  data() {
    return {
      showAddRoute: false,
    };
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
  methods: {

    //Alternar rutas *****************************************************************
    alternateShowAddRoute(){
      this.showAddRoute = !this.showAddRoute;
    },

    //Dar like ***********************************************************************
    like(ruta, index){

      if(!this.$cookies.get('token')){
        this.$router.push('/login')
        return
      }

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
                id_ruta : ruta.id_ruta,
                multimedia : ruta.multimedia,
                id_usuario : {
                  id_usuario : ruta.id_usuario
                },
                ubicacion : ruta.ubicacion,
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
                id_ruta : ruta.id_ruta,
                multimedia : ruta.multimedia,
                id_usuario : {
                  id_usuario : ruta.id_usuario
                },
                ubicacion : ruta.ubicacion,
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
  computed : {
    ...mapState({
      rutas : 'rutas',
      showImgs : 'showImgs',
      addMetrica : 'addMetrica'
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
  /* color:#37f185; */
  color:white;
}

.iconAdd:hover {
  cursor:pointer;
  color:rgb(27, 141, 74);
}

.errorNoPublications {
  min-height: 42.7vh;
}

.containerIconAdd {
  background:#37f185;
  border-radius:15px;
  display:flex;
  justify-content: center;
  margin: 0 20%;
}

</style>
