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
        
        this.clr_lsts();//reinicia las listas 
        System.err.print("\n("+this.I_list.get_size()+" 1 i) "+"("+this.P_list.get_size()+" 1 p) "+"("+this.S_list.get_size()+" 1 s)");
        
        this.P_list = this.get_shootable(M);//adquiere las cordenadas de las casillas que no se han jugado
        
        System.err.print("\n("+this.I_list.get_size()+" 2 i) "+"("+this.P_list.get_size()+" 2 p) "+"("+this.S_list.get_size()+" 2 s)");
        this.P_list.prnt_lst();//imprime la lista principal completa
        
        this.split_s_i(M);//separa las casillas de la lista principal en las casiillas seguras e inseguras
        System.err.print("\n("+this.I_list.get_size()+" 3 i) "+"("+this.P_list.get_size()+" 3 p) "+"("+this.S_list.get_size()+" 3 s)");
        
        
        if(this.S_list.get_size()>0){//si la lista segura tiene elementos escoge uno de estos
            
            System.out.print("\nseguro");
            return (this.S_list.get_first().get_Id() + " " + this.S_list.get_first().get_state());//devuelve el primero de la lista segura junto con el indicador 
        
        }else{//si no hay tiros seguros escoge uno aleatorio de los inseguros

            int idx = Rndm.random_int((this.I_list.get_size()));//genera un numero aleatorio menor a la cantidad de elementos en la lista 
            
            try{
                N_d_e t = this.I_list.d_srch_indx(idx);//busca el elemento idx'cimo de la lista y lo elimina
                System.out.print("\ninseguro");
                return t.get_Id() + " " + t.get_state();//devuleve las coordenadas junto con el estado
            
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

        while(this.P_list.get_size()!=0){//se serciora de que todavia no hayan casillas sin asignar en segura o insegura
            N_d_e act = this.P_list.srch_indx(Rndm.random_int(this.P_list.get_size()));//obtiene un nodo aleatorio de la lista principal
            String[] nom = act.get_Id().split(" ");//obtiene la informacion de la casilla
            int x = Integer.parseInt(nom[0]);//cordenadas en x
            int y = Integer.parseInt(nom[1]);//cordenadas en y

            String codes = "";//inicializa un string que lleva registro del indicador de las casillas auxiliares

            for(int i = (x-1); i<(x+2); i++){//recorre las filas de la matriz 3x3 circundatne a la casilla principal
                for(int j = (y-1); j<(y+2); j++){//recorre las columnas de la matriz3x3 circundante a la casilla principal
                    if(i==x && j==y){continue;}//se desecha el caso si es la casilla principal
                    try{
                        codes += c_bndr(i,j,M);//se a;ade el codigo de cada casilla circundante
                    }catch(Exception e){}
                }
            }

            if(codes.contains("b")){//si al menos una casilla indico que hay  bomba se suma a las seguras con indicador de bandera
                this.P_list.d_N(act);//se elimina de la lista
                act.set_state("@bndr");//se le asigna estado de bandera
                this.S_list.add_l(act);//se a;ade a la lista segura

            }else if(codes.contains("c")){//si no hay indicador de bombas y almenos una de casilla libre se alade a segura con estado de clik
                this.P_list.d_N(act);//se elimina de la lista 
                act.set_state("@clkd");//se le asigna estado de jugable
                this.S_list.add_l(act);//se alade a la lista segura

            }else {//si no hay ningun idicador de bomba o casilla libre la casiila es insegura
                this.P_list.d_N(act);//se elimina de la lista 
                act.set_state("@clkd");//se le asigna esto de jugable
                this.I_list.add_l(act);//se a;ade a la lista insegura

                }
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
        String info = M.get_cords(x, y);//obtiene la informacion que hay en las coordenadas x,y
        if(!info.contains("@clkd")){return "i";}//si la casilla no ha sido juigada no ofece informacion y se toma como insegura
        int num = Integer.parseInt(info.split("@")[0]);//la cantidad de  bombas cirncundantes a esta casilla
        int count_b = 0;//lleva registro de la cantidad de bombas circundantes ya clicadas
        int count_c = 0;//lleva registro de la cantidad de casillas circundantes que ya fueron judas 
        int count = 0;//lleva registro de la cantoidad de casillas que codean a la casilla principal de la iteracion
        for(int i = (x-1); i<(x+2); i++){//reccore las filas de la matriz 3x3 alrededor de la casilla principal
            for(int j = (y-1); j<(y+2); j++){//recorre las columnas de la matriz 3x3 alrededor de la casilla principal
                if(i == x && j == y){continue;}//si las cordenadas son la de la casilla principal se desecha la iteracion
                try{
                    String info_aux = M.get_cords(i, j);//obtiene la informacion de la casilla circundante
                    count++;//aumenta la cantidad de casillas circundantes a la principal
                    if(info_aux.contains("@bndr")){count_b++;}//aumenta la cantidad de bombas si esta casilla fue marcada con bandera
                    if(info_aux.contains("@clkd")){count_c++;}//aumenta la cantidad de casillas jugadas cuando ya lo fueron
                }catch(Exception e){}
            }
        }
        if(num == count_b){//si el numero de la casilla princoipal es igual a las bombas encontradas la casilla principal esta libre
            return "c";
        }else if(num == count - count_c){//si a las casillas se le restan las jugadas y esto es igual a la cantidad de bombas la en la principal hay una bomba
            return "b";
        }else{//no es seguro afirmar que hay en la casilla
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
        L_d_e L = new L_d_e();//inicializa una lista temporal
        for(int i=0; i<8; i++){//reccore la matriz por las fials
            for(int j=0; j<8; j++){//recorre la matriz por las columnas
                String info = M.get_cords(i, j);//obtiene la informacion de las coordenadas
                if(!(info.contains("@clkd")) && !(info.contains("@bndr"))){//se cerciora de que no hayan sido jugadas
                    N_d_e new_n = new N_d_e(i+" "+j);//inicializa un nuevo nodo con las coordenadas
                    L.add_l(new_n);//la a;ade a la lista temporal
                }
            }
        }
        return L;//retorna la lista temporal
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
