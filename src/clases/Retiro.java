/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudiantes
 */
public class Retiro extends ManejadorTransaccion{
    
    @Override
    public void realizarTransaccion(String transaccion) throws Exception{
        if ("1".equals(transaccion)) {
           Caja caja = this.getPoolCaja().obtenerCaja();
           if (caja == null) {
               this.getPoolCaja().addObserver(this);
           } else {
               
               Thread t1 = new Thread(realizarOperacion(caja));
               t1.sleep(1500);
               t1.start();
           }
        } else {
            this.setSucesor(new Consignacion());
            this.getSucesor().realizarTransaccion(transaccion);
        }
    }

    /**
     * Se encarga de realizar la transaccion una vez sea notificado que la caja se ha liberado
     * @param o
     * @param arg
     */

    @Override
    public void update(Observable o, Object arg) {
        try {
            realizarOperacion((Caja) arg);
        } catch (Exception ex) {
            Logger.getLogger(Retiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * Retorna un runnable para ejecutar la transaccion en un hilo aparte del hilo principal
     * @param caja
     * @return
     * @throws Exception
     */
    private Runnable realizarOperacion(Caja caja)  throws Exception {
           
        return () -> {
            this.getPoolCaja().liberarCaja(caja);
        };
    }
    
}
