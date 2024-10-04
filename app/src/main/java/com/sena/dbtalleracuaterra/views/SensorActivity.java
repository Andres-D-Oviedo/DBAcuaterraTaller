package com.sena.dbtalleracuaterra.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sena.dbtalleracuaterra.R;
import com.sena.dbtalleracuaterra.controllers.ManagerDB;
import com.sena.dbtalleracuaterra.models.Sensor;

public class SensorActivity extends AppCompatActivity {

    private EditText edtTipoSensor, edtDatoSensor, edtFechaSensor;
    private ManagerDB managerDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        // Inicializar ManagerDB para gestionar la base de datos
        managerDB = new ManagerDB(getApplicationContext());

        // Referenciar los componentes de la interfaz de usuario
        Button btnInsertarSensor = findViewById(R.id.btnInsertarSensor);
        edtTipoSensor = findViewById(R.id.edtTipoSensor);
        edtDatoSensor = findViewById(R.id.edtDatoSensor);
        edtFechaSensor = findViewById(R.id.edtFechaSensor);

        // Acciones al presionar el botón de insertar sensor
        btnInsertarSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener valores de los campos de entrada
                String tipoSensor = edtTipoSensor.getText().toString().trim();
                String datoSensor = edtDatoSensor.getText().toString().trim();
                String fechaSensor = edtFechaSensor.getText().toString().trim();

                // Verificar que todos los campos estén completos
                if (!tipoSensor.isEmpty() && !datoSensor.isEmpty() && !fechaSensor.isEmpty()) {
                    // Insertar sensor en la base de datos
                    // Crear un nuevo objeto Sensor
                    Sensor sensor = new Sensor(tipoSensor, datoSensor, fechaSensor);

                    // Insertar el sensor en la base de datos
                    managerDB.insertarSensor(sensor);
                    Toast.makeText(SensorActivity.this, "Sensor insertado correctamente", Toast.LENGTH_SHORT).show();

                    // Limpiar los campos de texto
                    limpiarCampos();
                } else {
                    // Mostrar mensaje si hay campos vacíos
                    Toast.makeText(SensorActivity.this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Botón para volver al menú principal
        Button buttonVolver = findViewById(R.id.btnVolverHomeSensor);
        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Finaliza la actividad actual y vuelve a la anterior.
            }
        });

    }

    // Método para limpiar los campos de texto después de insertar un sensor
    private void limpiarCampos() {
        edtTipoSensor.setText("");
        edtDatoSensor.setText("");
        edtFechaSensor.setText("");
    }

}