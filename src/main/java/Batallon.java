
import java.time.LocalDate;
import java.util.LinkedList;

public class Batallon {

    private String id;
    private String nombre;
    private LinkedList<Mision> listMisiones;
    private LinkedList<VehiculoTransporteTropas> listaVehiculosTransporte;
    private LinkedList<VehiculoBlindado> listaVehiculosBlindados;
    private LinkedList<VehiculoApoyo> listaVehiculosApoyo;
    private LinkedList<Vehiculo> listaVehiculos;
    private LinkedList<Soldado> listaSoldados;



    // Constructor
    public Batallon(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        listMisiones = new LinkedList<>();
        listaVehiculosApoyo = new LinkedList<>();
        listaVehiculosBlindados = new LinkedList<>();
        listaVehiculosTransporte = new LinkedList<>();
        listaVehiculos = new LinkedList<>();
        listaSoldados = new LinkedList<>();

    }

    public LinkedList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public LinkedList<Soldado> getListaSoldados() {
        return listaSoldados;
    }

    public void setListaSoldados(LinkedList<Soldado> listaSoldados) {
        this.listaSoldados = listaSoldados;
    }

    public double kilometrajePromedioTransporte() {
        double sumaTransporte = 0;
        double promedioTropas = 0;
        for (Vehiculo vehiculoTransporte : listaVehiculosTransporte) {
            sumaTransporte = vehiculoTransporte.getKilometraje() + sumaTransporte;
        }
        promedioTropas = sumaTransporte / listaVehiculosTransporte.size();
        return promedioTropas;
    }

    public double kilometrajePromedioBlindado() {
        double sumaBlindados = 0;
        double promedioBlindados = 0;
        for (Vehiculo vehiculoBlindado : listaVehiculosBlindados) {
            sumaBlindados = vehiculoBlindado.getKilometraje() + sumaBlindados;
        }
        sumaBlindados = sumaBlindados / listaVehiculosBlindados.size();
        return promedioBlindados;
    }

    public double kilometrajePromedioApoyo() {
        double sumaApoyo = 0;
        double promedioApoyo = 0;
        for (Vehiculo vehiculoApoyo : listaVehiculosApoyo) {
            sumaApoyo = vehiculoApoyo.getKilometraje() + sumaApoyo;
        }
        promedioApoyo = sumaApoyo / listaVehiculosApoyo.size();
        return promedioApoyo;
    }

