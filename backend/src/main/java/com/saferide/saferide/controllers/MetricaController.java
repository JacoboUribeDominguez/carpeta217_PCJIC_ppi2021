package com.saferide.saferide.controllers;

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
    public void getMetricas(@RequestParam String id_usuario){
        metricaService.getMetricas(id_usuario);
    }

}
