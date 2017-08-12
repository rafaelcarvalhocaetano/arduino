  int intervaloPisca = 100;
  int intervalo2Pisca = 200;
  int porta1 = 10;
  int porta2 = 9;
  
void setup() {
  pinMode(porta1, OUTPUT);
  pinMode(porta2, OUTPUT);

}

void loop() {
  /*
  int intervaloPisca = 100;
  int intervalo2Pisca = 200;
  int porta1 = 10;
  int porta2 = 9;
  */
  
  digitalWrite(porta1, HIGH);
  digitalWrite(porta2, LOW);
  delay(intervaloPisca);

  digitalWrite(porta1, LOW);
  digitalWrite(porta2, HIGH);
  delay(intervalo2Pisca);


}
