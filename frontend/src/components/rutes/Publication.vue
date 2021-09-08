<template>
    <div class="publicacion" >
        <ButtonsRute 
            v-if="showBotonsRute" 
            :ruta="ruta"
            @showBottonMenu="showBottonMenu"
            @goToPublication="goToPublication"
            @removeRute="removeRute"
        />
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
                @click="showBottonMenu"
                class="imagenes"
                :src="ruta.multimedia"
                alt="800x800"
                v-else
            />
        </div>
        <p class="descripcionMeGusta">{{ruta.me_gusta}}</p>
        <div class="ml-2 d-flex">
            <button @click="$emit('like', ruta, index)" class="meGusta">
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
</template>

<script>
import ButtonsRute from "./botonsRute.vue"
import "../../styles/publication.css"
//librerias
import { storage } from '../../utils/firebase'
const refStorage = storage.ref()

export default {
    name : 'Publication',
    components:{
        ButtonsRute,
    },
    props : {
        index : Number,
        showImgs : Boolean,
        ruta : Object,
    },
    data(){
        return {
            showBotonsRute : false,
        }
    },
    methods : {
        showBottonMenu(){
            //$router.push(`/ruta/${(index+1)}`)
            this.showBotonsRute = !this.showBotonsRute
        },
        goToPublication(){
            this.$router.push(`/ruta/${(this.index+1)}`)
        },
        removeRute(){
            fetch(`http://localhost:8081/rutas?id_usuario=${this.ruta.id_ruta}`, {
                method: 'DELETE'
            })
            .then(res => res.json())
            .then(result => {
                if(result.error === 0){
                    this.showBotonsRute = !this.showBotonsRute;
                    if(this.showImgs){
                        this.$store.dispatch('changeShowImgsAction')
                    }
                    if(this.$cookies.get('token')){
                        this.$store.dispatch('mountRutasAction', { refStorage, id : this.$cookies.get('token')})
                    } else {
                        this.$store.dispatch('mountRutasAction', { refStorage, id : "notoken"})
                    }
                }
            })
        },
    }
}
</script>