<template>
    <div class="row" style="height:100vh;margin:0;width:100%;">
        <div class="d-flex justify-content-center align-items-center col-md-8 col-12" style="background:black;">
            <div class="d-flex justify-content-between px-3" style="color:white;height:100%;position:absolute;width:100%;z-index:2;">
                <div class="d-flex align-items-center">
                    <svg @click="goTo(id-1)" v-if="id !== 0" xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-arrow-left-circle-fill" viewBox="0 0 16 16">
                        <path d="M8 0a8 8 0 1 0 0 16A8 8 0 0 0 8 0zm3.5 7.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
                    </svg>
                </div>
                <div class="d-flex align-items-center">
                    <svg @click="goTo(id+1)" v-if="id !== (rutas.length-1)" style="transform:rotate(180deg);" xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-arrow-left-circle-fill" viewBox="0 0 16 16">
                        <path d="M8 0a8 8 0 1 0 0 16A8 8 0 0 0 8 0zm3.5 7.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
                    </svg>
                </div>
            </div>
            <div class="my-5" v-if="!showImgs">
                <div class="spinner-border text-success" role="status">
                  <span class="sr-only">Loading...</span>
                </div>
            </div>
            <div class="containerImgRef" v-else>
                <img ref="imgRef" :src="rutas[id].multimedia" :alt="rutas[id].id_ruta"/>
            </div>
        </div>
        <div class="col-md-4 col-12" style="background:#212121;padding:0;">
            <div class="pt-3 pb-2 d-flex justify-content-between" style="color:#EEEEEE;">
                <h4 class="d-flex align-items-center ml-3" style="margin:0;">{{(rutas[id]) ? rutas[id].ubicacion : ''}}</h4>
                <svg @click="$router.push('/')" style="color:white" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-x-circle-fill my-2 mr-3 btn-remove-rute" viewBox="0 0 16 16">
                    <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                </svg>
            </div>
            <div class="headerComments px-3 d-flex justify-content-start align-items-center pb-3" style="color:white">
                <button class="meGusta mr-2">
                    <font-awesome-icon
                        class="up"
                        icon="thumbs-up"
                        style="font-size: .8rem"
                    />
                </button>
                <div>
                    {{rutas[id].me_gusta}}
                </div>
            </div>
            <div class="d-flex justify-content-start ml-3">
                <div class="giveLike" style="color:white;">
                    <font-awesome-icon
                        v-if="!rutas[id].liked"
                        class="up"
                        icon="thumbs-up"
                        style="font-size: 1rem"
                    />
                    <font-awesome-icon
                        v-else
                        class="down"
                        icon="thumbs-up"
                        style="font-size: 1rem"
                    />
                </div>
            </div>
            <div class="d-flex flex-column justify-content-center align-items-center p-4">
                <div class="d-flex justify-content-center inputCommentContainer px-2">
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
    methods : {
        goTo(id){
            this.id = id
        },
        change(){
            if(!this.cambiado){
                if(this.$refs.imgRef){
                    const img = new Image();
                    img.src = this.rutas[this.id].multimedia;
                    if(img.width > img.height){
                        this.$refs.imgRef.classList="widthHigher";
                    } else if(img.width < img.height) {
                        this.$refs.imgRef.classList="heightHigher";
                    } else {
                        this.$refs.imgRef.classList="widthIqualHeight";
                    }
                }
            }
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
            this.change()
        }
    },
    updated(){
        this.change()
    }
}
</script>

<style scoped>

    /************ PHOTO ************/

    .widthHigher {
        height:auto;
        max-width:85%;
    }

    .heightHigher {
        max-height:100vh;
        max-width:100%;
    }

    .widthIqualHeight {
        max-height:100vh;
        width:100%;
    }

    /* COMMENTS */

    .meGusta {
        /* background:#444444; */
        background: #24c567;
        border:none;
        border-radius:50%;
        /* color:#24c567; */
        color:#fff;
        margin-bottom:0px;
        padding:.2rem .5rem;
        width:auto;
    }

    .headerComments {
        border-bottom:1px solid #535353;
    }

    .inputCommentContainer {
        background:#444444;
        border:none;
        border-radius:18px;
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

    .btn-remove-rute:hover, .bi-arrow-left-circle-fill {
        cursor:pointer;
    }

    .containerImgRef{
        align-items: center;
        display:flex;
        height:100%;
        justify-content:center;
        width:auto;
    }

    .giveLike {
        color:white;
        background: #535353;
        border-bottom-left-radius: 50%;
        border-bottom-right-radius: 50%;
        padding: .5rem 1rem;
    }

    .down {
        transform : rotate(180deg)
    }

</style>