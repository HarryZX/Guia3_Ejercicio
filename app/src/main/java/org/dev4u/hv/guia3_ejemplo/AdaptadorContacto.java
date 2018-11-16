package org.dev4u.hv.guia3_ejemplo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 30/8/17.
 */

public class AdaptadorContacto extends ArrayAdapter<Contacto> {

    //TODO constructor con 2 parametros : el contexto y la lista de objetos (Contacto)
    public AdaptadorContacto(Context context, List<Contacto> objects) {
        super(context, 0, objects);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obteniendo el dato
        Contacto contacto = getItem(position);
        //TODO inicializando el layout correspondiente al item (Contacto)
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contacto, parent, false);
        }
        TextView lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
        TextView lblNumero = (TextView) convertView.findViewById(R.id.lblNumero);
        // mostrar los datos
        lblNombre.setText(contacto.nombre);
        lblNumero.setText(contacto.numero);
        // Return la convertView ya con los datos
        return convertView;
    }
}
