package com.example.yosua.yosuamartinezexamen2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yosua on 21/02/2018.
 */

public class AdaptadorPais extends BaseAdapter {

    private Context context;
    private ArrayList<DatosPais> listaPaises;

    public AdaptadorPais(Context context, ArrayList<DatosPais> listaPaises) {
        this.context = context;
        this.listaPaises = listaPaises;
    }

    @Override
    public int getCount() {
        return listaPaises.size();
    }

    @Override
    public Object getItem(int i) {
        return listaPaises.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        LayoutInflater inflater = LayoutInflater.from(context);
        v = inflater.inflate(R.layout.item_pais, null);

        TextView tvNombreEN = v.findViewById(R.id.tvNombreEN);
        TextView tvNombreES = v.findViewById(R.id.tvNombreES);
        TextView tvClave = v.findViewById(R.id.tvClave);
        TextView tvCapital = v.findViewById(R.id.tvCapital);
        TextView tvContintente = v.findViewById(R.id.tvContinente);

        TextView tvPoblacion = v.findViewById(R.id.tvPoblacion);
        TextView tvLatitud = v.findViewById(R.id.tvLatitud);
        TextView tvLongitud = v.findViewById(R.id.tvLongitud);
        TextView tvPaisesFronterizos = v.findViewById(R.id.tvPaisesFronterizos);

        tvNombreEN.setText("Nombre (inglés): " + listaPaises.get(i).getNombreEN());
        tvNombreES.setText("Nombre (castellano): " + listaPaises.get(i).getNombreES());
        tvClave.setText("Clave: " + listaPaises.get(i).getClave());
        tvCapital.setText("Capital: " + listaPaises.get(i).getCapital());
        tvContintente.setText("Continente: " + listaPaises.get(i).getContinente());

        tvPoblacion.setText("Población: " + listaPaises.get(i).getPoblacion());
        tvLatitud.setText("Latitud: " + listaPaises.get(i).getLatitud());
        tvLongitud.setText("Longitud: " + listaPaises.get(i).getLongitud());
        tvPaisesFronterizos.setText("Países fronterizos: " + listaPaises.get(i).getPaisesFronterizos());

        return v;
    }
}
