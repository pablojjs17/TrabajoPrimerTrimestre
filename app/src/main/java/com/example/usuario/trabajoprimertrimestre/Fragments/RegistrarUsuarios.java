package com.example.usuario.trabajoprimertrimestre.Fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.usuario.trabajoprimertrimestre.ConexionSQLiteHelper;
import com.example.usuario.trabajoprimertrimestre.R;
import com.example.usuario.trabajoprimertrimestre.utilidades.Utilidades;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegistrarUsuarios.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegistrarUsuarios#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrarUsuarios extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public RegistrarUsuarios() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistrarUsuarios.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrarUsuarios newInstance(String param1, String param2) {
        RegistrarUsuarios fragment = new RegistrarUsuarios();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    EditText campoDNI,campoNombre,campoApellidos,campoNombreUsuario,campoContraseña,campoFoto;
    Switch campoUsuarioInformatico;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_registrar_usuarios, container, false);



            campoDNI=(EditText)view.findViewById(R.id.campoDNI);
            campoNombre=(EditText)view.findViewById(R.id.campoNombre);
            campoApellidos=(EditText)view.findViewById(R.id.campoApellidos);
            campoNombreUsuario=(EditText)view.findViewById(R.id.campoNombreUsuario);
            campoContraseña=(EditText)view.findViewById(R.id.campoContraseña);
            campoFoto=(EditText)view.findViewById(R.id.campoFoto);
            campoUsuarioInformatico=(Switch)view.findViewById(R.id.campoUsuarioInformatico);






        return view;
    }

    public void onClick(View view){
        //registrarUsuarios();
        registrarUsuariosSQL();
    }

    private void registrarUsuariosSQL() {
        ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this.getContext(),"bd_usuario",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        String insert="INSERT INTO "+ Utilidades.TABLA_USUARIO+"("+Utilidades.CAMPO_USUARIO_DNI+","+Utilidades.CAMPO_USUARIO_NOMBRE+","
                +Utilidades.CAMPO_USUARIO_APELLIDOS+","+Utilidades.CAMPO_USUARIO_NOMBRE_USUARIO+","+Utilidades.CAMPO_USUARIO_CONTRASEÑA+","
                +Utilidades.CAMPO_USUARIO_FOTO+","+Utilidades.CAMPO_USUARIO_INFORMATICO+") VALUES ( '"
                +campoDNI.getText().toString()+"','"+campoNombre.getText().toString()+"','"+campoApellidos.getText().toString()+"','"
                +campoNombreUsuario.getText().toString()+"','"+campoContraseña.getText().toString()+"','"+campoFoto.getText().toString()+"','"
                +campoUsuarioInformatico.getText().toString()+"' ) ";

        db.execSQL(insert);

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
