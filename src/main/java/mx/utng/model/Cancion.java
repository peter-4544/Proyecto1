package mx.utng.model;

public class Cancion {
    private int id;
    private String titulo;
    private String interprete;
    private String genero;
    private int anio;


    public Cancion(){
    }

    public Cancion(int id, String titulo, String interprete, String genero, int anio) {
        this.id = id;
        this.titulo = titulo;
        this.interprete = interprete;
        this.genero = genero;
        this.anio = anio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Cancion [id=" + id + ", titulo=" + titulo + ", interprete=" + interprete + ", genero=" + genero + ", anio="
                + anio + "]";
    }
}