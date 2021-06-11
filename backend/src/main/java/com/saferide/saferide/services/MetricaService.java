package com.saferide.saferide.services;

import com.saferide.saferide.colas.Nodo;
import com.saferide.saferide.helpers.Error;
import com.saferide.saferide.models.MetricaModel;

public interface MetricaService {
//    Nodo[] getMetricas(String id_usuario);
    Nodo[] getMetricas(String id_usuario);
    Error saveMetricas(MetricaModel metrica);
}
