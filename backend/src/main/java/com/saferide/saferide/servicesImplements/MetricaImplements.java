package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.colas.ListMetricasColas;
import com.saferide.saferide.colas.Nodo;
import com.saferide.saferide.functions.Functions;
import com.saferide.saferide.models.MetricaModel;
import com.saferide.saferide.repositories.MetricaRepository;
import com.saferide.saferide.services.MetricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricaImplements implements MetricaService {

    @Autowired
    private MetricaRepository metricaRepository;

    @Override
    public void getMetricas(String id_usuario){
        ListMetricasColas list = new ListMetricasColas();
        for(MetricaModel metrica : metricaRepository.findMetricas(id_usuario)){
            list.addElement(metrica);
        }
        list.show();
    }

    @Override
    public void saveMetricas(MetricaModel metrica) {
        Functions functions = new Functions();
        metrica.setId_metrica(functions.makeId());
        metricaRepository.save(metrica);
    }
}
