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

        // Obtener los datos pasados desde la actividad anterior
        Intent intent = getIntent();
        if (intent != null) {
            int imagen = intent.getIntExtra("imagen", 0);
            String descripcionColor = intent.getStringExtra("descripcionColor");
            String costo = intent.getStringExtra("costo");

            // Configurar los elementos de la pantalla con los datos recibidos
            imageViewUrbana.setImageResource(imagen);
            descripcionTextView.setText("Descripción: " + descripcionColor);
            costoUnitario = Integer.parseInt(costo.replaceAll("[^\\d.]", "")); // Extraer el costo numérico
            costoTextView.setText("Costo: " + costo);
        }

        // Configurar el botón para regresar al menú
        regresarMenuButton.setOnClickListener(v -> {
            Intent menuIntent = new Intent(Urbana.this, MainActivity.class);
            startActivity(menuIntent);
        });

        // Configurar el botón para agregar más producto
        agregarProductoButton.setOnClickListener(v -> {
            cantidadProductos++;
            int costoTotal = costoUnitario * cantidadProductos * 2; // Duplicar el costo por la cantidad de productos
            // Actualizar el texto del botón para mostrar la cantidad de productos agregados
            agregarProductoButton.setText("Agregar más producto (" + cantidadProductos + ")");
            // Actualizar el texto del costo total
            costoTextView.setText("Costo: $" + costoTotal);
        });

        // Configurar el botón para pagar (por implementar)
        pagarButton.setOnClickListener(v -> {
            // Código para realizar el pago
        });
    }
}
