package org.aluraconversor;

import org.aluraconversor.ui.MenuEleccion;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        Object[] opciones = {"Conversor de moneda", "Conversor de temperatura"};
        // Se crea el menú con las opciones disponibles.
        new MenuEleccion(opciones, "Escoja lo que desea hacer", "Conversor Alura");
    }
}
