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
    
    
    /**
     * este metodo inicializa una pila con su cantidad maxima de 5 elementos
     */
    public Pila(){
        this.con = new String[this.max];
    }
    
    /**
     * este metodo revisa si la pila esta llena antes de hacer el nuevo elemento
     * @param M 
     */
    public void consejo(Game_Matrix M){
        if(num<max){
            gen_con(M);
        }
    }
    
    /**
     * este metodo genera a partir de un tablemro (Game_matrix) un consejo de un 
     * casilla en la cula tirar sin bomba
     * @param M 
     */
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
    
    /**
     * este metodo permite ver el elemento con el cual se puede trabajar
     * @return 
     */
    public String peek(){ 
        if(this.num == -1){return null;}
        return this.con[this.num];
    }
    
    /**
     * este metodo elimina el ultimo elemento y lo retorna
     * @return 
     */
    public String pop(){
        
        if(this.num == -1){return null;}
        
        String temp = this.con[this.num];
        
        this.num--;
        return temp;
    }
    
    /**
     * este metodo a;ade un nuevo elemento a la pila si esta tiene espacio
     * @param x 
     */
    public void push(String x){
        if(this.max == this.num - 1){
            return;
        }
        this.con[++this.num] = x;
    }
    
    /**
     * este metodo retorna la canitdad de elementos que tiene la pila
     * @return 
     */
    public int get_num(){
        return (this.num + 1);
    }
    
    
    /**
     * este metodo imprimer en consola la pila a manera de control
     */
    public void print_stack(){
        System.out.println("------------pila------------");
        for (String i : this.con){
            System.out.println(i);
        }
        System.out.println("-----------pila-------------");
    
    }
}
