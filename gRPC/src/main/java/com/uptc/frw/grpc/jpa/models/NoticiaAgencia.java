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

    public NoticiaAgencia() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(long idAgencia) {
        this.idAgencia = idAgencia;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    @Override
    public String toString() {
        return "NoticiaAgencia{" +
                "id=" + id +
                ", idAgencia=" + idAgencia +
                ", fechaAsignacion=" + fechaAsignacion +
                '}';
    }
}
