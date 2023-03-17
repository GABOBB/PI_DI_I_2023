/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controler.Rndm;

/**
 *  esta clase es la responsable de manterner la informacion para la logica del juego
 * @author GBB
 */
public class Game_Matrix {
    private L_d_e bombs;//una lista de donde se encuntran las bombas
    private String matrix[][];//la matriz principal del juego
    private int shots;//la cantidad de casillas sin bomba restantes
    private int bmbs;//la cantidad de bombas
    
    /**
     * carga los valores vacios y genera la matriz y la lista de bombas
     * @param b : este se toma para generar la cantidad de bombas
     */
    public Game_Matrix(int b){
        this.bombs = new L_d_e();//inicializa la lista bacia para las bombas
        this.matrix = new String[8][8];//inicializa la matriz 8x8 vacia
        this.shots = 8*8-b;//genera el numero de casillas sin una bomba 
        this.bmbs = b;//carga el parametro como la cantidad de bombas en el juego
        generate_M();//llama al metodo que genera las bombas en la matriz
    }
    /**
     * este metodo genera una cantidad n de casillas con 'bombas' 
     * this.bmbs delimita la cantidad de bombas a generar
     */
    private void generate_M(){
        for(int c=0;c<this.bmbs;c++){//genera una iteracion por cada bomba que debe poner
            int i = Rndm.random_int(8);//escoge una fila de manera aleatoria
            int j = Rndm.random_int(8);//escoge una columba de manera aleatoria
            
            if(!(i<6 && i>3) && !(j<6 && j>3)){//se asegura que no se ponga una bomba en las casillas sentrales
                N_d_e N_new = new N_d_e(null,null,i+""+j);//genera un nodo para a;adirlo a la lista de bombas
                if(!bombs.srch_N(N_new)){//revisa que no exista una bomba en esas cordenadas
                    this.matrix[i][j]="Bomb";//marca esa pocicion de la matriz como bomba 
                    this.bombs.add_l(N_new);//a;ade el nodo a la lista de bombas
                }else{//en caso de que la casilla ya tenga una bomba a;ade una iteracion mas
                    c--;
                }
            }else{//en caso de que la casilla sea central se desecha y se retrocede el contador
                c--;
            }
        }
    }
    /**
     * este metodo rebisa que codigo hay en la posicion de la matriz i,j
     * @param i : un intiger para las filas de la matriz
     * @param j : un intiger para las colubnas de la matriz
     * @return  : retorna un String con un codigo de lo que hay en la casilla
     */
    public String Player_S(int i, int j){
        this.shots--;//disminulle en uno la cantidad de casillas restantes sin bomba
        return this.matrix[i][j];//devulve la informacion de la casilla
    }
    /**
     * este metodo recorre la matriz y la imprime en consola
     */
    public void prnt_mtrx(){
        for(String i[] : this.matrix){
            for(String j : i){
                System.out.println(j+"");
            }
        }
    }
}
