package model;

/**
 *  esta clase es con el proposito de almacenar la informacion 
 *  necesaria para un nodo de una lista doblemante enlazada
 * @author G.B.B
 */
public class N_d_e {
    private N_d_e next;//referencia al nodo siguiente en la lista
    private N_d_e prev;//referencia al nodo anterior en la lista
    private Object data;//guarda un objeto a nececidad 
    private String id;//giarda un string con el nombre del nodo
    private String state;//guarda un string que funje com indicador
    
    /**
     * recibe el nombre del nodo y lo asigna 
     * @param Id 
     */
    public N_d_e (String Id){
        this.id = Id;
    }
    
    /**
     * este metodo guarda un nodo como siguiente
     * @param N 
     */
    public void set_N(N_d_e N){this.next = N;}
    
    /**
     * este modo guarda un nodo en como anterior
     * @param P 
     */
    public void set_P(N_d_e P){this.prev = P;}
    
    /**
     * este metodo guarda un indicador en el this.state
     * @param s 
     */
    public void set_state(String s){this.state = s;}
    
    /**
     * esteme metodo retoran el nodo guardado como siguiente
     * @return 
     */
    public N_d_e get_N(){return this.next;}
    
    /**
     * este metodo retoran el nodo guardado como anterior
     * @return 
     */
    public N_d_e get_P(){return this.prev;}
    
    /**
     * este metodo retorna el id del nodo
     * @return 
     */
    public String get_Id(){return this.id;}
    
    /**
     * este metodo retorna el estado del nodo
     * @return 
     */
    public String get_state(){return this.state;}

    /**
     * este metodo retorna el objeto guardado en el nodo
     * @return 
     */
    public Object get_D(){return this.data;}
    
}
