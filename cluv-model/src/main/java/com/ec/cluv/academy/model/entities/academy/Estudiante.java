/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "estudiante", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByIdEstudiante", query = "SELECT e FROM Estudiante e WHERE e.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "Estudiante.findByIdUsuarioEstudiante", query = "SELECT e FROM Estudiante e WHERE e.idUsuarioEstudiante = :idUsuarioEstudiante"),
    @NamedQuery(name = "Estudiante.findByActivoEstudiante", query = "SELECT e FROM Estudiante e WHERE e.activoEstudiante = :activoEstudiante")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estudiante")
    private Long idEstudiante;
    @Column(name = "id_usuario_estudiante")
    private BigInteger idUsuarioEstudiante;
    @Column(name = "activo_estudiante")
    private Boolean activoEstudiante;
    @JoinColumn(name = "id_estado_estudiante", referencedColumnName = "id_estado_estudiante")
    @ManyToOne
    private EstadoEstudiante idEstadoEstudiante;
    @OneToMany(mappedBy = "idEstudiante")
    private Collection<CarritoCompras> carritoComprasCollection;

    public Estudiante() {
    }


}
