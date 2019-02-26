package com.example.usuario.trabajoprimertrimestre.Fragments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.usuario.trabajoprimertrimestre.ConexionSQLiteHelper;
import com.example.usuario.trabajoprimertrimestre.R;
import com.example.usuario.trabajoprimertrimestre.utilidades.Utilidades;

public class gestionIncidencias extends Fragment {

    View vista;

    public gestionIncidencias() {
        // Required empty public constructor
    }

    EditText campoDNI,campoFechaIncidencia,campoObservaciones,campoDniInformatico,campoEstadoIncidencia,campoFechaResolucion,campoObservacionesInformatico;
    Button boton_registrar = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_gestion_incidencias, container, false);



        campoDNI=(EditText)vista.findViewById(R.id.campoDNI);
        campoFechaIncidencia=(EditText)vista.findViewById(R.id.campoFechaIncidencia);
        campoObservaciones=(EditText)vista.findViewById(R.id.campoObservaciones);
        campoDniInformatico=(EditText)vista.findViewById(R.id.campoDniInformatico);
        campoEstadoIncidencia=(EditText)vista.findViewById(R.id.campoEstadoIncidencia);
        campoFechaResolucion=(EditText)vista.findViewById(R.id.campoFechaResolucion);
        campoObservacionesInformatico=(EditText) vista.findViewById(R.id.campoObservacionesInformatico);
        boton_registrar = (Button)vista.findViewById(R.id.button_registrar);

        boton_registrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                registrarIncidenciasSQL();
            }
        });





        return vista;
    }



    private void registrarIncidenciasSQL() {
        ConexionSQLiteHelper conn= new ConexionSQLiteHelper(vista.getContext(),"bd",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        String insert="INSERT INTO "+ Utilidades.TABLA_INCIDENCIAS+"("+Utilidades.CAMPO_INCIDENCIAS_DNI+","+Utilidades.CAMPO_INCIDENCIAS_FECHA_INCIDENCIA+","
                +Utilidades.CAMPO_INCIDENCIAS_OBSERVACIONES+","+Utilidades.CAMPO_INCIDENCIAS_DNI_INFORMATICO+","+Utilidades.CAMPO_INCIDENCIAS_ESTADO_INCIDENCIAS+","
                +Utilidades.CAMPO_INCIDENCIAS_FECHA_RESOLUCION_INCIDENCIA+","+Utilidades.CAMPO_INCIDENCIAS_OBSERVACIONES_INFORMATICO+") VALUES ( '"
                +campoDNI.getText().toString()+"','"+campoFechaIncidencia.getText().toString()+"','"+campoObservaciones.getText().toString()+"','"
                +campoDniInformatico.getText().toString()+"','"+campoEstadoIncidencia.getText().toString()+"','"+campoFechaResolucion.getText().toString()+"','"
                +campoObservacionesInformatico.getText().toString()+"' ) ";

        db.execSQL(insert);

        Toast.makeText(this.getContext(),"Incidencia registrada",Toast.LENGTH_SHORT).show();

        db.close();
    }



}
