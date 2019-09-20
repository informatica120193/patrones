/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import javax.swing.JOptionPane;

/**
 * Clase encargada de definir un pool de cajas como un sigleton
 * y que sea administrada por el manejador de transacciones
 * Esta clase es un observable al que se pueden suscribir los
 * manejadores de transacciones para que sean notificados cuando
 * se libera una caja
 * @author estudiantes
 */
public class PoolCaja extends Observable {
    private static PoolCaja instancia;
    private List<Caja> cajas;

    /**
     * Crea un pool de 3 cajas
     */
    private PoolCaja(){
        cajas = new ArrayList<>();
        for(int i=0; i<3; i++)
            cajas.add(new Caja(i, "Caja: "+i));
        
    }

    /**
     * Retorna un singleton del pool de cajas
     * @return
     */
    public static PoolCaja getInstancia(){
        if(instancia == null)
            instancia = new PoolCaja();
        return instancia;
    }

    /**
     * Retorna una caja disponible del pool
     * @return
     */
    public Caja obtenerCaja(){
        for (Caja caja : cajas) {
             if(caja.isDisponible()){
                System.out.println("asignando caja "+caja.getNumero());
                caja.setDisponible(false);
                return caja;
            }
        }
        return null;
    }

    /**
     * Se encarga de liberar una caja que fue ocupada anteriormente
     * y notificar a los observadores del evento
     * @param caja
     */
    public void liberarCaja(Caja caja){
        System.out.println("liberando caja "+caja.getNumero());        
        caja.setDisponible(true);
        this.setChanged();
        this.notifyObservers(caja);
    }
    
}
