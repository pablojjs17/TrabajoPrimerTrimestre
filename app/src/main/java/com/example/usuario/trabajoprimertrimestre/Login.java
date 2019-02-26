package com.example.usuario.trabajoprimertrimestre;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity{
    private EditText Nombre;
    private EditText Contraseña;
    private TextView Info;
    private Button Login;
    private int counter=3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Nombre=(EditText)findViewById(R.id.etName);
        Contraseña=(EditText)findViewById(R.id.etPassword);
        Info=(TextView)findViewById(R.id.tvInfo);
        Login=(Button)findViewById(R.id.btnLogin);

        Info.setText("Numero de intentos: 3");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(),Contraseña.getText().toString(),Toast.LENGTH_SHORT).show();
                validate(Nombre.getText().toString(),Contraseña.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword){
        if((new String(userName).equals("admin")) && (new String(userPassword).equals("1234"))){
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }else{
            counter--;

            Info.setText("Numero de intentos: "+String.valueOf(counter));

            if (counter==0){
                Login.setEnabled(false);
            }
        }
    }
}
