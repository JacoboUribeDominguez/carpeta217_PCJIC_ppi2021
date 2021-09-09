<template>
  <header class="navbar d-flex justify-content-center">
    <img
      src="../assets/logo.png"
      class="elementsHeader logoSaferide"
      alt="navbarlogo"
    />
    <div class="elementsHeader buttons" v-if="!$cookies.get('token')">
      <button @click="$router.push('/Login')" class="button iniciarSesion">Ingresa</button>
      <button @click="$router.push('/register')" class="button registrarse">Registrarse</button>
    </div>
    <div class="elementsHeader buttons logged" v-else>
      <button id="btnShowAccount" @click="showAccount = !showAccount" class="btn-account">
        <svg id="iconShowAccount" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
          <path id="iconShowAccount2" d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
          <path id="iconShowAccount3" fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
        </svg>
      </button>
    </div>
    <div ref="outside" class="elementsHeader buttons logged menu" v-if="showAccount">
      <div class="menuAccount" >
        <button @click="showAccount = false; $router.push('/metricas')" class="botonesMenuAccount d-flex align-items-center">
          <div class="p-2" style="border:1px solid white;border-radius:50%;">
            <svg style="color:white;" xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
              <path d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z"/>
            </svg>
          </div>
          <div>
            <h5 class="ml-2" style="color:white;margin:0">Metricas</h5>
          </div>
        </button>
        <button @click="logout" class="botonesMenuAccount d-flex align-items-center">
          <div >
            <svg style="color:white;" xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-x-circle-fill" viewBox="0 0 16 16">
              <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
            </svg>
          </div>
          <div>
            <h5 class="ml-2" style="color:white;margin:0">Cerrar sesión</h5>
          </div>
        </button>
      </div>
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
      searchPlace : '',
      showAccount : false
    }
  },
  mounted(){
    document.addEventListener('mousedown', this.handleClickOutside)
  },
  methods : {
    goToMetricas(){
      this.showAccount = false; 
      if(this.$cookies.get('token')){
        this.$router.push('/metricas');
      } else {
        this.$router.push('/Login');
      }
    },
    search(){
      this.$store.dispatch('searchResultAction', this.searchPlace)
      this.$router.push("/results")
    },
    logout(){
      this.$cookies.remove('token')
      this.showAccount = false;
      this.$router.push('/Login')
    },
    handleClickOutside(event){
      if(this.showAccount && this.$refs.outside){
        if (!this.$refs.outside.contains(event.target)) {
          if(event.target.id){
            if(!event.target.id.includes('ShowAccount')){
              this.showAccount = false;
            }
          } else {
            this.showAccount = false;
          }
        }
      }
    }
  }
};
import "../styles/navbar.css";
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Overpass:wght@100&display=swap');

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

.elementsHeader.buttons.logged.menu {
  top: 4.5rem;
  z-index:4;
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

.btn-account {
  background: none;
  border:none;
  color: #383838;
  height: 100%;
  width: 100%;
}

.btn-account:hover {
  color:#616161;
}

.menuAccount {
  background:rgb(83, 83, 83);
  border-radius:4px;
  padding:.25rem;
  width:25vw;
}

.botonesMenuAccount {
  background:none;
  border:none;
  border-radius:15px;
  font-family: 'Overpass', sans-serif;
  padding:.5rem;
  width:100%;
}

.botonesMenuAccount:hover {
  background: #7e7e7e;
}

@media (max-width:965px){
  .menuAccount {
    width:35vw;
  }
}

@media (max-width:650px){
  .menuAccount {
    width:50vw;
  }
}

@media (max-width:430px){
  .menuAccount {
    width:85vw;
  }
}

</style>
