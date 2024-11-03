package com.example.api_rest.controller;
import com.example.api_rest.ADNdto.dtoADN;
import com.example.api_rest.service.ADNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class ADNController {
    @Autowired
    private ADNService adnService;

    @PostMapping
    public ResponseEntity<String> esMutante(@RequestBody dtoADN adnRequest) {
        String[] adn = adnRequest.getSecuencia();
        boolean esMutante = adnService.esMutante(adn);
        adnService.guardarADN(String.join(",", adn), esMutante);
        if (esMutante) {
            System.out.println("Calculando ADN");
            return new ResponseEntity<>("El ADN ingresado es de un Mutante", HttpStatus.OK);
        } else {
            System.out.println("Calculando ADN");
            return new ResponseEntity<>("El ADN ingresado es de un Humano", HttpStatus.FORBIDDEN);
        }
    }
}

