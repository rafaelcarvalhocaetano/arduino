/*
Ligando LED com PUSH BUTTON
Autor: Rafael Carvalho
*/
int pinLed = 13;
int pinoBtn = 2;
int estadoBtn = 0;


void setup() {
  pinMode(pinLed, OUTPUT);
  pinMode(pinoBtn, INPUT);

}

void loop() {

  estadoBtn = digitalRead(pinoBtn);

  if(estadoBtn == HIGH){
   
      digitalWrite(pinLed, HIGH);
      digitalWrite(pinLed, LOW);
   
  }else{
   
    digitalWrite(pinLed, LOW);
  }
}
