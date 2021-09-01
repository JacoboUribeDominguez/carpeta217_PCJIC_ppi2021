<template>
    <div id="Peatones" style="min-height:100vh;">
        <div class="d-flex py-3 pl-3" style="color:white;width:100%;">
            <svg @click="$router.push('/')" xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-arrow-left-square-fill" viewBox="0 0 16 16">
                <path d="M16 14a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12zm-4.5-6.5H5.707l2.147-2.146a.5.5 0 1 0-.708-.708l-3 3a.5.5 0 0 0 0 .708l3 3a.5.5 0 0 0 .708-.708L5.707 8.5H11.5a.5.5 0 0 0 0-1z"/>
            </svg>
        </div>
        <div class="">
            <div
                class="row justify-content-center"
                style="width: 100%; margin: 0px"
            >
                <div class="col-md-5 col-sm-8" style="padding: 0;">
                    <div class="m-4 d-flex justify-content-center align-items-center" v-if="!results" style="height:250px;">
                        <h1 class="text-muted" style="font-size:20px;">Algo esta mal, intentenlo mas tarde</h1>
                    </div>
                    <div v-else-if="results.length === 0">
                      <div class="ifTherereNotResult">
                        <h1 class="px-4">Resultados para <span class="px-2" style="background:#37f185;">{{searchedWord.toUpperCase()}}</span> <span style="font-size:25px">({{results.length}})</span></h1>
                      </div>
                      <div class="mt-4">
                        <div class="alert alert-danger" role="alert">
                          No hay resultados para esta busqueda
                        </div>
                      </div>
                    </div>
                    <div v-else>
                      <div class="ifTherereResult mb-5">
                        <h1 class="px-4">Resultados para <span class="px-2" style="background:#37f185;">{{searchedWord.toUpperCase()}}</span> <span style="font-size:25px">({{results.length}})</span></h1>
                      </div>
                      <div class="publicaciones" v-for="(ruta, index) in results" :key="index">
                        <div class="publicacion">
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
                              {{ruta.usuario}}
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
                          <p class="descripcionMeGusta">{{`${ruta.me_gusta} me gusta`}}</p>
                        </div>
                      </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

import { mapState } from 'vuex'

export default {
    name:'Results',
    computed : {
        ...mapState({
            results : 'results',
            showImgs : 'showImgs',
            searchedWord : 'searchedWord'
        })
    },
    mounted(){
      this.$store.dispatch('changeShowImgsAction')
      setTimeout(()=> {
        if(!this.results){
          this.$router.push('/')
        }
      }, 7000)
    }
}

</script>

<style scoped>
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
  text-align: start;
  padding: 10px 10px;
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

.ifTherereNotResult, .ifTherereResult {
  background: #575151;
  border-radius:35px;
  padding: .5rem 0px;
}

.ifTherereNotResult h1, .ifTherereResult h1 {
  margin:0;
}

.meGusta .down {
  transform : rotate(180deg)
}
</style>