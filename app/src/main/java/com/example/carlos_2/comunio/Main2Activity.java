package com.example.carlos_2.comunio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    public static String user;
    TextView login;
    TextView pswd;
    Button boton;
    CheckBox chkReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        chkReg = (CheckBox)findViewById(R.id.chkBoxRegistrar);
        login = (TextView)findViewById(R.id.txtLogin);
        pswd = (TextView)findViewById(R.id.txtPswd);
        boton = (Button)findViewById(R.id.btnLogin);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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
        if (chkReg.isChecked()){
            //Hacer registro
            Toast.makeText(Main2Activity.this, "Registrar", Toast.LENGTH_SHORT).show();
        }else {
            if (pswd.getText().toString().equals("1234")) {
                user = login.getText().toString();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(Main2Activity.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void RegisterOnOff(View v){
        if (chkReg.isChecked()) {
            boton.setText("Registrar");
            //Escribir en base de datos o fichero
        }else
            boton.setText("Aceptar");
    }

}
