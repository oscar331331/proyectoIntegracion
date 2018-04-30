/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalendario.persistencia;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import proyectocalendario.dto.profesorDTO;
import proyectocalendario.entitys.Profesor;

/**
 *
 * @author Vito
 */
@Stateless
public class ProfesorSessionBean {

    @PersistenceContext(unitName = "CalendarioDuocPU")
    private EntityManager em;
    
    public profesorDTO profesorValidaLogin(String login, String pass){
       profesorDTO infoClienteComunaDTO=null;
        try{
            infoClienteComunaDTO=em.createNamedQuery("Profesor.validar",profesorDTO.class)
                    .setParameter("usuario_profesor",login)
                    .setParameter("password_profesor",pass)
                    .getSingleResult();
        }catch(NoResultException ex){
            return null;
        }catch(NonUniqueResultException ex){
            throw ex;
        }
        return infoClienteComunaDTO;                
    }
    
    public void addProfesor(profesorDTO profesorDTO) throws ControladorExceptions{
        Profesor infoProfesor= new Profesor();
        infoProfesor.setNombreProfesor(profesorDTO.getNombre_profesor());
        infoProfesor.setApellidoProfesor(profesorDTO.getApellido_profesor());
        infoProfesor.setCorreoProfesor(profesorDTO.getCorreo_profesor());
        infoProfesor.setUsuarioProfesor(profesorDTO.getUsuario_profesor());
        infoProfesor.setPasswordProfesor(profesorDTO.getPassword_profesor());
             
            
        
        em.persist(infoProfesor);
    }
    
    public List<Profesor>getAllProfesor(){
        return em.createNamedQuery("Profesor.findAll",Profesor.class)
                .getResultList();
    }
    
    
    public void deleteProfesor(int codigoProfesor) throws ControladorExceptions {
        Profesor productoEntity = em.find(Profesor.class, codigoProfesor);
        em.flush();
        List<Profesor> listadoProfesor=this.getAllProfesor();
        for (Profesor producto : listadoProfesor) {
            if(producto.getIdProfesor().equals(codigoProfesor))
            em.remove(producto);
        }
        em.flush();
    }
    
    public Profesor buscaProfesorXCodigo(int codigo) {
        Profesor infoProfesorEntidad = null;
        try {
            infoProfesorEntidad = em.createNamedQuery("Profesor.findByIdProfesor", Profesor.class)
                    .setParameter("idProfesor", codigo)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            throw ex;
        }
        return infoProfesorEntidad;
    }
    
     public void updateProfesor(Profesor infoProfesor) throws ControladorExceptions {
        em.merge(infoProfesor);
    }
}
