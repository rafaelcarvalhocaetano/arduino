void setup() {
  pinMode(10, OUTPUT);
  pinMode(9, OUTPUT);

}

void loop() {
  int intervaloPisca = 100;
  
  digitalWrite(10, HIGH);
  digitalWrite(9, LOW);
  delay(intervaloPisca);

  digitalWrite(10, LOW);
  digitalWrite(9, HIGH);
  delay(intervaloPisca);


}
