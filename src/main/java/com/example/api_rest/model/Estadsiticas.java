package com.example.api_rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estadsiticas {
    private long contMutanteADN;
    private long contHumanoADN;
    private double ratio;

}
