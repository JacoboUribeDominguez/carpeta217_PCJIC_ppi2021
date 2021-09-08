package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.functions.Functions;
import com.saferide.saferide.helpers.Error;
import com.saferide.saferide.models.LikeRutaModel;
import com.saferide.saferide.models.MetricaModel;
import com.saferide.saferide.models.RutaModel;
import com.saferide.saferide.models.UserModel;
import com.saferide.saferide.pilas.ListRutasPilas;
import com.saferide.saferide.pilas.Nodo;
import com.saferide.saferide.repositories.*;
import com.saferide.saferide.services.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RutaImplements implements RutaService {

    //repositorio
    @Autowired
    private RutaRepository rutaRepository;

    //likes
    @Autowired
    private LikeRutaRepository likeRutaRepository;

    //métricas
    @Autowired
    private MetricaRepository metricaRepository;

    //comentario
    @Autowired
    private ComentarioRepository comentarioRepository;

    //times metrica
    @Autowired
    private TimesRepository timesRepository;

    //user
    @Autowired
    private UserRepository userRepository;

    @Override
    public RutaModel saveRuta(RutaModel ruta) {
        Functions functions = new Functions();
        ruta.setId_ruta(functions.makeId());
        ruta.setMe_gusta(0);
        ruta.getId_usuario().setContraseña("321");
        rutaRepository.save(ruta);
        return ruta;
    }

    @Override
    public Nodo[] getRutas(String id) {
        ListRutasPilas rutas = new ListRutasPilas();
        //acá pasamos el resultado de la busqueda a una pila
        for(RutaModel ruta : rutaRepository.findAll() ){
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
    public Nodo[] getResults( String palabra ){
        ListRutasPilas rutas = new ListRutasPilas();
        //acá pasamos el resultado de la busqueda a una pila
        for(RutaModel ruta : rutaRepository.findResults(palabra)){
            rutas.addElement(ruta);
        }
        return rutas.getPila(13);
    }

    @Override
    public Error updateRuta(RutaModel ruta){
        try {
//            RutaModel oldRute = rutaRepository.findById(ruta.getId_ruta()).get();
//            ruta.setMultimedia(oldRute.getMultimedia());
//            ruta.setId_usuario(oldRute.getId_usuario());
            rutaRepository.updateByLike(ruta.getMe_gusta(), ruta.getId_ruta());
            return new Error("Actualización exitosa", 0);
        } catch (Exception e) {
            return new Error("Hubo un error", 1);
        }
    }

    @Override
    public Error deleteRuta(String id_ruta){
        System.out.println(id_ruta);
        try{
            for(MetricaModel metrica : metricaRepository.findAllByIdRuta(id_ruta)){
                timesRepository.deleteByIdMetrica(metrica.getId_metrica());
            }
            metricaRepository.removeAllByIdRuta(id_ruta);
        }catch(Exception e){
            System.out.println("Métricas error");
            return new Error("Hubo un error", 1);
        }
        try{
            likeRutaRepository.deleteLikeByRuta(id_ruta);
        }catch(Exception e){
            System.out.println("Likes error");
            return new Error("Hubo un error", 1);
        }
        try{
            comentarioRepository.deleteCommentByIdRuta(id_ruta);
        }catch(Exception e){
            System.out.println("Comentarios error");
            return new Error("Hubo un error", 1);
        }
        try{
            rutaRepository.deleteById(id_ruta);
            return new Error("Eliminación exitosa", 0);
        }catch(Exception e){
            System.out.println("Ruta error");
            return new Error("Hubo un error", 1);
        }
    }

}
