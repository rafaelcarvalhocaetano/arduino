int led = 2;

void setup() {
 Serial.begin(9600);
 pinMode(led, OUTPUT);
}

void loop() {
  char tel = Serial.read();
  if(tel == 'l'){
     digitalWrite(led, HIGH);
  }else if(tel == 'b' ){
    digitalWrite(led, LOW);    
  }

}
