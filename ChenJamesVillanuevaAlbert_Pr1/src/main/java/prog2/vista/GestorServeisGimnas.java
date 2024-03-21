
package prog2.vista;
import java.time.LocalDateTime;
import java.util.ArrayList;
import prog2.model.*;

/**
 * Classe per gestionar els serveis del gimnàs Club Esportiu Medditerrani.
 * @author lauraigual
 */
public class GestorServeisGimnas {

    /**
     * @param args the command line arguments
     * @throws prog2.vista.ExcepcioReserva
     */
    public static void main(String[] args) throws ExcepcioReserva {
        
        Gimnas clubMediterrani = new Gimnas("Club Esportiu Mediterrani");
        
        ArrayList<Servei> serveis = new ArrayList<>();
        ArrayList<Soci> socis = new ArrayList<>();
        LlistaReserves reserves = new LlistaReserves();
        
        clubMediterrani.setReserves(reserves);
        clubMediterrani.setSocis(socis);
        clubMediterrani.setServeis(serveis);
        
        omplirDadesModel(clubMediterrani);
        
        ferReserves(clubMediterrani);
        
        
        
        
        // Calcular el mida total de les pistes (en M^2) del Gimnàs i mostrar un missatge de la següent manera:
        // >> La mida total de les pistes del gimnàs Club Esportiu Mediterrani és de X m^2
        //--------------------------------------------------------------------------------------------------------------------
        // Per completar:
        System.out.println("La mida total de les pistes del gimnàs Club Esportiu Mediterrani és de " + clubMediterrani.calculMidaTotalPistes() + " m^2.");
        
        // Mostrar el número total de serveis del Gimnàs i el número de serveis que estan operatius amb el següent missatge:
        // >> El número total de serveis del gimnàs és X dels quals X serveis estan operatius.
        //--------------------------------------------------------------------------------------------------
        // Per completar:
        System.out.println("El número total de serveis del gimnàs és " + clubMediterrani.getNumServeis() + " dels quals " + clubMediterrani.calculServeisOperatius() + " serveis estan operatius.");
    }
    
    /**
     * Mètode de classe per afegir pistes de tenis, pistes de futbol, sales de fitness i socis al gimnàs.
     * @param gim L'objecte de tipus Gimnas que anem a omplir 
     */
    private static void omplirDadesModel(Gimnas gim){
        
        
        // Afegir pistes de tenis:
        //------------------------------
           
        
        boolean iluminada = true;
        String tipusTanca = "Metàl·lica";
        float mida = 195.9f; 
        
        String tipusSuperficie = "Asfalt";
        String tipusXarxa = "Fixa";
        
          
        String nom = "Tenis Nord";
        String idServei = "100P";
        
        gim.afegirPistaTenis(nom, idServei, iluminada, tipusTanca, mida, tipusSuperficie, tipusXarxa);
             
        nom = "Tenis Sud";
        idServei = "101P";
        tipusTanca = "Metàl·lica";
        tipusSuperficie = "Terra batuda";
        tipusXarxa = "Ajustable";
        
        gim.afegirPistaTenis(nom, idServei, iluminada, tipusTanca, mida, tipusSuperficie, tipusXarxa);
        
         
        nom = "Pàdel Est";
        idServei = "102P";
        iluminada = false;
        tipusTanca = "Vidre";
        mida = 200f;
        tipusSuperficie = "Herba artificial";
        tipusXarxa = "Sense";
        
        gim.afegirPistaTenis(nom, idServei, iluminada, tipusTanca, mida, tipusSuperficie, tipusXarxa);
        
         
                
        // Afegir pistes de futbol:
        //------------------------------
         
        String tipusPorteria = "Estandard";
        iluminada = true;
        mida = 800f;
        tipusTanca = "Sense";
        int numPorteries = 2;
        nom = "Futbol Nord";
        idServei = "200P";
        
        gim.afegirPistaFutbol(nom, idServei, iluminada, tipusTanca, mida, tipusPorteria, numPorteries);
   
        tipusPorteria = "Petita";
        numPorteries = 3;
        nom = "Futbol Sud";
        idServei = "201P";
        
        gim.afegirPistaFutbol(nom, idServei, iluminada, tipusTanca, mida, tipusPorteria, numPorteries);
   
        mida = 600f;
        iluminada = false;
        tipusTanca = "Metàlica";
        numPorteries = 0;
        nom = "Futbol Est";
        idServei = "202P";
        
        gim.afegirPistaFutbol(nom, idServei, iluminada, tipusTanca, mida, tipusPorteria, numPorteries);
   
                
        // Afegir sales de fitness:
        //------------------------------
      
        int numMaquines = 1;
        boolean monitor = false;
        nom = "Tramuntana";
        idServei = "300S";
        
        gim.afegirSalaFitness(nom, idServei, numMaquines, monitor);
               
       
        monitor = true;
        nom = "Llevant";
        idServei = "301S";
        
        gim.afegirSalaFitness(nom, idServei, numMaquines, monitor);
        
        numMaquines = 2;
        nom = "Ponent";
        idServei = "302S";
      
        gim.afegirSalaFitness(nom, idServei, numMaquines, monitor);
               
        
        // Afegir socis:
        //------------------------------
        
        String nomSoci="Patricia Fernandez";
        String dni="123456X";
        gim.afegirSoci(nomSoci, dni);
        
        nomSoci = "Lluís Plans";
        dni="789101A";
        gim.afegirSoci(nomSoci, dni);
    }
    
