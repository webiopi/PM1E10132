package hn.uth.pm1e10132.Modelos;

public class Contactos {
    private Integer id;
    private String Nombre;
    private String Telefono;
    private String Pais;
    private String Nota;

    public Contactos(Integer id, String nombre, String telefono, String pais, String nota) {
        this.id = id;
        Nombre = nombre;
        Telefono = telefono;
        Pais = pais;
        Nota = nota;
    }

    public Contactos() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public String getNota() {
        return Nota;
    }

    public void setNota(String nota) {
        Nota = nota;
    }
}
