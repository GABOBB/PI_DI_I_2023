/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controler.Rndm;

/**
 *
 * @author G.B.B
 */
public class Pila {
    private int max = 5;
    private int num = -1;
    private String[] con;
    
    
    
    public Pila(){
        this.con = new String[this.max];
    }
    
    public void consejo(Game_Matrix M){
        if(num<max){
            gen_con(M);
        }
    }
    
    private void gen_con(Game_Matrix M){
        int i = Rndm.random_int(8);
        int j = Rndm.random_int(8);
        String info = M.get_cords(i, j);
        if(!info.equals("Bomb")){
            this.push(i+" "+j);
        }else{
            gen_con(M);
            return;
        }
        this.print_stack();
    }
    
    public String peek(){ 
        if(this.num == -1){return null;}
        return this.con[this.num];
    }
    
    public String pop(){
        
        if(this.num == -1){return null;}
        
        String temp = this.con[this.num];
        
        this.num--;
        return temp;
    }
    
    public void push(String x){
        if(this.max == this.num - 1){
            return;
        }
        this.con[++this.num] = x;
    }
    
    public int get_num(){
        return (this.num + 1);
    }
    
    public void print_stack(){
        System.out.println("------------d------------");
        for (String i : this.con){
            System.out.println(i);
        }
        System.out.println("-----------d-------------");
    
    }
}
