package com.example.app_terrenospanoramicos;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button ir_login, ir_SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ir_login=findViewById(R.id.ir_login);
        ir_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(com.example.app_terrenospanoramicos.MainActivity.this, com.example.app_terrenospanoramicos.Login.class));
                finish();
            }
        });


        ir_SignUp=findViewById(R.id.iniciar_registro);
        ir_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(com.example.app_terrenospanoramicos.MainActivity.this, com.example.app_terrenospanoramicos.SignUp.class));
                finish();
            }
        });
    }
}
