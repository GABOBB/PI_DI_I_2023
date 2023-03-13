/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gabriel
 */
public class L_d_e {
    N_d_e first = null;
    N_d_e last = null;
    int size = 0;
    
    public L_d_e(){}
    
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
    
    public N_d_e srch_Id(String id){
        N_d_e temp = this.first;
        while(temp != null && temp.get_Id()!=id){
            temp = temp.get_N();
        }
        return temp;
    }
    
    public N_d_e srch_indx(int x){
        N_d_e temp = this.first;
        for(int i=0; i<x; i++){
            temp = temp.get_N();
        }
        return temp;
    }
    
    public Boolean srch_N(N_d_e N){
        N_d_e temp = this.first;
        while(temp != null && temp!= N){
            temp = temp.get_N();
        }
        return temp!=null;
    }
}
