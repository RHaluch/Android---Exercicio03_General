package com.example.exercicio03_general;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button lancar;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lancar = findViewById(R.id.lancar);
        resultado = findViewById(R.id.resultado);
    }

    public void lancarDados(View view) {

        Random random = new Random();
        ArrayList valores = new ArrayList();
        String jogadas = "", maiorPonto = "";
        int pontos = 0;

        for (int i = 0; i < 5; i++) {
            valores.add(random.nextInt(6) + 1);
        }

        Collections.sort(valores);

        for (int i = 0; i < 5; i++) {
            jogadas += "(" + String.valueOf(i + 1) + ")Dado - Valor: " + String.valueOf(valores.get(i) + "\n");
        }

        //verificar pontos
        //jogada de 1
        if (Collections.frequency(valores, 1) > 0) {
            pontos = Collections.frequency(valores, 1);
            maiorPonto = "Jogada de 1 = " + String.valueOf(Collections.frequency(valores, 1) + " Pontos\n");
        }

        //jogada de 2
        if (Collections.frequency(valores, 2) > 0) {
            if (pontos < Collections.frequency(valores, 2) * 2) {
                pontos = Collections.frequency(valores, 2) * 2;
                maiorPonto = "Jogada de 2 = " + String.valueOf(Collections.frequency(valores, 2) * 2 + " Pontos\n");
            }
        }

        //jogada de 3
        if (Collections.frequency(valores, 3) > 0) {
            if (pontos < Collections.frequency(valores, 3) * 3) {
                pontos = Collections.frequency(valores, 3) * 3;
                maiorPonto = "Jogada de 3 = " + String.valueOf(Collections.frequency(valores, 3) * 3 + " Pontos\n");
            }
        }

        //jogada de 4
        if (Collections.frequency(valores, 4) > 0) {
            if (pontos < Collections.frequency(valores, 4) * 4) {
                pontos = Collections.frequency(valores, 4) * 4;
                maiorPonto = "Jogada de 4 = " + String.valueOf(Collections.frequency(valores, 4) * 4 + " Pontos\n");
            }
        }

        //jogada de 5
        if (Collections.frequency(valores, 5) > 0) {
            if (pontos < Collections.frequency(valores, 5) * 5) {
                pontos = Collections.frequency(valores, 5) * 5;
                maiorPonto = "Jogada de 5 = " + String.valueOf(Collections.frequency(valores, 5) * 5 + " Pontos\n");
            }
        }

        //jogada de 6
        if (Collections.frequency(valores, 6) > 0) {
            if (pontos < Collections.frequency(valores, 6) * 6) {
                pontos = Collections.frequency(valores, 6) * 6;
                maiorPonto = "Jogada de 6 = " + String.valueOf(Collections.frequency(valores, 6) * 6 + " Pontos\n");
            }
        }

        //trinca
        if (Collections.frequency(valores, 1) == 3 || Collections.frequency(valores, 2) == 3 ||
                Collections.frequency(valores, 3) == 3 || Collections.frequency(valores, 4) == 3 ||
                Collections.frequency(valores, 5) == 3 || Collections.frequency(valores, 6) == 3) {
            int aux = 0;
            for (int i = 0; i < 5; i++) {
                aux += Integer.parseInt(String.valueOf(valores.get(i)));
            }
            if (pontos < aux) {
                pontos = aux;
                maiorPonto = "Trinca com " + pontos + " pontos\n";
            }
        }

        //quadra
        if (Collections.frequency(valores, 1) == 4 || Collections.frequency(valores, 2) == 4 ||
                Collections.frequency(valores, 3) == 4 || Collections.frequency(valores, 4) == 4 ||
                Collections.frequency(valores, 5) == 4 || Collections.frequency(valores, 6) == 4) {
            int aux = 0;
            for (int i = 0; i < 5; i++) {
                aux += Integer.parseInt(String.valueOf(valores.get(i)));
            }
            if (pontos < aux) {
                pontos = aux;
                maiorPonto = "Quadra com " + pontos + " pontos\n";
            }
        }

        //full-house
        for (int i = 1; i < 7; i++) {
            if (Collections.frequency(valores, i) == 3) {
                for (int j = i + 1; j <= 6; j++) {
                    if (Collections.frequency(valores, j) == 2) {
                        if (pontos < 25) {
                            pontos = 25;
                            maiorPonto = "Full-House: " + pontos + " pontos\n";
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 1; i < 7; i++) {
            if (Collections.frequency(valores, i) == 2) {
                for (int j = i + 1; j <= 6; j++) {
                    if (Collections.frequency(valores, j) == 3) {
                        if (pontos < 25) {
                            pontos = 25;
                            maiorPonto = "Full-House: " + pontos + " pontos\n";
                            break;
                        }
                    }
                }
            }
        }

        //sequencia alta
        ArrayList<Integer> aux = new ArrayList<>();
        aux.add(2);
        aux.add(3);
        aux.add(4);
        aux.add(5);
        aux.add(6);
        if(valores.equals(aux)){
            if (pontos < 30) {
                pontos = 30;
                maiorPonto = "Sequencia Alta: " + pontos + " pontos\n";
            }
        }

        aux.clear();
        //sequencia baixa
        aux.add(1);
        aux.add(2);
        aux.add(3);
        aux.add(4);
        aux.add(5);
        if(valores.equals(aux)){
            if (pontos < 40) {
                pontos = 40;
                maiorPonto = "Sequencia Baixa: " + pontos + " pontos\n";
            }
        }

        //yam(general)
        if(Collections.frequency(valores,1)==5 || Collections.frequency(valores,2)==5 ||
                Collections.frequency(valores,3)==5 || Collections.frequency(valores,4)==5 ||
                Collections.frequency(valores,5)==5 || Collections.frequency(valores,6)==5){

            if (pontos < 50) {
                pontos = 50;
                maiorPonto = "Yam (General): " + pontos + " pontos\n";
            }
        }

        //jogada aleatoria
        int soma=0;
        for(int i=0;i<5;i++){
            soma += Integer.parseInt(String.valueOf(valores.get(i)));
        }
        if (pontos < soma) {
            pontos = soma;
            maiorPonto = "Jogada Aleatoria: " + pontos + " pontos\n";
        }
        resultado.setText(jogadas + "\n" + "Maior classificação: " + maiorPonto);
    }
}
