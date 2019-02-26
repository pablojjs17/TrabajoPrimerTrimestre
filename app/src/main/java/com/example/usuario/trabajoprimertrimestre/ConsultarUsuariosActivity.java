/*package com.example.usuario.trabajoprimertrimestre;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.usuario.trabajoprimertrimestre.utilidades.Utilidades;

public class ConsultarUsuariosActivity extends AppCompatActivity {
    EditText campoDNI,campoNombre,campoApellidos,campoNombreUsuario,campoContraseña,campoFoto;
    Switch campoUsuarioInformatico;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuarios);

        conn= new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);

        campoDNI=(EditText)findViewById(R.id.campoDNI);
        campoNombre=(EditText)findViewById(R.id.campoNombre);
        campoApellidos=(EditText)findViewById(R.id.campoApellidos);
        campoNombreUsuario=(EditText)findViewById(R.id.campoNombreUsuario);
        campoContraseña=(EditText)findViewById(R.id.campoContraseña);
        campoFoto=(EditText)findViewById(R.id.campoFoto);
        campoUsuarioInformatico=(Switch)findViewById(R.id.campoUsuarioInformatico);
    }

    public void onClick (View view){
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
            Toast.makeText(getApplicationContext(), "El documento no existe", Toast.LENGTH_SHORT).show();
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


}*/
