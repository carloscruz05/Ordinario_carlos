package com.example.vicicletasmonkey06;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PagarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar);

        TextView cantidadProductosTextView = findViewById(R.id.cantidadProductosTextView);
        TextView montoTotalTextView = findViewById(R.id.montoTotalTextView);
        Button regresarMenuButtonPagar = findViewById(R.id.regresarMenuButtonPagar);

        Intent intent = getIntent();
        if (intent != null) {
            int cantidadProductos = intent.getIntExtra("cantidadProductos", 0);
            int montoTotal = intent.getIntExtra("montoTotal", 0);

            cantidadProductosTextView.setText("Productos: " + cantidadProductos);
            montoTotalTextView.setText("Total a pagar: $" + montoTotal);
        }

        regresarMenuButtonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(PagarActivity.this, menu.class);
                startActivity(menuIntent);
            }
        });
    }
}



