package com.example.api_rest.service;

import com.example.api_rest.model.Estadsiticas;
import com.example.api_rest.repository.ADNRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EstadisticaService {
    @Autowired
    private ADNRepository adnRepository;

    public Estadsiticas getEstadisticas() {
        long contadorADNMutante = adnRepository.countByEsMutante(true);
        long contadorADNHumano = adnRepository.countByEsMutante(false);
        double ratio;
        if (contadorADNHumano > 0) {
            ratio = (double)contadorADNMutante / contadorADNHumano;
        } else{
            ratio = 0;
        }
        return new Estadsiticas(contadorADNMutante, contadorADNHumano, ratio);
    }
}