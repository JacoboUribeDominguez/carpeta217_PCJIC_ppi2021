<template>
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
        <img
            class="imagenes"
            src="../assets/img800x800.jpg"
            alt="800x800"
        />
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
</template>

<script>

export default {
    name : 'Publicacion'
}
</script>

<style scoped>

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

.iconAdd {
  color:#37f185;
}

.iconAdd:hover {
  cursor:pointer;
  color:rgb(27, 141, 74);
}

</style>