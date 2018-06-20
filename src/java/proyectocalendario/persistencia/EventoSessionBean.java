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
import proyectocalendario.dto.eventoDTO;
import proyectocalendario.entitys.Evento;


/**
 *
 * @author Vito
 */
@Stateless
public class EventoSessionBean {

    @PersistenceContext(unitName = "CalendarioDuocPU")
    private EntityManager em;
    
    public eventoDTO eventoValidaLogin(String login, String pass){
       eventoDTO infoClienteComunaDTO=null;
        try{
            infoClienteComunaDTO=em.createNamedQuery("Evento.validar",eventoDTO.class)
                    .setParameter("usuario_evento",login)
                    .setParameter("password_evento",pass)
                    .getSingleResult();
        }catch(NoResultException ex){
            return null;
        }catch(NonUniqueResultException ex){
            throw ex;
        }
        return infoClienteComunaDTO;                
    }
    
    public void addEvento(eventoDTO eventoDTO) throws ControladorExceptions{
        Evento infoEvento= new Evento();
        infoEvento.setNombreEvento(eventoDTO.getNombre_evento());
        infoEvento.setDescripcionEvento(eventoDTO.getDescripcion_evento());
        infoEvento.setSalaEvento(eventoDTO.getSala_evento());
        infoEvento.setUrlEvento(eventoDTO.getUrl_evento());
        infoEvento.setIdSeccion(eventoDTO.getId_seccion());
        infoEvento.setFechaEvento(eventoDTO.getFecha_evento());
        em.persist(infoEvento);
    }
    
    public List<Evento>getAllEvento(){
        return em.createNamedQuery("Evento.findAll",Evento.class)
                .getResultList();
    }
    
    
    public void deleteEvento(int codigoEvento) throws ControladorExceptions {
        Evento productoEntity = em.find(Evento.class, codigoEvento);
        em.flush();
        List<Evento> listadoEvento=this.getAllEvento();
        for (Evento producto : listadoEvento) {
            if(producto.getIdEvento().equals(codigoEvento))
            em.remove(producto);
        }
        em.flush();
    }
    
    public Evento buscaEventoXCodigo(int codigo) {
        Evento infoEventoEntidad = null;
        try {
            infoEventoEntidad = em.createNamedQuery("Evento.findByIdEvento", Evento.class)
                    .setParameter("idEvento", codigo)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            throw ex;
        }
        return infoEventoEntidad;
    }
    
     public void updateEvento(Evento infoEvento) throws ControladorExceptions {
        em.merge(infoEvento);
    }
}
