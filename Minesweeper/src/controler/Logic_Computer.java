/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import model.L_d_e;
import model.N_d_e;

/**
 *
 * @author Gabriel
 */
public class Logic_Computer {
    private L_d_e P_list;
    private L_d_e S_list;
    private L_d_e I_list;
    
    public Logic_Computer(){
        this.P_list = main_list_generator();
        this.S_list = new L_d_e();
        this.I_list = new L_d_e();
    }
    
    public String ez_shoot(){
        int x = Rndm.random_int(P_list.get_size()-1);
        N_d_e temp = P_list.srch_indx(x);
        P_list.d_srch_indx(x);
        
        return temp.get_Id().charAt(0)+ temp.get_Id().charAt(2)+"";
    }
    
    
    private L_d_e main_list_generator(){
        L_d_e l = new L_d_e();
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                N_d_e temp = new N_d_e(null,null,i+"_"+j);
                l.add_l(temp);
            }
        }
        return l; 
    }
}
