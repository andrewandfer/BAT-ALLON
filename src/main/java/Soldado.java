public class Soldado {
    private String id;
    private String nombre;
    private Rango rango;
    private Funcion funcion;
    private int edad;
    EstadoSoldado estado;

    public Soldado(String id, String nombre, Rango rango, Funcion funcion, int edad, EstadoSoldado estado) {
        this.id = id;
        this.nombre = nombre;
        this.rango = rango;
        this.funcion = funcion;
        this.edad = edad;
        this.estado = estado;
    }

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public EstadoSoldado getEstado() {
        return estado;
    }

    public void setEstado(EstadoSoldado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Soldado{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", rango=" + rango +
                ", funcion=" + funcion +
                ", edad=" + edad +
                ", estado=" + estado +
                '}';
    }
}