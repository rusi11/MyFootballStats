package rusi.myfootballstats;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    Intent intent;
    TextView textName;
    TextView textSurName;
    TextView textAlias;
    TextView textFavNumber;
    TextView textPeso;
    TextView textAltura;
    DataBaseHelper dbHelper;
    SQLiteDatabase db;


    public void init(){
        textName = (TextView) findViewById(R.id.nameText);
        textSurName = (TextView) findViewById(R.id.surnameText);
        textAlias = (TextView) findViewById(R.id.aliasText);
        textFavNumber = (TextView) findViewById(R.id.favNumberText);
        textPeso = (TextView) findViewById(R.id.pesoText);
        textAltura = (TextView) findViewById(R.id.alturaText);
        dbHelper = new DataBaseHelper(getApplicationContext());
//        db = dbHelper.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(getApplicationContext(),EditUserActivity.class);
                startActivity(i);
                finish();

                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        intent  = getIntent();
        actualizadatos();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user, menu);
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
            Intent i= new Intent(getApplicationContext(),EditUserActivity.class);
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_equipos) {
            // Handle the camera action
        } else if (id == R.id.nav_ligas) {

        } else if (id == R.id.nav_calendar) {

        } else if (id == R.id.nav_opciones) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void actualizadatos(){
        if(intent.getExtras()!=null) {
            if (!intent.getStringExtra("nombre").equals(""))
                textName.setText(intent.getStringExtra("nombre"));
            if (!intent.getStringExtra("apellidos").equals(""))
                textSurName.setText(intent.getStringExtra("apellidos"));
            if (!intent.getStringExtra("apodo").equals(""))
                textAlias.setText("''"+intent.getStringExtra("apodo")+"''");
            if (!intent.getStringExtra("dorsal").equals(""))
                textFavNumber.setText("Dorsal Favorito: "+intent.getStringExtra("dorsal"));
            if (!intent.getStringExtra("peso").equals(""))
                textPeso.setText("Peso: "+intent.getStringExtra("peso"));
            if (!intent.getStringExtra("altura").equals(""))
                textAltura.setText("Altura: "+intent.getStringExtra("altura"));
        }

    }
}
