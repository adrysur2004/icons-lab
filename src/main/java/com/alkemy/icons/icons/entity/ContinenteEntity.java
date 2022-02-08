package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity // Indica que es una entidad
@Table(name="continente") // defino la tabla y su n ombre
@Getter // crea automaticamente los getters de cada atributo
@Setter // crea automaticamente los setters de cada atributo

public class ContinenteEntity {

    //DEFINO EL ID (1er campo de la tabla "continente")
         // 1. creo e identifico que va a ser un IDENTIFICADOR
         // 2. le digo cómo voy a generar el id con una estrategia
         // que sea SEQUENCE: el primero va a ser 1, 2, 3, etc
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    // Creo el resto de los campos o atributos
    private String imagen;
    private String denominacion;

}
