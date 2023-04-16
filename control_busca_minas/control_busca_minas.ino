int VRx = A5;
int VRy = A3;
int SW = 6;
int Bttn = 8;

const int ledPin = 7;

const int sPin = 2;

int xPosition = 0;
int yPosition = 0;
int SW_state = 0;
int mapX = 0;
int mapY = 0;

void setup() {
  Serial.begin(9600);
  
  pinMode(ledPin,OUTPUT);
  pinMode(sPin,OUTPUT);
  
  
  pinMode(VRx, INPUT);
  pinMode(VRy, INPUT);
  pinMode(SW, INPUT_PULLUP); 
  pinMode(Bttn, INPUT_PULLUP);

  Serial.println("Begin now");
}

void loop() {
  xPosition = analogRead(VRx);
  yPosition = analogRead(VRy);
  SW_state = digitalRead(SW);

  mapX = map(xPosition, 0, 1023, -512, 512);
  mapY = map(yPosition, 0, 1023, -512, 512);

  if (SW_state==LOW){
    Serial.println("@clkd\n");
  }
  if (digitalRead(Bttn)==LOW){
    Serial.println("@bndr\n");
  }
  if (mapX>450){
    Serial.println("RT\n");
  }
  else if (mapX<-450){
    Serial.println("LF\n");
  }

  if (mapY>450){
    Serial.println("UP\n");
  }
  else if (mapY<-450){
    Serial.println("DW\n");
  }
  readSerial();
  delay(100);
}

 void makesound(int n){
    int count = 0;
    int hz ;
    if(n==1){
        hz = 400;//fecuencia para darle a una bomba
                                     
    }else{
        hz = 300;//frecuencia para darle a casilla libre
    }
    while(count<700){
        count++;
        digitalWrite(sPin, HIGH);
        delayMicroseconds(hz);
        digitalWrite(sPin,LOW);
        delayMicroseconds(hz);
    } 
 } 

 void encenderLed(){
    digitalWrite(ledPin,HIGH);
    delay(300);
    digitalWrite(ledPin,LOW);
    
 }

 
 void readSerial(){ //leer el monitor serial
  if(Serial.available()>0){ //leer si tiene datos en el monitor serial
    String data = Serial.readString();
    Serial.print(" I receive: ");
    Serial.println(data);
    compareIncoming(data);
    }
  }
  //este metodo compara el data y enciende un led
 void compareIncoming(String data){

  if (data=="flag\n"){
    
    encenderLed();

  }else if (data=="bomb\n"){
    
    makesound(1);
  
  }else if (data=="safe\n"){
    
    makesound(2);
    
  }
 
}
