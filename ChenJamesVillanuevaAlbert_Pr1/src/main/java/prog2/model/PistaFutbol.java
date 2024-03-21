/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author James Chen
 */
public class PistaFutbol extends Pista {
    private

    String tipusPorteries;
    int numPorteries;
    
    /**
      * Constructor per defecte de la classe PistaFutbol
     * 
     */
    public PistaFutbol() {}
    
    /**
     * Constructor amb paràmetres de la classe PistaFutbol
     * @param nom
     * @param idServei
     * @param iluminada
     * @param tipusTanca
     * @param mida
     * @param tipusPorteries
     * @param numPorteries 
     */
    public PistaFutbol(String nom, String idServei, float mida, String tipusTanca, boolean iluminada, String tipusPorteries, int numPorteries) {
        super(nom, idServei, mida, tipusTanca, iluminada);
        this.tipusPorteries = tipusPorteries;
        this.numPorteries = numPorteries;
    }

    /**
     * Mètodes getters i setters per accedir als atributs.
     * @return 
     */

    public String getTipusPorteries() {
        return tipusPorteries;
    }

    public int getNumPorteries() {
        return numPorteries;
    }

    /**
     * Mètode per comprovar el correcte funcionament de la pista
     * @return 
     */
    
    @Override
    public boolean correcteFuncionament() {
        return this.numPorteries >= 2;
    }
    
    /**
     * Retorna en format string totes les dades d'una pista de futbol
     * @return 
     */
    @Override
    public String toString(){
        return "Pista Futbol amb: \nNom: " + getNom() + ". Id Servei: " + getIdServei() + "\nIluminacio: " + printIluminada() 
                + ". Tipus de tanca: " + getTipusTanca() + ". Mida: " + getMida() + " metres\nTipus de porteria: " + getTipusPorteries() +
                ". Nombre de porteries: " + getNumPorteries();
    }
}
