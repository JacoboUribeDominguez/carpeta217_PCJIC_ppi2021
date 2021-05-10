<template>
  <div class="Login row justify-content-center">
    <div class="col-md-6 col-sm-11">
      <h1>Inicia sesión</h1>
      <form class="mr-3 ml-3">
        <input class="sesion" type="text" placeholder="Usuario o Correo">
        <br>
        <input type="password" placeholder="Contraseña">
        <br>
        <button type="submit">Iniciar sesión</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login"
};
</script>

<style scoped>
  *{
    color:white;
    font-family: Avenir, Helvetica, Arial, sans-serif;
  }
  h1{
    background-color: #4ac8f7;
    padding: 13px 0px 13px;
    border-radius: 15px;
    margin: 22px 4vw;
  }
  form{
    background: #4ac8f7;
    border-radius: 35px;
    text-align: center;
    margin:auto;
  }
  .sesion{
    margin-top: 95px;
  }
  input{
    background: #4ac8f7;
    border-top-style: none;
    border-left-style: none ;
    border-right-style: none;
    border-bottom-color: white;
    border-bottom-left-radius: 7px;
    border-bottom-right-radius: 7px;
    border-color: white;
    width: 90%;
    padding: 0px 0px 15px;
    margin: 20px 0px 20px;
    text-align: center;
    font-size: 15px;
    outline: none;
  }
  ::placeholder {
    color: white;
  }
  button{
    background-color: #4ac8f7;
    border-color: white;
    border-radius: 7px;
    margin: 30px 0px 95px;
    padding: 15px 35px 15px 35px;
    border-style: double;
    font-size: 15px;
    cursor: pointer;
  }
  button:active{
    background-color: #5CFFB2;
  }
  button:focus{
    background-color: #5CFFB2;
  }
  button:hover{
    background-color: #5CFFB2;
  }
</style>