package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name="icon")
@Getter
@Setter
@SQLDelete(sql = " UPDATE icon SET deleted = true WHERE id=?") // crea campo adicional "deleted" - pone 1 cdo el campo fue borrado
@Where(clause =  "deleted=false") // con esto verifico si el campo fue borrado o no (marcado)
public class IconEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;
    private String denominacion;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

    private Long altura;

    private String historia;

    private boolean deleted = Boolean.FALSE; // para el softdelete

    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<PaisEntity> paises = new ArrayList<>();

    // metodos: add and remove paises
    public void addPais(PaisEntity pais) {this.paises.add(pais);}
    public void removePais(PaisEntity pais) {this.paises.remove(pais);}
}
