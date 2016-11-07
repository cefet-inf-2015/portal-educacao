/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import java.util.Comparator;

public class Ordena implements Comparator<String>{
    public int compare(String s1, String s2) {
        System.out.print(s1+"\n"+s2+"\n-----------\n");
        String[] array1 = s1.split("/");
        String[] array2 = s2.split("/");
        if((Integer.parseInt(array1[2]))==(Integer.parseInt(array2[2]))){
            if(Integer.parseInt(array1[1])==Integer.parseInt(array2[1])){
                if(Integer.parseInt(array1[0])==Integer.parseInt(array2[0])){
                    return 0;
                } else {
                    return (Integer.parseInt(array1[0])-Integer.parseInt(array2[0]));
                }
            } else {
                return (Integer.parseInt(array1[1])-Integer.parseInt(array2[1]));
            }
        } else {
            return (Integer.parseInt(array1[2])-Integer.parseInt(array2[2]));
        }
    }
}
