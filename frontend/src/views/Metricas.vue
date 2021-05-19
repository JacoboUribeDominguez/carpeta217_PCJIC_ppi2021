<template>
  <div>
    <header class="header">
      <div class="m-3 imgContainer">
        <img src="../assets/textLogoWhite.png" class="logo-saferide" alt="logo saferide" />
      </div>
      <div class="m-3 btns">
        <button class="btn iniciar mx-2">Ingresa</button>
        <button class="btn registrar mx-2">Registrate</button>
      </div>
    </header>
    <MetricaCard />
    <MetricaCard />
    <MetricaCard />
  </div>
</template>

<script>
import MetricaCard from "../components/MetricaCard";

export default {
  name: "Metricas",
  components: { MetricaCard }
};
</script>

<style scoped>
.header {
  background: #000000;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.logo-saferide {
  width: 10rem;
  height: auto;
}

.btns {
  display: flex;
}

.iniciar {
  background: #37f185;
  color: white;
}

.iniciar:hover {
  background: #24ca69;
  color: white;
}

.registrar {
  background: #FFFFFF;
  color: black;
}

.registrar:hover {
  background: #d8d8d8;
}


</style>
