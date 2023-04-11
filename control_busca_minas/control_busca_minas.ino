#iclude <Keyboard.h>
#iclude <Mouse.h>

void setup() {
  // put your setup code here, to run once:

}

void loop() {
  xPosition = analogRead(VRx);
  yPosition = analogRead(VRy);
  SW_state = digitalRead(SW);
  mapX = map(xPosition, 0, 1023, -512, 512);
  mapY = map(yPosition, 0, 1023, -512, 512);

  if (SW_state==LOW){
    Serial.println("CLK\n");
  }
  
  if (mapX>150){
    
    Mouse.move(-40, 0)
    delay(500);

  } else if (mapX<-150){
    
    Serial.println("RGH\n");
    Mouse.move(40, 0)
    delay(500);
  
  } else if (mapX>350){
    
    Mouse.move(-40, 0)
    delay(200);

  } else if (mapX<-350){

    Mouse.move(40, 0)
    delay(200);

  }

  if (mapY>150){
    Serial.println("DWN\n");
    delay(500);
  }
  else if (mapY<-150){
    Serial.println("UP\n");
    delay(500);
  }
  readSerial();
  
}
