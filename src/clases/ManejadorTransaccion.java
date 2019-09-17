/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Observer;

/**
 *
 * @author estudiantes
 */
public abstract class ManejadorTransaccion implements Observer{
  
    private ManejadorTransaccion sucesor;
    abstract void realizarTransaccion(String transaccion) throws Exception;

    public ManejadorTransaccion getSucesor() {
        return sucesor;
    }

    public void setSucesor(ManejadorTransaccion sucesor) {
        this.sucesor = sucesor;
    }

    public PoolCaja getPoolCaja() {
        return PoolCaja.getInstancia();
    }
    
}
