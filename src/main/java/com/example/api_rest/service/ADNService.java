package com.example.api_rest.service;

import com.example.api_rest.model.ADN;
import com.example.api_rest.repository.ADNRepository;
import com.example.api_rest.utils.ValidarADN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ADNService {
    @Autowired
    private ADNRepository adnRepository;

    private final ValidarADN adnValidator = new ValidarADN();

    public void guardarADN(String Adn, boolean esMutante) {
        ADN adn = new ADN();
        adn.setSecuencia(String.join(",", Adn));
        adn.setEsMutante(esMutante);
        adnRepository.save(adn);
    }

    public boolean esMutante(String[] adn) {
        if (!adnValidator.esValido(adn)) {
            throw new IllegalArgumentException("La secuencia de ADN es inválida");
        }
        boolean esMutante = verificarMutante(adn);
        ADN adnEntity = new ADN();
        adnEntity.setSecuencia(String.join(",", adn));
        adnEntity.setEsMutante(esMutante);
        return esMutante;
    }

    private boolean verificarMutante(String[] adn) {
        return verificarHorizontal(adn) || verificarVertical(adn) || verificarDiagonalIzqDer(adn) || verificarDiagonalDerIzq(adn);
    }

    private boolean verificarHorizontal(String[] adn) {
        int n = adn.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - 4; j++) {
                if (secuenciaMutante(adn[i].substring(j, j + 4))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verificarVertical(String[] adn) {
        int n = adn.length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= n - 4; i++) {
                if (secuenciaMutante(adn[i].charAt(j), adn[i + 1].charAt(j), adn[i + 2].charAt(j), adn[i + 3].charAt(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verificarDiagonalIzqDer(String[] adn) {
        int n = adn.length;
        for (int i = 0; i <= n - 4; i++) {
            for (int j = 0; j <= n - 4; j++) {
                if (secuenciaMutante(adn[i].charAt(j), adn[i + 1].charAt(j + 1), adn[i + 2].charAt(j + 2), adn[i + 3].charAt(j + 3))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verificarDiagonalDerIzq(String[] adn) {
        int n = adn.length;
        for (int i = 0; i <= n - 4; i++) {
            for (int j = 3; j < n; j++) {
                if (secuenciaMutante(adn[i].charAt(j), adn[i + 1].charAt(j - 1), adn[i + 2].charAt(j - 2), adn[i + 3].charAt(j - 3))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean secuenciaMutante(String secuencia) {
        return secuencia.equals("AAAA") || secuencia.equals("TTTT") || secuencia.equals("CCCC") || secuencia.equals("GGGG");
    }

    private boolean secuenciaMutante(char c1, char c2, char c3, char c4) {
        return c1 == c2 && c2 == c3 && c3 == c4;
    }
}
