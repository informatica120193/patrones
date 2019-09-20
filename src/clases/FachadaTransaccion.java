/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * Clase encargada de servir como fachada para el acceso al primer eslabon de la cadena de responsabilidad
 * @author estudiantes
 */
public class FachadaTransaccion {
    private ManejadorTransaccion retiro;

    /**
     * Transmite al cliente con su transaccion al primer eslabon de la cadena de responsabilidad
     * @param transaccion
     * @throws Exception
     */
    public void realizarTransaccion(String transaccion) throws Exception {
        retiro = new Retiro();
        retiro.realizarTransaccion(transaccion);
    }
}
