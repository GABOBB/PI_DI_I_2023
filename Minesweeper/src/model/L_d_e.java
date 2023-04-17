package model;

/**
 *  esta clase es la que guarda los metodos necesarios para el 
 *  manejo de una lista doblemente enlazada 
 * @author G.B.B
 */
public class L_d_e {
    N_d_e first = null;
    N_d_e last = null;
    int size = 0;
    
    /**
     * este metodo incializa la lista vacia
     */
    public L_d_e(){}
    
    /**
     * este metodo retorna la cantida de elementos de la lista
     * @return 
     */
    public int get_size(){return this.size;}
    
    /**
     * este metodo retorna el primer elemento de la lista
     * @return 
     */
    public N_d_e get_first(){return this.first;}
    
    /**
     * este metodo setea la lista como una lista sin elementos
     */
    public void clear(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    /**
     * este metodo a;ade un nodo como first
     * @param N 
     */
    public void add_f(N_d_e N){
        if(this.first == null){//si la lista esta vacia 
            this.first = N;//el nodo se agrega como primero
            this.last = N;//el nodo se agrega como ultimo
        }else{//la lista ya tiene elementos
            N.set_N(this.first);//se guarda como siguiente al nodo el primero de la lista
            this.first.set_P(N);//se guarda como anterior al previo el nodo
            this.first = N;//se asigna el nodo como primero
        }
        this.size++;//se aumenta la cantidad de elementos de la lista
    }
    
    /**
     * este metodo a;ade un nodo como last
     * @param N 
     */
    public void add_l(N_d_e N){
        if(this.first==null){//si la lista esta bacia
            this.first = N;//se asigna el nodo como primero 
            this.last = N;//se asigna el nodo como ultimo
        }else{//si la lista ya tiene elementos
            this.last.set_N(N);//se guarda como siguiente al ultimo el nodo
            N.set_P(this.last);//se asigna comoa anterior del nodo el ultimo
            this.last = N;//se asigna el nod ocmo ultimo
        }
        this.size++;//se aumenta la cantidad de elemetnos de la lista
    }
    
    /**
     * este metodo imprime en consola la lista 
     */
    public void prnt_lst(){
        System.out.println("\n##################################################################");
        N_d_e actual = this.first;//referencia a un nodo temporal como el primero de la lista
        while(actual != null){//mientras el teporal no sea nulo repita
            System.out.print(actual.get_Id()+"   ");// imprimir el id del nodo temporal con espacios
            actual = actual.get_N();//el nodo actual se guarda commo el siguiente del mismo
        }
        System.out.println("\n##################################################################");
    }
    
    /**
     * este metodo buca un nodo por medio de un id y lo retorna si existe
     * @param id
     * @return 
     */
    public N_d_e srch_Id(String id){
        N_d_e temp = this.first;//esteablece un nodo temporal con lareferencia del primero de la lista
        while(temp != null && temp.get_Id()!=id){//mientras el temp no sea nulo y el id de temp no coincida repita
            temp = temp.get_N();//temp se guarda como el siguiente en la lista
        }
        return temp;//se retorna el nodo ya sea null o cuando tiene el mismo id 
    }
    
    /**
     * este metodo busca un nodo por medio de un id y retorna un booleano que indica si esta o no
     * @param id
     * @param T
     * @return 
     */
    public boolean srch_Id(String id, boolean T){
        N_d_e temp = this.first;//se establece un nodo temporal con la referenciadel primero de la lista
        while(temp != null){//mientras el temp no sea nulo repita
            if(temp.get_Id()==id){//si el id del nodo es igual al proporcionado returne true
                return true;
            }else{//de otra manera guarde en temp el siguiente en la lista
                temp = temp.get_N();
            }  
        }
        return false;//retorna false si ningun nodo en la lista coincidio
    }
    
    /**
     * este metodo elimina un nodo de la lista
     * @param x 
     */
    public void d_N(N_d_e x){
        if(this.size == 0){//si la lista en nula no hay nodo que eliminar
            return;
        }
        if(x == this.first && x == this.last){//si el nodo es primero y utimo es el unico nodo de la lista
            
            this.first = null;//se guarda el primro como nulo
            this.last = null;//se guarda el ultimo como nulo
            
        }else if(x == this.first){//si es el primero de la lista
            
            this.first = this.first.get_N();//guarda en la referencia al primero el segundo de la lista
            this.first.set_P(null);//guarda en la referencia de anterior del nuvo primero en nulo
            
        }else if(x == this.last){//si el nodo es el ultimo
            
            this.last = this.last.get_P();//guarda en la referncia al ultimo como el anterior al ultimo
            this.last.set_N(null);//guarda en la referencia de siguiente del nuevo ultimo en nulo
        
        }else{//de otra manera
            
            x.get_P().set_N(x.get_N());//se asigna el siguiente del anterior como el siguiente del actual
            x.get_N().set_P(x.get_P());//se asigna el anterior del siguiete como el anterior del actual
        }
        this.size--;//sereduce la cantidad de elementos
        
    }
    
    /**
     * este metodo busca un nodo por el id y si existe lo elimina
     * @param id
     * @return 
     */
    public N_d_e d_srch_Id(String id){
        N_d_e temp = this.first;//crea un nodo temporal con la refernaica del primero en la lista
        while(temp!=null && temp.get_Id()!=id){//mientras no sea nulo y tengo un id diferen repita
            temp = temp.get_N();//se guarda en el nodo la referencia del nodo siguiente
        }
        
        if(temp == this.first){//si el nodo es el primero
            temp.get_N().set_P(null);//se guarda en al referencia de anterior del siguiente como nulo
            this.first = temp.get_N();//se guarda el siguiente en la lista como primero
            
        }else if(temp == this.last){//si el nodo es el utlimo en la lista
            temp.get_P().set_N(null);//se guarda en el siguiente del anterior como nulo
            this.last = temp;//se guarda el utlimo como el anterior al ultimo
            
        }else if(temp!=null){//si el nodo es diferente de nulo
            
            temp.get_P().set_N(temp.get_N());//se asigna el siguiente del anterior como el siguiente del actual
            temp.get_N().set_P(temp.get_P());//se asigna el anterior del siguiete como el anterior del actual
            
        }
        this.size--;//disminulle la cantidad de elementos de la lista
        return temp;//retoran el nodo 
    }
    
    /**
     * este metodo buca un nodo por la pocicion en la lista y lo retorna
     * @param x
     * @return 
     */
    public N_d_e srch_indx(int x){
        N_d_e temp = this.first;//se inicila un nodo temporal como el primero de la lista
        for(int i=0; i<x; i++){//se repite x cantidad de veces
            temp = temp.get_N();//se obtiene el siguiente en la lista
        }
        
        return temp;//se retorna el nodo en la x pocicion de la lista
    }
    
    /**
     * este metodo buca un nodo por su pocicion en la lista y retorna despues de eliminarlo
     * @param x
     * @return 
     */
    public N_d_e d_srch_indx(int x){
        if(x>this.size){return null;}//si x exede el tama;o de la lista se desecha 
        N_d_e temp = this.srch_indx(x);//se genera un nodo temporal con la referencia del primero
        if(temp == this.first && temp == this.last){//si la list tiene solo un elemento
            this.first = null;//se guarda el primero como nulo
            this.last = null;//se guarda el ultimo como nulo
        }else if(temp == this.first ){//si el nodo es el primero de la lista
            temp.get_N().set_P(null);//se guarda el anterior del siguiete como nulo
            this.first = temp.get_N();//se guarada el nodo como el siguiente en la lista
        }else if(temp == this.last ){//si el nodo es el ultimo
            temp.get_P().set_N(null);//se guarda el siguiete del anterior como nulo
            this.last = temp.get_P();//se guarda el penultimo como utlimo
        }else{//en otro caso
            temp.get_P().set_N(temp.get_N());//se guarda el siguiente del anterior como el siguiente 
            temp.get_N().set_P(temp.get_P());//se guarda el anterior del siguiente como el anterior
        }
        this.size--;//se reduce la cantidad de elementos de la lista
        return temp;//retoran el nodo temporal
    }
    
    /**
     * este metodo buca un nodo en la lista y retorna un indicador booleano de si existe en la lista
     * @param N
     * @return 
     */
    public Boolean srch_N(N_d_e N){
        N_d_e temp = this.first;//se inicia un nodo temporal con la referencia del primero
        while(temp != null && temp!= N){//si el nodo no es nulo y diferente del N repita
            temp = temp.get_N();//se guarda en el temporal el nodo siguiente
        }
        return temp!=null;//se retorna el si el nodo existe o no
    }
    
    /**
     * este metodo buca un nodo en la lista y si esta lo elimina
     * @param N
     * @return 
     */
    public N_d_e d_srch_N(N_d_e N){
        N_d_e temp = this.first;
        while(temp != null && temp!= N){
            temp = temp.get_N();
        }
        if(temp == this.first){
            temp.get_N().set_P(null);//se guarda el anterior del siguiete como nulo
            this.first = temp.get_N();//se guarada el nodo como el siguiente en la lista
            
        }else if(temp == this.last){
            temp.get_P().set_N(null);//se guarda el siguiete del anterior como nulo
            this.last = temp;//se guarda el penultimo como utlimo
            
        }else if(temp!=null){
            temp.get_P().set_N(temp.get_N());//se guarda el siguiente del anterior como el siguiente 
            temp.get_N().set_P(temp.get_P());//se guarda el anterior del siguiente como el anterior
            
        }
        this.size--;//se reduce la cantidad de elementos de la lista
        return temp;//retoran el nodo temporal
    }
}
