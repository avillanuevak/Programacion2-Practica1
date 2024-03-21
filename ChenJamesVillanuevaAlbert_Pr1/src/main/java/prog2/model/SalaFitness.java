/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;
/**
 *
 * @author Albert Villanueva
 */
public class SalaFitness extends Servei{
    private 
    int numMaquines;
    boolean monitor;
    
    /**
     * Constructor per defecte de la classe SalaFiness
     */
    public SalaFitness(){}
    
    /**
     * Constructor de la classe SalaFitness amb paràmetres
     * @param nom
     * @param idServei
     * @param numMaquines
     * @param monitor 
     */
    public SalaFitness(String nom, String idServei, int numMaquines, boolean monitor){
        super(nom, idServei);
        this.numMaquines = numMaquines;
        this.monitor = monitor;
    }
    
    /**
     * Mètodes getters i setters per accedir als atributs de la classe SalaFitness
     * @return 
     */

    public int getNumMaquines() {
        return numMaquines;
    }

    public boolean isMonitor() {
        return monitor;
    }
    
    /**
     * Mètode per mostrar per pantalla un missatge indicant si hi ha un monitor o no.
     * @return 
     */
    public String printMonitor(){
        if(isMonitor()) return "Hi ha un monitor disponible.";
        else return "No hi ha un monitor disponible.";
    }
    
    /**
     * Mètode per comporvar el correcte funcionament d'una sala fitness. Si hi ha més d'una màquina el funcionament és correcte.
     * @return 
     */
    @Override
    public boolean correcteFuncionament() {
        return this.numMaquines > 0;
    }
    
    @Override
    public String toString(){
        return "\nNom: " + getNom() + ". Id del servei: " + getIdServei() + 
                "\nNombre de maquines: " + getNumMaquines() + ". Monitor disponible: " + printMonitor() + "\n";
    }
}
