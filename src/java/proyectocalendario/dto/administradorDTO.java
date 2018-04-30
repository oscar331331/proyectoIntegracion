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
public class administradorDTO {
    private int id_administrador;
    private String nombre_administrador;
    private String usuario_administrador;
    private String password_administrador;

    public administradorDTO(int id_administrador, String nombre_administrador, String usuario_administrador, String password_administrador) {
        this.id_administrador = id_administrador;
        this.nombre_administrador = nombre_administrador;
        this.usuario_administrador = usuario_administrador;
        this.password_administrador = password_administrador;
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getNombre_administrador() {
        return nombre_administrador;
    }

    public void setNombre_administrador(String nombre_administrador) {
        this.nombre_administrador = nombre_administrador;
    }

    public String getUsuario_administrador() {
        return usuario_administrador;
    }

    public void setUsuario_administrador(String usuario_administrador) {
        this.usuario_administrador = usuario_administrador;
    }

    public String getPassword_administrador() {
        return password_administrador;
    }

    public void setPassword_administrador(String password_administrador) {
        this.password_administrador = password_administrador;
    }
    
    
    
}
