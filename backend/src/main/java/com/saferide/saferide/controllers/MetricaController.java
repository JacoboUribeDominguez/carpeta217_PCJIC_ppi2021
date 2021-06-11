package com.saferide.saferide.controllers;

import com.saferide.saferide.colas.Nodo;
import com.saferide.saferide.models.MetricaModel;
import com.saferide.saferide.services.MetricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void saveMetrica(@RequestBody MetricaModel metrica){
        metricaService.saveMetricas(metrica);
    }

}
