<template>
  <div class="contenedorPrincipal justify-content-center align-items-center">
    <form
      class="d-flex flex-column justify-content-center align-items-center"
      @submit.prevent="login"
    >
      <div
        class="contenedorContenidoForm d-flex flex-column justify-content-center align-items-center"
      >
        <img
          src="../assets/textLogoWhite.png"
          alt="logo2 saferide"
          class="logoSaferide"
        />
        <h1 style="width: 100%"><strong>¡Bienvenido! </strong>Inicie Sesión</h1>
        <input
          style="margin-top: 20px"
          class="user"
          type="text"
          placeholder="Usuario o Correo Electronico"
          autocomplete="off"
          v-model="username"
          required
        />
        <br />
        <input
          class="password"
          type="password"
          placeholder="Contraseña"
          autocomplete="off"
          v-model="password"
          required
        />
        <br />
        <div v-if="error" class="error">
          <p style="margin: 0; color: #661e1e">
            Contraseña o correo/usuario inválido
          </p>
        </div>
        <button class="btnInicioSesion mb-4" type="submit">
          Iniciar Sesión
        </button>
        <p>
          ¿No tienes una cuenta?
          <a @click="$router.push('/register')" class="register">Registrate!</a>
        </p>
      </div>
    </form>
  </div>
</template>

<script>
import "../styles/login.css";

export default {
  name: "Login",
  data() {
    return {
      error: false,
      username: "",
      password: "",
    };
  },
  mounted() {
    if (this.$cookies.get("token")) {
      this.$router.push("/");
    }
  },
  methods: {
    login() {
      let obj = {
        id_usuario: "",
        nombre: "",
        usuario: "",
        correo: "",
        contraseña: "",
      };
      if (this.username.includes("@")) {
        obj = {
          ...obj,
          correo: this.username,
          contraseña: this.password,
        };
      } else {
        obj = {
          ...obj,
          usuario: this.username,
          contraseña: this.password,
        };
      }
      fetch("http://localhost:8081/login", {
        method: "POST",
        body: JSON.stringify(obj),
        headers: {
          "Content-Type": "application/json",
        },
      })
        .then((res) => res.json())
        .then((result) => {
          if (result.error === 1) {
            this.error = true;
          } else {
            this.error = false;
            this.$router.push("/");
            this.$cookies.set("token", result.message);
          }
        });
    },
  },
};
</script>

<style scoped>
* {
  color: #ffffff;
  font-family: "Raleway", sans-serif;
}

.contenedorPrincipal {
  height: 100vh !important;
  width: 100vw !important;
}

.contenedorContenidoForm {
  width: 50%;
}

h1 {
  margin-top: 15px;
  padding: 5px;
  text-shadow: 3px 3px 20px black;
}

strong {
  color: #25d66f;
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
  background: #242323;
  text-align: center;
  height: 100%;
  width: 100%;
}

.register {
  text-decoration: none;
}

.register:hover {
  color: #93d973;
}

input {
  display: flex;
  background: rgba(0, 0, 0, 0);
  border-right-style: none;
  border-bottom-color: white;
  width: 70%;
  padding: 0 0 15px;
  margin: 17px 0 17px;
  text-align: center;
  font-size: 15px;
  outline: none;
}

input:hover {
  border-bottom-color: #93d973;
}

input:focus {
  border-bottom-color: #93d973;
}

::placeholder {
  color: #ffffff;
}

.btnInicioSesion {
  background-color: #25d66f;
  border-color: #25d66f;
  border-radius: 7px;
  margin: 10px 0;
  padding: 15px 35px 15px;
  border-style: double;
  font-size: 17px;
  cursor: pointer;
}

.btnInicioSesion:hover {
  border: 1px solid #93d973;
  background: #93d973;
}

.error {
  background-color: #ff8383;
  padding: 1rem;
  border-radius: 7px;
  margin-bottom: 1.5rem;
  border: 1px solid #661e1e;
}
</style>
