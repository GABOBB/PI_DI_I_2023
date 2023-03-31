/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *  esta clase es la que guarda los metodos necesarios para el 
 *  manejo de una lista doblemente enlazada 
 * @author GBB
 */
public class L_d_e {
    N_d_e first = null;
    N_d_e last = null;
    int size = 0;
    
    public L_d_e(){}
    
    public int get_size(){return this.size;}
    
    public void add_f(N_d_e N){
        if(0 == this.size++){
            this.first = N;
            this.last = N;
        }else{
            N.set_N(this.first);
            this.first.set_P(N);
            this.first = N;
        }
    }
    
    public void add_l(N_d_e N){
        if(0 == this.size++){
            this.first = N;
            this.last = N;
        }else{
            this.last.set_N(N);
            N.set_P(this.last);
            this.last = N;
        }
    }
    
    public void prnt_lst(){
        N_d_e actual = this.first;
        while(actual != null){
            System.out.print(actual.get_Id()+"   ");
            actual = actual.get_N();
        }
    }
    
    public N_d_e srch_Id(String id){
        N_d_e temp = this.first;
        while(temp != null && temp.get_Id()!=id){
            temp = temp.get_N();
        }
        return temp;
    }
    
    public boolean srch_Id(String id, boolean T){
        N_d_e temp = this.first;
        while(temp != null){
            if(temp.get_Id()==id){
                return true;
            }else{
                temp = temp.get_N();
            }  
        }
        return false;
    }
    
    public void d_srch_Id(String id){
        N_d_e temp = this.first;
        while(temp!=null && temp.get_Id()!=id){
            temp = temp.get_N();
        }
        temp.get_P().set_N(temp.get_N());
        temp.get_N().set_P(temp.get_P());
        this.size--;
    }
    
    public N_d_e srch_indx(int x){
        N_d_e temp = this.first;
        for(int i=0; i<x; i++){
            temp = temp.get_N();
        }
        return temp;
    }
    
    public void d_srch_indx(int x){
        N_d_e temp = this.first;
        for(int i=0; i<x; i++){
            temp = temp.get_N();
        }
        temp.get_P().set_N(temp.get_N());
        temp.get_N().set_P(temp.get_P());
        this.size--;
    }
    
    public Boolean srch_N(N_d_e N){
        N_d_e temp = this.first;
        while(temp != null && temp!= N){
            temp = temp.get_N();
        }
        return temp!=null;
    }
    
    public void d_srch_N(N_d_e N){
        N_d_e temp = this.first;
        while(temp != null && temp!= N){
            temp = temp.get_N();
        }
        if(temp!=null){
            temp.get_P().set_N(temp.get_N());
            temp.get_N().set_P(temp.get_P());
            this.size--;
        }
    }
}
