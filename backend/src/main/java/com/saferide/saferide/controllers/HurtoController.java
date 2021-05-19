package com.saferide.saferide.controllers;

import com.saferide.saferide.models.HurtoModel;
import com.saferide.saferide.services.HurtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/hurtos")
public class HurtoController {

    @Autowired
    private HurtoService hurtoService;

    @PostMapping
    public void createHurto(@RequestBody HurtoModel hurto){
        hurtoService.saveHurto(hurto);
    }

    @PutMapping
    public void updateHurto(@RequestBody HurtoModel hurto){
        hurtoService.updateHurto(hurto);
    }

    @DeleteMapping
    public void deleteHurto(@RequestParam String id_usuario){
        hurtoService.deleteHurto(id_usuario);
    }

}
