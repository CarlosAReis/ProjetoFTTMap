/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comuns;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jojok
 */
public class Criptografia {
     
    private static final Integer number = 7;
    
    public static String encode(String password) {
        List<String> charList = new ArrayList<>();
        for (char c : password.toCharArray()) {
            charList.add(String.valueOf(c + number));
        }
        System.out.println(String.join("-", charList));
        return String.join("-", charList);
    }
    
    public static String decode(String encoded) {
        String[] charList = encoded.split("-");
        String aux = "";
        for (String c : charList) {
            aux += String.valueOf((char)(Integer.valueOf(c) - number));
        }
        System.out.println(aux);
        return aux;
    }
}
