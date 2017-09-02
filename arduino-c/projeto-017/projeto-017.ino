int n1 = 0;
int led = 9;

void setup() //funcao que é executada ao iniciar a aplicação
{
Serial.begin(9600);
pinMode(led,OUTPUT);
}
int ligaLed(int n, char a){
  
  if(a == 'l'){
    digitalWrite(led, HIGH);
    delay(n);
    digitalWrite(led, LOW);
  }else if(a == 'w'){
    digitalWrite(led, LOW);
  }
}
void loop(){
  if (Serial.available() > 0){
    n1 = Serial.parseInt();
   char a = Serial.read();
    // Serial.println(n1);
    
     ligaLed(n1, a);
    
    
  }
}
