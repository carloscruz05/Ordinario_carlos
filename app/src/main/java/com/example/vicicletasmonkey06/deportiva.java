package com.example.vicicletasmonkey06;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class deportiva extends AppCompatActivity {

    private int cantidadProductos = 0;
    private int costoUnitario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deportiva);

        ImageView imageViewDeportiva = findViewById(R.id.imageViewDeportiva);
        TextView descripcionTextViewDeportiva = findViewById(R.id.descripcionTextViewDeportiva);
        TextView costoTextViewDeportiva = findViewById(R.id.costoTextViewDeportiva);
        Button agregarProductoButtonDeportiva = findViewById(R.id.agregarProductoButtonDeportiva);
        Button regresarMenuButtonDeportiva = findViewById(R.id.regresarMenuButtonDeportiva);
        Button pagarButtonDeportiva = findViewById(R.id.pagarButtonDeportiva);


        Intent intent = getIntent();
        if (intent != null) {
            int imagen = intent.getIntExtra("imagen", 0);
            String descripcionColor = intent.getStringExtra("descripcionColor");
            String costo = intent.getStringExtra("costo");


            imageViewDeportiva.setImageResource(imagen);
            descripcionTextViewDeportiva.setText("Descripción: " + descripcionColor);
            costoUnitario = Integer.parseInt(costo.replaceAll("[^\\d.]", ""));
            costoTextViewDeportiva.setText("Costo: " + costo);
        }


        regresarMenuButtonDeportiva.setOnClickListener(v -> {
            Intent menuIntent = new Intent(deportiva.this, menu.class);
            startActivity(menuIntent);
        });


        agregarProductoButtonDeportiva.setOnClickListener(v -> {
            cantidadProductos++;
            int costoTotal = costoUnitario * cantidadProductos;

            agregarProductoButtonDeportiva.setText("Agregar más producto (" + cantidadProductos + ")");

            costoTextViewDeportiva.setText("Costo: $" + costoTotal);
        });



        pagarButtonDeportiva.setOnClickListener(v -> {

        });
    }
}
