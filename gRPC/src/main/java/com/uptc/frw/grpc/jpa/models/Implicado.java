package com.uptc.frw.grpc.jpa.models;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Implicados")
public class Implicado {

    @Id
    @Column(name = "ID_I")
    private long idI;

    @Column(name = "NOMBRE_I")
    private String nombreI;

    @Column(name = "F_NACIMIENTO")
    private Date fechaNacimiento;

    @Column(name = "CALIDAD")
    private String calidad;

    // Relación con Noticias (muchos a muchos a través de tabla intermedia)
    @ManyToMany
    @JoinTable(
            name = "NOTICIA_IMPLICADO",
            joinColumns = @JoinColumn(name = "ID_I"),
            inverseJoinColumns = @JoinColumn(name = "ID_N")
    )
    private List<Noticia> noticias;

    // Relación con Periodistas(muchos a muchos a través de tabla intermedia)
    @ManyToMany
    @JoinTable(
            name = "PERIODISTA_IMPLICADOS",
            joinColumns = @JoinColumn(name = "ID_I"),
            inverseJoinColumns = @JoinColumn(name = "ID_P")
    )
    private List<Periodista> periodistas;

    public Implicado() {
    }

    public long getIdI() {
        return idI;
    }

    public void setIdI(long idI) {
        this.idI = idI;
    }

    public String getNombreI() {
        return nombreI;
    }

    public void setNombreI(String nombreI) {
        this.nombreI = nombreI;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public List<Periodista> getPeriodistas() {
        return periodistas;
    }

    public void setPeriodistas(List<Periodista> periodistas) {
        this.periodistas = periodistas;
    }

    @Override
    public String toString() {
        return "Implicado{" +
                "calidad='" + calidad + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", nombreI='" + nombreI + '\'' +
                ", idI=" + idI +
                '}';
    }
}

