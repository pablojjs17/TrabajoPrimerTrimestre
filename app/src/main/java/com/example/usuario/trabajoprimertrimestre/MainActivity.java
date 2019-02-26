package com.example.usuario.trabajoprimertrimestre;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.usuario.trabajoprimertrimestre.Fragments.AlertsFragment;
import com.example.usuario.trabajoprimertrimestre.Fragments.EmailFragment;
import com.example.usuario.trabajoprimertrimestre.Fragments.InfoFragment;
import com.example.usuario.trabajoprimertrimestre.Fragments.InicioFragment;
import com.example.usuario.trabajoprimertrimestre.Fragments.RegistrarUsuarios;
import com.example.usuario.trabajoprimertrimestre.Fragments.gestionIncidencias;
import com.example.usuario.trabajoprimertrimestre.R;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this,"bd",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();

        setToolbar();

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView=(NavigationView)findViewById(R.id.navview);

        setFragmentByDefault();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                boolean fragmentTransaction=false;
                Fragment fragment=null;

                switch (item.getItemId()){
                    case R.id.menu_inicio:
                    fragment= new InicioFragment();
                    fragmentTransaction=true;
                    break;
                    case R.id.menu_mail:
                        /*FragmentTransaction fragmentTransaction2;
                        fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        final FragmentTransaction replace = fragmentTransaction2.replace(R.id.content_frame, new EmailFragment());
                        fragmentTransaction2.addToBackStack(null);
                        fragmentTransaction2.commit();*/
                        fragment= new EmailFragment();
                        fragmentTransaction=true;
                        break;
                    case R.id.menu_alert:
                        fragment=new AlertsFragment();
                        fragmentTransaction=true;
                        break;
                    case R.id.menu_info:
                        fragment=new InfoFragment();
                        fragmentTransaction=true;
                        break;
                    case R.id.menu_gestionIncidencias:
                        fragment=new gestionIncidencias();
                        fragmentTransaction=true;
                        break;

                    case R.id.menu_opcion_1:
                        Toast.makeText(MainActivity.this,"Has clickeado en la opcion 1", Toast.LENGTH_SHORT).show();
                        break;
                }

                if(fragmentTransaction){
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();

                    item.setChecked(true);
                    getSupportActionBar().setTitle(item.getTitle());
                    drawerLayout.closeDrawers();

                }

                return true;
            }
        });
    }

    private void setToolbar(){
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setFragmentByDefault(){
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new InicioFragment()).commit();
        MenuItem item= navigationView.getMenu().getItem(0);
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                //abrir el menu principal
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
