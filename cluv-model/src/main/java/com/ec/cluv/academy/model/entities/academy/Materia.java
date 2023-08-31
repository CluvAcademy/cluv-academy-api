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
@Table(name = "materia", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m"),
    @NamedQuery(name = "Materia.findByIdMateria", query = "SELECT m FROM Materia m WHERE m.idMateria = :idMateria"),
    @NamedQuery(name = "Materia.findByNombreMateria", query = "SELECT m FROM Materia m WHERE m.nombreMateria = :nombreMateria"),
    @NamedQuery(name = "Materia.findByDescripcionMateria", query = "SELECT m FROM Materia m WHERE m.descripcionMateria = :descripcionMateria"),
    @NamedQuery(name = "Materia.findByValoracionMateria", query = "SELECT m FROM Materia m WHERE m.valoracionMateria = :valoracionMateria"),
    @NamedQuery(name = "Materia.findByRecursosMateria", query = "SELECT m FROM Materia m WHERE m.recursosMateria = :recursosMateria"),
    @NamedQuery(name = "Materia.findByMaterialesMateria", query = "SELECT m FROM Materia m WHERE m.materialesMateria = :materialesMateria"),
    @NamedQuery(name = "Materia.findByAforoReferencialMateria", query = "SELECT m FROM Materia m WHERE m.aforoReferencialMateria = :aforoReferencialMateria"),
    @NamedQuery(name = "Materia.findByCostoReferencialMateria", query = "SELECT m FROM Materia m WHERE m.costoReferencialMateria = :costoReferencialMateria"),
    @NamedQuery(name = "Materia.findByActivoMateria", query = "SELECT m FROM Materia m WHERE m.activoMateria = :activoMateria")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_materia")
    private Long idMateria;
    @Column(name = "nombre_materia")
    private String nombreMateria;
    @Column(name = "descripcion_materia")
    private String descripcionMateria;
    @Column(name = "valoracion_materia")
    private BigInteger valoracionMateria;
    @Column(name = "recursos_materia")
    private String recursosMateria;
    @Column(name = "materiales_materia")
    private String materialesMateria;
    @Column(name = "aforo_referencial_materia")
    private BigInteger aforoReferencialMateria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_referencial_materia")
    private Double costoReferencialMateria;
    @Column(name = "activo_materia")
    private Boolean activoMateria;
    @OneToMany(mappedBy = "idMateria")
    private Collection<Paquete> paqueteCollection;
    @OneToMany(mappedBy = "idMateria")
    private Collection<Clase> claseCollection;
    @OneToMany(mappedBy = "idMateria")
    private Collection<Silabo> silaboCollection;
    @JoinColumn(name = "id_club", referencedColumnName = "id_club")
    @ManyToOne
    private Club idClub;

    public Materia() {
    }


}
