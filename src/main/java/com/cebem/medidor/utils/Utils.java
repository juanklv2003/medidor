package com.cebem.medidor.utils;


public class Utils {
        public static boolean Ispalindromo(String text) {
        String sb = new StringBuilder(text).reverse().toString();

        return text.equalsIgnoreCase(sb);
    }
}
