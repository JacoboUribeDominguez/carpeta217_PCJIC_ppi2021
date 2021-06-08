package com.saferide.saferide.controllers;

import com.saferide.saferide.models.RutaModel;
import com.saferide.saferide.pilas.Nodo;
import com.saferide.saferide.services.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/rutas")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    @PostMapping
    public RutaModel createRuta(@RequestBody RutaModel ruta){
        return rutaService.saveRuta(ruta);
    }

    @GetMapping
    public Nodo[] getRutas(){
        return rutaService.getRutas();
    }

    @GetMapping("/results")
    public List<RutaModel> getResults(@RequestParam String palabra) {
        return rutaService.getResults(palabra); }

    @PutMapping
    public void updateRuta(@RequestBody RutaModel ruta){
        rutaService.updateRuta(ruta);
    }

    @DeleteMapping
    public void deleteRuta(@RequestParam String id_usuario){
        rutaService.deleteRuta(id_usuario);
    }
}
