package com.uptc.frw.grpc.jpa.models;

import com.uptc.frw.grpc.jpa.models.key.NoticiaAgenciaKey;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "NOTICIA_AGENCIA")
@IdClass(NoticiaAgenciaKey.class)
public class NoticiaAgencia {

    @Column(name = "ID_N", insertable = false, updatable = false)
    private long id;

    @Column(name = "ID_A", insertable = false, updatable = false)
    private long idAgencia;

    @Column(name = "FECHA_A")
    private Date fechaAsignacion;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_A")
    private Agencia agencia;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_N")
    private Noticia noticia;

}