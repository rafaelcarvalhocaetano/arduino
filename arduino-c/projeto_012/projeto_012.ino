#define pinsom 7
#define pinrele1 2
#define pinrele2 3
#define tempoMaxdeumapalma 150
#define tempoMaxEntrePalmas 500

int contapalmas = 0;
long tempoEspera = 0;
long tempoEsperaEntrePalmas = 0;

void setup() {
  pinMode(pinsom, INPUT);
  pinMode(pinrele1, OUTPUT);
  pinMode(pinrele2, OUTPUT);
}

void loop() {
  int sensorSom = digitalRead(pinsom);

  if(sensorSom == LOW){

    if(tempoEspera == 0){
      tempoEspera = tempoEsperaEntrePalmas = millis();
      contapalmas ++;
    }else if((millis() - tempoEspera) >= tempoMaxdeumapalma){
      tempoEspera = 0;
    }
  }
  if( (contapalmas != LOW) && ( millis() - tempoEsperaEntrePalmas) ){
    executarAcao();
    contapalmas = 0;
    tempoEsperaEntrePalmas = millis();
  }
}
void executarAcao(){
  switch(contapalmas){
    case 2:
      digitalWrite(pinrele1, !digitalRead(pinrele1));
      break;
    /*
    case 3:
      digitalWrite(pinrele2, !digitalRead(pinrele2));
      break;
      */
  }
}

