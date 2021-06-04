package com.example.app_terrenospanoramicos;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Inicio extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        final TextView mensaje = (TextView)findViewById(R.id.Mensaje);
        Intent i = this.getIntent();
        String correo_electronico = i.getStringExtra("Correo Electrónico");
        String password = i.getStringExtra("Password");
        mensaje.setText(mensaje.getText()+correo_electronico+"Su contraseña:"+password+"");

    }
}
