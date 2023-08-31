/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.publick;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "aplicacion", catalog = "cluvacademy", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Aplicacion.findAll", query = "SELECT a FROM Aplicacion a"),
    @NamedQuery(name = "Aplicacion.findByIdAplicacion", query = "SELECT a FROM Aplicacion a WHERE a.idAplicacion = :idAplicacion"),
    @NamedQuery(name = "Aplicacion.findByNombre", query = "SELECT a FROM Aplicacion a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Aplicacion.findByDescripcion", query = "SELECT a FROM Aplicacion a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Aplicacion.findByActivo", query = "SELECT a FROM Aplicacion a WHERE a.activo = :activo"),
    @NamedQuery(name = "Aplicacion.findByUrl", query = "SELECT a FROM Aplicacion a WHERE a.url = :url"),
    @NamedQuery(name = "Aplicacion.findByUrlfoto", query = "SELECT a FROM Aplicacion a WHERE a.urlfoto = :urlfoto"),
    @NamedQuery(name = "Aplicacion.findByUrlfotoinfo", query = "SELECT a FROM Aplicacion a WHERE a.urlfotoinfo = :urlfotoinfo")})
public class Aplicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aplicacion")
    private Integer idAplicacion;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "activo")
    private String activo;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;
    @Column(name = "urlfoto")
    private String urlfoto;
    @Column(name = "urlfotoinfo")
    private String urlfotoinfo;
    @OneToMany(mappedBy = "idAplicacion")
    @JsonBackReference(value = "menuList")
    private List<Menu> menuList;

    public Aplicacion() {
    }

    public Aplicacion(Integer idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public Aplicacion(Integer idAplicacion, String nombre, String descripcion, String activo, String url) {
        this.idAplicacion = idAplicacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
        this.url = url;
    }

    public Integer getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(Integer idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }

    public String getUrlfotoinfo() {
        return urlfotoinfo;
    }

    public void setUrlfotoinfo(String urlfotoinfo) {
        this.urlfotoinfo = urlfotoinfo;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAplicacion != null ? idAplicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aplicacion)) {
            return false;
        }
        Aplicacion other = (Aplicacion) object;
        if ((this.idAplicacion == null && other.idAplicacion != null) || (this.idAplicacion != null && !this.idAplicacion.equals(other.idAplicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Aplicacion[ idAplicacion=" + idAplicacion + " ]";
    }
    
}
