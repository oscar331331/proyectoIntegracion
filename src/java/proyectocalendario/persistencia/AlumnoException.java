/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalendario.persistencia;

import javax.ejb.ApplicationException;

/**
 *
 * @author Vito
 */
@ApplicationException(rollback = true)
class AlumnoException extends Exception {
    public AlumnoException (String message){
        super(message);
    }
    
}
