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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.usuario.trabajoprimertrimestre.BaseDeDatos.Usuario;
import com.example.usuario.trabajoprimertrimestre.ConexionSQLiteHelper;
import com.example.usuario.trabajoprimertrimestre.R;
import com.example.usuario.trabajoprimertrimestre.utilidades.Utilidades;

import java.util.ArrayList;

public class EmailFragment extends Fragment {

    View vista;

    ListView listViewPersonas;
    ArrayList<String> listaInformacion;
    ArrayList<Usuario> listaUsuarios;

    public EmailFragment() {
        // Required empty public constructor
    }

  /*  EditText campoDNI,campoNombre,campoApellidos,campoNombreUsuario,campoContraseña,campoFoto;
    Switch campoUsuarioInformatico;*/

    ConexionSQLiteHelper conn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_email, container, false);

        conn= new ConexionSQLiteHelper(vista.getContext(),"bd",null,1);

        listViewPersonas=(ListView)vista.findViewById(R.id.listViewPersonas);

        consultarListaPersonas();

        ArrayAdapter adaptador= new ArrayAdapter(vista.getContext(),android.R.layout.simple_list_item_1,listaInformacion);
        listViewPersonas.setAdapter(adaptador);

        listViewPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String informacion="DNI: "+listaUsuarios.get(position).getDNI()+"\n";
                informacion+="Nombre: "+listaUsuarios.get(position).getNombre()+"\n";
                informacion+="Apellidos: "+listaUsuarios.get(position).getApellidos()+"\n";
                informacion+="Nombre Usuario: "+listaUsuarios.get(position).getNombre_usuario()+"\n";
                informacion+="Contraseña: "+listaUsuarios.get(position).getContraseña()+"\n";
                informacion+="Informatico: "+listaUsuarios.get(position).isInformatico();

                Toast.makeText(vista.getContext(),informacion,Toast.LENGTH_SHORT).show();
            }
        });

       /* campoDNI=(EditText)vista.findViewById(R.id.campoDNI);
        campoNombre=(EditText)vista.findViewById(R.id.campoNombre);
        campoApellidos=(EditText)vista.findViewById(R.id.campoApellidos);
        campoNombreUsuario=(EditText)vista.findViewById(R.id.campoNombreUsuario);
        campoContraseña=(EditText)vista.findViewById(R.id.campoContraseña);
        campoFoto=(EditText)vista.findViewById(R.id.campoFoto);
        campoUsuarioInformatico=(Switch)vista.findViewById(R.id.campoUsuarioInformatico);


            */

        return vista;
    }

    private void consultarListaPersonas() {
        SQLiteDatabase db= conn.getReadableDatabase();

        Usuario usuario=null;
        listaUsuarios=new ArrayList<Usuario>();

        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_USUARIO,null);

        while(cursor.moveToNext()){
            usuario=new Usuario();
            usuario.setDNI(cursor.getString(2));
            usuario.setNombre(cursor.getString(0));
            usuario.setApellidos(cursor.getString(1));
            usuario.setNombre_usuario(cursor.getString(3));
            usuario.setContraseña(cursor.getString(4));
            usuario.setFoto(cursor.getString(5));
            usuario.setInformatico(Boolean.valueOf(cursor.getString(6)));

            listaUsuarios.add(usuario);

        }

        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion=new ArrayList<String>();

        for (int i=0;i<listaUsuarios.size();i++){
            listaInformacion.add(listaUsuarios.get(i).getDNI()+" - "
            +listaUsuarios.get(i).getNombre()+" - "
                    +listaUsuarios.get(i).getApellidos()+" - "
                    +listaUsuarios.get(i).getNombre_usuario());
        }
    }

  /*  public void onClick (View view){
        switch (view.getId()){
            case R.id.btnConsultar:
                consultar();
                break;
            case R.id.btnActualizar:
                break;
            case R.id.btnEliminar:
                break;

        }
    }

    private void consultar() {
        conn= new ConexionSQLiteHelper(vista.getContext(),"bd",null,1);
        SQLiteDatabase db= conn.getReadableDatabase();
        String[] parametros={campoDNI.getText().toString()};
        String[] campos={Utilidades.CAMPO_USUARIO_DNI,Utilidades.CAMPO_USUARIO_NOMBRE,Utilidades.CAMPO_USUARIO_APELLIDOS,
                Utilidades.CAMPO_USUARIO_NOMBRE_USUARIO,Utilidades.CAMPO_USUARIO_CONTRASEÑA,Utilidades.CAMPO_USUARIO_FOTO,Utilidades.CAMPO_USUARIO_INFORMATICO};

        try{
            Cursor cursor=db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_USUARIO_DNI+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoApellidos.setText(cursor.getString(1));
            campoNombreUsuario.setText(cursor.getString(2));
            campoContraseña.setText(cursor.getString(3));
            campoFoto.setText(cursor.getString(4));
            campoUsuarioInformatico.setText(cursor.getString(5));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(vista.getContext(), "El documento no existe", Toast.LENGTH_SHORT).show();
            limpiar();
        }


    }

    private void limpiar() {
        campoNombre.setText("");
        campoApellidos.setText("");
        campoNombreUsuario.setText("");
        campoContraseña.setText("");
        campoFoto.setText("");
        campoUsuarioInformatico.setText("");
    }
*/
}
