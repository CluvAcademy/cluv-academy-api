/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.publick;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author PC
 */
@Embeddable
public class PerfilUsuarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_perfil")
    private int idPerfil;
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private int idUsuario;

    public PerfilUsuarioPK() {
    }

    public PerfilUsuarioPK(int idPerfil, int idUsuario) {
        this.idPerfil = idPerfil;
        this.idUsuario = idUsuario;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPerfil;
        hash += (int) idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilUsuarioPK)) {
            return false;
        }
        PerfilUsuarioPK other = (PerfilUsuarioPK) object;
        if (this.idPerfil != other.idPerfil) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.PerfilUsuarioPK[ idPerfil=" + idPerfil + ", idUsuario=" + idUsuario + " ]";
    }
    
}
