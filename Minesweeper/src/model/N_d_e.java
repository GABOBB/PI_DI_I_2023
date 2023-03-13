/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gabriel
 */
public class N_d_e {
    N_d_e next;
    N_d_e prev;
    Object data;
    String id;
    
    public N_d_e (N_d_e n, N_d_e p, String Id, Object d){
        this.next = n;
        this.prev = p;
        this.id = Id;
        this.data = d;
    }
    
    public N_d_e (N_d_e n, N_d_e p, Object d){
        this.next = n;
        this.prev = p;
        this.data = d;
    }
    
    public N_d_e (N_d_e n, N_d_e p, String Id){
        this.next = n;
        this.prev = p;
        this.id = Id;
    }
    
    public void set_N(N_d_e N){this.next = N;}
    
    public void set_P(N_d_e P){this.prev = P;}
    
    public N_d_e get_N(){return this.next;}
    
    public N_d_e get_P(){return this.prev;}
    
    public String get_Id(){return this.id;}
    
    public Object get_D(){return this.data;}
    
}
