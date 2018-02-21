package com.example.yosua.yosuamartinezexamen2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView lvListadoPaises;
    private static final String URL = "http://192.168.31.44/Paises/paises.json";
    private ArrayList <DatosPais> listaPaises;

    private GoogleMap mapa;
    private SupportMapFragment fragmentMapa;
    private LatLng posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvListadoPaises = findViewById(R.id.lvListadoPaises);



        RequestQueue request = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                listaPaises = new ArrayList<DatosPais>();

                String nombreEn, nombreEs, clave, capital, continente, poblacion, latitud, longitud, paisesFronterizos;

                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);

                        nombreEn = jsonObject.getString("name");
                        nombreEs = jsonObject.getJSONObject("translations").getString("es");
                        clave = jsonObject.getString("alpha2Code");
                        capital = jsonObject.getString("capital");
                        continente = jsonObject.getString("region");
                        poblacion = jsonObject.getString("population");

                        JSONArray jsonArray = jsonObject.getJSONArray("latlng");
                        if (jsonArray.length() > 0) {
                            latitud = jsonArray.getString(0);
                            longitud = jsonArray.getString(1);
                        } else {
                            latitud = "0";
                            longitud = "0";
                        }

                        jsonArray = jsonObject.getJSONArray("borders");
                        paisesFronterizos = "";
                        for (int j = 0; j < jsonArray.length(); j++) {
                            paisesFronterizos += jsonArray.getString(j) + " ";
                        }

                        DatosPais pais = new DatosPais(nombreEn, nombreEs, clave, capital, continente, poblacion, latitud, longitud, paisesFronterizos);
                        listaPaises.add(pais);

                        System.out.println("Añadido: " + pais.getNombreEN());
                    }
//                    }

                    //ADAPTADOR LIST VIEW
                    AdaptadorPais adaptador = new AdaptadorPais(getApplicationContext(), listaPaises);
                    lvListadoPaises.setAdapter(adaptador);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        request.add(jsonArrayRequest);

        lvListadoPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Mapa.class);
                intent.putExtra("latitud", listaPaises.get(i).getLatitud());
                intent.putExtra("longitud", listaPaises.get(i).getLongitud());
                intent.putExtra("pais", listaPaises.get(i).getNombreEN());
                intent.putExtra("capital", listaPaises.get(i).getCapital());
                intent.putExtra("poblacion", listaPaises.get(i).getPoblacion());
                startActivity(intent);
            }
        });

    }
}
