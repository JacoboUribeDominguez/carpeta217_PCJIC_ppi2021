import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    rutas : []
  },
  mutations: {
    mountRutas(state, rutas){
      state.rutas = rutas
    }
  },
  actions: {
    mountRutasAction( { commit }, { refStorage } ){
      fetch('http://localhost:8081/rutas')
      .then(res => res.json())
      .then(result => {
        let array = result
        result.map(async (ruta, index) => {
          const refImg = refStorage.child(ruta.multimedia)
          const url = await refImg.getDownloadURL()
          array[index].multimedia = url 
        })
        commit('mountRutas', result)
      })
    }
  },
  modules: {},
});
