<template>
  <div>
    <header class="header">
      <div class="m-3 imgContainer">
        <img src="../assets/textLogoWhite.png" @click="$router.push('/')" class="logo-saferide" alt="logo saferide" />
      </div>
      <div class="m-3 btns" v-if="!$cookies.get('token')">
        <button class="btn iniciar mx-2">Ingresa</button>
        <button class="btn registrar mx-2">Registrate</button>
      </div>
      <div class="m-3 btns" v-else>
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
    </header>
    <div class="mt-4" v-if="!metricas">
      <h3>Hubo algun problema, intentalo más tarde</h3>
      <a href="/" class="stretched-link">Click para volver</a>
    </div>
    <div v-else-if="metricas.length > 0">
      <MetricaCard v-for="(metrica, index) in metricas" :key="index" :metrica="metrica"/>
    </div>
    <div v-else>
      <h1>No hay métricas disponibles :(</h1>
    </div>
  </div>
</template>

<script>
import MetricaCard from "../components/MetricaCard";
import { mapState } from 'vuex'

export default {
  name: "Metricas",
  components: { MetricaCard },
  data(){
    return {
      showAccount : false
    }
  },
  computed : {
    ...mapState({
      metricas : 'metricas'
    })
  },
  mounted(){
    const token = this.$cookies.get('token');
    if(!token){
      this.$router.push('/Login')
    } else {
      this.$store.dispatch('mountMetricasAction', token)
    }
    document.addEventListener('mousedown', this.handleClickOutside)
  },
  methods : {
    logout(){
      this.$cookies.remove('token')
      this.showAccount = false;
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

.logo-saferide:hover {
  cursor:pointer;
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

.btn-account {
  background: none;
  border:none;
  color: white;
  height: 100%;
  width: 100%;
}

.btn-account:hover {
  color:#d6d6d6;
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

.elementsHeader.buttons.logged.menu {
  position: absolute;
  right: 20px;
  top: 4.5rem;
  z-index:4;
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

@media(max-width:425px){
  .elementsHeader.buttons.logged.menu {
    top: 7.2rem;
  }
}
</style>
