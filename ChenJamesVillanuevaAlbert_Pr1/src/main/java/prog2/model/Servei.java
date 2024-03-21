/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;
/**
 *
 * @author James Chen
 */
public abstract class Servei implements InServeiReservable{
    private 
    String nom, idServei;
    long tempsSlotReserva;
    
    /**
     * Constructor per defecte
     */
    public Servei(){}
    /**
     * Constructor de la classe Servei amb pàrametres
     * @param nom
     * @param idServei
     */
    public Servei(String nom, String idServei){
        this.nom = nom;
        this.idServei = idServei;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdServei() {
        return idServei;
    }

    public void setIdServei(String idServei) {
        this.idServei = idServei;
    }
    
    @Override
    public long getTempsSlotReserva() {
        return tempsSlotReserva;
    }
    @Override
    public void setTempsSlotReserva(long tempsSlotReserva) {
        this.tempsSlotReserva = tempsSlotReserva;
    }
    
    @Override
    public String toString(){
        return "Servei amb el nom " + nom + " amb el ID " + idServei + " amb el temps de reserva " + tempsSlotReserva;
    }
}
