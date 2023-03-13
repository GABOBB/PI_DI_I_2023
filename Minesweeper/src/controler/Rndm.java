/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.util.Random;
/**
 *
 * @author Gabriel
 */
public class Rndm {
    public static int random_int(int x){
        Random rand = new Random();
        int rnum = rand.nextInt(x);
        return rnum;
    }
}
