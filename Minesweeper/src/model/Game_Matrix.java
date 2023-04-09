package model;

import controler.Rndm;

/**esta clase es la responsable de manterner la informacion para la logica del juego
 * @author G.B.B
 */
public class Game_Matrix {
    private L_d_e bombs;//una lista de donde se encuntran las bombas
    private String matrix[][];//la matriz principal del juego
    private int shots;//la cantidad de casillas sin bomba restantes
    private int bmbs;//la cantidad de bombas
    
    /**carga los valores vacios y genera la matriz y la lista de bombas
     * @param b : este se toma para generar la cantidad de bombas
     */
    public Game_Matrix(int b){
        this.bombs = new L_d_e();//inicializa la lista bacia para las bombas
        this.matrix = new String[8][8];//inicializa la matriz 8x8 vacia
        this.shots = 8*8-b;//genera el numero de casillas sin una bomba 
        this.bmbs = b;//carga el parametro como la cantidad de bombas en el juego
        generate_M();//llama al metodo que genera las bombas en la matriz
        //generate_num();
        prnt_mtrx();//implirme la matriz como control
    }
    
    public String[][] get_M(){
        return this.matrix;
    }
    /**
     * este metodo genera una cantidad n de casillas con 'bombas' 
     * this.bmbs delimita la cantidad de bombas a generar
     * y realiza las llamadas a otros metodso para generar los numeros que indiacan la pocicion de bombas circundantes
     */
    private void generate_M(){
        int c=0;
        while(c<this.bmbs){//genera una iteracion por cada bomba que debe poner
            int i = Rndm.random_int(8);//escoge una fila de manera aleatoria
            int j = Rndm.random_int(8);//escoge una columba de manera aleatoria
            
            //if(!((i==4 || i==3) & (j==4 || j==3))){//(!(i<6 && i>3) && !(j<6 && j>3)){//se asegura que no se ponga una bomba en las casillas sentrales
                
                N_d_e N_new = new N_d_e(i+" "+j);//genera un nodo para a;adirlo a la lista de bombas
                
                if(!bombs.srch_Id(N_new.get_Id(),false)){//revisa que no exista una bomba en esas cordenadas
                    
                    this.matrix[i][j]="Bomb";//marca esa pocicion de la matriz como bomba 
                    this.gen_num(i, j);
                    this.bombs.add_l(N_new);//a;ade el nodo a la lista de bombas
                    c++;
                }
        }
        gen_num_aux();
    }
    
    /**
     * este metodo recibe las coordenadas de una bomba x,y y suma 1 a la cantidad de bombas de todos las cordenadas
     * circundantes que no sean bombas
     * @param x
     * @param y 
     */
    private void gen_num(int x, int y){
        for(int i = (x-1);i<(x+2);i++){
            for(int j = (y-1);j<(y+2);j++){
                try{
                    if(!"Bomb".equals(this.matrix[i][j])){
                        if(this.matrix[i][j]==null){
                            this.matrix[i][j]=1+"";
                        }else{
                            int temp = Integer.parseInt(this.matrix[i][j]);
                            temp += 1;
                            this.matrix[i][j]= temp+"";
                        }
                    }  
                }catch(Exception e){
                    System.out.println(e +" %%% "+ i +" "+ j);
                }
            }
        }
    }
    
    /**
     * este metodo recorre la matriz revisando las cordernadas vacias y para asignarles un valor de "0"
     */
    private void gen_num_aux(){
        for(int i=0; i<8; i++){//reccore las filas de la  matriz 
            for(int j=0; j<8; j++){//recorre las colubmas de la matriz
                if(this.matrix[i][j]==null){//verifica si la casilla es nula
                    this.matrix[i][j] = "0";//guarda 0 si la casilla es nula
                }
            }
        }
    }
    
    /**
     * este metodo rebisa que codigo hay en la posicion de la matriz i,j
     * @param i : un intiger para las filas de la matriz
     * @param j : un intiger para las colubnas de la matriz
     * @return  : retorna un String con un codigo de lo que hay en la casilla
     */
    public String get_cords(int i, int j){
        this.shots--;//disminulle en uno la cantidad de casillas restantes sin bomba
        return this.matrix[i][j];//devulve la informacion de la casilla
    }
    
    /**
     * este metodo recorre la matriz y la imprime en consola
     */
    public void prnt_mtrx(){
        for(String i[] : this.matrix){//obtiene una fila de la matiz en cada iteracion
            String fila="";// inicializa un String temporal para llevar los datos de cada fila
            for(String j : i){//reccore todos los elementos de cada filla
                
                if(j.equals("Bomb")){//verifica el valor de cada casiila para mantener el formato
                        fila+=" "+j+" ";//agrega espacios para mantener el formato
                }else{
                    fila+=" _"+j+"_ ";//agrega espacios para mantener el formato
                }
            }
            System.out.println(fila);//imprime fila por fila para conservar la forma de matriz
        }
    }
    
    /**
     * esta funcion recibe unas cordenas i,j un string c para guardar en las cordenadas y un indicador booleano x
     * en caso de que quiera a;adir o remplazar el texto
     * @param i 
     * @param j
     * @param c
     * @param x 
     */
    public void setCords(int i, int j, String c, boolean x){
        if(x){//si el indicador es true remplaza el texto 
            this.matrix[i][j] = c;
        }else{//si el indicador el false se a;ade el texto a lo que habia antes al inicio
             this.matrix[i][j]+=c;
        }
    }
 
}
