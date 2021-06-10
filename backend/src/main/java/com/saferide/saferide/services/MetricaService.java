package com.saferide.saferide.services;

import com.saferide.saferide.colas.Nodo;
import com.saferide.saferide.models.MetricaModel;

public interface MetricaService {
//    Nodo[] getMetricas(String id_usuario);
    void getMetricas(String id_usuario);
    void saveMetricas(MetricaModel metrica);
}
