package com.uptc.frw.grpc.jpa.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class Agencia {
    @Entity
    @Table(name = "AGENCIAS")
    public class Agencia {

        @Id
        @Column(name = "ID_A")
        private long id;

        @Column(name = "AGENCIA")
        private String agencia;

        @Column(name = "ANIO_C")
        private int anioCreacion;

        // Relación con Noticia_Agencia (OneToMany)
        @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<NoticiaAgencia> noticias;



    }

}
