package com.example.labtoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Vendedor extends AppCompatActivity {

    Button ofertar;
    Button consulta;
    String usuario;
    public static final String EXTRA_MESSAGE="mesagge";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedor);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ofertar = (Button) findViewById(R.id.OfertarComida);
        consulta = (Button) findViewById(R.id.consultarOfertas);

        Intent intent=getIntent();
        usuario = intent.getStringExtra(EXTRA_MESSAGE);

        ofertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(Vendedor.this, Ofertarcomida.class);
                i.putExtra(Ofertarcomida.EXTRA_MESSAGE, usuario);
                startActivity(i);
            }
        });

        consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Vendedor.this, Ofertasconsumidor.class);
                i.putExtra(Ofertarcomida.EXTRA_MESSAGE, usuario);
                startActivity(i);
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu){

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_create_order:
                Intent intent = new Intent(this, Ofertarcomida.class);
                intent.putExtra(Ofertarcomida.EXTRA_MESSAGE, usuario);
                startActivity(intent);
                return true;
            default:
                return super .onOptionsItemSelected(item);
        }
    }

}