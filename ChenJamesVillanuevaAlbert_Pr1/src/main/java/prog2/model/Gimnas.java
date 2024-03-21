/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import prog2.vista.ExcepcioReserva;

/**
 *
 * @author Albert Villanueva
 */
public class Gimnas implements InGimnas{
    private
    String nom;
    ArrayList<Servei> llistaServeis = new ArrayList<>();
    ArrayList<Soci> llistaSocis = new ArrayList<>();
    LlistaReserves llistaReserves = new LlistaReserves();
    
    /**
     * Constructors Default i amb nom de la classe Gimnas
    */
    public Gimnas(){}
    
    public Gimnas(String nom){
        this.nom = nom;
    }
    
    public void setServeis(ArrayList<Servei> serveis) {
        this.llistaServeis = serveis;
    }

    public void setSocis(ArrayList<Soci> socis) {
        this.llistaSocis = socis;
    }

    public void setReserves(LlistaReserves reserves) {
        this.llistaReserves = reserves;
    }
    
    /**
     * Metode que retrona el nom del gimnas
     * @return
     */
    @Override
    public String getNom(){
        return nom;
    }
    
    /**
     * Metode que retorna el numero total de serveis del gimnas
     * @return
     */
    @Override
    public int getNumServeis(){
        return llistaServeis.size();
    } 
    /**
     * Crea un nou objecte de tipus Soci amb la informació necessària rebuda com a paràmetres i l’afegeix a la llista de socis.
     * @param nom
     * @param dni
     */
    @Override
    public void afegirSoci(String nom, String dni) {
        Soci soci = new Soci(nom, dni);
        boolean sociExisteix = false;
        
        Iterator<Soci> it = llistaSocis.iterator();
        if (llistaSocis.isEmpty()) llistaSocis.add(soci);
        else {
            while(it.hasNext()) {
                if (it.next().getNom().equals(nom)) {
                    sociExisteix = true;
                    break;
                }
            }
            if (!sociExisteix) llistaSocis.add(soci);
            else System.out.println("Error: Aquest soci ja existeix\n");
        }
    }
     
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
    @Override
    public void afegirPistaTenis(String nom, String idServei, boolean iluminada, String tipusTanca, float mida, String tipusSuperficie, String tipusXarxa) {
        boolean tenisExisteix = false;
        
        for (Servei currentServei: llistaServeis) {
            if (currentServei.getIdServei().equals(idServei)) {
                tenisExisteix = true;
                break;
            }
        }
        
        if (tenisExisteix) System.out.println("Error: La pista de tennis amb nom " + nom + " i amb ID " + idServei + " ja existeix.\n");
        else {
            PistaTenis pTenis = new PistaTenis(nom, idServei, iluminada, tipusTanca, mida, tipusSuperficie, tipusXarxa);
            llistaServeis.add(pTenis);
            pTenis.setTempsSlotReserva(60);
        }
    }
    
    /**
     * Crea una pista de futbol amb la informació necessària rebuda com a paràmetres i l’afegeix a la llista de serveis.
     * @param tipusPorteries
     * @param iluminada
     * @param numPorteries
     * @param tipusTanca
     * @param mida
     * @param nom
     * @param idServei 
     */
    @Override
    public void afegirPistaFutbol(String nom, String idServei, boolean iluminada, String tipusTanca, float mida, String tipusPorteries, int numPorteries) {
        boolean futbolExisteix = false;
        
        for (Servei s: llistaServeis) {
            if (s.getIdServei().equals(idServei)) {
                futbolExisteix = true;
                break;
            }
        }
        if (futbolExisteix) System.out.println(nom + " amb ID " + idServei + " ja existeix.\n");
        else {
            PistaFutbol pFutbol = new PistaFutbol(nom, idServei, mida, tipusTanca, iluminada, tipusPorteries, numPorteries);
            llistaServeis.add(pFutbol);
            pFutbol.setTempsSlotReserva(90);
        }
    }
 
