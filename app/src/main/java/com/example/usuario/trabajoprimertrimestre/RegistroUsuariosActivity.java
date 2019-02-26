package com.example.usuario.trabajoprimertrimestre;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.usuario.trabajoprimertrimestre.ConexionSQLiteHelper;
import com.example.usuario.trabajoprimertrimestre.R;
import com.example.usuario.trabajoprimertrimestre.utilidades.Utilidades;

public class RegistroUsuariosActivity extends AppCompatActivity {

    EditText campoDNI,campoNombre,campoApellidos,campoNombreUsuario,campoContraseña,campoFoto;
    Switch campoUsuarioInformatico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        campoDNI=(EditText)findViewById(R.id.campoDNI);
        campoNombre=(EditText)findViewById(R.id.campoNombre);
        campoApellidos=(EditText)findViewById(R.id.campoApellidos);
        campoNombreUsuario=(EditText)findViewById(R.id.campoNombreUsuario);
        campoContraseña=(EditText)findViewById(R.id.campoContraseña);
        campoFoto=(EditText)findViewById(R.id.campoFoto);
        campoUsuarioInformatico=(Switch)findViewById(R.id.campoUsuarioInformatico);


    }

    public void onClick(View view){
        //registrarUsuarios();
        registrarUsuariosSQL();
    }

    private void registrarUsuariosSQL() {
        ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this,"bd_usuario",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        String insert="INSERT INTO "+Utilidades.TABLA_USUARIO+"("+Utilidades.CAMPO_USUARIO_DNI+","+Utilidades.CAMPO_USUARIO_NOMBRE+","
                +Utilidades.CAMPO_USUARIO_APELLIDOS+","+Utilidades.CAMPO_USUARIO_NOMBRE_USUARIO+","+Utilidades.CAMPO_USUARIO_CONTRASEÑA+","
                +Utilidades.CAMPO_USUARIO_FOTO+","+Utilidades.CAMPO_USUARIO_INFORMATICO+") VALUES ( '"
                +campoDNI.getText().toString()+"','"+campoNombre.getText().toString()+"','"+campoApellidos.getText().toString()+"','"
                +campoNombreUsuario.getText().toString()+"','"+campoContraseña.getText().toString()+"','"+campoFoto.getText().toString()+"','"
                +campoUsuarioInformatico.getText().toString()+"' ) ";

        db.execSQL(insert);

        db.close();
    }

    private void registrarUsuarios() {
        ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this,"bd_usuario",null,1);

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

        Toast.makeText(getApplicationContext(),"DNI Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }


}
