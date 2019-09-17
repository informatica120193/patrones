/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author estudiantes
 */
public class FachadaTransaccion {
    private ManejadorTransaccion retiro; 
    
    public void realizarTransaccion(String transaccion) throws Exception {
        retiro = new Retiro();
        retiro.realizarTransaccion(transaccion);
    }
}
