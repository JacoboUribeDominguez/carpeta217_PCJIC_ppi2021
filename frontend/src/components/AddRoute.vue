<template>
    <div id="addRoute" class="py-5">
        <div class="row justify-content-center" style="height:100%;">
            <div class="AddRouteContainer col-xl-5 col-md-6 col-sm-8 col-11">
                <div class="headerAddRouteContainer d-flex justify-content-between align-items-center">
                    <h4 class="d-flex align-items-center ml-3 my-3" style="margin:0;color:white;">Publicar ruta</h4>
                    <svg @click="close" style="color:white" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-x-circle-fill my-2 mr-3 btnClose" viewBox="0 0 16 16">
                        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                    </svg>
                </div>
                <div class="bodyAddRoute" style="overflow:auto;height:63vh">
                    <div class="d-flex justify-content-center">
                        <input type="text" class="input-ubicacion" v-model="firstUbication" placeholder="Ubicación inicial"/>
                        <p class="mx-3 d-flex align-items-center" style="margin:0;color:white;font-weight:bold;">-</p>
                        <input type="text" class="input-ubicacion" v-model="lastUbication" placeholder="Ubicación final"/>
                    </div>
                    <div class="my-4 d-flex flex-column align-items-center">
                        <input ref="addImage" id="addImagen" style="visibility:hidden; position:absolute" type="file" accept="image/*" @change="onChange"/>
                        <!-- <div v-if="img !== null" style="height:400px;margin:0;">
                            <imagen 
                                v-model="myCroppa" 
                                :width="400" 
                                :height="400" 
                                placeholder=""
                                :quality="1"
                                :zoom-speed="8"
                                :disable-click-to-choose="true"
                                :disable-rotation="true"
                                :prevent-white-space="true"
                                remove-button-color="green"
                                :remove-button-size="45"
                                :show-loading="true"
                                :replace-drop="true"
                                :auto-sizing="true"
                                :show-remove-button="false"
                                :video-enabled="true"
                                :initial-image="img"
                                :placeholder-font-size="30" >
                                <img @click="onClick" slot="placeholder" :src="img" />
                            </imagen>
                        </div> -->
                        <img v-if="img === null" src="../assets/sube_una_foto.jpg" style="width:auto;height:38vh;" @click="onClick" />
                        <div v-else class="d-flex justify-content-center align-items-center" style="width:38vh;height:38vh;overflow:hidden;background:black;margin:0;">
                            <div class="d-flex justify-content-end" style="position:absolute;width:38vh;height:38vh">
                                <button @click="$store.dispatch('changeImgAction')" class="btnRemove" style="position:absolute;z-index:4">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
                                        <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
                                    </svg>
                                </button>
                            </div>
                            <div class="d-flex justify-content-end align-items-end" style="position:absolute;width:38vh;height:38vh">
                                <button class="btnRemove" style="position:absolute;">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-pen-fill" viewBox="0 0 16 16">
                                        <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001z"/>
                                    </svg>
                                </button>
                            </div>
                            <img :src="img" style="width:100%;height:auto;"/>
                        </div>
                        <div class="my-4 d-flex justify-content-start" style="width:100%;">
                            <button @click="uploadImg" class="btnUpload">
                                Subir ruta
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>

    import { mapState } from 'vuex'
    //librerias
    import { storage } from '../utils/firebase'
    const refStorage = storage.ref()

    export default {
        name : 'AddRoute',
        data(){
            return {
                myCroppa : null,
                firstUbication : '',
                lastUbication : ''
            }
        },
        methods : {
            onChange(e){
                const files = e.target.files || e.dataTransfer.files;
                if (!files.length)
                    return;
                this.$store.dispatch('changeImgAction', files[0])
            },
            onClick(){
                this.$refs.addImage.click()
            },
            alternateShowAddRoute(){
                this.$emit('alternateShowAddRoute')
            },
            uploadImg(){
                let ubication = this.firstUbication + ' - ' + this.lastUbication;
                this.$store.dispatch('uploadImgAction', { 
                    id : this.$cookies.get('token'),
                    ubication
                })
                this.close()
            },
            close(){
                if(this.showImgs){
                    this.$store.dispatch('changeShowImgsAction')
                }
                if(this.$cookies.get('token')){
                    this.$store.dispatch('mountRutasAction', { refStorage, id : this.$cookies.get('token')})
                } else {
                    this.$store.dispatch('mountRutasAction', { refStorage, id : "notoken"})
                }
                this.firstUbication = ""
                this.lastUbication = ""
                this.$store.dispatch('changeImgAction')
                this.$emit('alternateShowAddRoute')
            }
        },
        computed : {
            ...mapState({
                img : 'img',
                showImgs : 'showImgs',
            })
        }
    }
</script>
<style scoped>

    #addRoute {
        height:100vh;
        position:fixed;
        width:100%;
        z-index:3;
    }
    .AddRouteContainer {
        background: #212121;
        border:1px solid #3f3f3f;
        border-radius:5px;
        height:100%;
        overflow:hidden;
        padding:0 !important;
    }
    .headerAddRouteContainer {
        border:1px solid #3f3f3f;
        width:100%;
    }
    .bodyAddRoute {
        margin:5%;
        width:90%;
    }
    .btnClose:hover {
        cursor:pointer;
    }
    .input-ubicacion {
        background: none;
        border:none;
        border-bottom:1px solid white;
        color:white;
        padding:.25rem 0;
        width:40%;
    }
    .input-ubicacion:focus {
        outline:none;
    }

    .btnUpload {
        background: #37f185;
        border:none;
        border-radius:15px;
        color:white;
        padding:.5rem 1rem;
        width:100%;
    }

    .btnRemove {
        background: #3f3f3f;
        border:none;
        border-radius: 50%;
        color:white;
        margin:.5rem;
        padding:.5rem;
    }

    @media (max-width: 575px){
        #addRoute {
            display:none;
        }
    }
</style>