/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Game_Matrix;

/**
 * FXML Controller class
 *
 * @author GBB
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
    
    private Game_Matrix Matrix_Main;
    
    private Logic_Computer COMPUTER;
    
    private Button btn_m[][] = new Button[8][8];
    
    private boolean begin = false;
    private boolean lose = false;
    private boolean ga_mo = false;
    private boolean playable = true;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lst_b();
        this.Matrix_Main = new Game_Matrix(10);
        this.load_img();
        
        this.COMPUTER = new Logic_Computer();
        
        this.g_m.setGraphic(new ImageView(this.img_c_f));
    }    

    @FXML
    private void game_mode(ActionEvent event) {
        this.Matrix_Main.prnt_mtrx();
        if(!this.begin){
            if(!this.ga_mo){
                System.out.println("hard mode activated");
                this.g_m.setGraphic((new ImageView(this.img_c_s)));
                
            }else{
                System.out.println("ez mode activated");
                this.g_m.setGraphic((new ImageView(this.img_c_f)));
                //insertar cambio de imagen
            }
            this.ga_mo=!this.ga_mo;
        }
        
    }
    /**
     * este metodo sencarga de manejar si la computadora tira de manera alatoria o en el modo avando
     */
    private void c_play(){
        if(this.ga_mo){//revisa si la  variable buleana para saber el modo de juego
            
            String shoot = this.COMPUTER.c_shoot(true);
            int i = Integer.parseInt(shoot.charAt(0)+"");
            int j = Integer.parseInt(shoot.charAt(2)+"");
            
            System.out.println("tiro ez "+ i + " "+ j + " --- " + this.Matrix_Main.get_cords(i, j));
            
            plc_img(this.Matrix_Main.get_cords(i, j)+"_c",this.btn_m[i][j],i,j);
            this.Matrix_Main.setCords(i, j, "@clkd", false);
        
        }else{
            
            String shoot = this.COMPUTER.c_shoot(false);
            int i = Integer.parseInt(shoot.charAt(0)+"");
            int j = Integer.parseInt(shoot.charAt(2)+"");
            
            System.out.println("tiro ez "+ i + " "+ j + " --- " + this.Matrix_Main.get_cords(i, j));
            
            plc_img(this.Matrix_Main.get_cords(i, j)+"_c",this.btn_m[i][j],i,j);
            this.Matrix_Main.setCords(i, j, "@clkd", false);
        }
        
        this.playable = true;//restaura la posibilidad del jugador para tirar
    }
    
    @FXML
    private void cords_selected(MouseEvent e) {
        if(this.playable & !this.lose){
            if(!this.begin){this.begin=true;}

            

            Button x = (Button) e.getSource();
            int i = Integer.parseInt(x.getId().charAt(1)+"");
            int j = Integer.parseInt(x.getId().charAt(3)+"");
            
            String info=this.Matrix_Main.get_cords(i,j);
            
            if ("PRIMARY".equals(e.getButton().toString())){

                //System.out.println("der "+i+" "+j);
                
                if(!info.contains("@clkd") & !info.contains("@bndr")){
                    System.out.println(info + "@der "+i+" "+j);
                    plc_img(info,x,i,j);
                    this.Matrix_Main.setCords(i, j, "@clkd", false);
                    this.playable = false;
                    if(!this.Matrix_Main.get_cords(i, j).contains("Bomb")){
                        this.c_play();
                    }
                        
                }
            }
            if ("SECONDARY".equals(e.getButton().toString())){
                if(!this.Matrix_Main.get_cords(i,j).contains("@clkd") & !this.Matrix_Main.get_cords(i,j).contains("@bndr")){
                    this.Matrix_Main.setCords(i, j, "@bndr", false);
                    plc_img("bndr", x, i, j);
           
                }else if(this.Matrix_Main.get_cords(i,j).contains("@bndr")){
                    x.setGraphic(null);
                    String temp = info.split("@")[0];
                    this.Matrix_Main.setCords(i, j, temp, true);
                
                }
            }
        //this.playable = false;
        //this.c_play();    
        }
    }
    private void plc_img(String code, Button b, int i, int j){
        switch(code){
            
            case "bndr":
                b.setGraphic(new ImageView(this.img_bndr));
                break;
            case "gan":
                this.g_m.setGraphic(new ImageView(this.img_c_g));
                this.playable = false;
                break;
            case "Bomb":
                b.setGraphic(new ImageView(this.img_b_r));
                this.g_m.setGraphic(new ImageView(this.img_c_d));
                this.lose = true;
                break;
            case "Bomb_c":
                b.setGraphic(new ImageView(this.img_b));
                this.g_m.setGraphic(new ImageView(this.img_c_g));
                this.playable = false;
                break;
            case "0":
                b.setGraphic(new ImageView(this.img_0));
                break;
            case "1":
                b.setGraphic(new ImageView(this.img_1));
                break;
            case "2":
                b.setGraphic(new ImageView(this.img_2));
                break;
            case "3":
                b.setGraphic(new ImageView(this.img_3));
                break;
            case "4":
                b.setGraphic(new ImageView(this.img_4));
                break;
            case "5":
                b.setGraphic(new ImageView(this.img_5));
                break;
            case "0_c":
                b.setGraphic(new ImageView(this.img_0));
                break;
            case "1_c":
                b.setGraphic(new ImageView(this.img_1_c));
                break;
            case "2_c":
                b.setGraphic(new ImageView(this.img_2_c));
                break;
            case "3_c":
                b.setGraphic(new ImageView(this.img_3_c));
                break;
            case "4_c":
                b.setGraphic(new ImageView(this.img_4_c));
                break;
            case "5_c":
                b.setGraphic(new ImageView(this.img_5_c));
                break;
            default:
                //b.setGraphic(new ImageView(this.img_0));
                break;
        }
    }
    
    private void load_img(){
        
        URL l_bomba = getClass().getResource("/auxiliar/bomba.png");
        URL l_bom_r = getClass().getResource("/auxiliar/bomba_red.png");
        URL l_c_f = getClass().getResource("/auxiliar/cara_feliz.png");
        URL l_c_d = getClass().getResource("/auxiliar/cara_muerta.png");
        URL l_c_s = getClass().getResource("/auxiliar/cara_sorp.png");
        URL l_c_g = getClass().getResource("/auxiliar/cara_fachera.png");
        URL l_bndr = getClass().getResource("/auxiliar/bndr.png");
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
        this.img_0_c = new Image(l_0_c.toString(),20,20,false,true);
        this.img_1_c = new Image(l_1_c.toString(),20,20,false,true);
        this.img_2_c = new Image(l_2_c.toString(),20,20,false,true);
        this.img_3_c = new Image(l_3_c.toString(),20,20,false,true);
        this.img_4_c = new Image(l_4_c.toString(),20,20,false,true);
        this.img_5_c = new Image(l_5_c.toString(),20,20,false,true);
    }
    
    private void lst_b(){
        Button f0[] = {this.b0_0, this.b0_1, this.b0_2, this.b0_3, this.b0_4, this.b0_5, this.b0_6, this.b0_7};
        Button f1[] = {this.b1_0, this.b1_1, this.b1_2, this.b1_3, this.b1_4, this.b1_5, this.b1_6, this.b1_7};
        Button f2[] = {this.b2_0, this.b2_1, this.b2_2, this.b2_3, this.b2_4, this.b2_5, this.b2_6, this.b2_7};
        Button f3[] = {this.b3_0, this.b3_1, this.b3_2, this.b3_3, this.b3_4, this.b3_5, this.b3_6, this.b3_7};
        Button f4[] = {this.b4_0, this.b4_1, this.b4_2, this.b4_3, this.b4_4, this.b4_5, this.b4_6, this.b4_7};
        Button f5[] = {this.b5_0, this.b5_1, this.b5_2, this.b5_3, this.b5_4, this.b5_5, this.b5_6, this.b5_7};
        Button f6[] = {this.b6_0, this.b6_1, this.b6_2, this.b6_3, this.b6_4, this.b6_5, this.b6_6, this.b6_7};
        Button f7[] = {this.b7_0, this.b7_1, this.b7_2, this.b7_3, this.b7_4, this.b7_5, this.b7_6, this.b0_7};
        
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
