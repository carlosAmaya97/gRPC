package com.uptc.frw.grpc.jpa.models;
import jakarta.persistence.*;

import java.util.List;
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
    @ManyToMany
    @JoinTable(
            name = "PERIODISTA_NOTICIA",
            joinColumns = @JoinColumn(name = "ID_P"),
            inverseJoinColumns = @JoinColumn(name = "ID_N")
    )
    private List<Noticia> noticias;

    // Relación con Implicados (muchos a muchos a través de tabla intermedia)
    @ManyToMany(mappedBy = "periodista")
    private List<Implicado> implicados;

    public Periodista() {
    }

    public long getIdP() {
        return idP;
    }

    public void setIdP(long idP) {
        this.idP = idP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public List<Implicado> getImplicados() {
        return implicados;
    }

    public void setImplicados(List<Implicado> implicados) {
        this.implicados = implicados;
    }

    @Override
    public String toString() {
        return "Periodista{" +
                "telefono=" + telefono +
                ", direccion='" + direccion + '\'' +
                ", nombreP='" + nombreP + '\'' +
                ", idP=" + idP +
                '}';
    }
}
