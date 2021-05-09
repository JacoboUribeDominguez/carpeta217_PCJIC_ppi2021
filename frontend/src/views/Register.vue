<template>
  <div class="contenedorPadre">
    <p class="title">Registrate</p>
    <div class="contenedorForm">
      <form class="formulario">
        <input id="username" placeholder="Usuario" autocomplete="off" />
        <input id="name" placeholder="Nombre completo" autocomplete="off" />
        <input
          type="email"
          id="email"
          placeholder="Correo electronico"
          autocomplete="off"
        />
        <input
          type="password"
          id="password"
          placeholder="Contraseña"
          autocomplete="off"
        />
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

<style scoped></style>
