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
import proyectocalendario.dto.alumnoDTO;
import proyectocalendario.entitys.Alumno;

/**
 *
 * @author Vito
 */
@Stateless
public class AlumnoSessionBean {

    @PersistenceContext(unitName = "CalendarioDuocPU")
    private EntityManager em;
    
    public alumnoDTO alumnoValidaLogin(String login, String pass){
       alumnoDTO infoClienteComunaDTO=null;
        try{
            infoClienteComunaDTO=em.createNamedQuery("Alumno.validar",alumnoDTO.class)
                    .setParameter("usuario_alumno",login)
                    .setParameter("password_alumno",pass)
                    .getSingleResult();
        }catch(NoResultException ex){
            return null;
        }catch(NonUniqueResultException ex){
            throw ex;
        }
        return infoClienteComunaDTO;                
    }
    
    public void addAlumno(alumnoDTO alumnoDTO) throws ControladorExceptions{
        Alumno infoAlumno= new Alumno();
        infoAlumno.setNombreAlumno(alumnoDTO.getNombre_alumno());
        infoAlumno.setApellidoAlumno(alumnoDTO.getApellido_alumno());
        infoAlumno.setCorreoAlumno(alumnoDTO.getCorreo_alumno());
        infoAlumno.setUsuarioAlumno(alumnoDTO.getUsuario_alumno());
        infoAlumno.setPasswordAlumno(alumnoDTO.getPassword_alumno());
             
            
        
        em.persist(infoAlumno);
    }
    
    public List<Alumno>getAllAlumno(){
        return em.createNamedQuery("Alumno.findAll",Alumno.class)
                .getResultList();
    }
    
    
    public void deleteAlumno(int codigoAlumno) throws ControladorExceptions {
        Alumno productoEntity = em.find(Alumno.class, codigoAlumno);
        em.flush();
        List<Alumno> listadoAlumno=this.getAllAlumno();
        for (Alumno producto : listadoAlumno) {
            if(producto.getIdAlumno().equals(codigoAlumno))
            em.remove(producto);
        }
        em.flush();
    }
    
    public Alumno buscaAlumnoXCodigo(int codigo) {
        Alumno infoAlumnoEntidad = null;
        try {
            infoAlumnoEntidad = em.createNamedQuery("Alumno.findByIdAlumno", Alumno.class)
                    .setParameter("idAlumno", codigo)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            throw ex;
        }
        return infoAlumnoEntidad;
    }
    
     public void updateAlumno(Alumno infoAlumno) throws ControladorExceptions {
        em.merge(infoAlumno);
    }
}
