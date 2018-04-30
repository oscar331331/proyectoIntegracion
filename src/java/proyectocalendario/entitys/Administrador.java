/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalendario.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vito
 */
@Entity
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(
            name="Administrador.validar",
            query="SELECT NEW proyectocalendario.dto.administradorDTO(a.idAdministrador,a.nombreAdministrador,a.usuarioAdmin,a.passwordAdmin)"
            +" FROM Administrador a where a.usuarioAdmin = :usuario_administrador and a.passwordAdmin = :password_administrador"
    ),
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByIdAdministrador", query = "SELECT a FROM Administrador a WHERE a.idAdministrador = :idAdministrador"),
    @NamedQuery(name = "Administrador.findByNombreAdministrador", query = "SELECT a FROM Administrador a WHERE a.nombreAdministrador = :nombreAdministrador"),
    @NamedQuery(name = "Administrador.findByUsuarioAdmin", query = "SELECT a FROM Administrador a WHERE a.usuarioAdmin = :usuarioAdmin"),
    @NamedQuery(name = "Administrador.findByPasswordAdmin", query = "SELECT a FROM Administrador a WHERE a.passwordAdmin = :passwordAdmin")})
public class Administrador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_administrador")
    private Integer idAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "nombre_administrador")
    private String nombreAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "usuario_admin")
    private String usuarioAdmin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "password_admin")
    private String passwordAdmin;

    public Administrador() {
    }

    public Administrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Administrador(Integer idAdministrador, String nombreAdministrador, String usuarioAdmin, String passwordAdmin) {
        this.idAdministrador = idAdministrador;
        this.nombreAdministrador = nombreAdministrador;
        this.usuarioAdmin = usuarioAdmin;
        this.passwordAdmin = passwordAdmin;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    public String getUsuarioAdmin() {
        return usuarioAdmin;
    }

    public void setUsuarioAdmin(String usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdministrador != null ? idAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.idAdministrador == null && other.idAdministrador != null) || (this.idAdministrador != null && !this.idAdministrador.equals(other.idAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectocalendario.entitys.Administrador[ idAdministrador=" + idAdministrador + " ]";
    }
    
}
