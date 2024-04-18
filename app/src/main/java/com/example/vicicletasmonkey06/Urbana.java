package com.example.vicicletasmonkey06;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Urbana extends AppCompatActivity {

    private int cantidadProductos = 0;
    private int costoUnitario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urbana);

        ImageView imageViewUrbana = findViewById(R.id.imageViewUrbana);
        TextView descripcionTextView = findViewById(R.id.descripcionTextView);
        TextView costoTextView = findViewById(R.id.costoTextView);
        Button agregarProductoButton = findViewById(R.id.agregarProductoButton);
        Button regresarMenuButton = findViewById(R.id.regresarMenuButton);
        Button pagarButton = findViewById(R.id.pagarButton);


        Intent intent = getIntent();
        if (intent != null) {
            int imagen = intent.getIntExtra("imagen", 0);
            String descripcionColor = intent.getStringExtra("descripcionColor");
            String costo = intent.getStringExtra("costo");


            imageViewUrbana.setImageResource(imagen);
            descripcionTextView.setText("Descripción: " + descripcionColor);
            costoUnitario = Integer.parseInt(costo.replaceAll("[^\\d.]", "")); // Extraer el costo numérico
            costoTextView.setText("Costo: " + costo);
        }


        regresarMenuButton.setOnClickListener(v -> {
            Intent menuIntent = new Intent(Urbana.this, menu.class);
            startActivity(menuIntent);
        });


        agregarProductoButton.setOnClickListener(v -> {
            cantidadProductos++;
            int costoTotal = costoUnitario * cantidadProductos;

            agregarProductoButton.setText("Agregar más producto (" + cantidadProductos + ")");

            costoTextView.setText("Costo: $" + costoTotal);
        });


        pagarButton.setOnClickListener(v -> {
            Intent pagarIntent = new Intent(Urbana.this, PagarActivity.class);
            pagarIntent.putExtra("cantidadProductos", cantidadProductos);
            pagarIntent.putExtra("montoTotal", costoUnitario * cantidadProductos);
            startActivity(pagarIntent);
        });


    }
}
