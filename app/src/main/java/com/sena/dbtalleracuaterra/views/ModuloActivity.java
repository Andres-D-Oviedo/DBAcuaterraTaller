package com.sena.dbtalleracuaterra.views;

import static java.lang.Integer.parseInt;

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
import com.sena.dbtalleracuaterra.models.Modulo;

public class ModuloActivity extends AppCompatActivity {

    private EditText edtVolumen, edtNumPeces, edtEspeciePeces, edtNumPlantas, edtEspeciePlantas;
    private ManagerDB managerDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo);

        // Inicializar ManagerDB para gestionar la base de datos
        managerDB = new ManagerDB(getApplicationContext());

        // Referenciar los componentes de la interfaz de usuario
        Button btnInsertar = findViewById(R.id.btnInsertarModulo);
        edtVolumen = findViewById(R.id.edtVolumen);
        edtNumPeces = findViewById(R.id.edtNumPeces);
        edtEspeciePeces = findViewById(R.id.edtEspeciePeces);
        edtNumPlantas = findViewById(R.id.edtNumPlantas);
        edtEspeciePlantas = findViewById(R.id.edtEspeciePlantas);

        // Acciones al presionar el botón de insertar módulo
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener valores de los campos de entrada
                String volumen = edtVolumen.getText().toString().trim();
                String numPecesStr = edtNumPeces.getText().toString().trim();
                String especiePeces = edtEspeciePeces.getText().toString().trim();
                String numPlantasStr = edtNumPlantas.getText().toString().trim();
                String especiePlantas = edtEspeciePlantas.getText().toString().trim();

                // Convertir los valores de número de peces y número de plantas a enteros
                int numPeces = Integer.parseInt(numPecesStr);
                int numPlantas = Integer.parseInt(numPlantasStr);

                // Verificar que todos los campos estén completos
                if (!volumen.isEmpty() && !numPecesStr.isEmpty() && !especiePeces.isEmpty() && !numPlantasStr.isEmpty() && !especiePlantas.isEmpty()) {
                    // Insertar módulo en la base de datos
                    // Crear un nuevo objeto Modulo
                    Modulo modulo = new Modulo(volumen, numPeces, especiePeces, numPlantas, especiePlantas);

                    // Insertar el módulo en la base de datos
                    managerDB.insertarModulo(modulo);
                    Toast.makeText(ModuloActivity.this, "Módulo insertado correctamente", Toast.LENGTH_SHORT).show();

                    // Limpiar los campos de texto
                    limpiarCampos();
                } else {
                    // Mostrar mensaje si hay campos vacíos
                    Toast.makeText(ModuloActivity.this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button buttonVolver = findViewById(R.id.btnVolverHome3);
        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Finaliza la actividad actual y vuelve a la anterior.
            }
        });

    }

    // Método para limpiar los campos de texto después de insertar un módulo
    private void limpiarCampos() {
        edtVolumen.setText("");
        edtNumPeces.setText("");
        edtEspeciePeces.setText("");
        edtNumPlantas.setText("");
        edtEspeciePlantas.setText("");
    }

}