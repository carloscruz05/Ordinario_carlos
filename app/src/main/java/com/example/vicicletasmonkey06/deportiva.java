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

        // Obtener los datos pasados desde la actividad anterior
        Intent intent = getIntent();
        if (intent != null) {
            int imagen = intent.getIntExtra("imagen", 0);
            String descripcionColor = intent.getStringExtra("descripcionColor");
            String costo = intent.getStringExtra("costo");

            // Configurar los elementos de la pantalla con los datos recibidos
            imageViewDeportiva.setImageResource(imagen);
            descripcionTextViewDeportiva.setText("Descripción: " + descripcionColor);
            costoUnitario = Integer.parseInt(costo.replaceAll("[^\\d.]", "")); // Extraer el costo numérico
            costoTextViewDeportiva.setText("Costo: " + costo);
        }

        // Configurar el botón para regresar al menú
        regresarMenuButtonDeportiva.setOnClickListener(v -> {
            Intent menuIntent = new Intent(deportiva.this, menu.class);
            startActivity(menuIntent);
        });

        // Configurar el botón para agregar más producto
        agregarProductoButtonDeportiva.setOnClickListener(v -> {
            cantidadProductos++;
            int costoTotal = costoUnitario * cantidadProductos; // Calcular el costo total sumando el costo unitario por la cantidad de productos
            // Actualizar el texto del botón para mostrar la cantidad de productos agregados
            agregarProductoButtonDeportiva.setText("Agregar más producto (" + cantidadProductos + ")");
            // Actualizar el texto del costo total
            costoTextViewDeportiva.setText("Costo: $" + costoTotal);
        });


        // Configurar el botón para pagar (por implementar)
        pagarButtonDeportiva.setOnClickListener(v -> {
            // Código para realizar el pago
        });
    }
}
