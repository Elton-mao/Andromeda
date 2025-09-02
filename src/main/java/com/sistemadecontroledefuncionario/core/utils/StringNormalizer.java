package com.sistemadecontroledefuncionario.core.utils;

public class StringNormalizer {

    /**
     * Converte a string fornecida para letras minúsculas (lowercase).
     *
     * @param input a string a ser normalizada
     * @return a string em letras minúsculas, ou {@code null} se a entrada for nula
     */

    public static String toLowerCase(String string) {
        return string != null ? string.toLowerCase() : null;
    }
}
