/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalendario.persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import proyectocalendario.dto.administradorDTO;
import proyectocalendario.dto.profesorDTO;
import proyectocalendario.entitys.Profesor;

/**
 *
 * @author Vito
 */
@Stateless
public class AdministradorSessionBean {

    @PersistenceContext(unitName = "CalendarioDuocPU")
    private EntityManager em;
    
    public administradorDTO administradorValidaLogin(String login, String pass){
       administradorDTO infoAdministradorDTO=null;
        try{
            infoAdministradorDTO=em.createNamedQuery("Administrador.validar",administradorDTO.class)
                    .setParameter("usuario_administrador",login)
                    .setParameter("password_administrador",pass)
                    .getSingleResult();
        }catch(NoResultException ex){
            return null;
        }catch(NonUniqueResultException ex){
            throw ex;
        }
        return infoAdministradorDTO;                
    }
    
    
}
