/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Observer;

/**
 *
 * Clase abstracta que se encarga de manejar el pool de cajas y las transacciones que pueden realizar,
 * ademas es un observador del pool de cajas al que se le notifica cuando una caja queda liberada
 * @author estudiantes
 */
public abstract class ManejadorTransaccion implements Observer{

    /**
     * Variable para seguir la cadena de responsabilidad
     */
    private ManejadorTransaccion sucesor;

    /**
     * Define si se puede realizar la transaccion, de no ser hace lo pasa al siguiente eslabon de la cadena
     * @param transaccion
     * @throws Exception
     */
    abstract void realizarTransaccion(String transaccion) throws Exception;

    /**
     * Retornara el pool de cajas que usaran la transaccion que son capaces de hacer
     * @return
     */
    public PoolCaja getPoolCaja() {
        return PoolCaja.getInstancia();
    }

    public ManejadorTransaccion getSucesor() {
        return sucesor;
    }

    public void setSucesor(ManejadorTransaccion sucesor) {
        this.sucesor = sucesor;
    }
    
}
