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
@Table(name = "seccion", catalog = "bd_calendario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seccion.findAll", query = "SELECT s FROM Seccion s"),
    @NamedQuery(name = "Seccion.findByIdSeccion", query = "SELECT s FROM Seccion s WHERE s.idSeccion = :idSeccion"),
    @NamedQuery(name = "Seccion.findByAbrevSeccion", query = "SELECT s FROM Seccion s WHERE s.abrevSeccion = :abrevSeccion"),
    @NamedQuery(name = "Seccion.findByNombreSeccion", query = "SELECT s FROM Seccion s WHERE s.nombreSeccion = :nombreSeccion"),
    @NamedQuery(name = "Seccion.findByIdProfesor", query = "SELECT s FROM Seccion s WHERE s.idProfesor = :idProfesor")})
public class Seccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_seccion", nullable = false)
    private Integer idSeccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "abrev_seccion", nullable = false, length = 32)
    private String abrevSeccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "nombre_seccion", nullable = false, length = 32)
    private String nombreSeccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_profesor", nullable = false)
    private int idProfesor;

    public Seccion() {
    }

    public Seccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Seccion(Integer idSeccion, String abrevSeccion, String nombreSeccion, int idProfesor) {
        this.idSeccion = idSeccion;
        this.abrevSeccion = abrevSeccion;
        this.nombreSeccion = nombreSeccion;
        this.idProfesor = idProfesor;
    }

    public Integer getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getAbrevSeccion() {
        return abrevSeccion;
    }

    public void setAbrevSeccion(String abrevSeccion) {
        this.abrevSeccion = abrevSeccion;
    }

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeccion != null ? idSeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seccion)) {
            return false;
        }
        Seccion other = (Seccion) object;
        if ((this.idSeccion == null && other.idSeccion != null) || (this.idSeccion != null && !this.idSeccion.equals(other.idSeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectocalendario.entitys.Seccion[ idSeccion=" + idSeccion + " ]";
    }
    
}
