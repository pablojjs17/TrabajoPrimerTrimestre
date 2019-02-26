package com.example.usuario.trabajoprimertrimestre.Fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.usuario.trabajoprimertrimestre.BaseDeDatos.Incidencias;
import com.example.usuario.trabajoprimertrimestre.BaseDeDatos.Usuario;
import com.example.usuario.trabajoprimertrimestre.ConexionSQLiteHelper;
import com.example.usuario.trabajoprimertrimestre.R;
import com.example.usuario.trabajoprimertrimestre.utilidades.Utilidades;

import java.util.ArrayList;

public class AlertsFragment extends Fragment {


    View vista;

    ListView listViewIncidencias;
    ArrayList<String> listaInformacion;
    ArrayList<Incidencias> listaIncidencias;

    ConexionSQLiteHelper conn;

    public AlertsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_alerta, container, false);

        conn= new ConexionSQLiteHelper(vista.getContext(),"bd",null,1);

        listViewIncidencias=(ListView)vista.findViewById(R.id.listViewIncidencias);

        consultarListaIncidencias();

        ArrayAdapter adaptador= new ArrayAdapter(vista.getContext(),android.R.layout.simple_list_item_1,listaInformacion);
        listViewIncidencias.setAdapter(adaptador);

        listViewIncidencias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String informacion="DNI: "+listaIncidencias.get(position).getDni()+"\n";
                informacion+="Fecha Incidencia: "+listaIncidencias.get(position).getFecha_incidencia()+"\n";
                informacion+="Observaciones: "+listaIncidencias.get(position).getObservaciones()+"\n";
                informacion+="Dni informatico: "+listaIncidencias.get(position).getDni_informatico()+"\n";
                informacion+="Estado: "+listaIncidencias.get(position).getEstado_incidencia()+"\n";
                informacion+="Fecha resolucion: "+listaIncidencias.get(position).getFecha_resolucion_incidencia()+"\n";
                informacion+="Observaciones Informatico: "+listaIncidencias.get(position).getObservaciones_informatico();

                Toast.makeText(vista.getContext(),informacion,Toast.LENGTH_SHORT).show();
            }
        });

        return vista;
    }

    private void consultarListaIncidencias() {
        SQLiteDatabase db= conn.getReadableDatabase();

        Incidencias incidencias=null;
        listaIncidencias=new ArrayList<Incidencias>();

        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_INCIDENCIAS,null);

        while(cursor.moveToNext()){
            incidencias=new Incidencias();
            incidencias.setDni(cursor.getString(0));
            incidencias.setFecha_incidencia(cursor.getString(1));
            incidencias.setObservaciones(cursor.getString(2));
            incidencias.setDni_informatico(cursor.getString(3));
            incidencias.setEstado_incidencia(cursor.getString(4));
            incidencias.setFecha_resolucion_incidencia(cursor.getString(5));
            incidencias.setObservaciones_informatico(cursor.getString(6));

            listaIncidencias.add(incidencias);

        }

        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion=new ArrayList<String>();

        for (int i=0;i<listaIncidencias.size();i++){
            listaInformacion.add(listaIncidencias.get(i).getDni()+" - "
                    +listaIncidencias.get(i).getFecha_incidencia()+" - "
                    +listaIncidencias.get(i).getDni_informatico()+" - "
                    +listaIncidencias.get(i).getEstado_incidencia());
        }
    }


}
