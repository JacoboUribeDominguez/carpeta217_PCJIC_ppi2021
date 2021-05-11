<template>
  <div>
    <header class="header">
      <div class="m-3 imgContainer">
        <img src="../assets/textLogoWhite.png" class="logo-saferide" alt="logo saferide"/>
      </div>
      <div class="m-3 btns">
        <button class="btn iniciar mx-2">Ingresa</button>
        <button class="btn registrar mx-2">Registrate</button>
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
    <div class="row justify-content-center ">
      <div class="col-md-4 col-sm-8">
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
  name: "Hurtos"
}
</script>

<style scoped>

</style>