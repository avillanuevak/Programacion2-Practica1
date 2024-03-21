/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;
import java.time.LocalDateTime;

/**
 *
 * @author Albert Villanueva
 */
public class Reserva{
    private 
    Servei servei;
    Soci soci;
    LocalDateTime data;
    
    /**
     * Constructor default reserva
     */
    public Reserva(){}
    
        /**
     * Constructor con parámetros reserva
     * @param servei
     * @param soci
     * @param data
     */
    public Reserva(Servei servei, Soci soci, LocalDateTime data){
        this.servei = servei;
        this.soci = soci;
        this.data = data;
    }
    /*
    * Getters per la data i hora d'inici i fi de la reserva
    * @return data i hora d'inici de la reserva
    */ 
    public Servei getServei() {
        return servei;
    }

    public Soci getSoci() {
        return soci;
    }

    public LocalDateTime getDataHoraInici() {
        return this.data;
    }

    public LocalDateTime getDataHoraFi() {
        return data.plusMinutes(servei.getTempsSlotReserva());
    }
    
    public long getDurada() {
        return servei.getTempsSlotReserva();
    }
    public LocalDateTime getData() {
        return data;
    }

    /**
     * Mètode toString per mostrar les dades d'una reserva
     * @return 
     */
    @Override
    public String toString(){
        return "\nServei: " + getServei() + " pel soci: " + getSoci() + "\nInici de la reserva: " + getDataHoraInici() + 
                ", fi de la reserva: " + getDataHoraFi() + ". Durada de la reserva: " + getDurada();
    }
}
