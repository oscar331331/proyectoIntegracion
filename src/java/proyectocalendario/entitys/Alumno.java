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
@Table(name = "alumno", catalog = "bd_calendario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a"),
    @NamedQuery(name = "Alumno.findByIdAlumno", query = "SELECT a FROM Alumno a WHERE a.idAlumno = :idAlumno"),
    @NamedQuery(name = "Alumno.findByNombreAlumno", query = "SELECT a FROM Alumno a WHERE a.nombreAlumno = :nombreAlumno"),
    @NamedQuery(name = "Alumno.findByApellidoAlumno", query = "SELECT a FROM Alumno a WHERE a.apellidoAlumno = :apellidoAlumno"),
    @NamedQuery(name = "Alumno.findByCorreoAlumno", query = "SELECT a FROM Alumno a WHERE a.correoAlumno = :correoAlumno"),
    @NamedQuery(name = "Alumno.findByUsuarioAlumno", query = "SELECT a FROM Alumno a WHERE a.usuarioAlumno = :usuarioAlumno"),
    @NamedQuery(name = "Alumno.findByPasswordAlumno", query = "SELECT a FROM Alumno a WHERE a.passwordAlumno = :passwordAlumno")})
public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_alumno", nullable = false)
    private Integer idAlumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "nombre_alumno", nullable = false, length = 32)
    private String nombreAlumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "apellido_alumno", nullable = false, length = 32)
    private String apellidoAlumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "correo_alumno", nullable = false, length = 32)
    private String correoAlumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "usuario_alumno", nullable = false, length = 32)
    private String usuarioAlumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "password_alumno", nullable = false, length = 32)
    private String passwordAlumno;

    public Alumno() {
    }

    public Alumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Alumno(Integer idAlumno, String nombreAlumno, String apellidoAlumno, String correoAlumno, String usuarioAlumno, String passwordAlumno) {
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.correoAlumno = correoAlumno;
        this.usuarioAlumno = usuarioAlumno;
        this.passwordAlumno = passwordAlumno;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }

    public String getCorreoAlumno() {
        return correoAlumno;
    }

    public void setCorreoAlumno(String correoAlumno) {
        this.correoAlumno = correoAlumno;
    }

    public String getUsuarioAlumno() {
        return usuarioAlumno;
    }

    public void setUsuarioAlumno(String usuarioAlumno) {
        this.usuarioAlumno = usuarioAlumno;
    }

    public String getPasswordAlumno() {
        return passwordAlumno;
    }

    public void setPasswordAlumno(String passwordAlumno) {
        this.passwordAlumno = passwordAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlumno != null ? idAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idAlumno == null && other.idAlumno != null) || (this.idAlumno != null && !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectocalendario.entitys.Alumno[ idAlumno=" + idAlumno + " ]";
    }
    
}
