package com.example.humbe.interaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {

    private EditText etNombre, etApellido;
    private final static int NOMBRE = 0;
    private final static int APELLIDO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = (EditText)findViewById(R.id.etNombre);
        etApellido = (EditText)findViewById(R.id.etApellido);

    }


    // Método que se ejecuta al pulsar el botón btNombre:
    public void rellenarNombre(View v) {
        Intent i = new Intent(this, RellenarCampos.class);
        // Iniciamos la segunda actividad, y le indicamos que la iniciamos
        // para rellenar el nombre:
        startActivityForResult(i, NOMBRE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Resultado cancelado", Toast.LENGTH_SHORT)
                    .show();
        } else {
            String resultado = data.getExtras().getString("RESULTADO");
            switch (requestCode) {
                case NOMBRE:
                    etNombre.setText(resultado);
                    break;
                case APELLIDO:
                    etApellido.setText(resultado);
                    break;
            }
        }
    }
    // Método que se ejecuta al pulsar el botón btApellido
    public void rellenarApellido(View v) {
        Intent i = new Intent(this, RellenarCampos.class);
        // Iniciamos la segunda actividad, y le indicamos que la iniciamos
        // para rellenar el apellido:
        startActivityForResult(i, APELLIDO);
    }


}
