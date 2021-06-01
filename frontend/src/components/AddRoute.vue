<template>
    <div id="addRoute" class="py-5">
        <div class="row justify-content-center" style="height:100%;">
            <div class="AddRouteContainer col-xl-5 col-md-6 col-sm-8 col-11">
                <div class="headerAddRouteContainer d-flex justify-content-between align-items-center">
                    <h4 class="d-flex align-items-center ml-3 my-3" style="margin:0;color:white;">Publicar ruta</h4>
                    <svg style="color:white" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-x-circle-fill my-2 mr-3" viewBox="0 0 16 16">
                        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                    </svg>
                </div>
                <div class="bodyAddRoute">
                    <div class="d-flex justify-content-center">
                        <input type="text" class="input-ubicacion" placeholder="Ubicación destino"/>
                        <p class="mx-3 d-flex align-items-center" style="margin:0;color:white;font-weight:bold;">-</p>
                        <input type="text" class="input-ubicacion" placeholder="Ubicación final"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        name : 'AddRoute'
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

    @media (max-width: 575px){
        #addRoute {
            display:none;
        }
    }
</style>