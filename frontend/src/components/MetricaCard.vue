<template>
  <div class="row containerMetrica">
    <div class="d-flex align-items-center justify-content-center" style="background:none;height:100vh;position:absolute;top:0;width:100%;z-index:3;">
        <div style="background:green;padding:1.5rem;">
          joas
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
      time : 10,
    }
  },
  methods : {
    sendTime(){
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
          if(result.msj === "Mayor"){
            console.log("Esta por encima del promedio")
          } else if(result.msj === "Menor") {
            console.log("Esta por debajo del promedio")
          } else {
            console.log("Es el primer tiempo que se agrega")
          }
          console.log('No hay error')
        }
      })
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

</style>
