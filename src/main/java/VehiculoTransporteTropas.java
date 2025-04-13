public class VehiculoTransporteTropas extends Vehiculo {

    private int capacidadSoldados;

    public VehiculoTransporteTropas(String id, String modelo, int anioFabricacion, double kilometraje, int misionesCompletadas, EstadoOperativo estadoOperativo, int capacidadSoldados) {
        super(id, modelo, anioFabricacion, kilometraje, misionesCompletadas, estadoOperativo);
        this.capacidadSoldados = capacidadSoldados;
    }

    public int getCapacidadSoldados() {
        return capacidadSoldados;
    }

    public void setCapacidadSoldados(int capacidadSoldados) {
        this.capacidadSoldados = capacidadSoldados;
    }

    @Override
    public String toString() {
        return "VehiculoTransporteTropas{" +
                "capacidadSoldados=" + capacidadSoldados +
                '}';
    }
}
