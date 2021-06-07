<template>
  <div>
    <header class="header">
      <div class="m-3 imgContainer">
        <img
            src="../assets/textLogoWhite.png"
            @click="() => this.$router.push('/peatones')"
            class="logo-saferide"
            alt="logo saferide"/>
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
    <div class="row containerSidebar" style="position: absolute; width:100%">
      <div class="col-md-4 col-sm-6 mt-4">
        <div class="d-flex justify-content-end mt-3">
          <div style="width:85%">
            <button class="btn-hurtos btn-reportar d-flex align-items-center optionSelected">
              <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-house" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
              </svg>
              <h4 class="ml-3">Hurtos</h4>
            </button>
            <button class="btn-hurtos btn-reportar d-flex align-items-center ">
              <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-capslock-fill" viewBox="0 0 16 16">
                <path d="M7.27 1.047a1 1 0 0 1 1.46 0l6.345 6.77c.6.638.146 1.683-.73 1.683H11.5v1a1 1 0 0 1-1 1h-5a1 1 0 0 1-1-1v-1H1.654C.78 9.5.326 8.455.924 7.816L7.27 1.047zM4.5 13.5a1 1 0 0 1 1-1h5a1 1 0 0 1 1 1v1a1 1 0 0 1-1 1h-5a1 1 0 0 1-1-1v-1z"/>
              </svg>
              <h4 class="ml-3">Reporta</h4>
            </button>
            <div class="space ml-3" style="width:67%"/>
            <div class="ml-3 mt-5 text-justify" style="color: #adadad; width:65%">
              Unete y construyamos juntos una ciudad mucho más segura para todos.
            </div>
            <div class="d-flex justify-content-start">
              <button class="ml-3 mt-4 btnUnirmeLeftbar">Unirme</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="row justify-content-center " style="margin:0;width:100vw;">
      <div class="col-md-4 col-sm-8" style="padding:0; width:100vw;">
        <div class="hurto-contenedor">
          <div class="hurto">
            <div class="mb-4">
              <div class="">
                <h3 class="">
                  <b>Poblado - Patio Bonito</b>
                </h3>
                <h5 class="">
                  Robo con arma blanca
                </h5>
              </div>
            </div>
            <img src="../assets/imgPrueba1.jpg" class="img-hurto" alt="imagen de prueba"/>
            <div class="space"/>
          </div>
        </div>
        <div class="hurto-contenedor">
          <div class="hurto">
            <div class="mb-4">
              <div class="">
                <h3>
                  <b>Belen Rincon</b>
                </h3>
                <h5>
                  Amenaza
                </h5>
              </div>
            </div>
            <img src="../assets/imgPrueba1.jpg" class="img-hurto" alt="imagen de prueba"/>
            <div class="space"/>
          </div>
        </div>
        <div class="hurto-contenedor">
          <div class="hurto">
            <div class="mb-4">
              <div class="">
                <h3 class="">
                  <b>Parque Botero</b>
                </h3>
                <h5 class="">
                  Engaño
                </h5>
              </div>
            </div>
            <img src="../assets/imgPrueba1.jpg" class="img-hurto" alt="imagen de prueba"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

//css
import "../styles/hurtos.css"

export default {
  name: "Hurtos",
  data(){
    return {
      showAccount : false
    }
  },
  mounted(){
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
}
</script>

<style scoped>
  .header {
    display:flex;
    background-color: #111111;
    justify-content: space-between;
    align-items: center;
  }

  .logo-saferide {
    width:10rem;
    height:auto;
  }

  .logo-saferide:hover {
    cursor:pointer;
  }

  .btns {
    display:flex;
  }

  .iniciar {
    background: #37f185;
    color:white;
  }

  .iniciar:hover {
    background: #24ca69;
    color:white;
  }

  .registrar {
    background: #ffffff;
    color:rgb(0, 0, 0);
  }

  .registrar:hover {
    background: #d8d8d8;
  }

  .img-hurto {
    border-radius:10px;
    height:auto;
    width:100%;
  }

  .hurto {
    margin: 2rem 0px;
  }

  .space {
    border-bottom:1px solid rgb(194, 194, 194);
    margin:3rem 0px;
  }

  .btn-hurtos {
    width:70%;
  }

  .btn-reportar {
    background: none;
    border: none;
    border-radius:8px;
    padding:1rem 1rem;
  }

  .btn-reportar h4 {
    margin: 0;
  }

  .btn-reportar:hover {
    background: #f5f5f5;
  }

  .optionSelected {
    color:#24ca69;
  }

  .btnUnirmeLeftbar {
    background: #37f185;
    border:none;
    border-radius:10px;
    color:white;
    padding:.5rem;
    width:67%;
  }

  .btnUnirmeLeftbar:hover {
    background: #25d66f;
    color:rgb(238, 238, 238);
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