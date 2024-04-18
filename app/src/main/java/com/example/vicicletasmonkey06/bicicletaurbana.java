package com.example.vicicletasmonkey06;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class bicicletaurbana extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicicletaurbana);

        Button buttonBasica = findViewById(R.id.buttonBasica);
        Button buttonIntermedia = findViewById(R.id.buttonIntermedia);
        Button buttonPremium = findViewById(R.id.buttonPremium);

        buttonBasica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDeportiva(R.drawable.deportivabasica, "hecha para las calles", "$1,000");
            }
        });

        buttonIntermedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDeportiva(R.drawable.deportivaintermidia, "facil manejo", "$2,000");
            }
        });

        buttonPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDeportiva(R.drawable.deportivapremiun, "duradera ", "$3,000");
            }
        });
    }

    private void abrirDeportiva(int imagen, String descripcionColor, String costo) {
        Intent intent = new Intent(bicicletaurbana.this, deportiva.class);
        intent.putExtra("imagen", imagen);
        intent.putExtra("descripcionColor", descripcionColor);
        intent.putExtra("costo", costo);
        startActivity(intent);
    }
}

