package com.alkemy.icons.icons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("icons")

public class IconController {

    private IconService iconService;

    @Autowired
    public IconController(IconService  iconService){
       this.iconService= iconService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<IconBasicDTO>> getAll(){
        List<IconBasicDTO> icons = this.iconService.getAll();
        return ResponseEntity.ok(icons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IconDTO>getDetailsById(@PathVariable Long id){
        IconDTO icon = this.iconService.getDetailsById(id);
        return ResponseEntity.ok(icon);
    }

    @PostMapping("/{id}/pais/{idPais}")
    public ResponseEntity<Void> removePais(@PathVariable Long id, @PathVariable Long idPais){
        this.iconService.removePais(id, idPais);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
