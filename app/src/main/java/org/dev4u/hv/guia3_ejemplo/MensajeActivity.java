package org.dev4u.hv.guia3_ejemplo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MensajeActivity extends AppCompatActivity {
    private AdaptadorMensaje adaptadorMensaje;
    private Button btnenviar;
    private ArrayList<Mensaje> mensajeArrayList;
    private EditText txtEntrada;

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    String fecha="15-11-2018";
    public static int GUARDADO=47;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        final Calendar calendar = Calendar.getInstance();

        txtEntrada = findViewById(R.id.txtEntrada);

        btnenviar = findViewById(R.id.btnEnviar);

        mensajeArrayList = new ArrayList<>();
        adaptadorMensaje = new AdaptadorMensaje(this, mensajeArrayList);

        ListView lstmensaje = findViewById(R.id.lstMensaje);

        lstmensaje.setAdapter(adaptadorMensaje);

        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtEntrada.getText().toString().isEmpty()){
                    Toast.makeText(MensajeActivity.this,"Inserta un mensaje para enviar",Toast.LENGTH_SHORT).show();
                }else {
                    Intent enviar = new Intent();
                    enviar.putExtra("mensaje",txtEntrada.getText().toString());
                    enviar.putExtra("fecha",fecha);
                    setResult(MensajeActivity.GUARDADO, enviar);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GUARDADO){
            if(data==null) return;
            //recibo los datos
            Mensaje c = new Mensaje(
                    data.getStringExtra("mensaje"),
                    data.getStringExtra("fecha")
            );
            //TODO agrego a la lista y luego actualizo el adaptador, de lo contrario no se mostraria el cambio
            mensajeArrayList.add(c);
            adaptadorMensaje.notifyDataSetChanged();
        }
    }
}