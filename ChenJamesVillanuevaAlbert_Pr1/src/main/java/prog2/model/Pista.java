/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author Albert
 */
public abstract class Pista extends Servei{
    private 
    float mida;
    String tipusTanca;
    boolean iluminada;
    
    
 /**
  * Constructor per defecte de la clase pistes
  */
    
    public Pista () {}
    
    /**
     * Constructor con parámetros de la clase pista
     * @param mida
     * @param tipusTanca
     * @param iluminada 
     */
    
    public Pista (String nom, String idServei, float mida, String tipusTanca, boolean iluminada){
        super(nom, idServei);
        this.mida = mida;
        this.tipusTanca = tipusTanca;
        this.iluminada = iluminada;
    }
    
    /**
     * Metode getter de mida
     * @return 
     */
    public float getMida() {
        return mida;
    }
    
    
    /**
     * Mètode getter de TipusTanca
     * @return 
     */
    public String getTipusTanca() {
        return tipusTanca;
    }
    
    /**
     * Mètode getter per saber si la pista està il·luminada
     * @return 
     */
    public boolean isIluminada() {
        return iluminada;
    }
    /**
     * Mètode que mostra un missatge si la pista esta iluminada o no
     * @return 
     */
    public String printIluminada() {
        if(isIluminada()) return "La pista esta iluminada.";
        else return "La pista no esta iluminada.";
    }
}
