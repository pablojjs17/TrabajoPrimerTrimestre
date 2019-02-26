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

public class InfoFragment extends Fragment {

    View vista;

    public InfoFragment() {
        // Required empty public constructor
    }

    EditText campoDNI,campoNombre,campoApellidos,campoNombreUsuario,campoContraseña,campoFoto;
    Switch campoUsuarioInformatico;
    Button boton_registrar = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_info, container, false);



        campoDNI=(EditText)vista.findViewById(R.id.campoDNI);
        campoNombre=(EditText)vista.findViewById(R.id.campoNombre);
        campoApellidos=(EditText)vista.findViewById(R.id.campoApellidos);
        campoNombreUsuario=(EditText)vista.findViewById(R.id.campoNombreUsuario);
        campoContraseña=(EditText)vista.findViewById(R.id.campoContraseña);
        campoFoto=(EditText)vista.findViewById(R.id.campoFoto);
        campoUsuarioInformatico=(Switch)vista.findViewById(R.id.campoUsuarioInformatico);
        boton_registrar = (Button)vista.findViewById(R.id.button_registrar);

        boton_registrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //registrarUsuarios();
                registrarUsuariosSQL();
            }
        });





        return vista;
    }



    private void registrarUsuariosSQL() {
        ConexionSQLiteHelper conn= new ConexionSQLiteHelper(vista.getContext(),"bd",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        String insert="INSERT INTO "+ Utilidades.TABLA_USUARIO+"("+Utilidades.CAMPO_USUARIO_DNI+","+Utilidades.CAMPO_USUARIO_NOMBRE+","
                +Utilidades.CAMPO_USUARIO_APELLIDOS+","+Utilidades.CAMPO_USUARIO_NOMBRE_USUARIO+","+Utilidades.CAMPO_USUARIO_CONTRASEÑA+","
                +Utilidades.CAMPO_USUARIO_FOTO+","+Utilidades.CAMPO_USUARIO_INFORMATICO+") VALUES ( '"
                +campoDNI.getText().toString()+"','"+campoNombre.getText().toString()+"','"+campoApellidos.getText().toString()+"','"
                +campoNombreUsuario.getText().toString()+"','"+campoContraseña.getText().toString()+"','"+campoFoto.getText().toString()+"','"
                +campoUsuarioInformatico.isChecked()+"' ) ";

        db.execSQL(insert);

        Toast.makeText(this.getContext(),"Usuario registrado",Toast.LENGTH_SHORT).show();

        db.close();
    }

    private void registrarUsuarios() {
        ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this.getContext(),"bd_usuario",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_USUARIO_DNI,campoDNI.getText().toString());
        values.put(Utilidades.CAMPO_USUARIO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_USUARIO_APELLIDOS,campoApellidos.getText().toString());
        values.put(Utilidades.CAMPO_USUARIO_NOMBRE_USUARIO,campoNombreUsuario.getText().toString());
        values.put(Utilidades.CAMPO_USUARIO_CONTRASEÑA,campoContraseña.getText().toString());
        values.put(Utilidades.CAMPO_USUARIO_FOTO,campoFoto.getText().toString());
        values.put(Utilidades.CAMPO_USUARIO_INFORMATICO,campoUsuarioInformatico.isChecked());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_USUARIO_DNI,values);

        Toast.makeText(this.getContext(),"DNI Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }

}
