package com.uptc.frw.grpc.jpa.models;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Periodistas")
public class Periodista {

    @Id
    @Column(name = "ID_P")
    private long idP;

    @Column(name = "Nombre_P")
    private String nombreP;

    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Telefono")
    private long telefono;

    // Relación con Periodista_noticia (muchos a muchos a través de tabla intermedia)
    @OneToMany(mappedBy = "periodista")
    private Set<PeriodistaNoticia> noticias;

    // Relación con Periodista_Implicados (muchos a muchos a través de tabla intermedia)
    @OneToMany(mappedBy = "periodista")
    private Set<PeriodistaImplicado> implicados;


}
