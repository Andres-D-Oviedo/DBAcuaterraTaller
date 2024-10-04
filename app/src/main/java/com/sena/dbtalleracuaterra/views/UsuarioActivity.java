package com.sena.dbtalleracuaterra.views;

import static android.app.ProgressDialog.show;

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
import com.sena.dbtalleracuaterra.models.Usuario;

public class UsuarioActivity extends AppCompatActivity {

    private EditText edtNombre, edtEmail, edtCelular, edtFechaNacimiento, edtRol;
    private ManagerDB managerDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        // Inicializar ManagerDB para gestionar la base de datos
        managerDB = new ManagerDB(getApplicationContext());

        // Referenciar los componentes de la interfaz de usuario
        // Variables para los elementos de la UI
        Button btnInsertar = findViewById(R.id.btnInsertar);
        edtNombre = findViewById(R.id.edtNombre);
        edtEmail = findViewById(R.id.edtEmail);
        edtCelular = findViewById(R.id.edtCelular);
        edtFechaNacimiento = findViewById(R.id.edtFechaNacimiento);
        edtRol = findViewById(R.id.edtRol);

        // Acciones al presionar el botón de insertar usuario
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener valores de los campos de entrada
                String nombre = edtNombre.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String celular = edtCelular.getText().toString().trim();
                String fechaNacimiento = edtFechaNacimiento.getText().toString().trim();
                String rol = edtRol.getText().toString().trim();

                // Verificar que todos los campos estén completos
                if (!nombre.isEmpty() && !email.isEmpty() && !celular.isEmpty() && !fechaNacimiento.isEmpty() && !rol.isEmpty()) {
                    // Insertar usuario en la base de datos
                    // Crear un nuevo objeto Usuario
                    Usuario usuario = new Usuario(nombre, email, celular, fechaNacimiento, rol);

                    // Insertar el usuario en la base de datos
                    managerDB.insertarUsuario(usuario);
                    Toast.makeText(UsuarioActivity.this, "Usuario insertado correctamente", Toast.LENGTH_SHORT).show();

                    // Limpiar los campos de texto
                    limpiarCampos();
                } else {
                    // Mostrar mensaje si hay campos vacíos
                    Toast.makeText(UsuarioActivity.this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Button buttonVolver = findViewById(R.id.btnVolverHome1);
        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Finaliza la actividad actual y vuelve a la anterior.
            }
        });

    }

    // Método para limpiar los campos de texto después de insertar un usuario
    private void limpiarCampos() {
        edtNombre.setText("");
        edtEmail.setText("");
        edtCelular.setText("");
        edtFechaNacimiento.setText("");
        edtRol.setText("");
    }

}