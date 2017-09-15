
void setup() {
  Serial.begin(9600);
  pinMode(7, OUTPUT);

}

void loop() {
 char nome = Serial.read();
 if(nome == 'a'){
  digitalWrite(7, HIGH);
 }
 if(nome == 'b'){
  digitalWrite(7, LOW);
 }
 
}
