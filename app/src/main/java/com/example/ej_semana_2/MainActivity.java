package com.example.ej_semana_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText nombre_completo, fecha_nacimiento, telefono, email, descripcion_contacto;
    private Button siguiente;
    DatePickerDialog datePickerDialog;
    final Calendar c = Calendar.getInstance();
    final int mYear = c.get(Calendar.YEAR); // current year
    final int mMonth = c.get(Calendar.MONTH); // current month
    final int mDay = c.get(Calendar.DAY_OF_MONTH); // current day



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
    }

    public void initializeView(){
        nombre_completo = findViewById(R.id.nombre_completo);
        fecha_nacimiento = findViewById(R.id.fecha_nacimiento);
        telefono = findViewById(R.id.telefono);
        email = findViewById(R.id.email);
        descripcion_contacto = findViewById(R.id.descripcion_contacto);
        siguiente = findViewById(R.id.siguiente);

        fecha_nacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ConfirmacionActivity.class);
                intent.putExtra("nombre_completo", nombre_completo.getText().toString());
                intent.putExtra("fecha_nacimiento", fecha_nacimiento.getText().toString());
                intent.putExtra("telefono", telefono.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("descripcion_contacto", descripcion_contacto.getText().toString());
                startActivity(intent);
            }
        });
    }


    private void showDatePickerDialog() {
        datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        fecha_nacimiento.setText(parseNumberToString(dayOfMonth) + "/"
                                + parseNumberToString(monthOfYear + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public static String parseNumberToString(int value) {
        return String.format("%02d", value);
    }


}