/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "foro_club", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "ForoClub.findAll", query = "SELECT f FROM ForoClub f"),
    @NamedQuery(name = "ForoClub.findByIdForoClub", query = "SELECT f FROM ForoClub f WHERE f.idForoClub = :idForoClub"),
    @NamedQuery(name = "ForoClub.findByDescripcionForoClub", query = "SELECT f FROM ForoClub f WHERE f.descripcionForoClub = :descripcionForoClub"),
    @NamedQuery(name = "ForoClub.findByForoPadreForoClub", query = "SELECT f FROM ForoClub f WHERE f.foroPadreForoClub = :foroPadreForoClub"),
    @NamedQuery(name = "ForoClub.findByActivoForoClub", query = "SELECT f FROM ForoClub f WHERE f.activoForoClub = :activoForoClub")})
public class ForoClub implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_foro_club")
    private Long idForoClub;
    @Column(name = "descripcion_foro_club")
    private String descripcionForoClub;
    @Column(name = "foro_padre_foro_club")
    private BigInteger foroPadreForoClub;
    @Column(name = "activo_foro_club")
    private Boolean activoForoClub;
    @JoinColumn(name = "id_club", referencedColumnName = "id_club")
    @ManyToOne
    private Club idClub;

    public ForoClub() {
    }


}
