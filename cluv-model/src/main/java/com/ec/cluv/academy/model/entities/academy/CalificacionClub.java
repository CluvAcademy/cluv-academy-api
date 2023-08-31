package com.ec.cluv.academy.model.entities.academy;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "calificacion_club", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
        @NamedQuery(name = "CalificacionClub.findAll", query = "SELECT c FROM CalificacionClub c"),
        @NamedQuery(name = "CalificacionClub.findByIdCalificacionClub", query = "SELECT c FROM CalificacionClub c WHERE c.idCalificacionClub = :idCalificacionClub"),
        @NamedQuery(name = "CalificacionClub.findByValorCalificacionClub", query = "SELECT c FROM CalificacionClub c WHERE c.valorCalificacionClub = :valorCalificacionClub")})
public class CalificacionClub implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calificacion_club")
    private Long idCalificacionClub;
    @Column(name = "valor_calificacion_club")
    private BigInteger valorCalificacionClub;
    @JoinColumn(name = "id_club", referencedColumnName = "id_club")
    @ManyToOne
    private Club idClub;

    public CalificacionClub() {
    }

    public CalificacionClub(Long idCalificacionClub) {
        this.idCalificacionClub = idCalificacionClub;
    }

    public Long getIdCalificacionClub() {
        return idCalificacionClub;
    }

    public void setIdCalificacionClub(Long idCalificacionClub) {
        this.idCalificacionClub = idCalificacionClub;
    }

    public BigInteger getValorCalificacionClub() {
        return valorCalificacionClub;
    }

    public void setValorCalificacionClub(BigInteger valorCalificacionClub) {
        this.valorCalificacionClub = valorCalificacionClub;
    }

    public Club getIdClub() {
        return idClub;
    }

    public void setIdClub(Club idClub) {
        this.idClub = idClub;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalificacionClub != null ? idCalificacionClub.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalificacionClub)) {
            return false;
        }
        CalificacionClub other = (CalificacionClub) object;
        if ((this.idCalificacionClub == null && other.idCalificacionClub != null) || (this.idCalificacionClub != null && !this.idCalificacionClub.equals(other.idCalificacionClub))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.CalificacionClub[ idCalificacionClub=" + idCalificacionClub + " ]";
    }

}

