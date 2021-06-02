<template>
    <div class="row" style="height:100vh;margin:0;width:100%;">
        <div class="d-flex justify-content-center align-items-center col-md-8 col-12" style="background:black;">
            <div class="my-5" v-if="!showImgs">
                <div class="spinner-border text-success" role="status">
                  <span class="sr-only">Loading...</span>
                </div>
            </div>
            <div v-else>
                <img ref="imgRef" :src="rutas[id].multimedia"/>
            </div>
        </div>
        <div class="col-md-4 col-12" style="background:#212121;padding:0;">
            <div class="py-3 headerComments d-flex justify-content-between" style="color:#EEEEEE;">
                <h4 class="d-flex align-items-center ml-3" style="margin:0;">{{(rutas[id]) ? rutas[id].ubicacion : ''}}</h4>
                <svg style="color:white" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-x-circle-fill my-2 mr-3" viewBox="0 0 16 16">
                    <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                </svg>
            </div>
            <div class="d-flex flex-column justify-content-center align-items-center p-4">
                <div class="d-flex justify-content-center inputCommentContainer">
                    <div class="mr-3" style="width:100%">
                        <input class="inputComment" type="text" placeholder="Comenta algo..."/>
                    </div>
                    <div class="d-flex align-items-center" style="color:#37f185;transform: rotate(-45deg);opacity:0.6">
                        <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-arrow-right-circle-fill" viewBox="0 0 16 16">
                            <path d="M8 0a8 8 0 1 1 0 16A8 8 0 0 1 8 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z"/>
                        </svg>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

import { mapState } from 'vuex'
import { storage } from '../utils/firebase'
const refStorage = storage.ref()

export default {
    name:"Ruta",
    data(){
        return{   
            id : this.$route.params.id - 1,
            cambiado : false
        }
    },
    computed : {
        ...mapState({
            rutas : 'rutas',
            showImgs : 'showImgs'
        })
    },
    mounted(){
        if(this.rutas.length === 0){
            this.$store.dispatch('mountRutasAction', { refStorage })
        } else {
            this.$store.dispatch('changeShowImgsAction')
        }
    },
    updated(){
        if(!this.cambiado){
            if(this.$refs.imgRef){
                const img = new Image();
                img.src = this.rutas[this.id].multimedia
                if(img.width > img.height){
                    this.$refs.imgRef.classList="widthHigher"
                } else if(img.width < img.height) {
                    this.$refs.imgRef.classList="heightHigher"
                } else {
                    this.$refs.imgRef.classList="widthIqualHeight"
                }
                this.cambiado = true
            }
        }
    },
    destroyed(){
        this.$store.dispatch('changeShowImgsAction')
    }
}
</script>

<style scoped>

    /************ PHOTO ************/

    .widthHigher {
        height:auto;
        max-width:100%;
    }

    .heightHigher {
        max-height:100vh;
        width:auto;
    }

    .widthIqualHeight {
        max-height:100vh;
        max-width:auto;
    }

    /* COMMENTS */
    .headerComments {
        border-bottom:1px solid #535353;
    }

    .inputCommentContainer {
        background:#444444;
        border:none;
        border-radius:15px;
        color:white;
        padding:.5rem;
        width:100%;
    }

    .inputComment {
        background:none;
        border:none;
        color:#EAEAEA;
        height:100%;
        outline: none;
        width:100%;
    }

    .inputCommnet:focus {
        outline: none;
    }
</style>