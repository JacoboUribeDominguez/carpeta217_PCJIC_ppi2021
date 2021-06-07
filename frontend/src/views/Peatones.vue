<template>
  <div class="peatonesContainer">
    <header class="header">
      <div class="m-3 imgContainer">
        <img
          src="../assets/textLogo.png"
          class="logo-saferide"
          alt="logo saferide"
        />
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
    <div id="Peatones">
      <div class="">
        <div
          class="row justify-content-center"
          style="width: 100%; margin: 0px"
        >
          <div class="col-md-6 col-sm-8" style="padding: 0">
            <div class="botones d-flex justify-content-between">
              <button
                @click="$router.push('/')"
                class="btnNavegacion btnNavegacion1"
              ></button>
              <button class="btnNavegacion btnNavegacion2"></button>
            </div>
            <div>
              <h1>Reporta y ayuda</h1>
            </div>
            <div class="publicaciones">
              <div class="publicacionDestacada">
                <p class="autor d-flex align-items-center">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="25"
                    height="25"
                    fill="currentColor"
                    class="bi bi-person-circle mr-2"
                    viewBox="0 0 16 16"
                  >
                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                    <path
                      fill-rule="evenodd"
                      d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"
                    />
                  </svg>
                  Autor
                </p>
                <p class="descripcion">Descripción</p>
                <img class="imagenes" src="../assets/img800x800.jpg" />
                <p class="descripcionMeGusta">Cantidad de me gustas</p>
                <div class="ml-2 d-flex">
                  <button class="meGusta">
                    <font-awesome-icon
                      icon="thumbs-up"
                      style="font-size: 1.5rem"
                    />
                  </button>
                </div>
              </div>
              <div class="publicacionDestacada">
                <p class="autor d-flex align-items-center">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="25"
                    height="25"
                    fill="currentColor"
                    class="bi bi-person-circle mr-2"
                    viewBox="0 0 16 16"
                  >
                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                    <path
                      fill-rule="evenodd"
                      d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"
                    />
                  </svg>
                  Autor
                </p>
                <p class="descripcion">Descripción</p>
                <img class="imagenes" src="../assets/img800x800.jpg" />
                <p class="descripcionMeGusta">Cantidad de me gustas</p>
                <div class="ml-2 d-flex">
                  <button class="meGusta">
                    <font-awesome-icon
                      icon="thumbs-up"
                      style="font-size: 1.5rem"
                    />
                  </button>
                </div>
              </div>
              <div class="publicacionDestacada">
                <p class="autor d-flex align-items-center">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="25"
                    height="25"
                    fill="currentColor"
                    class="bi bi-person-circle mr-2"
                    viewBox="0 0 16 16"
                  >
                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                    <path
                      fill-rule="evenodd"
                      d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"
                    />
                  </svg>
                  Autor
                </p>
                <p class="descripcion">Descripción</p>
                <img class="imagenes" src="../assets/img800x800.jpg" />
                <p class="descripcionMeGusta">Cantidad de me gustas</p>
                <div class="ml-2 d-flex">
                  <button class="meGusta">
                    <font-awesome-icon
                      icon="thumbs-up"
                      style="font-size: 1.5rem"
                    />
                  </button>
                </div>
              </div>
              <div class="publicacion">
                <p class="autor d-flex align-items-center">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="25"
                    height="25"
                    fill="currentColor"
                    class="bi bi-person-circle mr-2"
                    viewBox="0 0 16 16"
                  >
                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                    <path
                      fill-rule="evenodd"
                      d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"
                    />
                  </svg>
                  Autor
                </p>
                <p class="descripcion">Descripción</p>
                <img class="imagenes" src="../assets/img800x800.jpg" />
                <p class="descripcionMeGusta">Cantidad de me gustas</p>
                <div class="ml-2 d-flex">
                  <button class="meGusta">
                    <font-awesome-icon
                      icon="thumbs-up"
                      style="font-size: 1.5rem"
                    />
                  </button>
                </div>
              </div>
              <div class="publicacion">
                <p class="autor d-flex align-items-center">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="25"
                    height="25"
                    fill="currentColor"
                    class="bi bi-person-circle mr-2"
                    viewBox="0 0 16 16"
                  >
                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                    <path
                      fill-rule="evenodd"
                      d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"
                    />
                  </svg>
                  Autor
                </p>
                <p class="descripcion">Descripción</p>
                <img class="imagenes" src="../assets/img800x800.jpg" />
                <p class="descripcionMeGusta">Cantidad de me gustas</p>
                <div class="ml-2 d-flex">
                  <button class="meGusta">
                    <font-awesome-icon
                      icon="thumbs-up"
                      style="font-size: 1.5rem"
                    />
                  </button>
                </div>
              </div>
              <div class="publicacion">
                <p class="autor d-flex align-items-center">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="25"
                    height="25"
                    fill="currentColor"
                    class="bi bi-person-circle mr-2"
                    viewBox="0 0 16 16"
                  >
                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                    <path
                      fill-rule="evenodd"
                      d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"
                    />
                  </svg>
                  Autor
                </p>
                <p class="descripcion">Descripción</p>
                <img class="imagenes" src="../assets/img800x800.jpg" />
                <p class="descripcionMeGusta">Cantidad de me gustas</p>
                <div class="ml-2 d-flex">
                  <button class="meGusta">
                    <font-awesome-icon
                      icon="thumbs-up"
                      style="font-size: 1.5rem"
                    />
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import "../styles/Peatones.css";

export default {
  name: "Peatones",
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
};
</script>

<style scoped>
.header {
  background: white;
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

.registrar {
  background: #111111;
  color: white;
}

#Peatones {
  background-color: #212121;
}

h1 {
  color: white;
  margin: 60px 0px 0px;
}

img {
  width: 100%;
  height: auto;
}

.publicacion {
  background: #312e2e;
  border-radius: 10px;
  margin: 1rem 0px;
}

.publicacionDestacada {
  background-color: #312e2e;
  box-shadow: 0px 0px 25px 1px rgb(253, 194, 0);
  margin: 4rem 0px;
}

.autor {
  text-align: start;
  padding: 10px 10px 0px;
  color: white;
}

.descripcion {
  text-align: start;
  color: white;
  padding: 0px 10px 0px;
}

.meGusta {
  background: dodgerblue;
  border-color: dodgerblue;
  color: white;
  border-radius: 10px;
  padding: 0.5rem 0.5rem;
  width: 20%;
  margin-bottom: 1rem;
}

.descripcionMeGusta {
  padding: 10px 10px 10px;
  margin: 0px 0px;
  text-align: start;
  color: white;
}

.btnNavegacion1 {
  background-color: #ad9f1c;
  border: none;
  width: 43%;
  height: 1.5rem;
}

.btnNavegacion2 {
  background-color: #fff279;
  border: none;
  width: 43%;
  height: 1.5rem;
}
.botones {
  margin-top: 50px;
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
