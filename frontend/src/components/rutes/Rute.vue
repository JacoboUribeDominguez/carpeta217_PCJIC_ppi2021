<template>
    <div>
        <ButtonsRute 
            v-if="showBotonsRute" 
            @showBottonMenu="showBottonMenu"
        />
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
                    @click="showBottonMenu"
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
        <div class="publicacion" v-else>
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
                    @click="showBottonMenu"
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
</template>

<script>

import ButtonsRute from "./botonsRute.vue"

export default {
    name : 'Rute',
    components:{
        ButtonsRute,
    },
    props : {
        index : Number,
        showBotonsRute : Boolean,
        showImgs : Boolean,
        ruta : Object,
    },
    date(){
        return {
            showBotonsRute : false,
        }
    },
    methods : {
        showBottonMenu(){
            //$router.push(`/ruta/${(index+1)}`)
            this.showBotonsRute = !this.showBotonsRute
        },
    }
}
</script>

<style scoped>

/* PUBLICACION DESTACADA */
.publicacionDestacada {
  background-color: #312e2e;
  box-shadow: 0px 0px 25px 1px rgb(253, 194, 0);
  margin: 4rem 0px;
}

.publicacionDestacada:hover {
  cursor:pointer;
  box-shadow: 0px 0px 25px 1px #89ffba;
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

.descripcionMeGusta {
  padding: 10px 10px 10px;
  margin: 0px 0px;
  text-align: start;
  color: white;
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

/* PUBLICACIÓN */
.publicacion {
  background: #312e2e;
  border-radius: 10px;
  margin: 1rem 0px;
}

.publicacion:hover {
  cursor:pointer;
  box-shadow: 0px 0px 25px 1px white;
}

</style>