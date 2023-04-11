package model;

import controler.Rndm;

/**
 *
 * @author G.B.B
 */
public class Pila {
    private final int max = 5;//la cantidad maxima de elementos en la pila
    private int num = -1;//el indicador de pocicion en la pila
    private String[] con;//declara el array
    
    
    /**
     * este metodo inicializa una pila con su cantidad maxima de 5 elementos
     */
    public Pila(){
        this.con = new String[this.max];//inicializa el arraay con la cantidad de espacios this.max
    }
    
    /**
     * este metodo revisa si la pila esta llena antes de hacer el nuevo elemento
     * @param M 
     */
    public void consejo(Game_Matrix M){
        if((this.num+1)<this.max){//si la pila no esta llena
            gen_con(M);//se genera un consejo
        }
    }
    
    /**
     * este metodo genera a partir de un tablemro (Game_matrix) un consejo de un 
     * casilla en la cula tirar sin bomba
     * @param M 
     */
    private void gen_con(Game_Matrix M){
        int i = Rndm.random_int(8);// se genera un numero random 
        int j = Rndm.random_int(8);// se genera un numero random
        String info = M.get_cords(i, j);//se obtiene la informacion de las coordenas aleatorias
        if(!info.equals("Bomb")){//si no contiene bomba es segura 
            this.push(i+" "+j);//se a;ade a la pila de consejos
        }else{//si contiene bomba se desecha el caso
            gen_con(M);//se genera otro consejo
            return;
        }
        this.print_stack();//imprime la pila en consola como control
    }
    
    /**
     * este metodo permite ver el elemento con el cual se puede trabajar
     * @return 
     */
    public String peek(){ 
        if(this.num == -1){return null;}//si esta vacia retorna nulo
        return this.con[this.num];//de otra manera retorana el ultimo elemento 
    }
    
    /**
     * este metodo elimina el ultimo elemento y lo retorna
     * @return 
     */
    public String pop(){
        
        if(this.num == -1){return null;}//si la pila esta vacia desecha la llamada
        
        String temp = this.con[this.num];//obtiene la informacion de el ultimo elemento en la pila
        
        this.num--;//resta la cantidad de elemenetos de la pila
        return temp;//retorna la informacion obtenida
    }
    
    /**
     * este metodo a;ade un nuevo elemento a la pila si esta tiene espacio
     * @param x 
     */
    public void push(String x){
        
        if(this.max == this.num - 1){//se cerciora que la pila no este llena
            return;
        }
        this.con[++this.num] = x;//a;ade el elemento al final de la pila y aumenta la pocicion
    }
    
    /**
     * este metodo retorna la canitdad de elementos que tiene la pila
     * @return 
     */
    public int get_num(){
        return (this.num + 1);//retorna el numero de pocicion mas uno para evitar errores
    }
    
    
    /**
     * este metodo imprimer en consola la pila a manera de control
     */
    public void print_stack(){
        System.out.println("------------pila------------");//delimita la imprecion de la pila
        for (String i : this.con){//por cada elemento en la el array 
            System.out.println(i);//imprime las cordenadas de los mismos
        }
        System.out.println("-----------pila-------------");//delimita la imprecion de la pila
    
    }
}
