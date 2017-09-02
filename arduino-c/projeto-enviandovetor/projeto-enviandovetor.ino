int led;
void setup() {
  Serial.begin(9600);
  pinMode(led, OUTPUT);
}
int buscar(int n){
  int i;
  for(i=0; i<=n; i++){
    
    delay(100);
    digitalWrite(i, HIGH);
    Serial.println(i);
  }
}

void loop() {
  if(Serial.available()){
    led = Serial.parseInt();
    
    buscar(led);
  }

}
