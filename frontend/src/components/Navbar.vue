<template>
  <header class="navbar d-flex justify-content-center">
    <img
      src="../assets/logo.png"
      class="elementsHeader logoSaferide"
      alt="navbarlogo"
    />
    <div class="elementsHeader buttons">
      <button class="button iniciarSesion">Ingresa</button>
      <button class="button registrarse">Registrarse</button>
    </div>
    <div class="container contenedorTopSection">
      <div :style="{width:'100%'}">
        <div class="row justify-content-center" style="width:100%; margin: 0px;">
          <div class="col-md-8 col-lg-6 d-flex flex-column align-items-center">
            <h4 class="text-center">Conoce tu ruta favorita</h4>
            <div class="inputBuscarContainer row">
              <div class="col-md-8 mt-4 col-xs-12">
                <input
                  class="inputBuscar"
                  type="text"
                  placeholder="Busca con una ubicación"
                  v-model="searchPlace"
                />
              </div>
              <div class="col-md-4 mt-4 col-xs-12">
                <button class="btnBuscar" @click="search">Buscar</button>
              </div>
            </div>
            <div class="navegation d-flex justify-content-between">
              <button
                class="navegationElement active"
                style="width: 40%; height: 1rem"
              ></button>
              <button
                @click="$router.push('/peatones')"
                class="navegationElement"
                style="width: 40%; height: 1rem"
              ></button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: "Navbar",
  data(){
    return {
      searchPlace : ''
    }
  },
  methods : {
    search(){
      this.$store.dispatch('searchResultAction', this.searchPlace)
      this.$router.push("/results")
    }
  }
};
import "../styles/navbar.css";
</script>

<style scoped>
.navbar {
  width: 100%;
}

.elementsHeader {
  position: absolute;
}

.elementsHeader.logoSaferide {
  left: 20px;
  height: auto;
  top: 10px;
  width: 4rem;
}

.elementsHeader.buttons {
  right: 20px;
  top: 2.3rem;
}

.elementsHeader .button {
  border: none;
  border-radius: 5px;
  color: white;
  margin: 0.2rem 0.2rem;
  padding: 0.3rem 0.55rem;
  width: 8rem;
}

.elementsHeader .button.iniciarSesion {
  background: #37f185;
}

.elementsHeader .button.registrarse {
  background: black;
}

.contenedorTopSection {
  margin-top: 5rem;
  margin-bottom: 4rem;
}

.navegation {
  margin-top: 7rem;
  width: 50%;
}

.navegationElement {
  background-color: #f7e64a;
  border: none;
  width: 100%;
  height: 1rem;
}

.navegationElement.active {
  background-color: #e2cf22;
}

.inputBuscarContainer {
  width: 100%;
}

.inputBuscar {
  background-color: #f3f3f3;
  border: none;
  border-radius: 15px;
  color: #b4b4b4;
  padding: .5rem 2rem;
  width: 100%;
}

.inputBuscar:focus {
  outline: none;
}

.btnBuscar {
  background: #89ffba;
  border: none;
  border-radius: 15px;
  color: white;
  height: 100%;
  padding: .5rem 1.5rem;
  width: 100%;
}

</style>
