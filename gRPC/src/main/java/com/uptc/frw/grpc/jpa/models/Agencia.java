package com.uptc.frw.grpc.jpa.models;
import jakarta.persistence.*;

import java.util.List;

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
        @ManyToMany
        @JoinTable(
                name = "NOTICIA_AGENCIA",
                joinColumns = @JoinColumn(name = "ID_A") ,
                inverseJoinColumns = @JoinColumn(name = "ID_N")
        )
        private List<Noticia> noticias;

        public Agencia() {
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getAgencia() {
            return agencia;
        }

        public void setAgencia(String agencia) {
            this.agencia = agencia;
        }

        public int getAnioCreacion() {
            return anioCreacion;
        }

        public void setAnioCreacion(int anioCreacion) {
            this.anioCreacion = anioCreacion;
        }

        public List<Noticia> getNoticias() {
            return noticias;
        }

        public void setNoticias(List<Noticia> noticias) {
            this.noticias = noticias;
        }

        @Override
        public String toString() {
            return "Agencia{" +
                    "id=" + id +
                    ", agencia='" + agencia + '\'' +
                    ", anioCreacion=" + anioCreacion +
                    '}';
        }
    }

