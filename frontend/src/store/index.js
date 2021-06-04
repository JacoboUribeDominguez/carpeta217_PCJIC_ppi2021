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
    imgFile : null
  },
  mutations: {
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
    uploadImg(state, id){
      let name = id + state.imgFile.name
      const refImg = refStorage.child('imagenes/' + name)
      const metaData = { contentType: 'img/*'}
      refImg.put(state.imgFile, metaData)
      .then(() => {
          refImg.getDownloadURL()
          .then((url) => {
              console.log(url)
          })
      })
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
    uploadImgAction( { commit }, id ){
      commit('uploadImg', id)
    }
  },
  modules: {},
});
