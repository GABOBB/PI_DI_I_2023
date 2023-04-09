package model;

/**
 *  esta clase es con el proposito de almacenar la informacion 
 *  necesaria para un nodo de una lista doblemante enlazada
 * @author G.B.B
 */
public class N_d_e {
    private N_d_e next;
    private N_d_e prev;
    private Object data;
    private String id;
    private String state;
    
    /*    public N_d_e (N_d_e n, N_d_e p, String Id, Object d){
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
    }*/
    
    public N_d_e (String Id){
        this.id = Id;
    }
    public void set_N(N_d_e N){this.next = N;}
    
    public void set_P(N_d_e P){this.prev = P;}
    
    public void set_state(String s){this.state = s;}
    
    public N_d_e get_N(){return this.next;}
    
    public N_d_e get_P(){return this.prev;}
    
    public String get_Id(){return this.id;}
    
    public String get_state(){return this.state;}

    public Object get_D(){return this.data;}
    
}
