package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import org.springframework.stereotype.Component;

@Component
// Este objeto debo inyectarlo en mi servicio p/ poder utilizarlo
public class ContinenteMapper {

    // metodo donde llega DTO y devuelve ENTITY
    public ContinenteEntity continenteDTO2Entity(ContinenteDTO dto){
        ContinenteEntity continenteEntity = new ContinenteEntity();
        continenteEntity.setImagen(dto.getImagen());
        continenteEntity.setDenominacion(dto.getDenominacion());
        return continenteEntity;
    }

    // metodo donde llega ENTITY y devuelve DTO

    public ContinenteDTO continenteEntity2DTO(ContinenteEntity entity){
        ContinenteDTO dto = new ContinenteDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        return dto;
    }
}
