/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalendario.dto;

/**
 *
 * @author Vito
 */
public class eventoDTO {
    private int id_evento;
    private String nombre_evento;
    private int id_seccion;

    public eventoDTO(int id_evento, String nombre_evento, int id_seccion) {
        this.id_evento = id_evento;
        this.nombre_evento = nombre_evento;
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

    public int getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(int id_seccion) {
        this.id_seccion = id_seccion;
    }
    
    
    
}
