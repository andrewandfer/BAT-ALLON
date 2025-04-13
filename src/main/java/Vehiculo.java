
import java.util.LinkedList;

public abstract class Vehiculo {

    protected String id;
    protected String modelo;
    protected int anioFabricacion;
    protected double kilometraje;
    protected int misionesCompletadas;
    protected EstadoOperativo estadoOperativo;
    protected LinkedList<Mision> listaMisiones;

    public Vehiculo(String id, String modelo, int anioFabricacion, double kilometraje, int misionesCompletadas,
                    EstadoOperativo estadoOperativo) {
        this.id = id;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.kilometraje = kilometraje;
        this.misionesCompletadas = misionesCompletadas;
        this.estadoOperativo = estadoOperativo;
        listaMisiones = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public int getMisionesCompletadas() {
        return misionesCompletadas;
    }

    public void setMisionesCompletadas(int misionesCompletadas) {
        this.misionesCompletadas = misionesCompletadas;
    }

    public EstadoOperativo getEstadoOperativo() {
        return estadoOperativo;
    }

    public void setEstadoOperativo(EstadoOperativo estadoOperativo) {
        this.estadoOperativo = estadoOperativo;
    }

    public LinkedList<Mision> getListaMisiones() {
        return listaMisiones;
    }

    public void setListaMisiones(LinkedList<Mision> listaMisiones) {
        this.listaMisiones = listaMisiones;
    }





}

