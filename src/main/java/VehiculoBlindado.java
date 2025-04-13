import java.util.LinkedList;

public class VehiculoBlindado extends Vehiculo {

    private String nivelBlindaje;

    public VehiculoBlindado(String id, String modelo, int anioFabricacion, double kilometraje, int misionesCompletadas, EstadoOperativo estadoOperativo, String nivelBlindaje) {
        super(id, modelo, anioFabricacion, kilometraje, misionesCompletadas, estadoOperativo);
        this.nivelBlindaje = nivelBlindaje;
    }

    public String getNivelBlindaje() {
        return nivelBlindaje;
    }

    public void setNivelBlindaje(String nivelBlindaje) {
        this.nivelBlindaje = nivelBlindaje;
    }

    @Override
    public String toString() {
        return "VehiculoBlindado{" +
                "nivelBlindaje='" + nivelBlindaje + '\'' +
                '}';
    }
}