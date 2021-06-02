<template>
  <div id="app">
    <!--
    <div id="nav">
      <router-link to="/">
        <img src="./assets/textWhiteLogo.png" class="logoNavbar"/>
      </router-link>
    </div>-->
    <router-view />
  </div>
</template>

<style lang="scss">
body {
  margin:0;

}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  background: #4ac8f7;
  width:100%;
  display:flex;
  justify-content: center;
  padding:1rem;
  a {
    padding:1.4rem 1.5rem;
    color:white;
    border-radius:50%;
    text-decoration: none;
    background: #11a6de;
    display:flex;
    justify-content: center;
  }

  .logoNavbar {
    width: 9rem;
    height:auto;
  }
}

</style>
