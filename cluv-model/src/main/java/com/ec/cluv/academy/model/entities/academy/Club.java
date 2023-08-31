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
@Table(name = "club", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "Club.findAll", query = "SELECT c FROM Club c"),
    @NamedQuery(name = "Club.findByIdClub", query = "SELECT c FROM Club c WHERE c.idClub = :idClub"),
    @NamedQuery(name = "Club.findByNombreClub", query = "SELECT c FROM Club c WHERE c.nombreClub = :nombreClub"),
    @NamedQuery(name = "Club.findByDescripcionClub", query = "SELECT c FROM Club c WHERE c.descripcionClub = :descripcionClub"),
    @NamedQuery(name = "Club.findByObjetivosClub", query = "SELECT c FROM Club c WHERE c.objetivosClub = :objetivosClub"),
    @NamedQuery(name = "Club.findByIntroduccionClub", query = "SELECT c FROM Club c WHERE c.introduccionClub = :introduccionClub"),
    @NamedQuery(name = "Club.findByAvatarClub", query = "SELECT c FROM Club c WHERE c.avatarClub = :avatarClub"),
    @NamedQuery(name = "Club.findByActivoClub", query = "SELECT c FROM Club c WHERE c.activoClub = :activoClub")})
public class Club implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_club")
    private Long idClub;
    @Column(name = "nombre_club")
    private String nombreClub;
    @Column(name = "descripcion_club")
    private String descripcionClub;
    @Column(name = "objetivos_club")
    private String objetivosClub;
    @Column(name = "introduccion_club")
    private String introduccionClub;
    @Column(name = "avatar_club")
    private String avatarClub;
    @Column(name = "activo_club")
    private Boolean activoClub;
    @OneToMany(mappedBy = "idClub")
    private Collection<ForoClub> foroClubCollection;
    @JoinColumn(name = "id_reconocimiento_club", referencedColumnName = "id_reconocimiento_club")
    @ManyToOne
    private ReconocimientoClub idReconocimientoClub;
    @OneToMany(mappedBy = "idClub")
    private Collection<Materia> materiaCollection;
    @OneToMany(mappedBy = "idClub")
    private Collection<CalificacionClub> calificacionClubCollection;

    public Club() {
    }


}
