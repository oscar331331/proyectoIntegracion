/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalendario.dto;

import java.util.Date;

/**
 *
 * @author Vito
 */
public class eventoDTO {
    private int id_evento;
    private String nombre_evento;
    private String descripcion_evento;
    private String sala_evento;
    private String fecha_evento;
    private String url_evento;
    private String id_seccion;

    public eventoDTO(int id_evento, String nombre_evento, String descripcion_evento, String sala_evento, String fecha_evento, String url_evento, String id_seccion) {
        this.id_evento = id_evento;
        this.nombre_evento = nombre_evento;
        this.descripcion_evento = descripcion_evento;
        this.sala_evento = sala_evento;
        this.fecha_evento = fecha_evento;
        this.url_evento = url_evento;
        this.id_seccion = id_seccion;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getNombre_evento() {
        return nombre_evento;
    }

    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }

    public String getDescripcion_evento() {
        return descripcion_evento;
    }

    public void setDescripcion_evento(String descripcion_evento) {
        this.descripcion_evento = descripcion_evento;
    }

    public String getSala_evento() {
        return sala_evento;
    }

    public void setSala_evento(String sala_evento) {
        this.sala_evento = sala_evento;
    }

    public String getFecha_evento() {
        return fecha_evento;
    }

    public void setFecha_evento(String fecha_evento) {
        this.fecha_evento = fecha_evento;
    }

    public String getUrl_evento() {
        return url_evento;
    }

    public void setUrl_evento(String url_evento) {
        this.url_evento = url_evento;
    }

    public String getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(String id_seccion) {
        this.id_seccion = id_seccion;
    }

    
}
