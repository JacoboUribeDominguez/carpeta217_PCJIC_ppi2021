<template>
  <div class="Login row justify-content-center" >
    <div class="col-md-4 col-sm-6">
      <img src="../assets/logo.png" alt="logo1 saferide" class="logoppal" @click="goToLogin">
      <h4>
        <span class="bienvenidos">¡Bienvenidos a SafeRide!</span> <br><br>
        Aquí te puedes registrar para ayudar a mantener la seguridad
        vial en las calles y así formar parte de los buenos ciudadanos de Medellín.
      </h4>
    </div>
    <div class="col-md-6 col-sm-6">
      <form class="mr-3 ml-3">
        <img src="/img/textLogoWhite.8b2a4daa.png" alt="logo2 saferide" class="logosfrd">
        <h1>¡Registrate!</h1>
        <input class="name" type="text" placeholder="Nombre" v-on:keyup="typing" autocomplete="off" required>
        <br>
        <input class="user" type="text" placeholder="Nombre usuario" v-on:keyup="typing" autocomplete="off" required>
        <br>
        <input class="email" type="email" placeholder="Correo electrónico" v-on:keyup="typing" autocomplete="off" required>
        <br>
        <input class="password" type="password" placeholder="Contraseña" v-on:keyup="typing" autocomplete="off" required>
        <br>
        <button type="submit">Registrarse</button>
      </form>
    </div>
  </div>
</template>

<script>
import "../styles/register.css";

export default {
  name: "Register",
  methods: {
    goToLogin(){
      this.$router.push('Login')
    }
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap');
*{
  color:#FFFFFF;
  font-family: 'Raleway', sans-serif;
}
header{
  background: black;
}
h1{
  margin-top: 15px;
  background: #25d66f;
  padding: 5px;
  text-shadow: 3px 3px 20px black;
}
h4{
  color: black;
  margin-top: 25px;
  margin-right: 15px;
  margin-left: 15px;
  font-size: 22px;
}
.logosfrd{
  width:15rem;
  height:auto;
  padding-top: 10px;
}
form{
  margin: 30px;
  background: #242323;
  border-radius: 25px;
  text-align: center;
}
input{
  background: rgba(0,0,0,0);
  border-right-style: none;
  border-bottom-color: white;
  width: 85%;
  padding: 0px 0px 15px;
  margin: 17px 0px 17px;
  text-align: center;
  font-size: 15px;
  outline: none;
}
::placeholder {
  color: #FFFFFF;
}
button{
  background-color: #25d66f;
  border-color: #25d66f;
  border-radius: 7px;
  margin: 10px 0px 15px;
  padding: 15px 35px 15px;
  border-style: double;
  font-size: 17px;
  cursor: pointer;
}
button:hover{
  background: #0FD803;
}
.logoppal{
  width:16rem;
  height:auto;
}
.bienvenidos{
  background: #25d66f;
  padding: 0.3rem;
}

</style>
