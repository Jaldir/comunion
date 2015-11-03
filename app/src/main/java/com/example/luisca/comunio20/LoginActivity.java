package com.example.luisca.comunio20;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.content.Intent;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private String user; //Para que la otra actividad pueda acceder al nombre, tiene que ser pública y estática, pero esto puede ocasionar problemas en el momento en que se pueda cerrar sesión y logearse con otro user
    private String contra;
    TextView login;
    TextView pswd;
    Button boton;
    CheckBox chkReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        chkReg = (CheckBox)findViewById(R.id.chkBoxRegistrar);
        login = (TextView)findViewById(R.id.txtLogin);
        pswd = (TextView)findViewById(R.id.txtPswd);
        boton = (Button)findViewById(R.id.btnLogin);
        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void testlogin(View v) throws InterruptedException {
        //Abrimos / Creamos la bd
        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1); //El 1 indica la versión, si siempre es 1, no volverá a crear la bbdd
        SQLiteDatabase db = usdbh.getWritableDatabase();
        user = login.getText().toString();
        contra = pswd.getText().toString();
        if (chkReg.isChecked()){
            //Hacer registro
            if(db != null){
                //Comprobamos si el nombre de usuario está registrado ya
                Cursor c = db.rawQuery(" SELECT nombre FROM Usuarios WHERE nombre='"+user+"' ",null);
                if(c.moveToFirst()){
                    Toast.makeText(this, "Nombre ya registrado", Toast.LENGTH_SHORT).show();
                }else{
                    //Usuario no registrado
                    db.execSQL("INSERT INTO Usuarios (nombre,contra) VALUES ('" + user + "','" + contra + "')");
                    Toast.makeText(this, "Usuario registrado correctamente",Toast.LENGTH_SHORT).show();
                    db.close();
                    Intent intent = new Intent(this, MainPruebas.class);
                    intent.putExtra("username",user);
                    startActivity(intent);
                }
            }

        }else { //LOGIN
            Cursor c = db.rawQuery("SELECT contra FROM Usuarios WHERE nombre='"+user+"'",null);
            //Si existe en la bbdd el usuario
            if(c.moveToFirst()){
                contra = c.getString(0);
                if (pswd.getText().toString().equals(contra)) {
                    user = login.getText().toString();
                    db.close();
                    Intent intent = new Intent(this, MainPruebas.class);
                    intent.putExtra("username",user);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Usuario y/o contraseña incorrecto", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(LoginActivity.this, "Usuario y/o contraseña incorrecto", Toast.LENGTH_SHORT).show();
            }
        }
        db.close();
    }

    public void RegisterOnOff(View v){
        if (chkReg.isChecked()) {
            boton.setText("Registrar");
            //Escribir en base de datos o fichero
        }else
            boton.setText("Aceptar");
    }

}
