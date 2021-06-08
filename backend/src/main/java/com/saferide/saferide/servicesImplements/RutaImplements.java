package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.functions.Functions;
import com.saferide.saferide.helpers.Error;
import com.saferide.saferide.models.LikeRutaModel;
import com.saferide.saferide.models.RutaModel;
import com.saferide.saferide.pilas.ListRutasPilas;
import com.saferide.saferide.pilas.Nodo;
import com.saferide.saferide.repositories.LikeRutaRepository;
import com.saferide.saferide.repositories.RutaRepository;
import com.saferide.saferide.services.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaImplements implements RutaService {

    //repositorio
    @Autowired
    private RutaRepository rutaRepository;

    //likes
    @Autowired
    private LikeRutaRepository likeRutaRepository;

    @Override
    public RutaModel saveRuta(RutaModel ruta) {
        Functions functions = new Functions();
        ruta.setId_ruta(functions.makeId());
        ruta.setMe_gusta(0);
        rutaRepository.save(ruta);
        return ruta;
    }

    @Override
    public Nodo[] getRutas(String id) {
        ListRutasPilas rutas = new ListRutasPilas();
        //acá pasamos el resultado de la busqueda a una pila
        for(RutaModel ruta : rutaRepository.findAllRutes() ){
            rutas.addElement(ruta);
        }
        ListRutasPilas pila = new ListRutasPilas();//instanciamos pila contenedora
        ListRutasPilas pilaOrdenada = new ListRutasPilas();//instanciamos pila ordenada
        ListRutasPilas pilaRecientes = new ListRutasPilas();//instanciamos pila recientes
        pilaRecientes.fillBackwardsList(rutas);//llenamos pila recientes
        pilaOrdenada.fillList(rutas);//llenar pila ordenada
        pilaOrdenada.sortingBestScored();//ordenar pila ordenada
        pila.fillList(pilaRecientes, 10);//llenamos pila con pila recientes
        pila.fillList(pilaOrdenada, 3);//llenamos pila con pila ordenada

        Nodo pilaArray[] = pila.getPila(13); //array donde vamos a guardar
        //vamos a recorrer el array en pila a entregar
        if(!id.contains("notoken")){
            for(Nodo nodo : pilaArray){ //recorremos el array
                if(nodo == null){
                    break;
                }
                if(((List<LikeRutaModel>) likeRutaRepository.existsRutes(nodo.getId_ruta(), id)).size() > 0){ //verificamos si existen las coincidencias
                    nodo.setLiked(true); //establecemos si se le dio like el usuario
                } else {
                    nodo.setLiked(false); //establecemos si se le dio like el usuario
                }
            }
        } else {
            for(Nodo nodo : pilaArray){ //recorremos el array
                if(nodo == null){
                    break;
                }
                nodo.setLiked(false);
            }
        }
        return pilaArray;
    }

    @Override
    public List<RutaModel> getResults( String palabra ){
        return (List<RutaModel>) rutaRepository.findResults(palabra);
    }

    @Override
    public Error updateRuta(RutaModel ruta){
        try {
            RutaModel oldRute = rutaRepository.findById(ruta.getId_ruta()).get();
            ruta.setMultimedia(oldRute.getMultimedia());
            ruta.setId_usuario(oldRute.getId_usuario());
            rutaRepository.save(ruta);
            return new Error("Actualización exitosa", 0);
        } catch (Exception e) {
            return new Error("Hubo un error", 1);
        }
    }

    @Override
    public Error deleteRuta(String id_ruta){
        try{
            rutaRepository.deleteById(id_ruta);
            return new Error("Eliminación exitosa", 0);
        }catch(Exception e){
            return new Error("Hubo un error", 1);
        }
    }

}
