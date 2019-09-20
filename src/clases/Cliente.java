/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static java.lang.Integer.max;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author estudiantes
 */
public class Cliente {
    public static void main(String args[]) {
        
       try {
            while (true) {
                //Se crearan clientes y aleatoriamente se seleccionara la transacccion a realizar
                Thread t = new Thread(() -> {
                    try {
                        Random rand = new Random();
                        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
                        FachadaTransaccion fachadaTransaccion = new FachadaTransaccion();
                        fachadaTransaccion.realizarTransaccion(randomNum+"");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                t.sleep(500);
                t.start();
            }
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
