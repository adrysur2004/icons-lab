package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import com.alkemy.icons.icons.mapper.ContinenteMapper;
import com.alkemy.icons.icons.repository.ContinenteRepository;
import com.alkemy.icons.icons.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContinenteServiceImpl implements ContinenteService {

    @Autowired
    private ContinenteMapper continenteMapper; // Acá tengo la inyección del objeto "continenteMapper"

    @Autowired
    private ContinenteRepository continenteRepository; // Acá tengo la inyección del objeto "continenteRepository"
                                                        // es el que va a interactuar c/ n/ BD, a traves de JPA
                                                        // que tienen ya operaciones básicas para operar

    // creamos un metodo para guardar
    public ContinenteDTO save(ContinenteDTO dto){

        ContinenteEntity entity = continenteMapper.continenteDTO2Entity(dto);//convierto en ENtity
        ContinenteEntity entitySaved = continenteRepository.save(entity);// lo guardo y devuelve entidad guardada
        ContinenteDTO result =  continenteMapper.continenteEntity2DTO(entitySaved);// y la entidad guardada la convierto en DTO
        return result; //y lo devuelvo
    }
}
