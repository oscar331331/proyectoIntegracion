/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalendario.dto;

import java.io.Serializable;
import proyectocalendario.entitys.Alumno;

/**
 *
 * @author Vito
 */
public class alumnoDTO implements Serializable{
    private int id_alumno;
    private String nombre_alumno;
    private String apellido_alumno;
    private String correo_alumno;
    private String usuario_alumno;
    private String password_alumno;
    
    
    public alumnoDTO(){
    }

    public alumnoDTO(int id_alumno, String nombre_alumno, String apellido_alumno, String correo_alumno, String usuario_alumno, String password_alumno) {
        this.id_alumno = id_alumno;
        this.nombre_alumno = nombre_alumno;
        this.apellido_alumno = apellido_alumno;
        this.correo_alumno = correo_alumno;
        this.usuario_alumno = usuario_alumno;
        this.password_alumno = password_alumno;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getApellido_alumno() {
        return apellido_alumno;
    }

    public void setApellido_alumno(String apellido_alumno) {
        this.apellido_alumno = apellido_alumno;
    }

    public String getCorreo_alumno() {
        return correo_alumno;
    }

    public void setCorreo_alumno(String correo_alumno) {
        this.correo_alumno = correo_alumno;
    }

    public String getUsuario_alumno() {
        return usuario_alumno;
    }

    public void setUsuario_alumno(String usuario_alumno) {
        this.usuario_alumno = usuario_alumno;
    }

    public String getPassword_alumno() {
        return password_alumno;
    }

    public void setPassword_alumno(String password_alumno) {
        this.password_alumno = password_alumno;
    }

    
    
}
    

