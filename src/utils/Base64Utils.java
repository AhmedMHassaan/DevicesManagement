/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Base64;

/**
 *
 * @author pc
 */
public class Base64Utils {

    
    public static String encode(String text){
        return Base64.getEncoder().encodeToString(text.getBytes());
    }
    
    public static String decode(String text){
        return new String(Base64.getDecoder().decode(text));
    }
    
}
