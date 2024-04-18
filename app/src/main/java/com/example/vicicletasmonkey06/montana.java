package com.example.vicicletasmonkey06;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class montana extends AppCompatActivity {

    private int cantidadProductos = 0;
    private int costoUnitario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_montana);

        ImageView imageViewMontana = findViewById(R.id.imageViewMontana);
        TextView descripcionTextViewMontana = findViewById(R.id.descripcionTextViewMontana);
        TextView costoTextViewMontana = findViewById(R.id.costoTextViewMontana);
        Button agregarProductoButtonMontana = findViewById(R.id.agregarProductoButtonMontana);
        Button regresarMenuButtonMontana = findViewById(R.id.regresarMenuButtonMontana);
        Button pagarButtonMontana = findViewById(R.id.pagarButtonMontana);


        Intent intent = getIntent();
        if (intent != null) {
            int imagen = intent.getIntExtra("imagen", 0);
            String descripcionColor = intent.getStringExtra("descripcionColor");
            String costo = intent.getStringExtra("costo");


            imageViewMontana.setImageResource(imagen);
            descripcionTextViewMontana.setText("Descripción: " + descripcionColor);
            costoUnitario = Integer.parseInt(costo.replaceAll("[^\\d.]", ""));
            costoTextViewMontana.setText("Costo: " + costo);
        }


        regresarMenuButtonMontana.setOnClickListener(v -> {
            Intent menuIntent = new Intent(montana.this, menu.class);
            startActivity(menuIntent);
        });


        agregarProductoButtonMontana.setOnClickListener(v -> {
            cantidadProductos++;
            int costoTotal = costoUnitario * cantidadProductos;

            agregarProductoButtonMontana.setText("Agregar más producto (" + cantidadProductos + ")");

            costoTextViewMontana.setText("Costo: $" + costoTotal);
        });

        // Configurar el botón para pagar (por implementar)
        pagarButtonMontana.setOnClickListener(v -> {
            // Código para realizar el pago
        });
    }
}

