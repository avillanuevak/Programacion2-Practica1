/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author Albert Villanueva
 */
public class Soci {
    private String nom,dni;
    /**
     * Constructor default
     */
    public Soci(){}
    /**
     * Constructor amb paràmetres
     * @param nom
     * @param dni 
     */
    public Soci(String nom, String dni){
        this.nom = nom;
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    @Override
    public String toString(){
        return "\nNom: " + getNom() + ". Dni: " + getDni();
    }
}
