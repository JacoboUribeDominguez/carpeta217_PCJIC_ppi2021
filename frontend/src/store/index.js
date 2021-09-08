import Vue from "vue";
import Vuex from "vuex";
import { storage } from '../utils/firebase'
const refStorage = storage.ref()

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    rutas : [],
    results : null,
    showImgs : false,
    searchedWord : '',
    img : null,
    imgFile : null,
    addMetrica : {
      show : false
    },
    metricas : null
  },
  mutations: {
    mountMetricas(state, metricas){
      state.metricas = metricas
    },
    changeAddMetrica(state, metrica){
      if(metrica){
        state.addMetrica = {
          show : true,
          ruta : metrica
        }
      } else {
        state.addMetrica = {
          show : false
        }
      }
    },
    mountRutas(state, rutas){
      state.rutas = rutas
    },
    changeShowImgs(state){
      state.showImgs = !state.showImgs
    },
    searchResult(state, results){
      state.results = results
    },
    changeSearchedWord(state, word){
      if(word){
        state.searchedWord = word
      } else {
        state.searchedWord = ""
      }
    },
    changeImg(state, img) {
      if(img){
        state.imgFile = img
        state.img = URL.createObjectURL(img)
      } else {
        state.img = null
        state.imgFile = null
      }
    },
    uploadImg(state, { id, ubication }){
      //here we upload the image to firebase's storage
      let name = id + state.imgFile.name
      name = 'imagenes/' + name
      const refImg = refStorage.child(name)
      const metaData = { contentType: 'img/*'}
      refImg.put(state.imgFile, metaData)
      .then(() => {
          refImg.getDownloadURL()
      })
      //Here we upload the rute to the backend.
      fetch('http://localhost:8081/rutas', {
        method:'POST',
        body:JSON.stringify({
          id_ruta : '',
          multimedia : name,
          id_usuario : {
            id_usuario:'' + id
          },
          me_gusta : 0,
          ubicacion : ubication
        }),
        headers: {
          'Content-Type' : 'application/json'
        }
      })
      .then(res => res.json())
      .then(result => {
        this.$store.dispatch('addRoute', result)
        state.addMetrica = {
          show : false
        }
      })
    },
    addRoute(state, ruta){
      state.rutas.push(ruta)
    }
  },
  actions: {
    mountMetricasAction({ commit }, id_usuario ){
      fetch(`http://localhost:8081/metricas?id_usuario=${id_usuario}`)
      .then(res => res.json())
      .then(result => {
        commit('mountMetricas', result)
      })
    },
    mountRutasAction( { commit }, { refStorage, id } ){
      fetch(`http://localhost:8081/rutas?id=${id}`)
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
      fetch(`http://localhost:8081/rutas/results?palabra=${word}`)
      .then(res => res.json())
      .then(result => {
        //***********************************//
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
        //***********************************//
        commit('searchResult', array)
        commit('changeSearchedWord', word)
      })
    },
    changeSearchedWordAction( { commit } ) {
      commit('changeSearchedWord')
    },
    changeImgAction( { commit }, img) {
      commit('changeImg', img)
    },
    uploadImgAction( { commit }, payload ){
      commit('uploadImg', payload)
    },
    addRouteAction( { commit }, ruta ){
      commit('addRoute', ruta)
    },
    changeAddMetricaAction( { commit }, addMetrica ) {
      if(addMetrica){
        commit('changeAddMetrica', addMetrica)
      } else {
        commit('changeAddMetrica')
      }
    }
  },
  modules: {},
});
