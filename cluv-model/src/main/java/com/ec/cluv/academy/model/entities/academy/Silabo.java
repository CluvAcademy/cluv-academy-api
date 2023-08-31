/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "silabo", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "Silabo.findAll", query = "SELECT s FROM Silabo s"),
    @NamedQuery(name = "Silabo.findByIdSilabo", query = "SELECT s FROM Silabo s WHERE s.idSilabo = :idSilabo"),
    @NamedQuery(name = "Silabo.findByTemaSilabo", query = "SELECT s FROM Silabo s WHERE s.temaSilabo = :temaSilabo"),
    @NamedQuery(name = "Silabo.findByDescripcionSilabo", query = "SELECT s FROM Silabo s WHERE s.descripcionSilabo = :descripcionSilabo"),
    @NamedQuery(name = "Silabo.findByMaterialesSilabo", query = "SELECT s FROM Silabo s WHERE s.materialesSilabo = :materialesSilabo"),
    @NamedQuery(name = "Silabo.findByActivoSilabo", query = "SELECT s FROM Silabo s WHERE s.activoSilabo = :activoSilabo")})
public class Silabo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_silabo")
    private Long idSilabo;
    @Column(name = "tema_silabo")
    private String temaSilabo;
    @Column(name = "descripcion_silabo")
    private String descripcionSilabo;
    @Column(name = "materiales_silabo")
    private String materialesSilabo;
    @Column(name = "activo_silabo")
    private Boolean activoSilabo;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    @ManyToOne
    private Materia idMateria;

    public Silabo() {
    }

}
