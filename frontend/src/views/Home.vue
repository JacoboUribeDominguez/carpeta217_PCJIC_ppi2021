<template>
  <div class="home">
    <h1>TITULO EJEMPLO</h1>
    <ComponenteEjemplo msg="Welcome to Your Vue.js App" />
  </div>
</template>

<script>
// @ is an alias to /src
import ComponenteEjemplo from "@/components/ComponenteEjemplo.vue";

export default {
  name: "Home",
  components: {
    ComponenteEjemplo,
  },
};
</script>
