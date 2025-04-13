import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear el Batallón
        Batallon batallon = new Batallon("B001", "Batallón Alfa");

        // Crear vehículos
        VehiculoBlindado vehiculoBlindado = new VehiculoBlindado("V001", "MAZDA", 2020,17,72,EstadoOperativo.EN_MISION,"20");
        VehiculoTransporteTropas vehiculoTransporte = new VehiculoTransporteTropas("V002", "Modelo Trans", 2011, 1200, 50, EstadoOperativo.DISPONIBLE,89);
        VehiculoApoyo vehiculoApoyo = new VehiculoApoyo("V003", "800", 2019,25,18,EstadoOperativo.OPERATIVO,"ALCON",TipoFuncion.COMUNICACIONES);

        // Agregar vehículos al Batallón
        batallon.crearVehiculo(vehiculoBlindado);
        batallon.crearVehiculo(vehiculoTransporte);
        batallon.crearVehiculo(vehiculoApoyo);

        // Crear misiones
        Mision mision1 = new Mision("M001", LocalDate.of(2025, 4, 13), "Base Central");
        Mision mision2 = new Mision("M002", LocalDate.of(2025, 4, 13), "Base Sur");
        Mision mision3 = new Mision("M003", LocalDate.of(2025, 4, 14), "Base Norte");

        // Registrar misiones
        batallon.getListMisiones().add(mision1);
        batallon.getListMisiones().add(mision2);
        batallon.getListMisiones().add(mision3);

        // Crear soldados
        Soldado soldado1 = new Soldado("S001", "Juan", Rango.SOLDADO, Funcion.COMUNICACIONES,17,EstadoSoldado.DISPONIBLE);
        Soldado soldado2 = new Soldado("S002", "Pedro",Rango.SARGENTO,Funcion.COMUNICACIONES,18, EstadoSoldado.DISPONIBLE);

        // Agregar soldados al Batallón
        batallon.getListaSoldados().add(soldado1);
        batallon.getListaSoldados().add(soldado2);

        // Menú interactivo con opciones
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Menú de opciones ---");
            System.out.println("1. Buscar misiones por fecha y ubicación");
            System.out.println("2. Calcular kilometraje promedio por tipo de vehículo");
            System.out.println("3. Ver vehículo con más misiones");
            System.out.println("4. Ver vehículos con más de 50 misiones");
            System.out.println("5. Asignar soldado a misión");
            System.out.println("6. Liberar soldados");
            System.out.println("7. Calcular edad promedio de soldados");
            System.out.println("8. Buscar soldados por rango");
            System.out.println("9. Buscar soldados por especialidad");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    // Buscar misiones por fecha y ubicación
                    System.out.println("Introduce la fecha (yyyy-mm-dd): ");
                    String fechaStr = scanner.nextLine();
                    LocalDate fecha = LocalDate.parse(fechaStr);
                    System.out.println("Introduce la ubicación: ");
                    String ubicacion = scanner.nextLine();
                    LinkedList<Mision> misionesEncontradas = batallon.buscarMisionesPorFechaYUbicacion(fecha, ubicacion);
                    System.out.println("Misiones encontradas:");
                    for (Mision mision : misionesEncontradas) {
                        System.out.println(mision);
                    }
                    break;
                case 2:
                    // Calcular kilometraje promedio por tipo de vehículo
                    System.out.println("Kilometraje promedio de vehículos de Transporte: " + batallon.kilometrajePromedioTransporte());
                    System.out.println("Kilometraje promedio de vehículos Blindados: " + batallon.kilometrajePromedioBlindado());
                    System.out.println("Kilometraje promedio de vehículos de Apoyo: " + batallon.kilometrajePromedioApoyo());
                    break;
                case 3:
                    // Ver vehículo con más misiones
                    Vehiculo vehiculoMasMisiones = batallon.vehiculoMayorCantMisiones();
                    System.out.println("Vehículo con más misiones completadas: " + vehiculoMasMisiones.getId());
                    break;
                case 4:
                    // Ver vehículos con más de 50 misiones
                    LinkedList<Vehiculo> vehiculosCon50Misiones = batallon.obtenerVehiculosConmas50Misiones();
                    System.out.println("Vehículos con más de 50 misiones:");
                    for (Vehiculo vehiculo : vehiculosCon50Misiones) {
                        System.out.println(vehiculo.getId());
                    }
                    break;
                case 5:
                    // Asignar soldado a misión
                    System.out.println("Introduce el ID del soldado: ");
                    String idSoldado = scanner.nextLine();
                    System.out.println("Introduce el ID de la misión: ");
                    String idMision = scanner.nextLine();
                    boolean soldadoAsignado = batallon.asignarSoldadoMision(idSoldado, idMision);
                    System.out.println("¿Soldado asignado a misión? " + soldadoAsignado);
                    break;
                case 6:
                    // Liberar soldados
                    System.out.println("Liberando soldados...");
                    LinkedList<Soldado> listPersonal = new LinkedList<>();
                    listPersonal.add(soldado1);
                    listPersonal.add(soldado2);
                    boolean soldadosLiberados = batallon.liberarSoldados(listPersonal, LocalDate.of(2025, 4, 13));
                    System.out.println("¿Soldados liberados? " + soldadosLiberados);
                    break;
                case 7:
                    // Calcular edad promedio de soldados
                    System.out.println("Edad promedio de los soldados: " + batallon.calcularEdadPromedio());
                    break;
                case 8:
                    // Buscar soldados por rango
                    System.out.println("Introduce el rango (Ej: CAPITAN): ");
                    String rangoStr = scanner.nextLine();
                    Rango rango = Rango.valueOf(rangoStr.toUpperCase());
                    LinkedList<Soldado> soldadosRango = batallon.soldadosDisponiblesRango(rango);
                    System.out.println("Soldados con rango " + rango + ":");
                    for (Soldado soldado : soldadosRango) {
                        System.out.println(soldado.getId());
                    }
                    break;
                case 9:
                    // Buscar soldados por especialidad
                    System.out.println("Introduce la especialidad (Ej: PILOTO): ");
                    String funcionStr = scanner.nextLine();
                    Funcion funcion = Funcion.valueOf(funcionStr.toUpperCase());
                    LinkedList<Soldado> soldadosEspecialidad = batallon.buscarSoldadoEspecialidad(funcion);
                    System.out.println("Soldados con especialidad " + funcion + ":");
                    for (Soldado soldado : soldadosEspecialidad) {
                        System.out.println(soldado.getId());
                    }
                    break;
                case 0:
                    // Salir
                    exit = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida, intenta nuevamente.");
            }
        }

        scanner.close();
    }
}
