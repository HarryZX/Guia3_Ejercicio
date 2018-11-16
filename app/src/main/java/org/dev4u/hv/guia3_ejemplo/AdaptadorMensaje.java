package org.dev4u.hv.guia3_ejemplo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class AdaptadorMensaje extends ArrayAdapter<Mensaje> {
    public AdaptadorMensaje(Context context, List<Mensaje> objects){
        super(context,0,objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Mensaje mensaje = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mensaje,parent,false);
        }
        TextView lblmensaje = convertView.findViewById(R.id.lblmensaje);
        TextView lblfecha = convertView.findViewById(R.id.lblfecha);

        lblmensaje.setText(mensaje.contenido);
        lblfecha.setText(mensaje.fecha);

        return convertView;
    }
}