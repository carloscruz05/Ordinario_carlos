package com.example.vicicletasmonkey06;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class montana extends AppCompatActivity implements View.OnClickListener {

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
            costoTextViewMontana.setText("Costo: $" + costoUnitario);
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

        pagarButtonMontana.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.pagarButtonMontana) {
            Intent pagarIntent = new Intent(this, PagarActivity.class);
            pagarIntent.putExtra("cantidadProductos", cantidadProductos);
            pagarIntent.putExtra("montoTotal", costoUnitario * cantidadProductos);
            startActivity(pagarIntent);
        }
    }
}
