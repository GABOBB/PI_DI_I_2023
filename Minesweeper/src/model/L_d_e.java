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
    
    public L_d_e(){}
    
    public int get_size(){return this.size;}
    
    public N_d_e get_first(){return this.first;}
    
    public void clear(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    public void add_f(N_d_e N){
        if(this.first == null){
            this.first = N;
            this.last = N;
        }else{
            N.set_N(this.first);
            this.first.set_P(N);
            this.first = N;
        }
        this.size++;
    }
    
    public void add_l(N_d_e N){
        if(this.first==null){
            this.first = N;
            this.last = N;
        }else{
            this.last.set_N(N);
            N.set_P(this.last);
            this.last = N;
        }
        this.size++;
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
    
    
    public void d_N(N_d_e x){
        if(this.size == 0){
            return;
        }
        if(x == this.first && x == this.last){
            
            this.first = null;
            this.last = null;
            
        }else if(x == this.first){
            
            this.first = this.first.get_N();
            this.first.set_P(null);
            
        }else if(x == this.last){
            
            this.last = this.last.get_P();
            this.last.set_N(null);
        
        }else{
            
            x.get_P().set_N(x.get_N());
            x.get_N().set_P(x.get_P());
        }
        this.size--;
        
    }
    public N_d_e d_srch_Id(String id){
        N_d_e temp = this.first;
        while(temp!=null && temp.get_Id()!=id){
            temp = temp.get_N();
        }
        
        if(temp == this.first){
            temp.get_N().set_P(null);
            this.first = temp.get_N();
            
        }else if(temp == this.last){
            temp.get_P().set_N(null);
            this.last = temp;
            
        }else if(temp!=null){
            temp.get_P().set_N(temp.get_N());
            temp.get_N().set_P(temp.get_P());
            
        }
        this.size--;
        return temp;
    }
    
    public N_d_e srch_indx(int x){
        N_d_e temp = this.first;
        for(int i=0; i<x; i++){
            temp = temp.get_N();
        }
        
        return temp;
    }
    
    public N_d_e d_srch_indx(int x){
        if(x>this.size){return null;}
        N_d_e temp = this.srch_indx(x);
        if(temp == this.first && temp == this.last){
            this.first = null;
            this.last = null;
        }else if(temp == this.first ){
            temp.get_N().set_P(null);
            this.first = temp.get_N();
        }else if(temp == this.last ){
            temp.get_P().set_N(null);
            this.last = temp.get_P();
        }else{
            temp.get_P().set_N(temp.get_N());
            temp.get_N().set_P(temp.get_P());
        }
        this.size--;
        return temp;
    }
    
    public Boolean srch_N(N_d_e N){
        N_d_e temp = this.first;
        while(temp != null && temp!= N){
            temp = temp.get_N();
        }
        return temp!=null;
    }
    
    public N_d_e d_srch_N(N_d_e N){
        N_d_e temp = this.first;
        while(temp != null && temp!= N){
            temp = temp.get_N();
        }
        if(temp == this.first){
            temp.get_N().set_P(null);
            this.first = temp.get_N();
            
        }else if(temp == this.last){
            temp.get_P().set_N(null);
            this.last = temp;
            
        }else if(temp!=null){
            temp.get_P().set_N(temp.get_N());
            temp.get_N().set_P(temp.get_P());
            
        }
        this.size--;
        return temp;
    }
}
