<template>
    <div>
        <div class="row" style="height:100vh;margin:0;width:100%;" v-if="rutas.length > 0">

            <div class="d-flex justify-content-center align-items-center col-md-8 col-12" style="background:black;" >
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
                            @click="like(rutas[id], id)"
                            v-if="!rutas[id].liked"
                            class="up"
                            icon="thumbs-up"
                            style="font-size: 1rem"
                        />
                        <font-awesome-icon
                            @click="like(rutas[id], id)"
                            v-else
                            class="down"
                            icon="thumbs-up"
                            style="font-size: 1rem"
                        />
                    </div>
                </div>
                <div class="px-4 pt-3" v-for="(comment, index) in comments" :key="index">
                    <div class="comment">
                        {{comment.descripcion}}
                    </div>
                </div>
                <div class="d-flex flex-column justify-content-center align-items-center p-4">
                    <div class="d-flex justify-content-center inputCommentContainer px-2">
                        <div class="mr-3" style="width:100%">
                            <input 
                                class="inputComment" 
                                type="text" 
                                placeholder="Comenta algo..."
                                v-model="comment"
                                @keyup.enter="sendComment"
                                maxlength="250"/>
                        </div>
                        <div @click="sendComment" class="d-flex align-items-center btn-sendComment" style="transform: rotate(-45deg);">
                            <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-arrow-right-circle-fill" viewBox="0 0 16 16">
                                <path d="M8 0a8 8 0 1 1 0 16A8 8 0 0 1 8 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z"/>
                            </svg>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div style="height:100vh; background:#212121;" class="d-flex justify-content-center align-items-center" v-else>
            <div class="spinner-border text-success" role="status">
                <span class="sr-only">Loading...</span>
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
            cambiado : false,
            comment : "",
            comments : [],
            commentsLoading : false
        }
    },
    methods : {
        sendComment(){
            if(this.comment.length > 0){
                if(this.$cookies.get('token')){
                    console.log('entre')
                    fetch('http://localhost:8081/comentarios', {
                        method: 'POST',
                        body: JSON.stringify({
                            id_ruta: this.rutas[this.id].id_ruta,
                            id_usuario : this.$cookies.get('token'),
                            descripcion : this.comment
                        }),
                        headers : {
                            'Content-Type' : 'application/json'
                        }
                    }).then(() => {
                        fetch(`http://localhost:8081/comentarios?id_ruta=${this.rutas[this.id].id_ruta}`)
                        .then(result => result.json())
                        .then(res => {
                            this.comments = res
                        })
                    })
                    this.comment = ""
                } else {
                    this.$router.push("/login")
                } 
            }
        },
        goTo(id){
            this.comments = [];
            this.commentsLoading = false;
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
        },
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
            showImgs : 'showImgs'
        })
    },
    mounted(){
        if(this.rutas.length === 0){
            this.$store.dispatch('mountRutasAction', { refStorage })
        } else {
            fetch(`http://localhost:8081/comentarios?id_ruta=${this.rutas[this.id].id_ruta}`)
            .then(result => result.json())
            .then(res => {
                this.comments = res
            })
            this.commentsLoading = true;
            this.change()
        }
    },
    updated(){
        this.change()
        if(this.comments.length === 0 && !this.commentsLoading){
            fetch(`http://localhost:8081/comentarios?id_ruta=${this.rutas[this.id].id_ruta}`)
            .then(result => result.json())
            .then(res => {
                this.comments = res
            })
            this.commentsLoading = true;
        }
    },
    beforeDestroy(){
        this.comments = [];
        this.commentsLoading = false;
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
    
    .giveLike:hover {
        transition:450ms;
        background: #3a3a3a;
        cursor:pointer;
    }

    .down {
        transform : rotate(180deg)
    }

    .btn-sendComment {
        color:#37f185;
        cursor:pointer;
        opacity:0.6
    }

    .btn-sendComment:hover {
        color:#00ff6a;
        opacity:1
    }

    /* comments */

    .comment {
        background:#444444;
        border-radius:15px;
        color:#919191;
        padding:.5rem;
        text-align: start;
    }

</style>