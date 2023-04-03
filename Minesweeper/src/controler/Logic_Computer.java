/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import model.L_d_e;
import model.N_d_e;

/**
 *
 * @author Gabriel
 */
public class Logic_Computer {
    private L_d_e P_list;
    private L_d_e S_list;
    private L_d_e I_list;
    
    public Logic_Computer(){
        this.P_list = main_list_generator();
        this.S_list = new L_d_e();
        this.I_list = new L_d_e();
    }
    
    /**
     * este metodo publico es el que genera las administra el algoritmo elejido para generar las cordenadas del tiro
     * @param t
     * @return 
     */
    public String c_shoot(boolean t){
        if(t){//si el aprametro es true se escoge el tiro de modo dificil 
            return this.hard_shoot();
        }else{//si el parametro es false se escoge el tiro de modo facil
            return this.ez_shoot();
        }
    }
    
    /**
     * este es el metodo privado que genera un tiro para le modo facil ya que este
     * es generado de manera aleatoria 
     * @return 
     */
    private String ez_shoot(){
        int x = Rndm.random_int(P_list.get_size()-1);//se genera un intiger de manera aleatoria entre 0 y la cantidad de casillas po jugar 
        N_d_e temp = P_list.d_srch_indx(x);//elimina el nodo x-ecimo de la lista y lo retorna 
        
        return temp.get_Id();//retorna el id del nodo en el cual se almancenan las cordenandas
    }
    /**
     * este metodo es el que administra la logica necesaria para el algoridmo de 
     * seleccion de cordenadas para el modo de juego dificil
     * @return 
     */
    private String hard_shoot(){
        return "";
    }
    
    /**
     * este metodo es el que se encarga de generar una lista con todas las 
     * casillas de la matriz 
     * @return 
     */
    private L_d_e main_list_generator(){
        L_d_e l = new L_d_e();//se inicializa una lista temporal
        for(int i=0; i<8; i++){//se recorrer las filas 
            for(int j=0; j<8; j++){//se recorren las columnas
                N_d_e temp = new N_d_e(null,null,i+"_"+j);//se instancia el nuevo nodo con las cordenadas en el nombre
                l.add_l(temp);//se a;ade a la lista temporal
            }
        }
        return l;//se retorna la lista temporal para ser almacenada como atributo del objeto
    }
}
