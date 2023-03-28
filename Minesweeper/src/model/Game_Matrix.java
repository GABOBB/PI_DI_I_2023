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
        //generate_num();
        prnt_mtrx();
    }
    /**
     * este metodo genera una cantidad n de casillas con 'bombas' 
     * this.bmbs delimita la cantidad de bombas a generar
     */
    private void generate_M(){
        for(int c=0;c<this.bmbs;c++){//genera una iteracion por cada bomba que debe poner
            int i = Rndm.random_int(8);//escoge una fila de manera aleatoria
            int j = Rndm.random_int(8);//escoge una columba de manera aleatoria
            
            System.out.println(c);
            
            if((i!=4 && i!=5)&&(j!=4 && j!=5)){//(!(i<6 && i>3) && !(j<6 && j>3)){//se asegura que no se ponga una bomba en las casillas sentrales
                N_d_e N_new = new N_d_e(null,null,i+" "+j);//genera un nodo para a;adirlo a la lista de bombas
                if(!bombs.srch_N(N_new)){//revisa que no exista una bomba en esas cordenadas
                    this.matrix[i][j]="Bomb";//marca esa pocicion de la matriz como bomba 
                    System.out.println(this.matrix[i][j]);
                    //this.add_nums(i, j);
                    this.bombs.add_l(N_new);//a;ade el nodo a la lista de bombas
                }else{//en caso de que la casilla ya tenga una bomba a;ade una iteracion mas
                    c--;
                }
            }else{//en caso de que la casilla sea central se desecha y se retrocede el contador
                c--;
            }
        }
    }
    
    private void add_nums(int i, int j){
        int x = i-1; int y = j-1;
        int bombs = 0;
        for(;x<=i+1;x++){
            for(;y<=j+1;y++){
                
                if(this.matrix[x][y].equals("Bomb")){
                    bombs+=1;
                }
            }
        }
        this.matrix[x][y]=bombs+"";
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
    private void prnt_mtrx(){
        for(String i[] : this.matrix){
            String fila="";
            for(String j : i){
                if(j!=null){
                    fila+=" "+j;
                }else{
                    fila+="  ---";
                }
            }
            System.out.println(fila);
        }
    }
    
    private void generate_num(){
        for (int i=0; i<8; i++){//este for se usa para seleccionar cada fila de la matriz principal
            for(int j=0; j<8; j++){//este for se usa para seleccionar cada colubna de la matriz princiapl
                
                if(!(this.matrix[i][j].equals("Bomb"))){//se asegura que no hay una bomba en esa cassilla para poder seguir
                    
                    int num_bombs=0;//inicializa el integer que guarda la cantidad de bombas circundates
                    
                    for(int ix=(i-1); ix<(i+2); ix++){//este for recorre las filas de la matrix auxiliar generada por las casillas circundantes         
                        for(int jx=(j-1); jx<=(j+2); jx++){//este for recorre las columnas de la matriz auxiliar generada por las casillas circundantes
                            
                            try{
                                
                                if((ix!=i && jx != j) && "Bomb".equals(this.matrix[ix][jx])){//revisa que si la casilla tiene una bomba y que no sea la casilla principal de la iteracion principal
                                    num_bombs++;//si la casilla circundante tiene una bomba suma uno a la cantidad de bombas   
                                }
                                
                            }catch(Exception E){
                            }
                            System.out.println(num_bombs + "("+ix +" "+ jx+")");
                        }
                    }
                    System.out.println(num_bombs);
                    this.matrix[i][j]=num_bombs+"";//cuando terminan las iteraciones secundarias asigna la cantidad de bombas a la casilla
                }
            }
        }
    }
}
