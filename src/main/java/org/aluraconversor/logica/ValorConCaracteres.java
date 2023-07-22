package org.aluraconversor.logica;

public class ValorConCaracteresException extends Exception {

    /**
     * Crea una instancia con un mensaje predefinido.
     */
    public ValorConCaracteresException() {
        super("El valor ingresado contiene caracteres de texto, este valor no está permitido.");
    }
}
