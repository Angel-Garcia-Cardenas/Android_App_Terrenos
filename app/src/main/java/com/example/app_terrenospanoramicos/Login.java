package com.example.app_terrenospanoramicos;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    Button btn_ir_crearCuenta,iniciar_sesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_ir_crearCuenta=findViewById(R.id.btn_ir_crearCuenta);
        iniciar_sesion=findViewById(R.id.iniciar_sesion);
        final EditText correo_electronicoT = (EditText)findViewById(R.id.emailLogin);
        final EditText passwordT = (EditText)findViewById(R.id.passwordLogin);


        btn_ir_crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(com.example.app_terrenospanoramicos.Login.this, com.example.app_terrenospanoramicos.SignUp.class));
                finish();
            }
        });

        iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String correo_electronico = correo_electronicoT.getText().toString();
                final String password = passwordT.getText().toString();
                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("success");
   /*51*/                         if (ok == true) {
                                String correo_electronico = jsonRespuesta.getString("Correo Electrónico");
                                String password = jsonRespuesta.getString("Password");
                                Intent bienvenido = new Intent(Login.this, Inicio.class);
                                bienvenido.putExtra("Correo Electrónico", correo_electronico);
                                bienvenido.putExtra("Password", password);

                                Login.this.startActivity(bienvenido);
       //                         Login.this.finish();
                            } else {
                                AlertDialog.Builder alerta = new AlertDialog.Builder(Login.this);
                                alerta.setMessage("Fallo en el Login")
                                        .setNegativeButton("Reintentar", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.getMessage();
                        }
                    }
                };
                LoginRequest r = new LoginRequest(correo_electronico,password,respuesta);
                RequestQueue cola = Volley.newRequestQueue(Login.this);
                cola.add(r);
            }
        });

    }
}
