package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "tipos_logros", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
        @NamedQuery(name = "TiposLogros.findAll", query = "SELECT t FROM TiposLogros t"),
        @NamedQuery(name = "TiposLogros.findByIdTipoLogro", query = "SELECT t FROM TiposLogros t WHERE t.idTipoLogro = :idTipoLogro"),
        @NamedQuery(name = "TiposLogros.findByNombreTipoLogro", query = "SELECT t FROM TiposLogros t WHERE t.nombreTipoLogro = :nombreTipoLogro"),
        @NamedQuery(name = "TiposLogros.findByDescripcionTipoLogro", query = "SELECT t FROM TiposLogros t WHERE t.descripcionTipoLogro = :descripcionTipoLogro"),
        @NamedQuery(name = "TiposLogros.findByActivoTipoLogro", query = "SELECT t FROM TiposLogros t WHERE t.activoTipoLogro = :activoTipoLogro")})
public class TiposLogros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_logro")
    private Long idTipoLogro;
    @Column(name = "nombre_tipo_logro")
    private String nombreTipoLogro;
    @Column(name = "descripcion_tipo_logro")
    private String descripcionTipoLogro;
    @Column(name = "activo_tipo_logro")
    private Boolean activoTipoLogro;
    @OneToMany(mappedBy = "idTipoLogro")
    private Collection<Logros> logrosCollection;

    public TiposLogros() {
    }
}
