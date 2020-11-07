package com.example.ej_semana_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmacionActivity extends AppCompatActivity {

    private TextView nombre_completo, fecha_nacimiento, telefono, email, descripcion_contacto;
    private Button editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
        initializeView();
        initializeData();
    }

    public void initializeView(){
        nombre_completo = findViewById(R.id.nombre_completo);
        fecha_nacimiento = findViewById(R.id.fecha_nacimiento);
        telefono = findViewById(R.id.telefono);
        email = findViewById(R.id.email);
        descripcion_contacto = findViewById(R.id.descripcion_contacto);
        editar = findViewById(R.id.editar);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void initializeData(){

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            nombre_completo.setText(getIntent().getStringExtra("nombre_completo"));
            fecha_nacimiento.setText("Fecha Nacimiento: " + getIntent().getStringExtra("fecha_nacimiento"));
            telefono.setText("Tel: " + bundle.getString("telefono"));
            email.setText("Email: " + bundle.getString("email"));
            descripcion_contacto.setText("Descripción Contacto: " + bundle.getString("descripcion_contacto"));
        }
    }
}
