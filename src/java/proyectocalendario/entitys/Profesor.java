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
@Table(name = "profesor", catalog = "bd_calendario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(
            name="Profesor.validar",
            query="SELECT NEW proyectocalendario.dto.profesorDTO(p.idProfesor,p.nombreProfesor,p.apellidoProfesor,p.correoProfesor,p.usuarioProfesor,p.passwordProfesor)"
            +" FROM Profesor p where p.usuarioProfesor = :usuario_profesor and p.passwordProfesor = :password_profesor"
    ),
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByIdProfesor", query = "SELECT p FROM Profesor p WHERE p.idProfesor = :idProfesor"),
    @NamedQuery(name = "Profesor.findByNombreProfesor", query = "SELECT p FROM Profesor p WHERE p.nombreProfesor = :nombreProfesor"),
    @NamedQuery(name = "Profesor.findByApellidoProfesor", query = "SELECT p FROM Profesor p WHERE p.apellidoProfesor = :apellidoProfesor"),
    @NamedQuery(name = "Profesor.findByCorreoProfesor", query = "SELECT p FROM Profesor p WHERE p.correoProfesor = :correoProfesor"),
    @NamedQuery(name = "Profesor.findByUsuarioProfesor", query = "SELECT p FROM Profesor p WHERE p.usuarioProfesor = :usuarioProfesor"),
    @NamedQuery(name = "Profesor.findByPasswordProfesor", query = "SELECT p FROM Profesor p WHERE p.passwordProfesor = :passwordProfesor")})
public class Profesor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_profesor", nullable = false)
    private Integer idProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "nombre_profesor", nullable = false, length = 32)
    private String nombreProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "apellido_profesor", nullable = false, length = 32)
    private String apellidoProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "correo_profesor", nullable = false, length = 32)
    private String correoProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "usuario_profesor", nullable = false, length = 32)
    private String usuarioProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "password_profesor", nullable = false, length = 32)
    private String passwordProfesor;

    public Profesor() {
    }

    public Profesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Profesor(Integer idProfesor, String nombreProfesor, String apellidoProfesor, String correoProfesor, String usuarioProfesor, String passwordProfesor) {
        this.idProfesor = idProfesor;
        this.nombreProfesor = nombreProfesor;
        this.apellidoProfesor = apellidoProfesor;
        this.correoProfesor = correoProfesor;
        this.usuarioProfesor = usuarioProfesor;
        this.passwordProfesor = passwordProfesor;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApellidoProfesor() {
        return apellidoProfesor;
    }

    public void setApellidoProfesor(String apellidoProfesor) {
        this.apellidoProfesor = apellidoProfesor;
    }

    public String getCorreoProfesor() {
        return correoProfesor;
    }

    public void setCorreoProfesor(String correoProfesor) {
        this.correoProfesor = correoProfesor;
    }

    public String getUsuarioProfesor() {
        return usuarioProfesor;
    }

    public void setUsuarioProfesor(String usuarioProfesor) {
        this.usuarioProfesor = usuarioProfesor;
    }

    public String getPasswordProfesor() {
        return passwordProfesor;
    }

    public void setPasswordProfesor(String passwordProfesor) {
        this.passwordProfesor = passwordProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesor != null ? idProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.idProfesor == null && other.idProfesor != null) || (this.idProfesor != null && !this.idProfesor.equals(other.idProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectocalendario.entitys.Profesor[ idProfesor=" + idProfesor + " ]";
    }
    
}
