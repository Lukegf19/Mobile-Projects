package com.example.aulapedrapapeletesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        verificarGanhador("Pedra");
    }

    public void selecionarPapel(View view){
        verificarGanhador("Papel");
    }

    public void selecionarTesoura(View view){
        verificarGanhador("Tesoura");
    }

    private String gerarEscolhaAleatoriaApp() {

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int numeroAleatorio = new Random().nextInt(3);

        String escolhaApp = opcoes[numeroAleatorio];

        ImageView imageApp = findViewById(R.id.Image_App);

        switch (escolhaApp){
            case "Pedra":
                //Aqui, ele pega o nome do objeto que foi declarado na linha 38
                //E substitui no APP, com a foto do elemento aleatorio gerado.
                imageApp.setImageResource(R.drawable.pedra);
            break;

            case "Papel":
                imageApp.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                imageApp.setImageResource(R.drawable.tesoura);
                break;
        }

        return escolhaApp;
    }

    private void verificarGanhador(String escolhaUsuario){
        String escolhaApp = gerarEscolhaAleatoriaApp();

        TextView textoResultado = findViewById(R.id.Text_Resultado);

        if((escolhaApp == "Pedra" && escolhaUsuario == "Tesoura") || (escolhaApp == "Papel" && escolhaUsuario== "Pedra") || (escolhaApp == "Tesoura" && escolhaUsuario == "Papel") ){
            textoResultado.setText("Você perdeu");
        }else if((escolhaUsuario == "Pedra" && escolhaApp == "Tesoura") || (escolhaUsuario == "Papel" && escolhaApp == "Pedra")||(escolhaUsuario == "Tesoura" && escolhaApp == "Pedra")){
            textoResultado.setText("Você ganhou");
        }else{
            textoResultado.setText("Empatamos!!!");
        }
    }




}