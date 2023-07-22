package org.aluraconversor.ui;

import javax.swing.*;
import java.awt.*;

public class ConversorTemperatura extends JFrame {

    private JTextField textCentigradosInputA;
    private JTextField textCentigradoToFarenheit;
    private JTextField textCentigradoToKelvin;
    private JTextField textFarenheitInputA;
    private JTextField textFarenheitToCentigrado;
    private JTextField textFarenheitToKelvin;
    private JTextField textKelvinInputA;
    private JTextField textKelvinToCentigrados;
    private JTextField textKelvinToFarenheit;
    private JButton convertirButton;
    private JButton limpiarButton;
    private JButton inicioButton;
    private JPanel jpPrincipal;

    public ConversorTemperatura() {
        super("Conversor Moneda");
        setContentPane(jpPrincipal);

        convertirButton.addActionListener(e -> {
            convertirCentigrados();
            convertirFarenheit();
            convertirKelvin();
        });

        limpiarButton.addActionListener(e -> limpiarCampos());

        inicioButton.addActionListener(e -> volverAlMenu());
    }

    private void convertirCentigrados() {
        if (!textCentigradosInputA.getText().isEmpty()) {
            float centigradoValue = Float.parseFloat(textCentigradosInputA.getText());
            float farenheit = centigradoValue * 9.0f/5.0f + 32;
            float kelvin = centigradoValue + 273.15f;
            
            textCentigradoToFarenheit.setText(Float.toString(farenheit));
            textCentigradoToKelvin.setText(Float.toString(kelvin));
        }
    }

    private void convertirFarenheit() {
        if (!textFarenheitInputA.getText().isEmpty()) {
            float farenheitValue = Float.parseFloat(textFarenheitInputA.getText());
            float centigrado = (farenheitValue - 32) * 5.0f/9.0f;
            float kelvin = (farenheitValue - 32) * 5.0f/9.0f + 273.15f;
            
            textFarenheitToCentigrado.setText(Float.toString(centigrado));
            textFarenheitToKelvin.setText(Float.toString(kelvin));
        }
    }

    private void convertirKelvin() {
        if (!textKelvinInputA.getText().isEmpty()) {
            float kelvinValue = Float.parseFloat(textKelvinInputA.getText());
            float centigrado = kelvinValue - 273.15f;
            float farenheit = (kelvinValue - 273.15f) * 9.0f/5.0f + 32;
            
            textKelvinToCentigrados.setText(Float.toString(centigrado));
            textKelvinToFarenheit.setText(Float.toString(farenheit));
        }
    }

    private void limpiarCampos() {
        textCentigradosInputA.setText("");
        textCentigradoToFarenheit.setText("");
        textCentigradoToKelvin.setText("");
        textFarenheitInputA.setText("");
        textFarenheitToCentigrado.setText("");
        textFarenheitToKelvin.setText("");
        textKelvinInputA.setText("");
        textKelvinToCentigrados.setText("");
        textKelvinToFarenheit.setText("");
    }

    private void volverAlMenu() {
        Object opciones[] = {"Conversor de moneda", "Conversor de temperatura"};
        dispose();
        MenuEleccion menu = new MenuEleccion(opciones,"Escoja lo que desea hacer","Conversor Alura");
    }
}
