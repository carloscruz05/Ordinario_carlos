package com.example.vicicletasmonkey06;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class bicicletademontana extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicicletademontana);

        Button buttonBasica = findViewById(R.id.buttonBasica);
        Button buttonIntermedia = findViewById(R.id.buttonIntermedia);
        Button buttonPremium = findViewById(R.id.buttonPremium);

        buttonBasica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDeportiva(R.drawable.deportivabasica, "comoda al andar", "$1,000");
            }
        });

        buttonIntermedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDeportiva(R.drawable.deportivaintermidia, "facil de manejar", "$2,000");
            }
        });

        buttonPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDeportiva(R.drawable.deportivapremiun, "el confort en ruedas", "$3,000");
            }
        });
    }

    private void abrirDeportiva(int imagen, String descripcionColor, String costo) {
        Intent intent = new Intent(bicicletademontana.this, deportiva.class);
        intent.putExtra("imagen", imagen);
        intent.putExtra("descripcionColor", descripcionColor);
        intent.putExtra("costo", costo);
        startActivity(intent);
    }
}
