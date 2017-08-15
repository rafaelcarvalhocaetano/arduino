//FOTORESISTOR

int sensorPin = A0;
int ledPin = 9;
int ledPin2 = 7;
int sensorValue = 0;

void setup() {
  Serial.begin(9600);
  pinMode(ledPin, OUTPUT);
  pinMode(ledPin2, OUTPUT);

}

void loop() {
  sensorValue = analigRead(sensorPin);
  Serial.println("Sensor = "+sensorValue);

  if(sensorValue < 100){
    digitalWrite(ledPin, HIGH);
    digitalWrite(ledPin2, LOW);
  }else if(sensorValue > 101 && sensorValue < 150){
    digitalWrite(ledPin, LOW);
    digitalWrite(ledPin2, HIGH);
  }else{
     digitalWrite(ledPin, LOW);
    digitalWrite(ledPin2, LOW);
  }
  delay(1000);

}
