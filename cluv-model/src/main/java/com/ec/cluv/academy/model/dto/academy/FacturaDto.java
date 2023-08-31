/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.dto.academy;

import com.ec.cluv.academy.model.entities.academy.CarritoCompras;
import com.ec.cluv.academy.model.entities.academy.EstadoFactura;
import com.ec.cluv.academy.model.entities.academy.Pagos;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author PC
 */
@Data
@AllArgsConstructor
public class FacturaDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idFactura;
    private String dniFactura;
    private String direccionFactura;
    private String nombreFactura;
    private String telefonoFactura;
    private Double subtotalFactura;
    private Double ivaFactura;
    private Double descuentoFactura;
    private Double recargoFactura;
    private Double totalFactura;
    private Boolean activoFactura;
    private EstadoFacturaDto idEstadoFacturaDto;
    private Collection<PagosDto> pagosCollectionDto;
    private Collection<CarritoComprasDto> carritoComprasCollectionDto;

    public FacturaDto() {
    }

}
