/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "clase", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c"),
    @NamedQuery(name = "Clase.findByIdClase", query = "SELECT c FROM Clase c WHERE c.idClase = :idClase"),
    @NamedQuery(name = "Clase.findByNombreClase", query = "SELECT c FROM Clase c WHERE c.nombreClase = :nombreClase"),
    @NamedQuery(name = "Clase.findByDescripcionClase", query = "SELECT c FROM Clase c WHERE c.descripcionClase = :descripcionClase"),
    @NamedQuery(name = "Clase.findByLinkZoomClase", query = "SELECT c FROM Clase c WHERE c.linkZoomClase = :linkZoomClase"),
    @NamedQuery(name = "Clase.findByGrabarClase", query = "SELECT c FROM Clase c WHERE c.grabarClase = :grabarClase"),
    @NamedQuery(name = "Clase.findByAsistenciaClase", query = "SELECT c FROM Clase c WHERE c.asistenciaClase = :asistenciaClase"),
    @NamedQuery(name = "Clase.findByAforoClase", query = "SELECT c FROM Clase c WHERE c.aforoClase = :aforoClase"),
    @NamedQuery(name = "Clase.findByCostoClase", query = "SELECT c FROM Clase c WHERE c.costoClase = :costoClase"),
    @NamedQuery(name = "Clase.findByDuracionClase", query = "SELECT c FROM Clase c WHERE c.duracionClase = :duracionClase"),
    @NamedQuery(name = "Clase.findByValoracionClase", query = "SELECT c FROM Clase c WHERE c.valoracionClase = :valoracionClase"),
    @NamedQuery(name = "Clase.findByRecursosClase", query = "SELECT c FROM Clase c WHERE c.recursosClase = :recursosClase"),
    @NamedQuery(name = "Clase.findByMaterialesClase", query = "SELECT c FROM Clase c WHERE c.materialesClase = :materialesClase"),
    @NamedQuery(name = "Clase.findByFechaInicioClase", query = "SELECT c FROM Clase c WHERE c.fechaInicioClase = :fechaInicioClase"),
    @NamedQuery(name = "Clase.findByFechaFinClase", query = "SELECT c FROM Clase c WHERE c.fechaFinClase = :fechaFinClase"),
    @NamedQuery(name = "Clase.findByRecargoClase", query = "SELECT c FROM Clase c WHERE c.recargoClase = :recargoClase"),
    @NamedQuery(name = "Clase.findByDescuentoClase", query = "SELECT c FROM Clase c WHERE c.descuentoClase = :descuentoClase"),
    @NamedQuery(name = "Clase.findByActivoClase", query = "SELECT c FROM Clase c WHERE c.activoClase = :activoClase")})
public class Clase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clase")
    private Long idClase;
    @Column(name = "nombre_clase")
    private String nombreClase;
    @Column(name = "descripcion_clase")
    private String descripcionClase;
    @Column(name = "link_zoom_clase")
    private String linkZoomClase;
    @Column(name = "grabar_clase")
    private Boolean grabarClase;
    @Column(name = "asistencia_clase")
    private BigInteger asistenciaClase;
    @Column(name = "aforo_clase")
    private BigInteger aforoClase;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_clase")
    private Double costoClase;
    @Column(name = "duracion_clase")
    private Double duracionClase;
    @Column(name = "valoracion_clase")
    private BigInteger valoracionClase;
    @Column(name = "recursos_clase")
    private String recursosClase;
    @Column(name = "materiales_clase")
    private String materialesClase;
    @Column(name = "fecha_inicio_clase")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioClase;
    @Column(name = "fecha_fin_clase")
    @Temporal(TemporalType.DATE)
    private Date fechaFinClase;
    @Column(name = "recargo_clase")
    private Double recargoClase;
    @Column(name = "descuento_clase")
    private Double descuentoClase;
    @Column(name = "zona_horaria_clase")
    private String zonaHorariaClase;
    @Column(name = "start_url_clase")
    private String startUrlClase;
    @Column(name = "join_url_clase")
    private String joinUrlClase;
    @Column(name = "password_clase")
    private String passwordClase;
    @Column(name = "avatar_clase")
    private String avatarClase;
    @Column(name = "activo_clase")
    private Boolean activoClase;
    @JoinColumn(name = "id_estado_clase", referencedColumnName = "id_estado_clase")
    @ManyToOne
    private EstadoClase idEstadoClase;
    @JoinColumns({
        @JoinColumn(name = "id_horas_horario", referencedColumnName = "id_horas_horario"),
        @JoinColumn(name = "id_dias_horario", referencedColumnName = "id_dias_horario")})
    @ManyToOne
    private Horario horario;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    @ManyToOne
    private Materia idMateria;
    @JoinColumn(name = "id_tipo_clase", referencedColumnName = "id_tipo_clase")
    @ManyToOne
    private TipoClase idTipoClase;
    @JoinColumn(name = "id_tutor", referencedColumnName = "id_tutor")
    @ManyToOne
    private Tutor idTutor;
    @OneToMany(mappedBy = "idClase")
    private Collection<ListaAsistencia> listaAsistenciaCollection;
    @OneToMany(mappedBy = "idClase")
    private Collection<Resenias> reseniasCollection;
    @OneToMany(mappedBy = "idClase")
    private Collection<CarritoCompras> carritoComprasCollection;
    @OneToMany(mappedBy = "idClase")
    private Collection<ForoClase> foroClaseCollection;

    public Clase() {
    }


}
