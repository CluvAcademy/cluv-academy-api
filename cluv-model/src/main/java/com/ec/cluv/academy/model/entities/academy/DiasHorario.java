/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "dias_horario", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "DiasHorario.findAll", query = "SELECT d FROM DiasHorario d"),
    @NamedQuery(name = "DiasHorario.findByIdDiasHorario", query = "SELECT d FROM DiasHorario d WHERE d.idDiasHorario = :idDiasHorario"),
    @NamedQuery(name = "DiasHorario.findByNombreDiasHorario", query = "SELECT d FROM DiasHorario d WHERE d.nombreDiasHorario = :nombreDiasHorario"),
    @NamedQuery(name = "DiasHorario.findByActivoDiasHorario", query = "SELECT d FROM DiasHorario d WHERE d.activoDiasHorario = :activoDiasHorario")})
public class DiasHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dias_horario")
    private Long idDiasHorario;
    @Column(name = "nombre_dias_horario")
    private String nombreDiasHorario;
    @Column(name = "activo_dias_horario")
    private Boolean activoDiasHorario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diasHorario")
    private Collection<Horario> horarioCollection;

    public DiasHorario() {
    }


}
