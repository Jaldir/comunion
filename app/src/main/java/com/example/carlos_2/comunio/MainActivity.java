package com.example.carlos_2.comunio;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private String[] names;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ListView mDrawerList;
    String username;
    TextView Tab1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tab1 = (TextView)findViewById(R.id.textView1);
        username = com.example.carlos_2.comunio.Main2Activity.user;
        Tab1.setText(username);


        names = getResources().getStringArray(R.array.nav_options);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);


        mAdapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());


        //Código de las pestañas
        Resources res = getResources();
        TabHost tabs = (TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("Mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Equipo", res.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("Mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Clasificación", res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("Mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Mercado", res.getDrawable(android.R.drawable.ic_lock_idle_alarm));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    private void selectItem(int position) {
        // Crear nuevo fragmento
        Fragment fragment = new MenuActivity();
        //Mandar como argumento la posición del item
        Bundle args = new Bundle();

        fragment.setArguments(args);

        //Reemplazar contenido
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();



        // Se actualiza el item seleccionado y el título, después de cerrar el drawer

        mDrawerLayout.closeDrawer(mDrawerList);
        Toast.makeText(MainActivity.this, "Registrar", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public class DrawerItemClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            
            selectItem(position);
        }
    }

}
