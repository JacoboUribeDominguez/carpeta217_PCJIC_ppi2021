<template>
  <div class="row containerMetrica">
    <div class="col-md-2 col-sm-3" style="padding: 0">
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
          <h3 class="mt-3 tituloCard"><strong>Poblado</strong></h3>
          <div class="tiempos d-flex align-items-center mb-4">
            <input
              class="inputMetricaAgregarTiempo"
              placeholder="Agrega un tiempo"
            />
            <button class="ml-2 btnAgregarTiempo">Enviar</button>
          </div>
        </div>
        <div
          class="col-sm-6 d-flex justify-content-end containerRightMetrica"
          style="padding: 0"
        >
          <div class="mt-4 mb-2 col-12">
            <h4 class="elementsRight">Jacobo Uribe Domínguez</h4>
            <h5 class="elementsRight">50 Likes</h5>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MetricaCard"
};
import "../styles/metricard.css";
</script>

<style scoped>
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
  width: 10rem;
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
  width: 5rem;
}

.tituloCard {
  text-align: left;
}
</style>
