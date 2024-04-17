package com.example.vicicletasmonkey06;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;
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

        buttonLogin.setOnClickListener(v -> loginUser());
        buttonRegister.setOnClickListener(v -> openRegistration());
    }

    private void loginUser() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        String email = editTextEmail.getText().toString();

        // Obtener los datos del usuario guardados en SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString("username", "");
        String savedPassword = sharedPreferences.getString("password", "");
        String savedEmail = sharedPreferences.getString("email", "");

        // Verificar si los datos ingresados coinciden con los datos guardados
        if (username.equals(savedUsername) && password.equals(savedPassword) && email.equals(savedEmail)) {
            // Credenciales válidas, redirige al usuario a la pantalla principal
            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
            // Aquí puedes abrir la pantalla principal de tu aplicación u otra actividad relevante
            // Por ejemplo:
            // Intent intent = new Intent(this, HomeActivity.class);
            // startActivity(intent);
        } else {
            // Credenciales inválidas, muestra un mensaje de error
            Toast.makeText(this, "Nombre de usuario, contraseña o correo electrónico incorrectos", Toast.LENGTH_SHORT).show();
        }
    }


    private void openRegistration() {
        // Inicia la actividad MainActivity para el registro de usuario
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    private boolean isValidCredentials(String username, String password, String email) {
        // Aquí debes implementar la lógica para verificar las credenciales
        // con los datos almacenados (por ejemplo, en SharedPreferences o una base de datos)
        // Retorna true si las credenciales son válidas, false de lo contrario
        // Este es solo un ejemplo básico, necesitarás reemplazarlo con tu propia lógica
        return (username.equals("usuario") && password.equals("contraseña") && email.equals("correo@example.com"));
    }
}
