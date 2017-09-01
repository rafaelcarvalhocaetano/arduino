int led = 9;
int dado;

void setup() {
  Serial.begin(9600);
  pinMode(led, OUTPUT);
}

void loop() {

 if(Serial.available() > 0){
  dado = Serial.read();
  switch(dado){
    case 1:
      digitalWrite(led, HIGH);
      break;
    case 2:
      digitalWrite(led, LOW);
      break;
  }
 }
}
