<template>
    <div class="d-flex align-items-center" style="position:fixed;width:100vw;z-index:2;">
        <div class="addMetricaContainer">
            <div class="title-warning">
                ¿Estas seguro que deseas agregar esta ruta a tus metricas?
            </div>
            <div class="mt-4 row justify-content-center">
                <div class="col-md-6">
                    <button @click="subir" class="button">
                        sí
                    </button>
                    <button @click="cerrar" class="button">
                        no
                    </button>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    name : 'AddMetrica',
    methods : {
        subir(){
            console.log('subiendo')
        },
        cerrar(){
            this.$store.dispatch('changeAddMetricaAction')
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Raleway:wght@100&display=swap');
.addMetricaContainer {
    background:rgb(161, 240, 161);
    border: 1px solid rgb(74, 163, 74);
    border-radius:7px;
    color:white;
    margin:5vh 5vw;
    padding:2rem;
    position:fixed;
    width:90vw;
}

.title-warning {
    background:rgb(23, 116, 23);
    border-bottom-left-radius: 15px;
    border-bottom-right-radius: 15px;
    font-family: 'Raleway', sans-serif;
    padding:1rem;
    width:100%;
}

/* **************** BUTONS **************** */
.button {
    background:none;
    border:1px solid white;
    border-radius:15px;
    color:white;
    margin-left:2%;
    margin-right:2%;
    padding:.5rem 1rem;
    width:46%;
}

.button:hover {
    border:white;
    background: white;
    color: rgb(74, 163, 74);
}

@media(max-width:480px){
    .addMetricaContainer {
        border-radius: 0%;
        margin:0;
        transition:550ms;
        width:100vw;
    }
}
</style>