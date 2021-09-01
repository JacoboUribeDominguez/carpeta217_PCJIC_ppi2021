package com.saferide.saferide.controllers;

import com.saferide.saferide.colas.Nodo;
import com.saferide.saferide.models.MetricaModel;
import com.saferide.saferide.services.MetricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.saferide.saferide.helpers.Error;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/metricas")
public class MetricaController {

    @Autowired
    private MetricaService metricaService;

    @GetMapping
    public Nodo[] getMetricas(@RequestParam String id_usuario){
        return metricaService.getMetricas(id_usuario);
    }

    @PostMapping
    public Error saveMetrica(@RequestBody MetricaModel metrica){
        return metricaService.saveMetricas(metrica);
    }

    @PostMapping("/exists")
    public boolean metricaExists (@RequestBody MetricaModel metrica){
        return metricaService.exists(metrica.getId_ruta().getId_ruta(), metrica.getId_usuario().getId_usuario());
    }

}
