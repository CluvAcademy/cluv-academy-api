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
@Table(name = "info_bancaria", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "InfoBancaria.findAll", query = "SELECT i FROM InfoBancaria i"),
    @NamedQuery(name = "InfoBancaria.findByIdInfoBancariaTutor", query = "SELECT i FROM InfoBancaria i WHERE i.idInfoBancariaTutor = :idInfoBancariaTutor"),
    @NamedQuery(name = "InfoBancaria.findByCuentaInfoBancariaTutor", query = "SELECT i FROM InfoBancaria i WHERE i.cuentaInfoBancariaTutor = :cuentaInfoBancariaTutor"),
    @NamedQuery(name = "InfoBancaria.findByTipoInfoBancariaTutor", query = "SELECT i FROM InfoBancaria i WHERE i.tipoInfoBancariaTutor = :tipoInfoBancariaTutor"),
    @NamedQuery(name = "InfoBancaria.findByEntidadInfoBancariaTutor", query = "SELECT i FROM InfoBancaria i WHERE i.entidadInfoBancariaTutor = :entidadInfoBancariaTutor"),
    @NamedQuery(name = "InfoBancaria.findByOtroMetodoInfoBancariaTutor", query = "SELECT i FROM InfoBancaria i WHERE i.otroMetodoInfoBancariaTutor = :otroMetodoInfoBancariaTutor"),
    @NamedQuery(name = "InfoBancaria.findByActivoInfoBancariaTutor", query = "SELECT i FROM InfoBancaria i WHERE i.activoInfoBancariaTutor = :activoInfoBancariaTutor")})
public class InfoBancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_info_bancaria_tutor")
    private Long idInfoBancariaTutor;
    @Column(name = "cuenta_info_bancaria_tutor")
    private String cuentaInfoBancariaTutor;
    @Column(name = "tipo_info_bancaria_tutor")
    private String tipoInfoBancariaTutor;
    @Column(name = "entidad_info_bancaria_tutor")
    private String entidadInfoBancariaTutor;
    @Column(name = "otro_metodo_info_bancaria_tutor")
    private String otroMetodoInfoBancariaTutor;
    @Column(name = "activo_info_bancaria_tutor")
    private Boolean activoInfoBancariaTutor;
    @JoinColumn(name = "id_tutor", referencedColumnName = "id_tutor")
    @ManyToOne
    private Tutor idTutor;

    public InfoBancaria() {
    }


}