    /**
     * Mètode per fer reserves d'espais.
     * @param gim 
     */
    private static void ferReserves(Gimnas gim) throws ExcepcioReserva{
        
        // Per completar:
        
        // 1. Afegeix una reserva pel soci amb DNI "123456X" del servei amb identificador "100P" 
        // amb la data i hora 20 de Febrer del 2024 a 2:30 PM.
        
        // Declarar les variables de tipus String idServei i dni.
        // Assigna els valors corresponents.
        String  idServei = "100P";
        String dni = "123456X";

        // Crear una LocalDateTime per definir la data i hora de la reserva. 
         LocalDateTime dateTime = LocalDateTime.of (2024, 2, 20, 14, 30);       
         
        // Intentar afegir la reserva amb la informació indicada i si no és possible mostrar el missatge d'error.
        try{
            gim.afegirReserva(idServei, dni, dateTime);
        }
        catch (ExcepcioReserva e){
            System.out.println(e.getMessage());
        }
        
        // 2. Afegeix una reserva pel soci amb DNI "789101A" del servei amb identificador "100P" 
        // amb la data i hora 20 de Febrer del 2024 a 3:15 PM.
        
        // Assigna els nous valors a les variables
        idServei = "100P";
        dni = "789101A";
        dateTime = LocalDateTime.of(2024, 2, 20, 15, 15);
        // Intentar afegir la reserva amb la informació indicada i si no és possible mostrar el missatge d'error.
        try{
            gim.afegirReserva(idServei, dni, dateTime);
        }
        catch (ExcepcioReserva e){
            System.out.println(e.getMessage());
        }
           
        // 3. Afegeix una reserva pel soci amb DNI "789101A" del servei amb identificador "300S" 
        // amb la data i hora 25 de Febrer del 2024 a 10:00 AM.
        
        // Assigna els nous valors a les variables.    
        idServei = "300S";
        dni = "789101A";
        dateTime = LocalDateTime.of(2024, 2, 25, 10, 0);
        // Intentar afegir la reserva amb la informació indicada i si no és possible mostrar el missatge d'error.
        try{
            gim.afegirReserva(idServei, dni, dateTime);
        }
        catch (ExcepcioReserva e){
            System.out.println(e.getMessage());
        }
    }
}
