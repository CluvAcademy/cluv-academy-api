package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "lista_asistencia", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
        @NamedQuery(name = "ListaAsistencia.findAll", query = "SELECT l FROM ListaAsistencia l"),
        @NamedQuery(name = "ListaAsistencia.findByIdListaAsistencia", query = "SELECT l FROM ListaAsistencia l WHERE l.idListaAsistencia = :idListaAsistencia"),
        @NamedQuery(name = "ListaAsistencia.findByIdEstudianteAsistencia", query = "SELECT l FROM ListaAsistencia l WHERE l.idEstudianteAsistencia = :idEstudianteAsistencia"),
        @NamedQuery(name = "ListaAsistencia.findByFechaReistroListaAsistencia", query = "SELECT l FROM ListaAsistencia l WHERE l.fechaReistroListaAsistencia = :fechaReistroListaAsistencia")})
public class ListaAsistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lista_asistencia")
    private Long idListaAsistencia;
    @Column(name = "id_estudiante_asistencia")
    private BigInteger idEstudianteAsistencia;
    @Column(name = "fecha_reistro_lista_asistencia")
    @Temporal(TemporalType.DATE)
    private Date fechaReistroListaAsistencia;
    @JoinColumn(name = "id_clase", referencedColumnName = "id_clase")
    @ManyToOne
    private Clase idClase;

    public ListaAsistencia() {
    }
}
