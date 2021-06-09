<template>
  <div class="hurto-contenedor">
    <div class="hurto">
      <div class="mb-4">
        <div class="">
          <h3 class="">
            <b>{{ titulo }}</b>
          </h3>
          <h5 class="">{{ modalidad }}</h5>
        </div>
      </div>
      <img :src="imagen" class="img-hurto" alt="imagen de prueba" />
      <div class="space" />
    </div>
  </div>
</template>

<script>
export default {
  name: "HurtoCard",
  props: {
    titulo: String,
    modalidad: String,
    imagen: String,
  },
};
import "../styles/hurtocard.css";
</script>

<style scoped>
.img-hurto {
  border-radius: 10px;
  height: auto;
  width: 100%;
}

.hurto {
  margin: 2rem 0px;
}
</style>
