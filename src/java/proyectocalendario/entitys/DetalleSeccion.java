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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vito
 */
@Entity
@Table(name = "detalle_seccion", catalog = "bd_calendario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleSeccion.findAll", query = "SELECT d FROM DetalleSeccion d"),
    @NamedQuery(name = "DetalleSeccion.findByIdDetalle", query = "SELECT d FROM DetalleSeccion d WHERE d.idDetalle = :idDetalle"),
    @NamedQuery(name = "DetalleSeccion.findByIdAlumno", query = "SELECT d FROM DetalleSeccion d WHERE d.idAlumno = :idAlumno"),
    @NamedQuery(name = "DetalleSeccion.findByIdSeccion", query = "SELECT d FROM DetalleSeccion d WHERE d.idSeccion = :idSeccion"),
    @NamedQuery(name = "DetalleSeccion.findByIdEvento", query = "SELECT d FROM DetalleSeccion d WHERE d.idEvento = :idEvento")})
public class DetalleSeccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle", nullable = false)
    private Integer idDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_alumno", nullable = false)
    private int idAlumno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_seccion", nullable = false)
    private int idSeccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_evento", nullable = false)
    private int idEvento;

    public DetalleSeccion() {
    }

    public DetalleSeccion(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public DetalleSeccion(Integer idDetalle, int idAlumno, int idSeccion, int idEvento) {
        this.idDetalle = idDetalle;
        this.idAlumno = idAlumno;
        this.idSeccion = idSeccion;
        this.idEvento = idEvento;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleSeccion)) {
            return false;
        }
        DetalleSeccion other = (DetalleSeccion) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectocalendario.entitys.DetalleSeccion[ idDetalle=" + idDetalle + " ]";
    }
    
}
