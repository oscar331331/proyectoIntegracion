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
@Table(name = "evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByIdEvento", query = "SELECT e FROM Evento e WHERE e.idEvento = :idEvento"),
    @NamedQuery(name = "Evento.findByNombreEvento", query = "SELECT e FROM Evento e WHERE e.nombreEvento = :nombreEvento"),
    @NamedQuery(name = "Evento.findByDescripcionEvento", query = "SELECT e FROM Evento e WHERE e.descripcionEvento = :descripcionEvento"),
    @NamedQuery(name = "Evento.findBySalaEvento", query = "SELECT e FROM Evento e WHERE e.salaEvento = :salaEvento"),
    @NamedQuery(name = "Evento.findByFechaEvento", query = "SELECT e FROM Evento e WHERE e.fechaEvento = :fechaEvento"),
    @NamedQuery(name = "Evento.findByUrlEvento", query = "SELECT e FROM Evento e WHERE e.urlEvento = :urlEvento"),
    @NamedQuery(name = "Evento.findByIdSeccion", query = "SELECT e FROM Evento e WHERE e.idSeccion = :idSeccion")})
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evento")
    private Integer idEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "nombre_evento")
    private String nombreEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "descripcion_evento")
    private String descripcionEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "sala_evento")
    private String salaEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "fecha_evento")
    private String fechaEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "url_evento")
    private String urlEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id_seccion")
    private String idSeccion;

    public Evento() {
    }

    public Evento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Evento(Integer idEvento, String nombreEvento, String descripcionEvento, String salaEvento, String fechaEvento, String urlEvento, String idSeccion) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.descripcionEvento = descripcionEvento;
        this.salaEvento = salaEvento;
        this.fechaEvento = fechaEvento;
        this.urlEvento = urlEvento;
        this.idSeccion = idSeccion;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public String getSalaEvento() {
        return salaEvento;
    }

    public void setSalaEvento(String salaEvento) {
        this.salaEvento = salaEvento;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getUrlEvento() {
        return urlEvento;
    }

    public void setUrlEvento(String urlEvento) {
        this.urlEvento = urlEvento;
    }

    public String getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(String idSeccion) {
        this.idSeccion = idSeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectocalendario.entitys.Evento[ idEvento=" + idEvento + " ]";
    }
    
}
