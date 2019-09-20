/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author estudiantes
 */
public class Transferencia extends ManejadorTransaccion{
    
    @Override
    public void realizarTransaccion(String transaccion) throws Exception {
        if ("3".equals(transaccion)) {
           Caja caja = this.getPoolCaja().obtenerCaja();
           if (caja == null) {
               this.getPoolCaja().addObserver(this);
           } else {
                Thread t1 = new Thread(realizarOperacion(caja));
                t1.sleep(1500);
                t1.start();
           }
        } else {
            JOptionPane.showMessageDialog(null, "Operacion no soportada");
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
            Logger.getLogger(Transferencia.class.getName()).log(Level.SEVERE, null, ex);
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
