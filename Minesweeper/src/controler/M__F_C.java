package controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Game_Matrix;
import model.Pila;
import javax.swing.Timer;

/**
 * FXML Controller class
 *
 * @author G.B.B
 */
public class M__F_C implements Initializable {
    @FXML
    private Button g_m;
    @FXML
    private Button b0_0;
    @FXML
    private Button b0_1;
    @FXML
    private Button b0_2;
    @FXML
    private Button b0_3;
    @FXML
    private Button b0_7;
    @FXML
    private Button b0_6;
    @FXML
    private Button b0_5;
    @FXML
    private Button b0_4;
    @FXML
    private Button b1_4;
    @FXML
    private Button b1_5;
    @FXML
    private Button b1_6;
    @FXML
    private Button b1_7;
    @FXML
    private Button b1_3;
    @FXML
    private Button b1_2;
    @FXML
    private Button b1_1;
    @FXML
    private Button b1_0;
    @FXML
    private Button b2_4;
    @FXML
    private Button b2_5;
    @FXML
    private Button b2_6;
    @FXML
    private Button b2_7;
    @FXML
    private Button b2_3;
    @FXML
    private Button b2_2;
    @FXML
    private Button b2_1;
    @FXML
    private Button b2_0;
    @FXML
    private Button b3_4;
    @FXML
    private Button b3_5;
    @FXML
    private Button b3_6;
    @FXML
    private Button b3_7;
    @FXML
    private Button b3_3;
    @FXML
    private Button b3_2;
    @FXML
    private Button b3_1;
    @FXML
    private Button b3_0;
    @FXML
    private Button b4_4;
    @FXML
    private Button b4_5;
    @FXML
    private Button b4_6;
    @FXML
    private Button b4_7;
    @FXML
    private Button b4_3;
    @FXML
    private Button b4_2;
    @FXML
    private Button b4_1;
    @FXML
    private Button b4_0;
    @FXML
    private Button b5_4;
    @FXML
    private Button b5_5;
    @FXML
    private Button b5_6;
    @FXML
    private Button b5_7;
    @FXML
    private Button b5_3;
    @FXML
    private Button b5_2;
    @FXML
    private Button b5_1;
    @FXML
    private Button b5_0;
    @FXML
    private Button b6_4;
    @FXML
    private Button b6_5;
    @FXML
    private Button b6_6;
    @FXML
    private Button b6_7;
    @FXML
    private Button b6_3;
    @FXML
    private Button b6_2;
    @FXML
    private Button b6_1;
    @FXML
    private Button b6_0;
    @FXML
    private Button b7_4;
    @FXML
    private Button b7_5;
    @FXML
    private Button b7_6;
    @FXML
    private Button b7_7;
    @FXML
    private Button b7_3;
    @FXML
    private Button b7_2;
    @FXML
    private Button b7_1;
    @FXML
    private Button b7_0;
    
    private Image img_b;
    private Image img_b_r;
    private Image img_c_f;
    private Image img_c_d;
    private Image img_c_s;
    private Image img_c_g;
    
    private Image img_bndr;
    private Image img_bndr_c;
    
    private Image img_0;
    private Image img_1;
    private Image img_2;
    private Image img_3;
    private Image img_4;
    private Image img_5;
    private Image img_0_c;
    private Image img_1_c;
    private Image img_2_c;
    private Image img_3_c;
    private Image img_4_c;
    private Image img_5_c;
    
    private Timer timer;
    
    private Game_Matrix Matrix_Main;
    
    private Logic_Computer COMPUTER;
    
    private Pila sugerencia;
    
    private Button btn_m[][] = new Button[8][8];
    
    
    private int time;
    
    private boolean begin = false;
    private boolean lose = false;
    private boolean ga_mo = false;
    private boolean playable = true;

