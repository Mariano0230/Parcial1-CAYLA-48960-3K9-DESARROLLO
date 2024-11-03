package com.example.api_rest.utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ValidarADN {
    public boolean esValido(String[] adn) {
        if (adn == null || adn.length == 0) {
            return false;
        }
        int n = adn.length;
        for (String row : adn) {
            if (row == null || row.length() != n) {
                return false;
            }
            for (char c : row.toCharArray()) {
                if (c != 'A' && c != 'T' && c != 'C' && c != 'G') {
                    return false;
                }
            }
        }
        return true;
    }
}
