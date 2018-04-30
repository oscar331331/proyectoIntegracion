/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalendario.dto;

import proyectocalendario.entitys.Profesor;

/**
 *
 * @author Vito
 */
public class profesorDTO {
    private int id_profesor;
    private String nombre_profesor;
    private String apellido_profesor;
    private String correo_profesor;
    private String usuario_profesor;
    private String password_profesor;

    public profesorDTO(int id_profesor, String nombre_profesor, String apellido_profesor, String correo_profesor, String usuario_profesor, String password_profesor) {
        this.id_profesor = id_profesor;
        this.nombre_profesor = nombre_profesor;
        this.apellido_profesor = apellido_profesor;
        this.correo_profesor = correo_profesor;
        this.usuario_profesor = usuario_profesor;
        this.password_profesor = password_profesor;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombre_profesor() {
        return nombre_profesor;
    }

    public void setNombre_profesor(String nombre_profesor) {
        this.nombre_profesor = nombre_profesor;
    }

    public String getApellido_profesor() {
        return apellido_profesor;
    }

    public void setApellido_profesor(String apellido_profesor) {
        this.apellido_profesor = apellido_profesor;
    }

    public String getCorreo_profesor() {
        return correo_profesor;
    }

    public void setCorreo_profesor(String correo_profesor) {
        this.correo_profesor = correo_profesor;
    }

    public String getUsuario_profesor() {
        return usuario_profesor;
    }

    public void setUsuario_profesor(String usuario_profesor) {
        this.usuario_profesor = usuario_profesor;
    }

    public String getPassword_profesor() {
        return password_profesor;
    }

    public void setPassword_profesor(String password_profesor) {
        this.password_profesor = password_profesor;
    }
    
    
    
}
