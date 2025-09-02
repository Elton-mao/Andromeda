package com.sistemadecontroledefuncionario.core.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    /**
     * Formata um objeto {@link LocalDateTime} para o padrão brasileiro de data e
     * hora.
     * O formato de saída é "dd/MM/yyyy HH:mm".
     *
     * @param dataHorario o {@link LocalDateTime} a ser formatado
     * @return uma string representando a data e hora formatadas no padrão
     *         brasileiro
     */
    public static String formataDataPadraoBrasileiro(LocalDateTime dataHorario) {
        DateTimeFormatter dataHorarioBr = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataHorario.format(dataHorarioBr);

    }
}