    /**
     * Crea una sala de fitness amb la informació necessària rebuda com a paràmetres i l’afegeix a la llista de serveis.
     * @param numMaquines
     * @param monitor
     * @param nom
     * @param idServei 
     */
    @Override
    public void afegirSalaFitness(String nom, String idServei, int numMaquines, boolean monitor) {
        boolean fitnessExisteix = false;
        
        for (Servei s: llistaServeis) {
            if (s.getIdServei().equals(idServei)) {
                fitnessExisteix = true;
                break;
            }
        }
        if (fitnessExisteix) System.out.println("Error: La sala de fitness amb nom " + nom + " amb ID " + idServei + " ja existeix.\n");
        else {
            SalaFitness salaFitness = new SalaFitness(nom, idServei, numMaquines, monitor);
            llistaServeis.add(salaFitness);
            salaFitness.setTempsSlotReserva(60);
        }
    }
    
     /**
      * Cerca el soci que vol fer la reserva i el servei que es vol reservar amb la informació necessària rebuda com a paràmetres i invoca al mètode afegirReserva de la classe LlistaReserves que crearà la reserva, si es pot, i la afegirà a la llista de reserves.
      * @param idServei
      * @param dni
      * @param data
      * @throws ExcepcioReserva 
      */
    @Override
    public void afegirReserva(String idServei, String dni, LocalDateTime data) throws ExcepcioReserva {
        Servei servei = buscarServei(idServei);
        Soci soci = buscarSoci(dni);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        
        if (servei == null) throw new ExcepcioReserva("Error: Servei no trobat\n");
        if (soci == null) throw new ExcepcioReserva("Error: Soci no trobat\n");

  
        if (servei != null && soci != null) {
            String formattedDataTime = data.plusMinutes(servei.getTempsSlotReserva()).format(formatter);
            String formattedDataTimeInicio = data.format(formatter);  Reserva reserva = new Reserva(servei, soci, data);              
            llistaReserves.afegirReserva(servei,soci,data);
            System.out.println("Reserva exitosa pel soci: " + soci + "\nServei: " + servei + "Inici: " + formattedDataTimeInicio
                                + ", fi: " + formattedDataTime + ".\n");
        }
    }
    
    /**
     * Suma la mida de totes les pistes disponibles al gimnàs i retorna el valor.
     * @return 
     */
    @Override
    public float calculMidaTotalPistes(){
        float midaTotal = 0;
        for(Servei servei : llistaServeis){
            if(servei instanceof Pista){ 
                Pista pista = (Pista) servei;
                midaTotal += pista.getMida();
            }
        }
        return midaTotal;
    }
    
    /**
     * Recorre la llista de serveis comprovant el correcte funcionament de cadascun d'ells per contar el número de serveis que estan operatius i retornar el valor.
     * @return 
     */
    @Override
    public int calculServeisOperatius() {
        int serveisOperatius = 0;
        Iterator<Servei> it = llistaServeis.iterator();
        if (llistaServeis.isEmpty()) System.out.println("Llista de serveis buida\n");
        else {
            while(it.hasNext()) {
                if (it.next().correcteFuncionament()) ++serveisOperatius;
            }  
        }
        return serveisOperatius;
    }
    /**
     * Mètode de tipus Servei que retorna el servei passat un identificador com a paràmetre
     * @param idServei
     * @return 
     */
    public Servei buscarServei(String idServei) {
        Servei servei = null;

        for (Servei currentServei : llistaServeis) {
            if (currentServei.getIdServei().equals(idServei)) {
                servei = currentServei;
                break;
            }
        }
        
        return servei;
    }
    
    /**
     * Mètode de tipus Soci que retorna el soci passat el dni com a paràmetre
     * @param dni
     * @return 
     */
    public Soci buscarSoci(String dni) {
        Soci soci = null;

        for (Soci currentSoci : llistaSocis) {
            if (currentSoci.getDni().equals(dni)) {
                soci = currentSoci;
                break;
            }
        }
        return soci;
    }
}