<template>
    <div class="d-flex align-items-center justify-content-center" style="height:100vh;position:fixed;width:100vw;z-index:2;">
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

import { mapState } from "vuex"

export default {
    name : 'AddMetrica',
    computed : {
        ...mapState({
            addMetrica : 'addMetrica'
        })
    },
    methods : {
        subir(){
            const { id_ruta } = this.addMetrica.ruta
            fetch('http://localhost:8081/metricas/exists', {
                method: 'POST',
                body : JSON.stringify({
                    id_usuario : {
                        id_usuario : this.$cookies.get('token')
                    },
                    id_ruta : {
                        id_ruta
                    }
                }),
                headers : {
                    'Content-Type' : 'application/json'
                }
            })
            .then(res => res.json())
            .then(result => {
                if (!result || result === "false"){
                    fetch('http://localhost:8081/metricas', {
                        method:'POST',
                        body : JSON.stringify({
                            id_usuario : {
                                id_usuario : this.$cookies.get('token')
                            },
                            id_ruta : {
                                id_ruta
                            }
                        }),
                        headers:{
                            "Content-Type" : 'application/json'
                        }
                    })
                    .then(res => res.json())
                    .then(result => {
                        if(result.error === 1){
                            console.log('hubo un error')
                        } else {
                            this.$router.push('/metricas');
                            this.$store.dispatch('changeAddMetricaAction');
                        }
                    })
                } else {
                    this.$router.push('/metricas')
                }
            })
        },
        cerrar(){
            this.$store.dispatch('changeAddMetricaAction')
        }
    },
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
    width:40vw;
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

@media(max-width:750px){
    .addMetricaContainer {
        width:60vw;
        transition:550ms;
    }
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