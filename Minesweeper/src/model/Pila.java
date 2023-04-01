/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controler.Rndm;

/**
 *
 * @author Gabriel
 */
public class Pila {
    private int max = 5;
    private int num = 0;
    private String[] con;
    
    
    Pila(){
        this.con = new String[this.max];
    }
    
    private String gen_con(){
        int i = Rndm.random_int(8);
        int j = Rndm.random_int(8);
        if(true){
            return "";
        }else{
            return gen_con();
        }
    }
}
