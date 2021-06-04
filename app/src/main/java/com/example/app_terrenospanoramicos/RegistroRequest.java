package com.example.app_terrenospanoramicos;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;

import java.util.Map;
import java.util.HashMap;

import java.util.HashMap;
import java.util.Map;

public class RegistroRequest extends StringRequest {
    private static final String ruta = "http://terrenospanoramicos.freeoda.com/registro.php";
    private Map<String, String> parametros;

    public RegistroRequest(String nombre, String username, String apellido_paterno, /*String apellido_materno,*/ String correo_electronico, String password, Response.Listener<String> listener) {
        super(Request.Method.POST, ruta, listener, null);
        parametros = new HashMap<>();
        parametros.put("nombre", nombre + "");
        parametros.put("username", username + "");
        parametros.put("apellido_paterno", apellido_paterno + "");
      /*  parametros.put("apellido_materno", apellido_materno + "");*/
        parametros.put("correo_electronico", correo_electronico + "");
        parametros.put("password", password + "");
    }
    @Override
    protected Map<String, String> getParams() {
        return parametros;
    }
}

