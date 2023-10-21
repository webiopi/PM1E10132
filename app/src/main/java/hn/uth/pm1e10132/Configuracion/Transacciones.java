package hn.uth.pm1e10132.Configuracion;

public class Transacciones {

    public static final String nameDB = "Examen1";

    //Tablas
    public static final String Tabla = "contactos";

    //Campos de Tabla
    public static final String id= "id";
    public static final String nombre= "nombre";
    public static final String telefono= "telefono";

    public static final String pais= "pais";
    public static final String nota= "nota";

    //Consulta a Base de Datos - DDL
    public static final String CreateTableContactos = "CREATE TABLE contactos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, telefono TEXT, pais TEXT, nota TEXT)";
    public static final String DropTableContactos= "DROP TABLE IF EXISTS contactos";
    //DML
    public static final String selectTableContactos = "SELECT * FROM contactos";

}
