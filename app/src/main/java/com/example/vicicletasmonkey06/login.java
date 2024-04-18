package com.example.vicicletasmonkey06;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword, editTextEmail;
    private Button buttonLogin, buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistration();
            }
        });
    }

    private void loginUser() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        String email = editTextEmail.getText().toString();



        if (isValidCredentials(username, password, email)) {

            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(login.this, menu.class);
            startActivity(intent);
        } else {

            Toast.makeText(this, "Nombre de usuario, contraseña o correo electrónico incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    private void openRegistration() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    private boolean isValidCredentials(String username, String password, String email) {
        // Este es solo un ejemplo básico, debes implementar tu propia lógica aquí
        // Aquí podrías comparar las credenciales con datos almacenados en SharedPreferences o una base de datos
        // Por ahora, simplemente verifica si los campos no están vacíos
        return !username.isEmpty() && !password.isEmpty() && !email.isEmpty();
    }
}
