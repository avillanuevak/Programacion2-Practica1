/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import prog2.vista.ExcepcioReserva;

/**
 *
 * @author James Chen
 */
public class LlistaReserves implements InLlistaReserves {

    private LocalDateTime dataInici;
    protected ArrayList<Reserva> reserves = new ArrayList<>();

    public LlistaReserves() {
    }

    public LlistaReserves(ArrayList<Reserva> reserves) {
        this.reserves = reserves;
    }

    public ArrayList<Reserva> getReserves() {
        return reserves;
    }

    public void setReserves(ArrayList<Reserva> reserves) {
        this.reserves = reserves;
    }

    public LocalDateTime dataInici() {
        return dataInici;
    }

    public void setDataInici(LocalDateTime dataInici) {
        this.dataInici = dataInici;
    }

    @Override
    public void afegirReserva(Servei servei, Soci soci, LocalDateTime data) throws ExcepcioReserva {
        Reserva newReserva = new Reserva(servei, soci, data);
        LocalDateTime horaFinal = newReserva.getDataHoraFi();
        boolean horaLliure = true;
        boolean correcteFuncionament = servei.correcteFuncionament();
        
        if (reserves.isEmpty() && correcteFuncionament){
            reserves.add(newReserva);
        }
        else if (correcteFuncionament){
            for (Reserva currentReserva : reserves) {
                // Si existeix una reserva per un servei concret i el seu temps reservat solapa amb la nova reserva, el servei no està disponible.
                if (currentReserva.getServei().getIdServei().equals(servei.getIdServei())) { 
                    if (data.isAfter(currentReserva.getDataHoraInici()) && data.isBefore(currentReserva.getDataHoraFi()) ||
                        horaFinal.isAfter(currentReserva.getDataHoraInici()) && horaFinal.isBefore(currentReserva.getDataHoraFi())) {
                        horaLliure = false; break;
                    }
                }
            }
        }
        if (horaLliure && correcteFuncionament) {
            reserves.add(newReserva);
        } 
        else {
            throw new ExcepcioReserva("El servei amb identificador " + servei.getIdServei() + " no esta disponible en la data demanada " + data + " pel soci " + soci.getNom() + " amb DNI: " + soci.getDni() + ".");
        }
    }

    /**
     * Mètode que comprova la disponibilitat d'un servei
     * @param servei
     * @param soci
     * @param data
     * @return 
     */
    public boolean serveiDisponible(Servei servei, Soci soci, LocalDateTime data) {

        for (Reserva it : reserves) {
            if (it.getData().isBefore(data) && it.getData().isAfter(data.plusMinutes(servei.getTempsSlotReserva()))) {
                return true;
            }
        }
        return false;
    }
}
