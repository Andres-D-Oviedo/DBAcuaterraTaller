package com.sena.dbtalleracuaterra.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sena.dbtalleracuaterra.R;
import com.sena.dbtalleracuaterra.controllers.ManagerDB;
import com.sena.dbtalleracuaterra.models.Usuario;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonUsuario = findViewById(R.id.button_usuario);
        Button buttonModulo = findViewById(R.id.button_modulo);
        Button buttonSensor = findViewById(R.id.button_sensor);

        buttonUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UsuarioActivity.class);
                startActivity(intent);
            }
        });

        buttonModulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ModuloActivity.class);
                startActivity(intent);
            }
        });

        buttonSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SensorActivity.class);
                startActivity(intent);
            }
        });

    }


}