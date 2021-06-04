<template>
  <div class="login row justify-content-center align-items-center">
    <div class="col-md-6 col-sm-6">
      <form
        class="mr-3 ml-3 d-flex flex-column justify-content-center align-items-center"
      >
        <img
          src="../assets/textLogoWhite.png"
          alt="logo2 saferide"
          class="logoSaferide"
        />
        <h1 style="width: 100%">¡Bienvenido! Inicie Sesión</h1>
        <input
          style="margin-top: 20px"
          class="user"
          type="text"
          placeholder="Nombre usuario"
          v-on:keyup="typing"
          autocomplete="off"
          required
        />
        <br />
        <input
          class="password"
          type="password"
          placeholder="Contraseña"
          v-on:keyup="typing"
          autocomplete="off"
          required
        />
        <br />
        <button class="btnInicioSesion ml-4" type="submit">
          Iniciar Sesión
        </button>
        <p>¿No tienes una cuenta? <a class="register">Registrate!</a></p>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {};
  },
  methods: {
    typing(event) {
      console.log(event.target.value);
    },
  },
};
</script>

<style scoped>
* {
  color: #ffffff;
  font-family: "Raleway", sans-serif;
}

.login {
  height: 98vh !important;
}

h1 {
  margin-top: 15px;
  background: #25d66f;
  padding: 5px;
  text-shadow: 3px 3px 20px black;
}

h4 {
  color: black;
  margin-top: 25px;
  margin-right: 15px;
  margin-left: 15px;
}

.logoSaferide {
  width: 15rem;
  height: auto;
  padding-top: 10px;
}

form {
  margin: 30px;
  background: #242323;
  border-radius: 25px;
  text-align: center;
  height: 50vh !important;
}

.register {
  text-decoration: none;
}

.register:hover {
  color: #93d973;
}

input {
  background: rgba(0, 0, 0, 0);
  border-right-style: none;
  border-bottom-color: white;
  width: 85%;
  padding: 0 0 15px;
  margin: 17px 0 17px;
  text-align: center;
  font-size: 15px;
  outline: none;
}

::placeholder {
  color: #ffffff;
}

.btnInicioSesion {
  background-color: #25d66f;
  border-color: #25d66f;
  border-radius: 7px;
  margin: 10px 0 15px;
  padding: 15px 35px 15px;
  border-style: double;
  font-size: 17px;
  cursor: pointer;
}

.btnInicioSesion:hover {
  border: 1px solid #93d973;
  background: #93d973;
}
</style>
