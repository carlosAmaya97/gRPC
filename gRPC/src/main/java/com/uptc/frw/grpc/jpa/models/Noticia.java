package com.uptc.frw.grpc.jpa.models;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Noticias")
public class Noticia {

    @Id
    @Column(name = "ID_N")
    private long idN;

    @Column(name = "ID_R")
    private long idR;

    @Column(name = "FECHA_N")
    private Date fechaN;

    @Column(name = "TITULAR")
    private String titular;

    @Column(name = "TEXTO")
    private String texto;

    // Relación con Periodista (muchos a muchos a través de tabla intermedia)
    @ManyToMany(mappedBy = "noticia")
    private List<Periodista> periodistas;

    // Relación con Implicado (muchos a muchos a través de tabla intermedia)
    @ManyToMany(mappedBy = "noticia")
    private List<Implicado> implicados;

    // Relación con Agencia (muchos a muchos a través de tabla intermedia)
    @ManyToMany(mappedBy = "noticia")
    private List<Agencia> agencias;

    // Relacion consigo misma por ID_R
    @ManyToOne
    @JoinColumn(name = "ID_R")
    private Noticia noticiaRelacionada;

    @OneToMany(mappedBy = "noticiaRelacionada")
    private List<Noticia> noticiasRelacionadas;

    public Noticia() {
    }

    public long getIdN() {
        return idN;
    }

    public void setIdN(long idN) {
        this.idN = idN;
    }

    public long getIdR() {
        return idR;
    }

    public void setIdR(long idR) {
        this.idR = idR;
    }

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<Periodista> getPeriodistas() {
        return periodistas;
    }

    public void setPeriodistas(List<Periodista> periodistas) {
        this.periodistas = periodistas;
    }

    public List<Implicado> getImplicados() {
        return implicados;
    }

    public void setImplicados(List<Implicado> implicados) {
        this.implicados = implicados;
    }

    public List<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
    }

    public Noticia getNoticiaRelacionada() {
        return noticiaRelacionada;
    }

    public void setNoticiaRelacionada(Noticia noticiaRelacionada) {
        this.noticiaRelacionada = noticiaRelacionada;
    }

    public List<Noticia> getNoticiasRelacionadas() {
        return noticiasRelacionadas;
    }

    public void setNoticiasRelacionadas(List<Noticia> noticiasRelacionadas) {
        this.noticiasRelacionadas = noticiasRelacionadas;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "idN=" + idN +
                ", idR=" + idR +
                ", fechaN=" + fechaN +
                ", titular='" + titular + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }
}
