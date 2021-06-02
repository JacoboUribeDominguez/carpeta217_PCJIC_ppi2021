import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    rutas : [],
    results : [],
    showImgs : false
  },
  mutations: {
    mountRutas(state, rutas){
      state.rutas = rutas
    },
    changeShowImgs(state){
      state.showImgs = !state.showImgs
    },
    searchResult(state, word){
      let results = []
      state.rutas.map((ruta, index) => {
        if(index >= 2){
          if(ruta.ubicacion.toLowerCase().includes(word.toLowerCase())){
            results.push(ruta)
          }
        }
      })
      state.results = results
    }
  },
  actions: {
    mountRutasAction( { commit }, { refStorage } ){
      fetch('http://localhost:8081/rutas')
      .then(res => res.json())
      .then(result => {
        let array = []
        for(let i = 0; i < result.length; i++){
          if(result[i] == null){
            break;
          }
          array.push(result[i])
        }

        const getUrl = async(index) => {
          const refImg = refStorage.child(array[index].multimedia)
          const url = await refImg.getDownloadURL()
          array[index].multimedia = url 
          if(index === array.length - 1){
            commit('changeShowImgs');
          }
        }

        let index = 0
        while(index < array.length){
          getUrl(index)
          index = index + 1;
        }
        commit('mountRutas', array)
      })
    },
    changeShowImgsAction( { commit } ) {
      commit('changeShowImgs')
    },
    searchResultAction( { commit }, word){
      commit('searchResult', word)
    }
  },
  modules: {},
});
