package org.aluraconversor.logica;

import javax.swing.*;
import java.text.DecimalFormat;

public class ConversorMonedaLogica {

    private static float getFloatValue(String value) throws NumberFormatException {
        return Float.parseFloat(value);
    }

    private static void checkNegativeValues(float... values) throws ValorNegativo {
        for (float value : values) {
            if (value <= 0) {
                throw new ValorNegativo("Alguno de los valores es negativo o es igual a 0");
            }
        }
    }

    /**
     * Convierte la moneda local a una moneda extranjera.
     *
     * @param valorConvertir Valor en moneda local
     * @param trmConversion  Tasa de cambio
     * @return Valor en moneda extranjera
     */
    public static String convertirA(String valorConvertir, String trmConversion) {
        return performConversion(valorConvertir, trmConversion, '/');
    }

    /**
     * Convierte una moneda extranjera a moneda local.
     *
     * @param valorConvertir Valor en moneda extranjera
     * @param trmConversion  Tasa de cambio
     * @return Valor en moneda local
     */
    public static String convertirB(String valorConvertir, String trmConversion) {
        return performConversion(valorConvertir, trmConversion, '*');
    }

    private static String performConversion(String valorConvertir, String trmConversion, char operation) {
        float valorConvertirF;
        float valorTRMConversionF;
        float valorConvertido;
        DecimalFormat formatoDecimal = new DecimalFormat("#.##");

        try {
            valorConvertirF = getFloatValue(valorConvertir);
            valorTRMConversionF = getFloatValue(trmConversion);

            checkNegativeValues(valorConvertirF, valorTRMConversionF);

            if (operation == '*') {
                valorConvertido = valorConvertirF * valorTRMConversionF;
            } else if (operation == '/') {
                valorConvertido = valorConvertirF / valorTRMConversionF;
            } else {
                throw new IllegalArgumentException("Operación no válida");
            }

            return formatoDecimal.format(valorConvertido);
        } catch (NumberFormatException | ValorNegativo e) {
            JOptionPane.showMessageDialog(null, e);
            return "";
        }
    }
}
