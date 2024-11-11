import jakarta.persistence.*;
import java.util.Date;
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

    // Relación con NoticiaImplicado (muchos a muchos a través de tabla intermedia)
    @OneToMany(mappedBy = "implicado")
    private Set<NoticiaImplicado> noticias;

    // Relación con PeriodistaImplicados (muchos a muchos a través de tabla intermedia)
    @OneToMany(mappedBy = "implicado")
    private Set<PeriodistaImplicados> periodistas;

}

