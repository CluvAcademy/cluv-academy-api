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
@Table(name = "tutor", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "Tutor.findAll", query = "SELECT t FROM Tutor t"),
    @NamedQuery(name = "Tutor.findByIdTutor", query = "SELECT t FROM Tutor t WHERE t.idTutor = :idTutor"),
    @NamedQuery(name = "Tutor.findByEspecializacionTutor", query = "SELECT t FROM Tutor t WHERE t.especializacionTutor = :especializacionTutor"),
    @NamedQuery(name = "Tutor.findByHabilidadesTutor", query = "SELECT t FROM Tutor t WHERE t.habilidadesTutor = :habilidadesTutor"),
    @NamedQuery(name = "Tutor.findBySobremiTutor", query = "SELECT t FROM Tutor t WHERE t.sobremiTutor = :sobremiTutor"),
    @NamedQuery(name = "Tutor.findByValoracionTutor", query = "SELECT t FROM Tutor t WHERE t.valoracionTutor = :valoracionTutor"),
    @NamedQuery(name = "Tutor.findByCantEstudiantesTutor", query = "SELECT t FROM Tutor t WHERE t.cantEstudiantesTutor = :cantEstudiantesTutor"),
    @NamedQuery(name = "Tutor.findByCatClasesTutor", query = "SELECT t FROM Tutor t WHERE t.catClasesTutor = :catClasesTutor"),
    @NamedQuery(name = "Tutor.findByExperienciaTutor", query = "SELECT t FROM Tutor t WHERE t.experienciaTutor = :experienciaTutor"),
    @NamedQuery(name = "Tutor.findByRedesTutor", query = "SELECT t FROM Tutor t WHERE t.redesTutor = :redesTutor"),
    @NamedQuery(name = "Tutor.findByVideoPresentacionTutor", query = "SELECT t FROM Tutor t WHERE t.videoPresentacionTutor = :videoPresentacionTutor"),
    @NamedQuery(name = "Tutor.findByEnsenianzaTutor", query = "SELECT t FROM Tutor t WHERE t.ensenianzaTutor = :ensenianzaTutor"),
    @NamedQuery(name = "Tutor.findByCurriculumTutor", query = "SELECT t FROM Tutor t WHERE t.curriculumTutor = :curriculumTutor"),
    @NamedQuery(name = "Tutor.findByMetodologiaTutor", query = "SELECT t FROM Tutor t WHERE t.metodologiaTutor = :metodologiaTutor"),
    @NamedQuery(name = "Tutor.findByReseniasTutor", query = "SELECT t FROM Tutor t WHERE t.reseniasTutor = :reseniasTutor"),
    @NamedQuery(name = "Tutor.findByNotificaEstudiantesTutor", query = "SELECT t FROM Tutor t WHERE t.notificaEstudiantesTutor = :notificaEstudiantesTutor"),
    @NamedQuery(name = "Tutor.findByNotificaForoTutor", query = "SELECT t FROM Tutor t WHERE t.notificaForoTutor = :notificaForoTutor"),
    @NamedQuery(name = "Tutor.findByNotificaCalificacionTutor", query = "SELECT t FROM Tutor t WHERE t.notificaCalificacionTutor = :notificaCalificacionTutor"),
    @NamedQuery(name = "Tutor.findByWhatsappmeTutor", query = "SELECT t FROM Tutor t WHERE t.whatsappmeTutor = :whatsappmeTutor"),
    @NamedQuery(name = "Tutor.findByIdUsuarioTutor", query = "SELECT t FROM Tutor t WHERE t.idUsuarioTutor = :idUsuarioTutor"),
    @NamedQuery(name = "Tutor.findByActivoTutor", query = "SELECT t FROM Tutor t WHERE t.activoTutor = :activoTutor")})
public class Tutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tutor")
    private Long idTutor;
    @Column(name = "especializacion_tutor")
    private String especializacionTutor;
    @Column(name = "habilidades_tutor")
    private String habilidadesTutor;
    @Column(name = "sobremi_tutor")
    private String sobremiTutor;
    @Column(name = "valoracion_tutor")
    private BigInteger valoracionTutor;
    @Column(name = "cant_estudiantes_tutor")
    private BigInteger cantEstudiantesTutor;
    @Column(name = "cat_clases_tutor")
    private BigInteger catClasesTutor;
    @Column(name = "experiencia_tutor")
    private String experienciaTutor;
    @Column(name = "redes_tutor")
    private String redesTutor;
    @Column(name = "video_presentacion_tutor")
    private String videoPresentacionTutor;
    @Column(name = "ensenianza_tutor")
    private String ensenianzaTutor;
    @Column(name = "curriculum_tutor")
    private String curriculumTutor;
    @Column(name = "metodologia_tutor")
    private String metodologiaTutor;
    @Column(name = "resenias_tutor")
    private String reseniasTutor;
    @Column(name = "notifica_estudiantes_tutor")
    private Boolean notificaEstudiantesTutor;
    @Column(name = "notifica_foro_tutor")
    private Boolean notificaForoTutor;
    @Column(name = "notifica_calificacion_tutor")
    private Boolean notificaCalificacionTutor;
    @Column(name = "whatsappme_tutor")
    private String whatsappmeTutor;
    @Column(name = "id_usuario_tutor")
    private BigInteger idUsuarioTutor;
    @Column(name = "activo_tutor")
    private Boolean activoTutor;
    @OneToMany(mappedBy = "idTutor")
    private Collection<ForoTutor> foroTutorCollection;
    @OneToMany(mappedBy = "idTutor")
    private Collection<Clase> claseCollection;
    @OneToMany(mappedBy = "idTutor")
    private Collection<MultimediaTutor> multimediaTutorCollection;
    @OneToMany(mappedBy = "idTutor")
    private Collection<InfoBancaria> infoBancariaCollection;
    @OneToMany(mappedBy = "idTutor")
    private Collection<HorarioSugeridoTutor> horarioSugeridoTutorCollection;
    @OneToMany(mappedBy = "idTutor")
    private Collection<InfoAcademicaTutor> infoAcademicaTutorCollection;
    @JoinColumn(name = "id_estado_actividad_tutor", referencedColumnName = "id_estado_actividad_tutor")
    @ManyToOne
    private EstadoActividadTutor idEstadoActividadTutor;
    @OneToMany(mappedBy = "idTutor")
    private Collection<Postulaciones> postulacionesCollection;
    @OneToMany(mappedBy = "idTutor")
    private Collection<InfoDestrezas> infoDestrezasCollection;
    @OneToMany(mappedBy = "idTutor")
    private Collection<CalificacionTutor> calificacionTutorCollection;

    public Tutor() {
    }

   
}
