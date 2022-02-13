package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.service.ContinenteService;
import com.alkemy.icons.icons.service.impl.ContinenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que es un controlador
@RequestMapping("continentes") // definicimos la base para n/ path p/ poder acceder a este controlador

public class ContinenteController {

    @Autowired // para que cuando spring se inicialice
                // me deja hacer uso de continenteServiceImpl de la sig linea
    private ContinenteService continenteService;

    @GetMapping
    public ResponseEntity<List<ContinenteDTO>> getAll(){
        List<ContinenteDTO> continentes = continenteService.getAllContinentes();
        return ResponseEntity.ok().body(continentes);
    }

    @PostMapping // SI LE AGRGARAMOS ("/cualquiera") ==> POST localhost:8080/continentes/cualquiera

    // vamos a poner un ENDPOINT para poder guardar "continentes"
    // definiendo el siguiente metodo

    public ResponseEntity<ContinenteDTO> save(@RequestBody ContinenteDTO continente) {
        // save continente --> creo una variable

        ContinenteDTO continenteGuardado = continenteService.save(continente);

            //201, continente guardado
            return ResponseEntity.status(HttpStatus.CREATED).body(continenteGuardado);

    }
}
