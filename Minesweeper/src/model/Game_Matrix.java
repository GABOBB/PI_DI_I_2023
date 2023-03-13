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
public class Game_Matrix {
    private L_d_e bombs;
    private String matrix[][];
    private int shots;
    private int bmbs;
    
    
    public Game_Matrix(int b){
        this.bombs = new L_d_e();
        this.matrix = new String[8][8];
        this.shots = 8*8-b;
        this.bmbs = b;
        generate_M();
    }
    
    private void generate_M(){
        for(int c=0;c<=this.bmbs;c++){
            int i = Rndm.random_int(8);
            int j = Rndm.random_int(8);
            N_d_e N_new = new N_d_e(null,null,i+""+j);
            if(!bombs.srch_N(N_new)){
                this.matrix[i][j]="Bomb";
                this.bombs.add_l(N_new);
            }else{
                c--;
            }   
        }
    }
    
    public String Player_S(int i, int j){
        this.shots--;
        return this.matrix[i][j];
    }
    
    public void prnt_mtrx(){
        for(String i[] : this.matrix){
            for(String j : i){
                System.out.println(j+"");
            }
        }
    }
}
