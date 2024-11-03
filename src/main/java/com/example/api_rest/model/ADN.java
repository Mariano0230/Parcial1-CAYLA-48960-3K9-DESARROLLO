package com.example.api_rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ADN")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ADN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String secuencia;
    private boolean esMutante;

    public ADN(String secuencia, boolean esMutante) {
        this.secuencia = secuencia;
        this.esMutante = esMutante;
    }
}
