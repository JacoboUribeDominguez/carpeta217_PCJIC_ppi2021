package com.saferide.saferide.controllers;

import com.saferide.saferide.helpers.Error;
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
    public Nodo[] getRutas(@RequestParam String id){
        return rutaService.getRutas(id);
    }

    @GetMapping("/results")
    public Nodo[] getResults(@RequestParam String palabra) {
        return rutaService.getResults(palabra); }

    @PutMapping
    public Error updateRuta(@RequestBody RutaModel ruta){
        return rutaService.updateRuta(ruta);
    }

    @DeleteMapping
    public Error deleteRuta(@RequestParam String id_usuario){
        return rutaService.deleteRuta(id_usuario);
    }
}
