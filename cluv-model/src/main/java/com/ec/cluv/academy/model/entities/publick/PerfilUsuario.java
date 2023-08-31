/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.publick;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "perfil_usuario", catalog = "cluvacademy", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PerfilUsuario.findAll", query = "SELECT p FROM PerfilUsuario p"),
    @NamedQuery(name = "PerfilUsuario.findByIdPerfil", query = "SELECT p FROM PerfilUsuario p WHERE p.perfilUsuarioPK.idPerfil = :idPerfil"),
    @NamedQuery(name = "PerfilUsuario.findByIdUsuario", query = "SELECT p FROM PerfilUsuario p WHERE p.perfilUsuarioPK.idUsuario = :idUsuario")})
public class PerfilUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilUsuarioPK perfilUsuarioPK;
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Perfil perfil;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Usuario usuario;

    public PerfilUsuario() {
    }

    public PerfilUsuario(PerfilUsuarioPK perfilUsuarioPK) {
        this.perfilUsuarioPK = perfilUsuarioPK;
    }

    public PerfilUsuario(int idPerfil, int idUsuario) {
        this.perfilUsuarioPK = new PerfilUsuarioPK(idPerfil, idUsuario);
    }

    public PerfilUsuarioPK getPerfilUsuarioPK() {
        return perfilUsuarioPK;
    }

    public void setPerfilUsuarioPK(PerfilUsuarioPK perfilUsuarioPK) {
        this.perfilUsuarioPK = perfilUsuarioPK;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilUsuarioPK != null ? perfilUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilUsuario)) {
            return false;
        }
        PerfilUsuario other = (PerfilUsuario) object;
        if ((this.perfilUsuarioPK == null && other.perfilUsuarioPK != null) || (this.perfilUsuarioPK != null && !this.perfilUsuarioPK.equals(other.perfilUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.PerfilUsuario[ perfilUsuarioPK=" + perfilUsuarioPK + " ]";
    }
    
}
