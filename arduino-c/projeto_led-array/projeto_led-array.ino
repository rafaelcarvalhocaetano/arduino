
int led = 8;

void setup() {
  
  Serial.begin(9600);
  pinMode(led, OUTPUT);
}

void loop() {

  char serial = Serial.read();
  
  if(serial == 'l'){
    
    digitalWrite(8, HIGH);
    
  }else if(serial == 'd'){
    
    digitalWrite(8, LOW);
  }
}