    // Metodo para obtener el vehiculo con mas misiones completadas
    public Vehiculo vehiculoMayorCantMisiones() {
        Vehiculo vehiculoMasMisiones = null;
        int cantMaximaMisiones = 0;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getListaMisiones().size() > cantMaximaMisiones) {
                cantMaximaMisiones = vehiculo.getMisionesCompletadas();
                vehiculoMasMisiones = vehiculo;
            }
        }

        return vehiculoMasMisiones;
    }

    // Metodo para obtener los vehiculos con mas de 50 misiones completadas
    public LinkedList<Vehiculo> obtenerVehiculosConmas50Misiones() {
        LinkedList<Vehiculo> vehiculosMisionesCompletadas = new LinkedList<>();

        for (VehiculoApoyo vehiculo : listaVehiculosApoyo) {
            if (vehiculo.getListaMisiones().size()> 50) {
                vehiculosMisionesCompletadas.add(vehiculo);
            }
        }

        for (VehiculoBlindado vehiculo : listaVehiculosBlindados) {
            if (vehiculo.getListaMisiones().size() > 50) {
                vehiculosMisionesCompletadas.add(vehiculo);
            }
        }

        for (VehiculoTransporteTropas vehiculo : listaVehiculosTransporte) {
            if (vehiculo.getListaMisiones().size() > 50) {
                vehiculosMisionesCompletadas.add(vehiculo);
            }
        }

        return vehiculosMisionesCompletadas;
    }

    // Metodo para registrar las misiones de cada vehiculo
    public boolean registrarMision(LocalDate fechaMision, String ubicacionMision, LinkedList<String> listPersonal,
                                   String idVehiculoMision) {

        boolean flag = false;

        String cantMisionesActuales = String.valueOf(getListMisiones().size() + 1);
        Mision newMision = new Mision(cantMisionesActuales, fechaMision, ubicacionMision);
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getId().equals(idVehiculoMision)) {
                newMision.setTheVehiculo(vehiculo);

                LinkedList<Mision> listTemporal = vehiculo.getListaMisiones();
                listTemporal.add(newMision);

                vehiculo.setListaMisiones(listTemporal);
                flag = true;
                break;
            }
        }

        return flag;

    }

    //CRUD para vehiculo
    public boolean crearVehiculo(Vehiculo newVehiculo) {
        for (Vehiculo newvehiculo : listaVehiculos) {
            if (verificarVehiculo(newvehiculo.getId())) {
                listaVehiculos.add(newvehiculo);
                return true;
            }
        }
        return false;
    }

    public boolean verificarVehiculo(String idVerificar) {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getId().equals(idVerificar)) {
                return false;
            }
        }
        return true;
    }

    //CRUD para vehiculo de apoyo
    public boolean crearVehiculoApoyo(VehiculoApoyo newVehiculoApoyo) {
        for (VehiculoApoyo newvehiculoApoyo : listaVehiculosApoyo) {
            if (verificarVehiculo(newvehiculoApoyo.getId())) {
                listaVehiculos.add(newvehiculoApoyo);
                return true;
            }
        }
        return false;
    }

    //CRUD para vehiculo de Transporte
    public boolean crearVehiculoTransporte(VehiculoTransporteTropas newVehiculoTransporte) {
        for (VehiculoTransporteTropas newvehiculoTransporte : listaVehiculosTransporte) {
            if (verificarVehiculo(newvehiculoTransporte.getId())) {
                listaVehiculos.add(newvehiculoTransporte);
                return true;
            }
        }
        return false;
    }

    //CRUD para vehiculo blindado
    public boolean crearVehiculoBlindado(VehiculoBlindado newVehiculoBlindado) {
        for (VehiculoBlindado newvehiculoBlindado : listaVehiculosBlindados) {
            if (verificarVehiculo(newvehiculoBlindado.getId())) {
                listaVehiculos.add(newvehiculoBlindado);
                return true;
            }
        }
        return false;
    }


    //CRUD para mision
    public boolean registrarMision() {
        for (Mision newMision : listMisiones) {
            if (verificarId(newMision.getId())) {
                listMisiones.add(newMision);
                return true;
            }
        }
        return false;
    }

    public boolean verificarId(String idVerificar) {
        for (Mision mision : listMisiones) {
            if (mision.getId().equals(idVerificar)) {
                return false;
            }
        }
        return true;
    }

    // Getters y setters
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

    public LinkedList<Mision> getListMisiones() {
        return listMisiones;
    }

    public void setListMisiones(LinkedList<Mision> listMisiones) {
        this.listMisiones = listMisiones;
    }

    public LinkedList<VehiculoTransporteTropas> getListaVehiculosTransporte() {
        return listaVehiculosTransporte;
    }

    public void setListaVehiculosTransporte(LinkedList<VehiculoTransporteTropas> listaVehiculosTransporte) {
        this.listaVehiculosTransporte = listaVehiculosTransporte;
    }

    public LinkedList<VehiculoBlindado> getListaVehiculosBlindados() {
        return listaVehiculosBlindados;
    }

    public void setListaVehiculosBlindados(LinkedList<VehiculoBlindado> listaVehiculosBlindados) {
        this.listaVehiculosBlindados = listaVehiculosBlindados;
    }

    public LinkedList<VehiculoApoyo> getListaVehiculosApoyo() {
        return listaVehiculosApoyo;
    }

    public void setListaVehiculosApoyo(LinkedList<VehiculoApoyo> listaVehiculosApoyo) {
        this.listaVehiculosApoyo = listaVehiculosApoyo;
    }

    public LinkedList<Vehiculo> getlistVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(LinkedList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    // Asigna Mision al Soldado
    public boolean asignarSoldadoMision (String identificadorSoldado, String idMision){
        boolean asignar = false;
        Mision newMision = null;
        Soldado newSoldado1 = null;

        for(Mision newMision1 : listMisiones){
            if(newMision1.getId().equals(idMision)){
                newMision = newMision1;
                break;
            }
        }

        for (Soldado newSoldado : listaSoldados){
            if(newSoldado.getId().equals(identificadorSoldado)&&newSoldado.getEstado().equals(Estado.DISPONIBLE)){
                newSoldado1= newSoldado;
            }
        }if(newMision!=null&&newSoldado1!=null){
            newMision.getPersonal().add(newSoldado1);
            newSoldado1.setEstado(EstadoSoldado.NO_DISPONIBLE);
            asignar = true;
        }
        return asignar;

    }

    public boolean liberarSoldados(LinkedList<Soldado> listPersonal, LocalDate fechaMision) {
        LocalDate fechaActual = LocalDate.now();
        boolean soldadosLiberados = false;

        if (fechaMision.isBefore(fechaActual)) {
            for (Soldado soldado : listPersonal) {
                soldado.setEstado(EstadoSoldado.DISPONIBLE);
                soldadosLiberados = true;
            }
        }

        return soldadosLiberados;
    }

    // Buscar soldado por especializacion
    public LinkedList<Soldado> buscarSoldadoEspecialidad(Funcion funcionBuscar) {
        LinkedList<Soldado> listSoldadosEspecialidad = new LinkedList<>();
        for (Soldado soldado : listaSoldados) {
            if (soldado.getFuncion().equals(funcionBuscar)) {
                listSoldadosEspecialidad.add(soldado);
            }
        }
        return listSoldadosEspecialidad;
    }

    //Obtener soldados disponibles por rango
    public LinkedList<Soldado> soldadosDisponiblesRango(Rango indexRango) {
        LinkedList<Soldado> listSoldadosRango = new LinkedList<>();
        for (Soldado soldado : listaSoldados) {
            if (soldado.getRango().equals(indexRango)) {
                listSoldadosRango.add(soldado);
            }
        }
        return listSoldadosRango;
    }

    public double calcularEdadPromedio(){
        double sumaEdades = 0;
        double promedioEdades = 0;
        for(Soldado newSoldado : listaSoldados){
            sumaEdades += newSoldado.getEdad();
        }

        promedioEdades = sumaEdades/ listaSoldados.size();
        return promedioEdades;
    }



    //Buscar soldado por id
    public Soldado buscarIdSoldado(String idBuscar) {
        for (Soldado soldado : listaSoldados) {
            if (soldado.getId().equals(idBuscar)) {
                return soldado;
            }
        }
        return null;
    }
    public LinkedList<Mision> buscarMisionesPorFechaYUbicacion(LocalDate fecha, String ubicacion) {
        LinkedList<Mision> misionesEncontradas = new LinkedList<>();

        // Recorremos la lista de misiones y buscamos aquellas que coincidan
        for (Mision mision : listMisiones) {
            if (mision.getFecha().equals(fecha) && mision.getUbicacion().equalsIgnoreCase(ubicacion)) {
                misionesEncontradas.add(mision);
            }
        }

        return misionesEncontradas;
    }
}








