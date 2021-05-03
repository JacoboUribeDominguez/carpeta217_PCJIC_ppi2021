<template>
  <div class="contenedorPadre">
    <p class="title">Registrate</p>
    <div class="contenedorForm">
      <form class="formulario">
        <p>Usuario:</p>
        <input id="username" placeholder="Digite su usuario" autocomplete="off">
        <p>Nombre:</p>
        <input id="name" placeholder="Digite su nombre" autocomplete="off">
        <p>Correo:</p>
        <input type="email" id="email" placeholder="Digite su correo electronico" autocomplete="off">
        <p>Contraseña:</p>
        <input type="password" id="password" placeholder="Digite su contraseña" autocomplete="off">
      </form>
    </div>
  </div>
</template>

<script>

import "../styles/register.css";

export default {
  name: "Register"
};
</script>

<style scoped>

</style>