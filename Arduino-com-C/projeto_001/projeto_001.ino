void setup() {
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
 

}

void loop() {
  digitalWrite(9, HIGH);
  delay(100);
  digitalWrite(9, LOW);
  delay(100);
  digitalWrite(10, HIGH);
  delay(100);
  digitalWrite(10, LOW);
  delay(100);
  
  
}
