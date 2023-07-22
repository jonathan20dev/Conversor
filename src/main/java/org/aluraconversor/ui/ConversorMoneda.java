package org.aluraconversor.ui;

import org.aluraconversor.logica.ConversorMonedaLogica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorMoneda extends JFrame {
    private JRadioButton rbtnDolar;
    private JRadioButton rbtnEuro;
    private JRadioButton rbtnLibra;
    private JRadioButton rbtnYen;
    private JRadioButton rbtnWon;
    private JTextField txtfValorAConvertir;
    private JButton convertirButton;
    private JButton limpiarButton;
    private JTextField txtfTRMDolar;
    private JTextField txtfTRMEuro;
    private JTextField txtfTRMLibra;
    private JTextField txtfTRMYen;
    private JTextField txtfTRMWon;
    private JTextField txtfValorDolar;
    private JTextField txtfValorEuro;
    private JTextField txtfValorLibra;
    private JTextField txtfValorYen;
    private JTextField txtfValorWon;
    private JLabel txtTitulo;
    private JLabel textValorConvertir;
    private JLabel txtDolar;
    private JLabel textEuro;
    private JLabel textLibra;
    private JLabel txtWon;
    private JPanel panelFirts;
    private JButton inicioButton;
    private JTextField txtUSDtoCOP;
    private JTextField txtEURtoCOP;
    private JTextField txtGBPtoCOP;
    private JTextField txtJPYtoCOP;
    private JTextField txtKRWtoCOP;
    private JButton convertirUnitariosAPesosButton;
    private JRadioButton radioBtnUSDtoCOP;
    private JRadioButton radioBtnEURtoCOP;
    private JRadioButton radioBtnGBPtoCOP;
    private JRadioButton radioBtnJPYtoCOP;
    private JRadioButton radioBtnKRWtoCOP;

    public ConversorMoneda() {
        super("Conversor de moneda ALURA");
        setContentPane(panelFirts);
        inicioTXTField();

        convertirButton.addActionListener(e -> {
            applyConversion(txtfValorAConvertir.getText());
        });

        ActionListener radioButtonListener = e -> {
            JRadioButton btn = (JRadioButton) e.getSource();
            if (btn == rbtnDolar) txtfTRMDolar.setEnabled(true);
            if (btn == rbtnEuro) txtfTRMEuro.setEnabled(true);
            if (btn == rbtnLibra) txtfTRMLibra.setEnabled(true);
            if (btn == rbtnYen) txtfTRMYen.setEnabled(true);
            if (btn == rbtnWon) txtfTRMWon.setEnabled(true);
        };

        rbtnDolar.addActionListener(radioButtonListener);
        rbtnEuro.addActionListener(radioButtonListener);
        rbtnLibra.addActionListener(radioButtonListener);
        rbtnYen.addActionListener(radioButtonListener);
        rbtnWon.addActionListener(radioButtonListener);

        inicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object opciones[] = {"Conversor de moneda", "Conversor de temperatura"};
                dispose();
                MenuEleccion menu = new MenuEleccion(opciones,"Escoja lo que desea hacer","Conversor Alura");

            }
        });

        limpiarButton.addActionListener(e -> clearFields());

        convertirUnitariosAPesosButton.addActionListener(e -> applyUnitaryConversions());
    }

    private void applyConversion(String valorConvertir) {
        txtfValorDolar.setText(enableTRM(valorConvertir, "4100", rbtnDolar, txtfTRMDolar));
        txtfValorEuro.setText(enableTRM(valorConvertir, "4500", rbtnEuro, txtfTRMEuro));
        txtfValorLibra.setText(enableTRM(valorConvertir, "5300", rbtnLibra, txtfTRMLibra));
        txtfValorYen.setText(enableTRM(valorConvertir, "28.78", rbtnYen, txtfTRMYen));
        txtfValorWon.setText(enableTRM(valorConvertir, "3.21", rbtnWon, txtfTRMWon));
    }

    private void applyUnitaryConversions() {
        txtUSDtoCOP.setText(applySingleConversion(txtfValorDolar, "4200", radioBtnUSDtoCOP, txtfTRMDolar));
        txtEURtoCOP.setText(applySingleConversion(txtfValorEuro, "4200", radioBtnEURtoCOP, txtfTRMEuro));
        txtGBPtoCOP.setText(applySingleConversion(txtfValorLibra, "4200", radioBtnGBPtoCOP, txtfTRMLibra));
        txtJPYtoCOP.setText(applySingleConversion(txtfValorYen, "4200", radioBtnJPYtoCOP, txtfTRMYen));
        txtKRWtoCOP.setText(applySingleConversion(txtfValorWon, "4200", radioBtnKRWtoCOP, txtfTRMWon));
    }

    private String applySingleConversion(JTextField txtfValor, String defaultTRM, JRadioButton radioButton, JTextField trmField) {
        if (txtfValor.getText().isEmpty()) {
            return "";
        } else {
            String result = enableTRMto(txtfValor.getText(), defaultTRM, radioButton, trmField);
            txtfValor.setEnabled(false);
            return result;
        }
    }

    private void clearFields() {
        txtfValorAConvertir.setText("");
        clearSingleCurrencyField(txtfTRMDolar, rbtnDolar, txtfValorDolar);
        clearSingleCurrencyField(txtfTRMEuro, rbtnEuro, txtfValorEuro);
        clearSingleCurrencyField(txtfTRMLibra, rbtnLibra, txtfValorLibra);
        clearSingleCurrencyField(txtfTRMYen, rbtnYen, txtfValorYen);
        clearSingleCurrencyField(txtfTRMWon, rbtnWon, txtfValorWon);
    }

    private void clearSingleCurrencyField(JTextField trmField, JRadioButton radioButton, JTextField valueField) {
        trmField.setText("");
        trmField.setEnabled(false);
        radioButton.setEnabled(false);
        valueField.setText("");
    }

}
