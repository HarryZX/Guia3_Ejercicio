package org.dev4u.hv.guia3_ejemplo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactoActivity extends AppCompatActivity {

    //declaracion de variables
    private EditText txtNombre,txtNumero;
    private Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        //inicializando variables
        txtNombre   = (EditText) findViewById(R.id.txtNombre);
        txtNumero   = (EditText) findViewById(R.id.txtNumero);
        btnAgregar  = (Button  ) findViewById(R.id.btnAgregarContacto);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //si alguno de los dos campos estan vacios
                if(txtNombre.getText().toString().isEmpty() || txtNumero.getText().toString().isEmpty() ){
                    Toast.makeText(ContactoActivity.this,"Inserta los datos del contacto",Toast.LENGTH_SHORT).show();
                }else{//de lo contrario los campos estan llenos
                    //envio los datos al MainActivity
                    Intent resultIntent = new Intent();
                    // TODO envio los datos mediante el intent
                    resultIntent.putExtra("NOMBRE",txtNombre.getText().toString());
                    resultIntent.putExtra("NUMERO",txtNumero.getText().toString());
                    setResult(MainActivity.GUARDADO, resultIntent);
                    finish();
                }
            }
        });
    }
}
