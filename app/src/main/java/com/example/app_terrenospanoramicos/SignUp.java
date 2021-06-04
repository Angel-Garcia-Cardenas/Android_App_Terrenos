package com.example.app_terrenospanoramicos;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUp extends AppCompatActivity {

    Button btn_ir_inicioSesion,crear_cuenta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btn_ir_inicioSesion=findViewById(R.id.btn_ir_inicioSesion);
        crear_cuenta=findViewById(R.id.crear_cuenta);



        btn_ir_inicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(com.example.app_terrenospanoramicos.SignUp.this,Login.class));
                finish();
            }
        });

        final EditText usernameT           = (EditText)findViewById(R.id.usernameRegistro);
        final EditText nombreT             = (EditText)findViewById(R.id.nombreRegistro);
        final EditText apellido_paternoT   = (EditText)findViewById(R.id.paternoRegistro);
      /*  final EditText apellido_maternoT   = (EditText)findViewById(R.id.maternoRegistro);*/
        final EditText correo_electronicoT = (EditText)findViewById(R.id.emailLogin);
        final EditText passwordT           = (EditText)findViewById(R.id.passwordLogin);

        Button crear_cuenta                 = (Button)findViewById(R.id.crear_cuenta);
        crear_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre               = nombreT.getText().toString();
                String username             = usernameT.getText().toString();
                String apellido_paterno     = apellido_paternoT.getText().toString();
               /* String apellido_materno     = apellido_maternoT.getText().toString();*/
                String correo_electronico   = correo_electronicoT.getText().toString();
                String password             = passwordT.getText().toString();

                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("sucess");
                            if (ok == true) {
                                Intent i = new Intent(SignUp.this, Login.class);
                                SignUp.this.startActivity(i);
                                SignUp.this.finish();

                            }else{
                                AlertDialog.Builder alerta = new AlertDialog.Builder(SignUp.this);
                                alerta.setMessage("Fallo en el Registro")
                                        .setNegativeButton("Reintentar", null)
                                        .create()
                                        .show();
                            }
                        }catch (JSONException e){
                            e.getMessage();
                        }
                    }
                };

                RegistroRequest r = new RegistroRequest(nombre,username,apellido_paterno,/*apellido_materno,*/correo_electronico,password,respuesta);
                RequestQueue cola = Volley.newRequestQueue(SignUp.this);
                cola.add(r);
            }
        });

    }
}
