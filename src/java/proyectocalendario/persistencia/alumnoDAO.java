/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalendario.persistencia;

import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import proyectocalendario.entitys.Alumno;

/**
 *
 * @author Vito
 */
public class alumnoDAO {
    @PersistenceContext
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
       public List<Alumno> getAllAlumnos(){
           return em.createNamedQuery("Alumno.findAll",Alumno.class)
                   .getResultList();
       }
       
    public Alumno buscaAlumnoId(int id_alumno){
        Alumno infoAlumno = null;
        try{
            infoAlumno=em.createNamedQuery("Alumno.findByIdAlumno",Alumno.class)
                    .setParameter("idAlumno", id_alumno)
                    .getSingleResult();
        }catch(NoResultException ex){
            infoAlumno=null;
            
        }catch(NonUniqueResultException ex){
            throw ex;
        }
         return infoAlumno;      
    }
    
    public void addAlumno(Alumno infoAlumno) throws AlumnoException{
       em.persist(infoAlumno);
    }
    
    public void updateAlumno(Alumno infoAlumno) throws AlumnoException{
        em.merge(infoAlumno);
    }
    
    public void deleteAlumno(int id_alumno) throws AlumnoException{
        Alumno infoALumno=buscaAlumnoId(id_alumno);
        em.remove(infoALumno);
    }
}
