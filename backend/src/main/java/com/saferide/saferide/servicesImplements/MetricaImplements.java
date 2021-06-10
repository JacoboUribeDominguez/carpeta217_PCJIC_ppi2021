package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.colas.ListMetricasColas;
import com.saferide.saferide.colas.Nodo;
import com.saferide.saferide.repositories.MetricaRepository;
import com.saferide.saferide.services.MetricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricaImplements implements MetricaService {

    @Autowired
    private MetricaRepository metricaRepository;

    @Override
    public void getMetricas(String id_usuario){
        //ListMetricasColas list = new ListMetricasColas();
//        for(Nodo nodo : metricaRepository.findMetricas(id_usuario)){
//            list.addElement(nodo);
//        }
        System.out.println(metricaRepository.findMetricas(id_usuario));
        //list.show();
    }
}
