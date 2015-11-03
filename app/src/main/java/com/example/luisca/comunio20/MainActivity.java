package com.example.luisca.comunio20;

import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

import android.view.LayoutInflater;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
//import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    private String[] names;
    private DrawerLayout mDrawerLayout;
    //private ListView mDrawerList;
    String username;
    //TextView Tab1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent(MainActivity.this, Nav_Activity.class);
        startActivity(intent);




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tab1 = (TextView)findViewById(R.id.textView);
        //Tab1.setText(username);

        //Abrimos / Creamos la bd
        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1); //El 1 indica la versión, si siempre es 1, no volverá a crear la bbdd
        SQLiteDatabase db = usdbh.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if(db != null) {
            //Accedemos a la BD
            username = getIntent().getStringExtra("username");
            //Tab1.setText(username);
        }
        //Cerramos la base de datos
        db.close();

        names = getResources().getStringArray(R.array.nav_options);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //mDrawerList = (ListView) findViewById(R.id.left_drawer);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        // mDrawerList.setAdapter(adapter);

        //mDrawerList.setOnItemClickListener(new DrawerItemClickListener());


    }
}
