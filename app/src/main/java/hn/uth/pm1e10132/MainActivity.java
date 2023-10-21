package hn.uth.pm1e10132;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;

import hn.uth.pm1e10132.Configuracion.SQLiteConnection;
import hn.uth.pm1e10132.Configuracion.Transacciones;

public class MainActivity extends AppCompatActivity {

    EditText nombre, telefono, nota;

    Button Guardar, Mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.txtNombre);
        telefono = (EditText) findViewById(R.id.txtTele);
        nota = (EditText) findViewById(R.id.txtNota);

        Guardar = (Button) findViewById(R.id.btGuardar);
        Mostrar = (Button) findViewById(R.id.btMostrar);

        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddContactos();

            }
        });


        Mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreate = new Intent(getApplicationContext(), Listado.class);
                startActivity(intentCreate);
            }
        });
    }

    private void AddContactos() {
        try {
            SQLiteConnection conexion = new SQLiteConnection(this, Transacciones.nameDB, null, 1);
            SQLiteDatabase db = conexion.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put(Transacciones.nombre, nombre.getText().toString());
            valores.put(Transacciones.telefono, telefono.getText().toString());
            valores.put(Transacciones.nota, nota.getText().toString());

            Long Result= db.insert(Transacciones.Tabla, Transacciones.id, valores);

            Toast.makeText(this, getString(R.string.RespuestaExito), Toast.LENGTH_LONG).show();
            db.close();

        } catch (Exception exception) {
            Toast.makeText(this, getString(R.string.RespuestaError), Toast.LENGTH_LONG).show();
        }
    }
}