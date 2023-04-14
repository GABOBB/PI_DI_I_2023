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

/**
 *
 * @author Gabriel
 */
public class Arduino_serial_c extends Thread {
    private SerialPort ardn_prt;
    
    private OutputStream outP;
    private InputStream inP;
    
    private boolean reading;
        
    SerialPort[] AvailablePorts = SerialPort.getCommPorts();
    
    public Arduino_serial_c (){
        this.ardn_prt = SerialPort.getCommPort("COM6");
        this.ardn_prt.setBaudRate(9600);

        if(this.ardn_prt.openPort(1000)){

        }else{
            System.err.println("el puerto no se pudo abrir :(");
            return;
        }

        this.inP = this.ardn_prt.getInputStream();
        this.outP = this.ardn_prt.getOutputStream();
    }
    
    private void accion(){
    
    
    }
    
    @Override
    public void run(){
        while(this.reading){
            try {
                if(this.inP.available() >0){
                    byte[] bffr = new byte[this.inP.available()];
                    this.inP.read(bffr);
                    String data = new String(bffr);
                    
                    
                    Thread.sleep(200);
                }
            } catch (IOException ex) {
                Logger.getLogger(Arduino_serial_c.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Arduino_serial_c.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}



