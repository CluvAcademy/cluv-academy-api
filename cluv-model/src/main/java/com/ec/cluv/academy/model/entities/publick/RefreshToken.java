package com.ec.cluv.academy.model.entities.publick;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.Instant;

@Entity
@Table(name = "refresh_token", catalog = "cluvacademy", schema = "public")
@XmlRootElement
@SequenceGenerator(name = "SEQ_REFRESH_TOKEN", sequenceName = "SEQ_REFRESH_TOKEN", allocationSize = 1)
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario user;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expira;

    public RefreshToken() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getExpira() {
        return expira;
    }

    public void setExpira(Instant expira) {
        this.expira = expira;
    }
}
