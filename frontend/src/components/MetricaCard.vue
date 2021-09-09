<template>
  <div class="row containerMetrica">
    <div class="d-flex align-items-center justify-content-center" style="background:none;height:100vh;position:absolute;top:0;width:100%;z-index:3;" v-if="msj !== ''">
        <div class="d-flex flex-column align-items-center justify-content-center" style="background:white;border:1px solid #37f185;border-radius:7px;color:#37f185;height:8rem;padding:1.5rem;width:60vw;">
          <div class="mb-2">
            {{msj}}
          </div>
          <div>
            <button @click="msj=''" style="background:#37f185;color:white;border:none;border-radius:15px;padding:.5rem 1.5rem;">
              Cerrar
            </button>
          </div>
        </div>
    </div>
    <div class="col-md-2 col-sm-3 d-flex jusity-content-center align-items-center" style="padding: 0">
      <img
        src="../assets/imgPrueba1.jpg"
        class="imgMetrica"
        alt="ImagenPrueba"
      />
    </div>
    <div class="col-md-10 col-sm-9 d-flex" style="padding: 0 0 0 1.5rem">
      <div class="row" style="width: 100%">
        <div
          class="col-sm-6 col-12 d-flex flex-column justify-content-between containerLeftMetrica"
        >
          <h3 class="mt-3 tituloCard"><strong>{{metrica.ubicacion}}</strong></h3>
          <div class="tiempos d-flex align-items-center mb-4">
            <div class="alert-noTime" v-if="noTime">
              Digita un tiempo
            </div>
            <input
              class="inputMetricaAgregarTiempo"
              type="number"
              v-model="time"
              placeholder="Digita minutos"
            />
            <button 
              @click="sendTime"
              class="ml-2 btnAgregarTiempo"
            >
              Añadir
            </button>
          </div>
        </div>
        <div
          class="col-sm-6 d-flex justify-content-end containerRightMetrica"
          style="padding: 0"
        >
          <div class="mt-4 mb-2 col-12">
            <h4 class="elementsRight">{{metrica.usuario}}</h4>
            <h5 class="elementsRight">{{metrica.me_gusta}} Likes</h5>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MetricaCard",
  props : {
    metrica : Object,
  },
  data(){
    return {
      time : null,
      msj : '',
      noTime : false
    }
  },
  methods : {
    sendTime(){
      if(this.time > 0){
        fetch('http://localhost:8081/times', {
          method : 'POST',
          body : JSON.stringify({
            id_metrica : this.metrica.id_metrica,
            tiempo : this.time,
          }),
          headers : {
            'Content-Type' : 'application/json'
          }
        })
        .then(res => res.json())
        .then(result => {
          if(result.error === 0){
            if(result.message === "Mayor"){
              this.msj = "¡Felicitaciones! Lo has hecho mejor que tu promedio"
            } else if(result.message === "Menor") {
              this.msj = "Lo lamento, te ha ido peor que en tu promedio"
            } else {
              this.msj = "Es tu primer tiempo agregado 😊"
            }
          }
        })
      } else {
        this.noTime = true;
        setTimeout(() => {
          this.noTime = false;
        },3000)
      }
    },
  },
};
import "../styles/metricard.css";
</script>

<style scoped>

.msjContainer {

}

input[type=number]::-webkit-inner-spin-button, 
input[type=number]::-webkit-outer-spin-button { 
  -webkit-appearance: none; 
  margin: 0; 
}

input[type=number] { -moz-appearance:textfield; }

.containerMetrica {
  max-width: 100vw;
  margin: 0;
  border-bottom: 1px solid rgb(194, 194, 194);
}

.imgMetrica {
  height: auto;
  width: 100%;
}

.inputMetricaAgregarTiempo {
  border: 1px solid rgb(206, 206, 206);
  border-radius: 15px;
  color: rgb(168, 168, 168);
  height: 100%;
  padding: 0.5rem;
  width: 8rem;
}

.inputMetricaAgregarTiempo:focus {
  border: 1px solid #37f185;
  outline: none;
}

.elementsRight {
  text-align: end;
}

.btnAgregarTiempo {
  background: #37f185;
  border: none;
  border-radius: 15px;
  color: white;
  height: 100%;
  padding: 0.5rem;
  width: 10rem;
}

.tituloCard {
  text-align: left;
}

.alert-noTime {
  background: red;
  border-radius:15px;
  color:white;
  padding:.5rem 1rem;
  position:absolute;
}

</style>
