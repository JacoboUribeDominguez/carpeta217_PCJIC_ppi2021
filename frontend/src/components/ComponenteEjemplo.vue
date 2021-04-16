<template>
  <div class="hello">
    <b>Esto es un ejemplo de un componente</b>
  </div>
</template>

<script>
export default {
  name: "ComponenteEjemplo",
  props: {
    msg: String,
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
</style>