    private int contador;
    @FXML
    private Text num_bombs;
    @FXML
    private Text timer_lb;
    @FXML
    private Button sugenrencia_bt;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int b_c = 10;
        lst_b();//esta llamada carga todos los botones en un array :(
        this.Matrix_Main = new Game_Matrix(b_c);// esta llamada inicializa la matriz con una cantidad de bombas (10) y sus indicadores correspondientes
        this.load_img();//esta llamada carga todas la imagenes
        
        this.num_bombs.setText(b_c+"");
        this.contador = 0;
        this.time=0;
        
        this.COMPUTER = new Logic_Computer();// se inicializa la clase encargada de la logica de los tiros en de la computadora
        
        this.sugerencia = new Pila();
        
        this.g_m.setGraphic(new ImageView(this.img_c_f));//carga la imagen inicial en el boton de seleccion de modo de juego
        
        this.timer = new Timer(1000, (java.awt.event.ActionEvent e) -> {
            this.time++;
            Platform.runLater(()->this.timer_lb.setText(String.valueOf(this.time)));
        });
    }   
    
    
    
/**
 * este metodo cambia el modo de juego antes de que la partida comience
 * una ves hecho el primer tiro se le restringe el uso a solo imprimir la matriz 
 * para llevar un control
 * @param event 
 */
    @FXML
    private void game_mode(ActionEvent event) {
        System.out.println("\n###############################");
        this.Matrix_Main.prnt_mtrx();//imprime la matriz de las bombas y los respectivos indicadores
        System.out.println("\n###############################");
        if(!this.begin){//se asegura que no se haya realizado ningun disparo por parte del jugador
            if(this.ga_mo){//si el indicador es true se ejecuta el cambio de dificil a facil
                System.out.println("ez mode activated");
                this.g_m.setGraphic((new ImageView(this.img_c_f)));//se le asigna la imagen de modo facil al boton principal
                
            }else{
                System.out.println("hard mode activated");
                this.g_m.setGraphic((new ImageView(this.img_c_s)));//se le asigna la imagen de modo dificil al boton principal
                
            }
            this.ga_mo=!this.ga_mo;//se alterna el valor booleano
        }
        
    }
    /**
     * este metodo sencarga de pedir las cordenadas del tiro de la computadora en ambos modos de juego
     */
    private void c_play(){
        if(this.ga_mo){//dependiendo del estado de la variable booleana es le tipo de tiro
            
            String shoot = this.COMPUTER.c_shoot(Matrix_Main);//obtiene un string con la informacion de las coordenadas y si es bandera o jugada 
            
            String[] s = shoot.split(" ");//obtiene las coordenadas y el tipo de tiro
            
            int i = Integer.parseInt(s[0]);//la fila de las coordenadas
            int j = Integer.parseInt(s[1]);//la colubna de las coordenadas
            String code = s[2];//el codigo diferenciador del tipo de tiro
            
            System.out.println(code + " en " + i + "__" + j);//por control imprime las cordenadas despues del identificador de tiro
            String info = this.Matrix_Main.get_cords(i, j);//obtiene el codigo de la casilla en las coordenadas
            
            if(code.equals("@bndr")){//revisa si el identificador de tiro es para colocar una bandera
                
                this.Matrix_Main.setCords(i, j, "@bndr", false);//a;ade a la matriz la etidqueta de que ha sido colocada una bandera en la casilla
                this.plc_img("bndr_c", this.btn_m[i][j], i, j);//se realiza la llamada para colocar la imagen correspondiente al boton seleccionado

                int bombs_temp = Integer.parseInt(this.num_bombs.getText());//disminulle en uno la el indicador de posibles bombas encontradas
                this.num_bombs.setText((bombs_temp - 1)+"");//actualiza la etiqueta

                this.playable = true;//devuelve la oportunidad al judador para seleccionar un tiro
                
            }else if(code.equals("@clkd")){//si el identificador de tiro es jugar la casilla
                
                this.plc_img(info + "_c", this.btn_m[i][j], i, j);//coloca la imegen correspondiente a la casilla jugada
                this.Matrix_Main.setCords(i, j, "@clkd", false);//se actualiza la informacion en la matriz para evidencia qie ya fue jugada
                if(!info.contains("Bomb")){//si en las cordenadas no hay una bomba
                    this.playable = true;//devuelve la posibilidad al jugador de selecciona un tiro 
                }else{//si en la casilla hay una bomba
                    this.timer.stop();//detiene el contador de tiempo
                    this.plc_img("gan", this.g_m, i, j);//coloca la imagen para dejarle saber al jugador que ya gano
                }
                
            }
        }else{//si el indicador es false significa modo "dummy"
         
            String shoot = this.COMPUTER.c_shoot();//se generan cordenadas aleatorias 
            int i = Integer.parseInt(shoot.charAt(0)+"");//se obtiene la fila de las cordenadas 
            int j = Integer.parseInt(shoot.charAt(2)+"");//se obtiene la columna de las cordenadas

            
            String info = this.Matrix_Main.get_cords(i, j);//obtiene el codigo de lo que hay en la casilla seleccionada

            if(info.contains("@clkd") || info.contains("@bndr")){//se serciora que esa casilla no haya sido juganda antes
                c_play();//realiza una llamada recurciva hasta que la casilla seleccionada de manera aleatoria no haya sido jugada
                return;//detiene la ejecucuin para evitar errores
            }

            plc_img(info+"_c",this.btn_m[i][j],i,j);//hace la llamada a colocar la imagen correspondiente al boton en las cordenadas i,j
            //this.Matrix_Main.setCords(i, j, "@clkd", false);//a;ade a las cordenadas el indicador de que la casilla ya fue cliqueada

            if(!info.equals("Bomb")){//si la ca
            this.playable = true;//restaura la posibilidad del jugador para tirar
            }else{
                this.plc_img("gan", this.g_m, i, j);
                this.timer.stop();
            }
        }
           
        
    }
    
    /**
     * este metodo esta encargado de gentionar los tiros realizados por el jugador
     * de manera que se separan en clik derecho e izquierdo
     * 
     * el iz realiza el tiro principal 
     * el der coloca o quita una vandera 
     * 
     * @param e 
     */
    @FXML
    private void cords_selected(MouseEvent e) {
        if(this.playable && !this.lose){//se asegura que sea turno del jugador y que no se halla terminado el juego
            if(!this.begin){
                this.begin=true;
                this.timer.start();
            }//si el primer tiro de la partida se cambia el balor a iniciado
            
            this.playable = false;//le quita la posibilidad al jugador de tirar para que no tire fuera de su turno
            
            Button x = (Button) e.getSource();//se obtiene el boton que realiza el tiro
            int i = Integer.parseInt(x.getId().charAt(1)+"");//separa la cordenada i dada por el nombre del boton
            int j = Integer.parseInt(x.getId().charAt(3)+"");//separa la cordenada j dada por el nombre del boton
            
            String info=this.Matrix_Main.get_cords(i,j);//con las cordenadas i,j se consulata a la matriz principal el contenido
            
            if ("PRIMARY".equals(e.getButton().toString())){//en caso de que el boton se precione con el clik iz
                
                if(!info.contains("@clkd") & !info.contains("@bndr")){//se asegura que la casilla no tenga bandera o que no haya sido juegada 
                    
                    if(++this.contador == 5 && !this.lose){
                        this.contador = 0;
                        this.sugerencia.consejo(Matrix_Main);
                        this.sugenrencia_bt.setText("?"+this.sugerencia.get_num());
                        this.sugenrencia_bt.setDisable(false);
                    }
                    
                    plc_img(info,x,i,j);//se realiza la llamada para colocar la imagen correspondiente en le boton seleccionado
                    
                    if(!this.Matrix_Main.get_cords(i, j).contains("Bomb")){//se verifica que la casilla no fuera una bomba 
                        this.c_play();//si no lo es se hace la llamada al metodo que genera la jugada de la computadora
                        /*if(this.Matrix_Main.get_shots()==0){
                        
                        this.plc_img("gan", this.g_m, i, j);
                        this.timer.stop();
                        
                        }else{
                        
                        }*/
                    }else{
                    this.timer.stop();
                    }
                        
                }
            }
            if ("SECONDARY".equals(e.getButton().toString())){//en caso que el boton se precione con el clik der
                //System.out.println(info + "@der "+i+" "+j);//se imprime por control las cordenadas y lo que estas contienen
                if(!info.contains("@clkd") & !info.contains("@bndr")){//se asegura que la casilla no tenga ni bandera ni haya sido jugada

                    if(++this.contador == 2 && !this.lose){
                        this.contador = 0;
                        this.sugerencia.consejo(Matrix_Main);
                        this.sugenrencia_bt.setText("?"+this.sugerencia.get_num());
                        this.sugenrencia_bt.setDisable(false);
                    }
                    
                    this.Matrix_Main.setCords(i, j, "@bndr", false);//a;ade a la matriz la etidqueta de que ha sido colocada una bandera en la casilla
                    plc_img("bndr", x, i, j);//se realiza la llamada para colocar la imagen correspondiente al boton seleccionado
                    
                    int bombs_temp = Integer.parseInt(this.num_bombs.getText());
                    this.num_bombs.setText((bombs_temp - 1)+"");
                    
                    this.playable = false;//le quita la posibilidad al jugador de tirar fuera de su turno
                    this.c_play();//realiza la llamada al metodo que controla el tiro de la computadora
           
                }else if(this.Matrix_Main.get_cords(i,j).contains("@bndr")){//si solo tiene el indicador de bandera la quita
                    
                    if(++this.contador == 2 && !this.lose){
                        this.contador = 0;
                        this.sugerencia.consejo(Matrix_Main);
                        this.sugenrencia_bt.setText("?"+this.sugerencia.get_num());
                        this.sugenrencia_bt.setDisable(false);
                    }
                    
                    x.setGraphic(null);//elimina la imagen de banderda del boton
                    String temp = info.split("@")[0];//obtiene le valor origianl en las cordenandas
                    this.Matrix_Main.setCords(i, j, temp, true);//lo guarda en la posicion en la que estba pero ahora sin el indicador de bandera
                    
                    int bombs_temp = 1+Integer.parseInt(this.num_bombs.getText());
                    this.num_bombs.setText(bombs_temp + "");
                    
                    this.playable = false;//le quita la posibilidad al jugador de tirar fuera de su turno
                    this.c_play();//realiza la llamada al metodo que controla el tiro de la computadora
                }
            }
            
        }
    }
    
        @FXML
    private void juega_sug(ActionEvent event) {
        
        if(!this.playable || this.lose || this.sugerencia.get_num()<0){
            //System.out.println("cea necio");
            return;}
        
        String temp = this.sugerencia.pop();
        
        if(this.sugerencia.get_num() == 0){
            this.sugenrencia_bt.setDisable(true);
        }
        
        if(temp == null){
        return;
        }
        
        int i = Integer.parseInt(temp.split(" ")[0]);//separa la cordenada i dada por el nombre del boton
        int j = Integer.parseInt(temp.split(" ")[1]);//separa la cordenada j dada por el nombre del boton
        
        //System.out.println(temp+" estes son las coordenadas sugeridas" + i + " " + j);
        
        String info = this.Matrix_Main.get_cords(i, j);
        
        if(info.contains("@clkd") || info.contains("@bndr")){
            this.juega_sug(event);
            return;
        }
        
        this.plc_img(info, this.btn_m[i][j], i, j);
        
        this.sugenrencia_bt.setText("?"+this.sugerencia.get_num());
        
        this.playable = false;//le quita la posibilidad al jugador de tirar fuera de su turno
        this.c_play();//realiza la llamada al metodo que controla el tiro de la computadora

    }
    
    /**
     * este metodo se encarga de colocar las imagenes en los botones de la matriz 
     * @param code es el indicador de que boton debe de poner
     * @param b es el boton en el que deve de poner la imagen
     * @param i es la cordenada fila del boton 
     * @param j es la cordenada columna del boton
     */
    private void plc_img(String code, Button b, int i, int j){
        
        switch(code){
            
            case "bndr"://significa que debe de poner una bandera en el boton
                b.setGraphic(new ImageView(this.img_bndr));
                break;
            case "bndr_c"://significa que debe de poner una bandera en el boton
                b.setGraphic(new ImageView(this.img_bndr_c));
                break;
            case "gan"://significa que debe poner la cara ganadora en el boton principal y detener el juego
                this.g_m.setGraphic(new ImageView(this.img_c_g));
                this.playable = false;
                this.sugenrencia_bt.setDisable(true);
                break;
            case "Bomb"://significa que debe poner una bomba roja en la casilla y detener el juego porque el jugador perdio
                b.setGraphic(new ImageView(this.img_b_r));
                this.g_m.setGraphic(new ImageView(this.img_c_d));
                this.sugenrencia_bt.setDisable(true);
                this.lose = true;
                break;
            case "Bomb_c"://significa que debe poner una bomba en la casilla y detener el juego porque el jugador gano
                b.setGraphic(new ImageView(this.img_b));
                this.g_m.setGraphic(new ImageView(this.img_c_g));
                this.sugenrencia_bt.setDisable(true);
                this.playable = false;
                break;
            case "0"://significa que debe poner la imagen correspondiente a cuando el tiro del jugador da en una casilla sin bombas circundantes
                b.setGraphic(new ImageView(this.img_0));
                this.Matrix_Main.setCords(i, j, "@clkd", false);
                //realiza la llamada al metodo que le a;ade el indiacador a la casilla que ya fie jugada
                for(int x = (i - 1); x < (i+2); x++){
                    for(int y = (j - 1); y < (j+2); y++){
                            try{
                                if(!(this.Matrix_Main.get_cords(x, y).contains("@clkd"))){
                                    
                                    this.plc_img(this.Matrix_Main.get_cords(x, y),this.btn_m[x][y],x,y);
                                }
                            }catch(Exception e){
                                
                            }
                    }
                }
                break;
            case "1"://significa que debe poner la imagen correspondiente a cuando el tiro del jugador da en una casiila con una bomba circuandate
                b.setGraphic(new ImageView(this.img_1));
                this.Matrix_Main.setCords(i, j, "@clkd", false);//realiza la llamada al metodo que le a;ade el indiacador a la casilla que ya fie jugada
                break;
            case "2"://significa que debe poner la imagen correspondietne a cuendo el tiro del jugador da en una casilla con dos bomnbas circundantes
                b.setGraphic(new ImageView(this.img_2));
                this.Matrix_Main.setCords(i, j, "@clkd", false);//realiza la llamada al metodo que le a;ade el indiacador a la casilla que ya fie jugada
                break;
            case "3"://significa que debe poner la imagen correspondietne a cuando el tipo del jugador da en una casilla con tres bombas cirncundantes
                b.setGraphic(new ImageView(this.img_3));
                this.Matrix_Main.setCords(i, j, "@clkd", false);//realiza la llamada al metodo que le a;ade el indiacador a la casilla que ya fie jugada
                break;
            case "4"://signfica qeu debe poner la imagen correspondiente a cuando el tiro del jugador da en una casilla con cuatro bombas circundantes
                b.setGraphic(new ImageView(this.img_4));
                this.Matrix_Main.setCords(i, j, "@clkd", false);//realiza la llamada al metodo que le a;ade el indiacador a la casilla que ya fie jugada
                break;
            case "5"://significa que debe poner la imagen correspondiente a cuando el tiro del jugador da en una casilla con cinco bombas circundades
                b.setGraphic(new ImageView(this.img_5));
                this.Matrix_Main.setCords(i, j, "@clkd", false);//realiza la llamada al metodo que le a;ade el indiacador a la casilla que ya fie jugada
                break;
            case "0_c"://sifnifica que debe poner la imagen correspondiente a cuando la computadora da en uan casiila con cero bombas circundantes
                b.setGraphic(new ImageView(this.img_0_c));
                this.Matrix_Main.setCords(i, j, "@clkd", false);//realiza la llamada al metodo que le a;ade el indiacador a la casilla que ya fie jugada
                for(int x = i-1; x< (i+2); x++){
                    for(int y = (j - 1); y < (j+2); y++){
                        if(x==i && y==j){break;}
                        try{
                            
                            this.plc_img(this.Matrix_Main.get_cords(x, y)+"_c",this.btn_m[x][y],x,y);

                        }catch(Exception e){}
                    }
                }
                break;
            case "1_c"://significa que debe poner la imagen correspondiente a cuando al ocmputadora da en una casilla con una bomba circundante
                b.setGraphic(new ImageView(this.img_1_c));
                this.Matrix_Main.setCords(i, j, "@clkd", false);//realiza la llamada al metodo que le a;ade el indiacador a la casilla que ya fie jugada
                break;
            case "2_c"://signfinica que debe poner la imagen correspondiente a cuando la computadora da en una casilla con dos bombas circundantes
                b.setGraphic(new ImageView(this.img_2_c));
                this.Matrix_Main.setCords(i, j, "@clkd", false);//realiza la llamada al metodo que le a;ade el indiacador a la casilla que ya fie jugada
                break;
            case "3_c"://significa que debe poner la imagen correspondiente a cuando la ocmputadora da en una casilla con tres bombas circunadantes
                b.setGraphic(new ImageView(this.img_3_c));
                this.Matrix_Main.setCords(i, j, "@clkd", false);//realiza la llamada al metodo que le a;ade el indiacador a la casilla que ya fie jugada
                break;
            case "4_c"://significa que debe poner la imgaen correspontiende a cuando al computadora da en una casilla con cuatro bombas circundatnes
                b.setGraphic(new ImageView(this.img_4_c));
                this.Matrix_Main.setCords(i, j, "@clkd", false);//realiza la llamada al metodo que le a;ade el indiacador a la casilla que ya fie jugada
                break;
            case "5_c"://significa que debe poner la imagen correspondiente a cuando la computadora da en cuna casilla con cinco bombas circuandatnes
                b.setGraphic(new ImageView(this.img_5_c));
                this.Matrix_Main.setCords(i, j, "@clkd", false);//realiza la llamada al metodo que le a;ade el indiacador a la casilla que ya fie jugada
                break;
            default://significa que hubo un error el el codigo no esta tipificado
                //System.out.println( i+"---"+j+"codigo no reconocido");
                break;
        }
    }
    
    
    
    /**
     * este metodo se encarga de cargar todas las imagenes y las guarda en atributos de la clase para facul acceso
     */
    private void load_img(){
        
        URL l_bomba = getClass().getResource("/auxiliar/bomba.png");
        URL l_bom_r = getClass().getResource("/auxiliar/bomba_red.png");
        URL l_c_f = getClass().getResource("/auxiliar/cara_feliz.png");
        URL l_c_d = getClass().getResource("/auxiliar/cara_muerta.png");
        URL l_c_s = getClass().getResource("/auxiliar/cara_sorp.png");
        URL l_c_g = getClass().getResource("/auxiliar/cara_fachera.png");
        URL l_bndr = getClass().getResource("/auxiliar/bndr.png");
        URL l_bndr_c = getClass().getResource("/auxiliar/bndr_c.png");
        URL l_0 = getClass().getResource("/auxiliar/0.png");
        URL l_0_c = getClass().getResource("/auxiliar/0_c.png");
        URL l_1 = getClass().getResource("/auxiliar/1.png");
        URL l_1_c = getClass().getResource("/auxiliar/1_c.png");
        URL l_2 = getClass().getResource("/auxiliar/2.png");
        URL l_2_c = getClass().getResource("/auxiliar/2_c.png");
        URL l_3 = getClass().getResource("/auxiliar/3.png");
        URL l_3_c = getClass().getResource("/auxiliar/3_c.png");
        URL l_4 = getClass().getResource("/auxiliar/4.png");
        URL l_4_c = getClass().getResource("/auxiliar/4_c.png");
        URL l_5 = getClass().getResource("/auxiliar/5.png");
        URL l_5_c = getClass().getResource("/auxiliar/5_c.png");
        
        this.img_b = new Image(l_bomba.toString(),20,20,false,true);
        this.img_b_r = new Image(l_bom_r.toString(),20,20,false,true);
        this.img_c_f = new Image(l_c_f.toString(),40,40,false,true);
        this.img_c_d = new Image(l_c_d.toString(),40,40,false,true);
        this.img_c_s = new Image(l_c_s.toString(),40,40,false,true);
        this.img_c_g = new Image(l_c_g.toString(),40,40,false,true);
        this.img_bndr = new Image(l_bndr.toString(),20,20,false,true);
        this.img_0 = new Image(l_0.toString(),20,20,false,true);
        this.img_1 = new Image(l_1.toString(),20,20,false,true);
        this.img_2 = new Image(l_2.toString(),20,20,false,true);
        this.img_3 = new Image(l_3.toString(),20,20,false,true);
        this.img_4 = new Image(l_4.toString(),20,20,false,true);
        this.img_5 = new Image(l_5.toString(),20,20,false,true);
        this.img_bndr_c = new Image(l_bndr_c.toString(),20,20,false,true);
        this.img_0_c = new Image(l_0_c.toString(),20,20,false,true);
        this.img_1_c = new Image(l_1_c.toString(),20,20,false,true);
        this.img_2_c = new Image(l_2_c.toString(),20,20,false,true);
        this.img_3_c = new Image(l_3_c.toString(),20,20,false,true);
        this.img_4_c = new Image(l_4_c.toString(),20,20,false,true);
        this.img_5_c = new Image(l_5_c.toString(),20,20,false,true);
    }
    /**
     * este metodo ordena todos los botones en una matriz para facil acceso
     */
    private void lst_b(){
        Button f0[] = {this.b0_0, this.b0_1, this.b0_2, this.b0_3, this.b0_4, this.b0_5, this.b0_6, this.b0_7};
        Button f1[] = {this.b1_0, this.b1_1, this.b1_2, this.b1_3, this.b1_4, this.b1_5, this.b1_6, this.b1_7};
        Button f2[] = {this.b2_0, this.b2_1, this.b2_2, this.b2_3, this.b2_4, this.b2_5, this.b2_6, this.b2_7};
        Button f3[] = {this.b3_0, this.b3_1, this.b3_2, this.b3_3, this.b3_4, this.b3_5, this.b3_6, this.b3_7};
        Button f4[] = {this.b4_0, this.b4_1, this.b4_2, this.b4_3, this.b4_4, this.b4_5, this.b4_6, this.b4_7};
        Button f5[] = {this.b5_0, this.b5_1, this.b5_2, this.b5_3, this.b5_4, this.b5_5, this.b5_6, this.b5_7};
        Button f6[] = {this.b6_0, this.b6_1, this.b6_2, this.b6_3, this.b6_4, this.b6_5, this.b6_6, this.b6_7};
        Button f7[] = {this.b7_0, this.b7_1, this.b7_2, this.b7_3, this.b7_4, this.b7_5, this.b7_6, this.b7_7};
        
        this.btn_m[0] = f0;
        this.btn_m[1] = f1;
        this.btn_m[2] = f2;
        this.btn_m[3] = f3; 
        this.btn_m[4] = f4;
        this.btn_m[5] = f5; 
        this.btn_m[6] = f6; 
        this.btn_m[7] = f7; 
    }


}
