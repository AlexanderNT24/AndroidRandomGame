package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> numbers = new ArrayList<Integer>(100);
    int contador=0;
    int jugadorActivo=0;
    int puntajeJugador1=0;
    int puntajeJugador2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnJugar = findViewById(R.id.btnJugar);
        Button btnResetear = findViewById(R.id.btnResetear);

        TextView textJugador1 = findViewById(R.id.jugadorText1);
        TextView textJugador2 = findViewById(R.id.jugadorText2);

        TextView textGanador = findViewById(R.id.ganadorText);



        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++;
                if (contador % 2 == 0) {
                    puntajeJugador2 = (int) (Math.random() * (10 + 1 - 1)) + 1;
                    textJugador2.setText(puntajeJugador2+"");


                    juego(textGanador);
                    jugadorActivo=1;

                } else {
                    puntajeJugador1 = (int) (Math.random() * (10 + 1 - 1)) + 1;
                    textJugador1.setText(puntajeJugador1+"");
                    jugadorActivo=2;

                }
                btnJugar.setText("Jugador: "+jugadorActivo);


            }
        });

        btnResetear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador=0;
                jugadorActivo=1;
                int puntajeJugador1=0;
                int puntajeJugador2=0;
                textJugador1.setText(0+"");
                textJugador2.setText(0+"");
                btnJugar.setText("Jugador: "+jugadorActivo);
                textGanador.setText("Gana jugador:");
                }


        });


        }



        private void juego(TextView textGanador){

             if(puntajeJugador1==puntajeJugador2){
                 textGanador.setText("Empate");
             } else if (puntajeJugador1>puntajeJugador2) {
                 textGanador.setText("Gana jugador 1");
             }else {
                 textGanador.setText("Gana jugador 2");
             }

        }

}