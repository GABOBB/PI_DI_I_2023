/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javafx.application.Platform;

/**
 *
 * @author Gabriel
 */
public class Arduino_serial_c extends Thread {
    private SerialPort ardn_prt;
    
    private M__F_C Win_c;
    
    private OutputStream outP;
    private InputStream inP;
    
    private boolean reading;
        
    SerialPort[] AvailablePorts = SerialPort.getCommPorts();
    
    public Arduino_serial_c (M__F_C c){
        this.Win_c = c;
        
        this.ardn_prt = SerialPort.getCommPort("COM6");
        this.ardn_prt.setBaudRate(9600);

        if(this.ardn_prt.openPort(1000)){
            System.out.println("el puerto se abrio correctamente :)");
            this.reading = true;
        }else{
            System.err.println("el puerto no se pudo abrir :(");
            return;
        }

        this.inP = this.ardn_prt.getInputStream();
        this.outP = this.ardn_prt.getOutputStream();
        
    }
    
    public void close(){
        this.reading = false;
        this.ardn_prt.closePort();
        if(!this.ardn_prt.isOpen()){
            System.out.println("se logro cerrar el puerto correctamente");
        }
    }
    
 private void accion(String code){
    Platform.runLater(() -> {
        if(this.Win_c.get_playable() && !this.Win_c.get_lose()){
        
            if(code.contains("UP")){
                this.Win_c.move_UP();
            }else if(code.contains("DW")){
                this.Win_c.move_dn();
            }else if(code.contains("LF")){
                this.Win_c.move_LF();
            }else if(code.contains("RT")){
                this.Win_c.move_RD();
            }else if(code.contains("@bndr")){
                this.Win_c.flag_ino();
            }else if(code.contains("@clkd")){
                this.Win_c.Sht_ino();
            }
        }
    });
}
    public void send_s(String mensaje) {
    try {
        this.outP.write(mensaje.getBytes());
        this.outP.flush();
        System.out.println("Mensaje enviado: " + mensaje);
    } catch (IOException ex) {
        Logger.getLogger(Arduino_serial_c.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    
    @Override
    public void run(){
        while(this.reading){
            try {
                if(this.inP.available() >0){
                    byte[] bffr = new byte[this.inP.available()];
                    this.inP.read(bffr);
                    String data = new String(bffr);
                    System.out.println(data);
                    this.accion(data);
                    Thread.sleep(100);
                }
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Arduino_serial_c.class.getName()).log(Level.SEVERE, null, ex);
            
            }
            
        }
    }
}



