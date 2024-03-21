package prog2.model;

import java.time.LocalDateTime;
import prog2.vista.ExcepcioReserva;

/**
 * Interfície per definir la forma del Gimnàs
 * @author lauraigual
 */
public interface InGimnas {
    /**
     * Retorna el nom del gimnàs.
     * @return 
     */
    public String getNom();
     
    /**
     * Retorna el número de serveis total del gimnàs.
     * @return 
     */
    public int getNumServeis();
    
    /**
     * Crea un nou objecte de tipus Soci amb la informació necessària rebuda com a paràmetres i l’afegeix a la llista de socis.
     * @param nom
     * @param dni
     */
    public void afegirSoci(String nom, String dni);
     
    /**
     * Crea una pista de tenis amb la informació necessària rebuda com a paràmetres i l’afegeix a la llista de serveis.
     * @param tipusSuperficie
     * @param iluminada
     * @param tipusTanca
     * @param tipusXarxa
     * @param mida
     * @param nom
     * @param idServei 
     */

    public void afegirPistaTenis(String nom, String idServei, boolean iluminada, String tipusTanca, float mida, String tipusSuperficie, String tipusXarxa);
    
    /**
     * Crea una pista de futbol amb la informació necessària rebuda com a paràmetres i l’afegeix a la llista de serveis.
     * @param tipusPorteries_
     * @param iluminada
     * @param numPorteries_
     * @param tipusTanca
     * @param mida
     * @param nom
     * @param idServei 
     */
    public void afegirPistaFutbol(String nom, String idServei, boolean iluminada, String tipusTanca, float mida, String tipusPorteries_, int numPorteries_);
 
    /**
     * Crea una sala de fitness amb la informació necessària rebuda com a paràmetres i l’afegeix a la llista de serveis.
     * @param numMaquines
     * @param monitor
     * @param nom
     * @param idServei 
     */
    public void afegirSalaFitness(String nom, String idServei, int numMaquines, boolean monitor);
    
    
    
     /**
      * Cerca el soci que vol fer la reserva i el servei que es vol reservar amb la informació necessària rebuda com a paràmetres i invoca al mètode afegirReserva de la classe LlistaReserves que crearà la reserva, si es pot, i la afegirà a la llista de reserves.
      * @param idServei
      * @param dni
      * @param data
      * @throws ExcepcioReserva 
      */
    public void afegirReserva(String idServei, String dni, LocalDateTime data) throws ExcepcioReserva;
    
    
    
    /**
     * Suma la mida de totes les pistes disponibles al gimnàs i retorna el valor.
     * @return 
     */
    public float calculMidaTotalPistes();

    
    /**
     * Recorre la llista de serveis comprovant el correcte funcionament de cadascun d'ells per contar el número de serveis que estan operatius i retornar el valor.
     * @return 
     */
    public int calculServeisOperatius();
}