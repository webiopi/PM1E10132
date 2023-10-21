package hn.uth.pm1e10132;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import hn.uth.pm1e10132.Configuracion.SQLiteConnection;
import hn.uth.pm1e10132.Configuracion.Transacciones;
import hn.uth.pm1e10132.Modelos.Contactos;

public class Listado extends AppCompatActivity {
    SQLiteConnection conexion;

    ListView listView;

    ArrayList<Contactos> listContactos;

    ArrayList<String> ArregloContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        try {
            //Establecer Conexion a la DB
            conexion= new SQLiteConnection(this, Transacciones.nameDB, null, 1);
            listView= (ListView) findViewById(R.id.listaContactos);

            getcontactos();

            ArrayAdapter adp= new ArrayAdapter(this, android.R.layout.simple_list_item_1, ArregloContactos);
            listView.setAdapter(adp);

        }catch (Exception exception){
            exception.toString();
        }

    }

    private void getcontactos() {
        SQLiteDatabase db= conexion.getReadableDatabase();
        Contactos contacto= null;
        listContactos= new ArrayList<Contactos>();

        Cursor cursor= db.rawQuery(Transacciones.selectTableContactos, null);
        while(cursor.moveToNext()){
            contacto= new Contactos();
            contacto.setId(cursor.getInt(0));
            contacto.setNombre(cursor.getString(1));
            contacto.setTelefono(cursor.getString(2));
            contacto.setPais(cursor.getString(3));
            contacto.setNota(cursor.getString(4));

            listContactos.add(contacto);


        }
        cursor.close();
        FillList();

    }

    private void FillList() {

        ArregloContactos = new ArrayList<String>();

        for (int i = 0; i < listContactos.size(); i++) {
            ArregloContactos.add(listContactos.get(i).getId() + " - " +
                    listContactos.get(i).getNombre() + " - " +
                    listContactos.get(i).getTelefono() + " - " +
                    listContactos.get(i).getPais() + " - " +
                    listContactos.get(i).getNota());
        }
    }
}
