package com.ec.cluv.academy.model.entities.academy;

import com.ec.cluv.academy.model.entities.academy.Clase;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "resenias", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
        @NamedQuery(name = "Resenias.findAll", query = "SELECT r FROM Resenias r"),
        @NamedQuery(name = "Resenias.findByIdResenias", query = "SELECT r FROM Resenias r WHERE r.idResenias = :idResenias"),
        @NamedQuery(name = "Resenias.findByDescripcionResenias", query = "SELECT r FROM Resenias r WHERE r.descripcionResenias = :descripcionResenias"),
        @NamedQuery(name = "Resenias.findByIdEstudianteResenias", query = "SELECT r FROM Resenias r WHERE r.idEstudianteResenias = :idEstudianteResenias"),
        @NamedQuery(name = "Resenias.findByValorResenias", query = "SELECT r FROM Resenias r WHERE r.valorResenias = :valorResenias")})
public class Resenias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_resenias")
    private Long idResenias;
    @Column(name = "descripcion_resenias")
    private String descripcionResenias;
    @Column(name = "id_estudiante_resenias")
    private BigInteger idEstudianteResenias;
    @Column(name = "valor_resenias")
    private BigInteger valorResenias;
    @JoinColumn(name = "id_clase", referencedColumnName = "id_clase")
    @ManyToOne
    private Clase idClase;

    public Resenias() {
    }
}
