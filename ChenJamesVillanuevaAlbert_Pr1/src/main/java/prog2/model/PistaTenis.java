/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author Albert Villanueva
 */
public class PistaTenis extends Pista{
    private
    String tipusSuperficie, tipusXarxa;
    
    /**
     * Constructor default de PistaTenis
     */
    public PistaTenis(){}
    
    /**
     * Constructor de PistaTenis amb paràmetres
     * @param nom
     * @param idServei
     * @param iluminada
     * @param tipusTanca
     * @param mida
     * @param tipusSuperficie
     * @param tipusXarxa 
     */
    public PistaTenis(String nom, String idServei, boolean iluminada, String tipusTanca, float mida, String tipusSuperficie, String tipusXarxa){
        super(nom, idServei, mida, tipusTanca, iluminada);
        this.tipusSuperficie = tipusSuperficie;
        this.tipusXarxa = tipusXarxa;
    }
    /**
     * Mètodes getters i setters dels atributs de PistaTenis
     * @return 
     */

    public String getTipusSuperficie() {
        return tipusSuperficie;
    }

    public String getTipusXarxa() {
        return tipusXarxa;
    }
    
    /**
     * Mètode que comprova el correcte funcionament d'una pista de tenis. Es correcte si té xarxa
     * @return 
     */
   @Override
   public boolean correcteFuncionament(){
       return !this.tipusXarxa.equals("Sense");
   }
   @Override public String toString(){
       return "\nNom: " + getNom() + ". Id del servei: " + getIdServei() + "\nMida de la pista: " + getMida() + 
               " metres. Iluminacio: " + printIluminada() + "\nTipus de tanca: " + getTipusTanca() + ". Tipus de superficie: " + getTipusSuperficie() + 
               ". Tipus de xarxa: " + getTipusXarxa() +".\n";
   }
}
