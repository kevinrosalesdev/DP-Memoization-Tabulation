/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinationsGenerator;

/**
 *
 * @author Hector
 */
public class Utility {
    public static boolean available(String [] a){
        for (String i : a) {
            if (i.equals("0")) {
                return false;
            }
        }
        return true;
    }
}
