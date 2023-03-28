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
    
    private Game_Matrix Matrix_Main;
    
    private boolean begin = false;
    private boolean ga_mo = false;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.Matrix_Main = new Game_Matrix(10);
        this.load_img();
        
        this.g_m.setGraphic(new ImageView(this.img_c_f));
    }    

    @FXML
    private void game_mode(ActionEvent event) {
        if(!this.begin){
            if(!this.ga_mo){
                System.out.println("hard mode activated");
                this.g_m.setGraphic((new ImageView(this.img_c_d)));
                
            }else{
                System.out.println("ez mode activated");
                this.g_m.setGraphic((new ImageView(this.img_c_f)));
                //insertar cambio de imagen
            }
            this.ga_mo=!this.ga_mo;
        }
    }

    @FXML
    private void cords_selected(MouseEvent e) {
        if(!this.begin){this.begin=true;}
        String info="";
        
        Button x = (Button) e.getSource();
        int i = Integer.parseInt(x.getId().charAt(1)+"");
        int j = Integer.parseInt(x.getId().charAt(3)+"");

        if ("PRIMARY".equals(e.getButton().toString())){
            System.out.println("der "+i+" "+j);
            System.out.println(this.Matrix_Main.Player_S(i, j));
            if((this.Matrix_Main.Player_S(i, j)!=null) && this.Matrix_Main.Player_S(i, j).equals("Bomb")){
                x.setGraphic((new ImageView(this.img_b_r)));
            } 
        }
        if ("SECONDARY".equals(e.getButton().toString())){
            System.out.println("iz "+i+" "+j);
        }
        
    }
    
    private void load_img(){
        URL l_bomba = getClass().getResource("/auxiliar/cara_feliz.png");
        URL l_bom_r = getClass().getResource("/auxiliar/bomba_red.png");
        URL l_c_f = getClass().getResource("/auxiliar/cara_feliz.png");
        URL l_c_d = getClass().getResource("/auxiliar/cara_muerta.png");
        URL l_c_s = getClass().getResource("/auxiliar/cara_sorp.png");
        
        this.img_b = new Image(l_bomba.toString(),20,20,false,true);
        this.img_b_r = new Image(l_bom_r.toString(),20,20,false,true);
        this.img_c_f = new Image(l_c_f.toString(),40,40,false,true);
        this.img_c_d = new Image(l_c_d.toString(),40,40,false,true);
        this.img_c_s = new Image(l_c_s.toString(),40,40,false,true);
        
    }
}
