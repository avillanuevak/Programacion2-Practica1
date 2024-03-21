/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package prog2.model;

import java.time.LocalDateTime;
import prog2.vista.ExcepcioReserva;

/**
 *
 * @author lauraigual
 */
public interface InLlistaReserves {
  
    /**
     * Comprova que el servei estigui disponible pel dia i hora indicat. 
     * En cas afirmatiu, crea la reserva i l’afegeix a la llista de reserves del gimnàs. 
     * En cas negatiu, llança una excepció de tipus ExceptionReserva amb el missatge d'error.
     * 
     * @param servei
     * @param soci
     * @param data
     * @throws ExcepcioReserva 
     */
    public void afegirReserva(Servei servei, Soci soci, LocalDateTime data) throws ExcepcioReserva;
    
    
}
