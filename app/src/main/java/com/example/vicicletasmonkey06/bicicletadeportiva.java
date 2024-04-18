package com.example.vicicletasmonkey06;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class bicicletadeportiva extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicicletadeportiva);

        Button buttonBasica = findViewById(R.id.buttonBasica);
        Button buttonIntermedia = findViewById(R.id.buttonIntermedia);
        Button buttonPremium = findViewById(R.id.buttonPremium);

        buttonBasica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirUrbana(R.drawable.deportivabasica, "Azul", "$1,000");
            }
        });

        buttonIntermedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirUrbana(R.drawable.deportivaintermidia, "Negro", "$2,000");
            }
        });

        buttonPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirUrbana(R.drawable.deportivapremiun, "Morado", "$3,000");
            }
        });
    }

    private void abrirUrbana(int imagen, String descripcionColor, String costo) {
        Intent intent = new Intent(bicicletadeportiva.this, Urbana.class);
        intent.putExtra("imagen", imagen);
        intent.putExtra("descripcionColor", descripcionColor);
        intent.putExtra("costo", costo);
        startActivity(intent);
    }
}

