package com.example.usuario.trabajoprimertrimestre;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;

import static java.security.AccessController.getContext;

public class RegistrarUsuarioFragment extends AppCompatActivity {

   /* private String mParam1;
    private String mParam2;*/

   // private OnFragmentInteractionListener nListener;

    private static final String CARPETA_PRINCIPAL="misImagenesApp/";//directorio principal
    private static final String CARPETA_IMAGEN="imagenes";//carpeta donde se guardan las fotos
    private static final String DIRECTORIO_IMAGEN=CARPETA_PRINCIPAL+CARPETA_IMAGEN;//ruta carpeta de directorio
    private String path;//almacena la ruta de la imagen
    File fileImagen;
    Bitmap bitmap;

    private static final int COD_SELECCIONA=10;
    private static final int COD_FOTO=20;

    EditText campoNombre,camppDocumento,campoProfesion;
    Button botonRegistro,btnFoto;
    ImageView imgFoto;
    ProgressDialog progreso;

    private void mostrarDialogOpciones(){
        final CharSequence[] opciones={"Tomar Foto","Elegir de Galeria","Cancelar"};
        final AlertDialog.Builder builder= new AlertDialog.Builder(this.getBaseContext());
        builder.setTitle("Elige una opcion");
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
               switch (i){
                   case 0:
                       abrirCamara();
                       break;
                   case 1:
                       Intent intent=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                       intent.setType("image/");
                       startActivityForResult(intent.createChooser(intent,"Selecciona"),COD_SELECCIONA);
                       break;
                   default:
                       dialogInterface.dismiss();
                       break;

               }

              /*  if(opciones[i].equals("Tomar Foto")){
                    abrirCamara();
                }else{
                    if(opciones[i].equals("Elegir de Galeria")){
                        Intent intent=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/");
                        startActivityForResult(intent.createChooser(intent,"Selecciona"),COD_SELECCIONA);
                    }else{
                        dialogInterface.dismiss();
                    }
                }*/
            }

        });
    }

    public void abrirCamara(){
        File miFile=new File(Environment.getExternalStorageDirectory(),DIRECTORIO_IMAGEN);
        boolean isCreada=miFile.exists();

        if(isCreada==false){
            isCreada=miFile.mkdirs();
        }else{
            Long consecutivo=System.currentTimeMillis()/1000;
            String nombre=consecutivo.toString()+".jpg";

            path=Environment.getExternalStorageDirectory()+File.separator+DIRECTORIO_IMAGEN+File.separator+nombre;//indicamos ruta almacenamiento

            fileImagen=new File(path);

            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(fileImagen));

            startActivityForResult(intent,COD_FOTO);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        switch (requestCode){
            case COD_SELECCIONA:
                Uri miPath=data.getData();
                imgFoto.setImageURI(miPath);
                break;
            case COD_FOTO:
                MediaScannerConnection.scanFile(this.getBaseContext(), new String[]{path}, null, new MediaScannerConnection.OnScanCompletedListener() {
                    @Override
                    public void onScanCompleted(String path, Uri uri) {
                        Log.i("Path",""+path);
                    }
                });

                bitmap= BitmapFactory.decodeFile(path);
                imgFoto.setImageBitmap(bitmap);

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario_fragment);
    }
}
