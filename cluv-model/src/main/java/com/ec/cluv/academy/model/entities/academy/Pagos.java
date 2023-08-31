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
@Table(name = "pagos", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p"),
    @NamedQuery(name = "Pagos.findByIdPago", query = "SELECT p FROM Pagos p WHERE p.idPago = :idPago"),
    @NamedQuery(name = "Pagos.findByMontoPago", query = "SELECT p FROM Pagos p WHERE p.montoPago = :montoPago"),
    @NamedQuery(name = "Pagos.findBySaldoPago", query = "SELECT p FROM Pagos p WHERE p.saldoPago = :saldoPago"),
    @NamedQuery(name = "Pagos.findByComprobantePago", query = "SELECT p FROM Pagos p WHERE p.comprobantePago = :comprobantePago"),
    @NamedQuery(name = "Pagos.findByActivoPago", query = "SELECT p FROM Pagos p WHERE p.activoPago = :activoPago")})
public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Long idPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_pago")
    private Double montoPago;
    @Column(name = "saldo_pago")
    private Double saldoPago;
    @Column(name = "comprobante_pago")
    private String comprobantePago;
    @Column(name = "activo_pago")
    private Boolean activoPago;
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura")
    @ManyToOne
    private Factura idFactura;
    @JoinColumn(name = "id_tipo_pago", referencedColumnName = "id_tipo_pago")
    @ManyToOne
    private TipoPago idTipoPago;

    public Pagos() {
    }


}
