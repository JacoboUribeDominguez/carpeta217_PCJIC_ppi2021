package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.functions.Functions;
import com.saferide.saferide.models.RutaModel;
import com.saferide.saferide.pilas.ListRutasPilas;
import com.saferide.saferide.pilas.Nodo;
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

    //usar makeId
    @Autowired
    private UserImplements userImplements;

    @Override
    public void saveRuta(RutaModel ruta) {
        Functions functions = new Functions();
        ruta.setId_ruta(functions.makeId());
        ruta.setMe_gusta(0);
        rutaRepository.save(ruta);
    }

    @Override
    public Nodo[] getRutas() {
        List<RutaModel> rutas = (List<RutaModel>) rutaRepository.findAll();//buscamos rutas
        ListRutasPilas pila = new ListRutasPilas();//instanciamos pila contenedora
        ListRutasPilas pilaOrdenada = new ListRutasPilas();//instanciamos pila ordenada
        ListRutasPilas pilaRecientes = new ListRutasPilas();//instanciamos pila recientes
        pilaRecientes.fillList(rutas);//llenamos pila recientes
        pilaOrdenada.fillList(rutas);//llenar pila ordenada
        pilaOrdenada.sortingBestScored();//ordenar pila ordenada
        pila.fillList(pilaRecientes, 10);//llenamos pila con pila recientes
        pila.fillList(pilaOrdenada, 3);//llenamos pila con pila ordenada
        pila.showList();//mostramos la pila
        System.out.println("Ultima ruta: "+rutas.get(rutas.size()-1).getMe_gusta());
        return pila.getPila(13);
    }

    @Override
    public void updateRuta(RutaModel ruta){
        rutaRepository.save(ruta);
    }

    @Override
    public void deleteRuta(String id_ruta){
        rutaRepository.deleteById(id_ruta);
    }

}
