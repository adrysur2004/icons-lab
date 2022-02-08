package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="pais")
@Getter
@Setter

public class PaisEntity {

    @Id // si o si tiene que ir xq indicamos que es un Identificador
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;
    private String denominacion;

    // se usa @Column xq los nombres son distintos
    @Column(name = "cant_habitantes") // nombre en la BD
    private Long cantidadHabitantes;   // nombre en Java

    private Long superficie; // m2

    // Defino la relación entre tablas 1 a N: continente-pais (pais Dentro de continente)
    // a través de que campos se joinean
    // y defino continente como ContinenteEntity (es decir, como un tipo objeto)

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

        // FetchType.EAGER: digo que la inicialización va a ser de tipo TEMPRANA
            // es decir que cada vez que pida un dato de tipo PAIS
            // si o si va a venir con su CONTINENTE
        // cascade = CascadeType.ALL: para que todas las operaciones sean concecuentes con el CONTINENTE
            // es decir, que si aplico un DELETE, tambien lo hará sobre continente, y demas

    @JoinColumn(name = "continente_id", insertable = false, updatable = false)
    private ContinenteEntity continente;

    @Column(name = "continente_id", nullable = false)
    private Long continenteId;

    // Defino la relación entre tablas N a N:
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "icon_pais",
            joinColumns = @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id")
    )
    private Set<IconEntity> icons = new HashSet<>();

    @Override  // redefiniendo la comparacion de paises
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        final PaisEntity other = (PaisEntity) obj;
        return other.id == this.id;
    }
}
