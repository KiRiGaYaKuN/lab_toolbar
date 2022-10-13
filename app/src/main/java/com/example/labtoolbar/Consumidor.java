package com.example.labtoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Consumidor extends AppCompatActivity {

    Button consulta;
    Button carrito;
    public static final String EXTRA_MESSAGE="mesagge";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumidor);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        consulta = (Button) findViewById(R.id.consultarcomida);
        carrito = (Button) findViewById(R.id.consultacarrito);

        Intent intent=getIntent();
        String usuario = intent.getStringExtra(EXTRA_MESSAGE);

        consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Consumidor.this, Ofertasconsumidor.class);
                i.putExtra(Ofertasconsumidor.EXTRA_MESSAGE, usuario);
                startActivity(i);
            }
        });

        carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Consumidor.this, carritodecompras.class);
                i.putExtra(carritodecompras.EXTRA_MESSAGE, usuario);
                startActivity(i);
            }
        });
    }
}