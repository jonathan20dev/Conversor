package org.aluraconversor.logica;

public class ValorNegativo extends Exception {
    /**
     * Ingresa un String para imprimir el mensaje que va a salir cuando
     * la excepcion se lance.
     * @param mensaje
     */
    public ValorNegativo(String mensaje){
        super(mensaje);
    }
}
