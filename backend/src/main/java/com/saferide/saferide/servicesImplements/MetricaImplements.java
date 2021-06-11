package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.colas.ListMetricasColas;
import com.saferide.saferide.colas.Nodo;
import com.saferide.saferide.functions.Functions;
import com.saferide.saferide.helpers.Error;
import com.saferide.saferide.models.MetricaModel;
import com.saferide.saferide.repositories.MetricaRepository;
import com.saferide.saferide.services.MetricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricaImplements implements MetricaService {

    @Autowired
    private MetricaRepository metricaRepository;

    @Override
    public Nodo[] getMetricas(String id_usuario){
        ListMetricasColas list = new ListMetricasColas();
        for(MetricaModel metrica : metricaRepository.findMetricas(id_usuario)){
            list.addElement(metrica);
        }
        return list.getList();
    }

    @Override
    public Error saveMetricas(MetricaModel metrica) {
        try{
            Functions functions = new Functions();
            metrica.setId_metrica(functions.makeId());
            metricaRepository.save(metrica);
            return new Error("No hubo ningun problema", 0);
        } catch (Exception e){
            return new Error("Hubo un problema", 1);
        }
    }
}
