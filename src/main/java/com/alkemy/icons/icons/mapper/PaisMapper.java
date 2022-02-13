package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.PaisEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaisMapper {

    // TODO: falta la primer parte

    public PaisDTO paisEntity2DTO(PaisEntity entity, boolean loadIcons){
        PaisDTO dto = new PaisDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setCantidadHabitantes(entity.getCantidadHabitantes());
        dto.setContineteId(entity.getContinenteId());
        dto.setSuperficie(entity.getSuperficie());
        if(loadIcons){                  // TODO: no encuentro los errores
            List<IconDTO> iconDTOS = this.iconMapper.iconEntitySet2DTOList(entity.getIcons(), false);
            dto.setIcons(iconDTOS);
        }
        return dto;
    }

    public List<PaisDTO> paisEntityList2DTOList(List<PaisEntity> entities, boolean loadIcons){
        List<PaisDTO> dtos = new ArrayList<>();
        for (PaisEntity entity : entities) {
            dtos.add(this.paisEntityList2DTO(entity, loadIcons));
        }
        return dtos;
    }

    public  List<PaisEntity> paisDTOList2Entity(List<PaisDTO> dtos){
        List<PaisEntity> entities = new ArrayList<>();
        for(PaisDTO dto : dtos){
            entities.add(this.paisDTO2Entity(dto));
        }
        return entities;
    }

}
