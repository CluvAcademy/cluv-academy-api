package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "logros", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
        @NamedQuery(name = "Logros.findAll", query = "SELECT l FROM Logros l"),
        @NamedQuery(name = "Logros.findByIdLogro", query = "SELECT l FROM Logros l WHERE l.idLogro = :idLogro"),
        @NamedQuery(name = "Logros.findByIdClaseLogro", query = "SELECT l FROM Logros l WHERE l.idClaseLogro = :idClaseLogro")})
public class Logros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_logro")
    private Long idLogro;
    @Column(name = "id_clase_logro")
    private BigInteger idClaseLogro;
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante")
    @ManyToOne
    private Estudiante idEstudiante;
    @JoinColumn(name = "id_tipo_logro", referencedColumnName = "id_tipo_logro")
    @ManyToOne
    private TiposLogros idTipoLogro;

    public Logros() {
    }

}
