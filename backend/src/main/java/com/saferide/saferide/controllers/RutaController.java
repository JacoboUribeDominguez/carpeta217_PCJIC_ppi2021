package com.saferide.saferide.controllers;

import com.saferide.saferide.models.RutaModel;
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
    public void createRuta(@RequestBody RutaModel ruta){
        rutaService.saveRuta(ruta);
    }

    @GetMapping
    public List<RutaModel> getRutas(){
        return rutaService.getRutas();
    }

    @PutMapping
    public void updateRuta(@RequestBody RutaModel ruta){
        rutaService.updateRuta(ruta);
    }

    @DeleteMapping
    public void deleteRuta(@RequestParam String id_usuario){
        rutaService.deleteRuta(id_usuario);
    }
}
