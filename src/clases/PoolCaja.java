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
 *
 * @author estudiantes
 */
public class PoolCaja extends Observable {
    private static PoolCaja instancia;
    private List<Caja> cajas;
    
    private PoolCaja(){
        cajas = new ArrayList<>();
        for(int i=0; i<3; i++)
            cajas.add(new Caja(i, "Caja: "+i));
        
    }
    
    public static PoolCaja getInstancia(){
        if(instancia == null)
            instancia = new PoolCaja();
        return instancia;
    }
    
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
    
    public void liberarCaja(Caja caja){
        System.out.println("liberando caja "+caja.getNumero());        
        caja.setDisponible(true);
        this.setChanged();
        this.notifyObservers(caja);
    }
    
}
