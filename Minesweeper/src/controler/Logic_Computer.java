package controler;

import model.Game_Matrix;
import model.L_d_e;
import model.N_d_e;

/**
 * esta clase es la que administra los algoridmos para generar las cordenadas del tiro de la computadora
 * @author G.B.B
 */
public class Logic_Computer {
    private L_d_e P_list;//lista principal (todas las casillas jugables)
    private L_d_e S_list;//lista segura (tiros que son seguros de jugar)
    private L_d_e I_list;//lista insegura (tiros con insertidumbre)
    
    
    /**
     * este metodo inicializa las tres listas principales y carga las jugadas 
     * aleatorias del modo facil
     */
    public Logic_Computer(){
        this.P_list = this.dummy_m_l_g();
        this.S_list = new L_d_e();
        this.I_list = new L_d_e();
    }
    
    /**
     * este metodo publico es el que genera las administra el algoritmo elejido para generar las cordenadas del tiro
     * @param t
     * @return 
     */
    public String c_shoot(){
            return this.ez_shoot();
    }
    /**
     * este metodo realiza la genera las cordenadas y el tipo de tiro
     * en el modo de dificultad alta
     * @param M
     * @return 
     */
    public String c_shoot(Game_Matrix M){
        return this.hard_shoot(M);
    }
    
    /**
     * este es el metodo privado que genera un tiro para le modo facil ya que este
     * es generado de manera aleatoria 
     * @return 
     */
    private String ez_shoot(){
        int x = Rndm.random_int(P_list.get_size());//se genera un intiger de manera aleatoria entre 0 y la cantidad de casillas po jugar 
        N_d_e temp = P_list.d_srch_indx(x);//elimina el nodo x-ecimo de la lista y lo retorna 
        
        return temp.get_Id();//retorna el id del nodo en el cual se almancenan las cordenandas
    }
    /**
     * este met
     * odo es el que administra la logica necesaria para el algoridmo de 
     * seleccion de cordenadas para el modo de juego dificil
     * @return 
     */
    private String hard_shoot(Game_Matrix M){
        
        this.clr_lsts();
        System.err.print("\n("+this.I_list.get_size()+" 1 i) "+"("+this.P_list.get_size()+" 1 p) "+"("+this.S_list.get_size()+" 1 s)");
        
        this.P_list = this.get_shootable(M); 
        
        System.err.print("\n("+this.I_list.get_size()+" 2 i) "+"("+this.P_list.get_size()+" 2 p) "+"("+this.S_list.get_size()+" 2 s)");
        this.P_list.prnt_lst();
        
        System.err.print("\n("+this.I_list.get_size()+" 3 i) "+"("+this.P_list.get_size()+" 3 p) "+"("+this.S_list.get_size()+" 3 s)");
        this.split_s_i(M);
        
        System.err.print("\n("+this.I_list.get_size()+" 4 i) "+"("+this.P_list.get_size()+" 4 p) "+"("+this.S_list.get_size()+" 4 s)");
        
        if(this.S_list.get_size()>0){
            System.out.println("seguro");
            return (this.S_list.get_first().get_Id() + " " + this.S_list.get_first().get_state());
        }else{
            System.err.println("\n"+this.I_list.get_size());
            this.I_list.prnt_lst();
            int idx = Rndm.random_int((this.I_list.get_size()));
            /*System.out.println("\n"+idx + "este es el numero de pocion en la lista");*/
            this.I_list.prnt_lst();
            
            
            try{
                N_d_e t = this.I_list.d_srch_indx(idx);
                System.out.println("inseguro");
                return t.get_Id() + " " + t.get_state();
            
            }catch(Exception r){
                
                return null;
            }
            
        }
        
    }
    
   
    /**
     * este metodo se encarga de gestionar cuales casillas del tablero son seguras
     * de jugar en cuales hay una bomba y cuales son inciertas
     * @param M 
     */
    private void split_s_i(Game_Matrix M){
        N_d_e act = this.P_list.get_first();
        while(act != null){
            String[] nom = act.get_Id().split(" ");
            int x = Integer.parseInt(nom[0]);
            int y = Integer.parseInt(nom[1]);
            
            String codes = "";
            
            for(int i = (x-1); i<(x+2); i++){
                for(int j = (y-1); j<(y+2); j++){
                    if(i==x && j==y){continue;}
                    try{
                        codes += c_bndr(i,j,M);
                    }catch(Exception e){}
                }
            }
            
            if(codes.contains("b")){
                this.P_list.d_N(act);
                act.set_state("@bndr");
                this.S_list.add_l(act);
                
            }else if(codes.contains("c")){
                this.P_list.d_N(act);
                act.set_state("@clkd");
                this.S_list.add_l(act);
                
            }else {//if(code.equals("i"))
                this.P_list.d_N(act);
                act.set_state("@clkd");
                this.I_list.add_l(act);
                
            }
            
        act = act.get_N();    
        
        }
    }
    /**
     * este metodo revisa si una casilla es segura de jugar, si hay bomba o si es insegura 
     * @param x
     * @param y
     * @param M
     * @return 
     */
    private String c_bndr (int x, int y, Game_Matrix M){
        String info = M.get_cords(x, y);
        if(!info.contains("@clkd")){return "i";}
        int num = Integer.parseInt(info.split("@")[0]);
        int count_b = 0;
        int count_c = 0;
        int count = 0;
        for(int i = (x-1); i<(x+2); i++){
            for(int j = (y-1); j<(y+2); j++){
                if(i == x && j == y){continue;}
                try{
                    String info_aux = M.get_cords(i, j);
                    count++;
                    if(info_aux.contains("@bndr")){count_b++;}
                    if(info_aux.contains("@clkd")){count_c++;}
                }catch(Exception e){}
            }
        }
        if(num == count_b){
            return "c";
        }else if(num == count - count_c){
            return "b";
            /*}else if(num == count_c){
            return "c";*/
        }else{
            return "i";
        }
        
    }    
    
    /**
     * este metodo recorre la matriz de juego para saber cuales casiillas se 
     * pueden jugan
     * @param M
     * @return 
     */
    private L_d_e get_shootable(Game_Matrix M){
        L_d_e L = new L_d_e();
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                String info = M.get_cords(i, j);
                if(!(info.contains("@clkd")) && !(info.contains("@bndr"))){
                    N_d_e new_n = new N_d_e(i+" "+j);
                    L.add_l(new_n);
                }
            }
        }
        return L;
    }
    
    
    /**
     * este metodo se encarga de limpiar las listas 
     */
    private void clr_lsts(){
        this.P_list.clear();
        this.I_list.clear();
        this.S_list.clear();
    }
    
    /**
     * este metodo es el que se encarga de generar una lista con todas las 
     * casillas de la matriz 
     * @return 
     */
    private L_d_e dummy_m_l_g(){
        L_d_e l = new L_d_e();//se inicializa una lista temporal
        for(int i=0; i<8; i++){//se recorrer las filas 
            for(int j=0; j<8; j++){//se recorren las columnas
                    N_d_e temp = new N_d_e(i+"_"+j);//se instancia el nuevo nodo con las cordenadas en el nombre
                    l.add_l(temp);//se a;ade a la lista temporal
            }
        }
        return l;//se retorna la lista temporal para ser almacenada como atributo del objeto
    }
}
