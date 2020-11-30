/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author baoph
 */
public class StringLib {
    public static String toUnicode(String src) {
        return new String(src.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }
}
