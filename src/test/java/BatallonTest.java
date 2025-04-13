
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.logging.Logger;

class BatallonTest {

    private static final Logger LOG = Logger.getLogger(BatallonTest.class.getName());
    @Test
    @DisplayName("Test Asignar soldado a una misión")
    public void testAsignarSoldado() {
        LOG.info("iniciando prueba testAsignarSoldado");
        Batallon batallonTest = new Batallon("1234","Octavo Brigada");
        Mision misionTest = new Mision("345", LocalDate.of(2025,04,12),"Armenia");
        Soldado soldadoTest = new Soldado("567","Carlos",Rango.SOLDADO,Funcion.MEDICO,22,EstadoSoldado.DISPONIBLE);
        LinkedList <Soldado>  ListPersonal = new LinkedList<>();
        Soldado soldado1 = new Soldado("ID001", "JUANA", Rango.SOLDADO, Funcion.MEDICO, 25, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado2 = new Soldado("ID002", "ANDREZ", Rango.SARGENTO, Funcion.LOGISTICA, 30, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado3 = new Soldado("ID003", "LUIS", Rango.SARGENTO, Funcion.MEDICO, 28, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado4 = new Soldado("ID004", "MARIA", Rango.CABO, Funcion.LOGISTICA, 35, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado5 = new Soldado("ID005", "PEDRO", Rango.SOLDADO, Funcion.LOGISTICA, 32, EstadoSoldado.NO_DISPONIBLE);

        batallonTest.getListMisiones().add(misionTest);
        batallonTest.getListaSoldados().add(soldadoTest);

        ListPersonal.add(soldado1);
        ListPersonal.add(soldado2);
        ListPersonal.add(soldado3);
        ListPersonal.add(soldado4);
        ListPersonal.add(soldado5);

        boolean result = batallonTest.asignarSoldadoMision("567","345");
        assertFalse(result);

        LOG.info("finalizando test asignarSoldado");
    }

    @Test
    @DisplayName("Test liberarSoldado")
    public void testLiberarSoldado() {
        LOG.info("iniciando prueba testLiberarSoldado");

        Batallon batalonTest = new Batallon("1234","Octavo Brigada");
        Mision misionTest = new Mision("345",LocalDate.of(2024,03,12), "Armenia");

        LinkedList <Soldado>  listpersonal = new LinkedList<>();
        Soldado soldado1 = new Soldado("ID001", "RAMIRO", Rango.SOLDADO, Funcion.MEDICO, 25, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado2 = new Soldado("ID002", "JOSE LUIS", Rango.SARGENTO, Funcion.LOGISTICA, 30, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado3 = new Soldado("ID003", "ANDREA GUZMAN", Rango.SARGENTO, Funcion.MEDICO, 28, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado4 = new Soldado("ID004", "LIU KANG", Rango.CABO, Funcion.COMUNICACIONES, 35, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado5 = new Soldado("ID005", "DAVID PLATA", Rango.SOLDADO, Funcion.LOGISTICA, 32, EstadoSoldado.NO_DISPONIBLE);

        listpersonal.add(soldado1);
        listpersonal.add(soldado2);
        listpersonal.add(soldado3);
        listpersonal.add(soldado4);
        listpersonal.add(soldado5);

        boolean result = batalonTest.liberarSoldados(listpersonal,misionTest.getFecha());
        assertTrue(result);
        assertEquals(EstadoSoldado.DISPONIBLE, soldado1.getEstado());
        assertEquals(EstadoSoldado.DISPONIBLE, soldado2.getEstado());
        assertEquals(EstadoSoldado.DISPONIBLE, soldado3.getEstado());
        assertEquals(EstadoSoldado.DISPONIBLE, soldado4.getEstado());
        assertEquals(EstadoSoldado.DISPONIBLE, soldado5.getEstado());

        LOG.info("finalizando prueba testLiberarSoldad");
    }

    @Test
    @DisplayName("Test buscar soldado especialidad")
    public void testBuscarSoldadoEspecialidad() {

        Batallon batallonTest = new Batallon("1234","Octavo Brigada");

        Soldado soldado1 = new Soldado("ID0078", "RAMIRO", Rango.SOLDADO, Funcion.MEDICO, 25, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado2 = new Soldado("ID00266", "ANA", Rango.SARGENTO, Funcion.LOGISTICA, 30, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado3 = new Soldado("ID00345", "ANTUCO", Rango.SARGENTO, Funcion.MEDICO, 28, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado4 = new Soldado("ID00410", "ANTUQUITOZ", Rango.CABO, Funcion.COMUNICACIONES, 35, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado5 = new Soldado("ID00526", "ANTUQUITOX", Rango.SOLDADO, Funcion.LOGISTICA, 32, EstadoSoldado.NO_DISPONIBLE);

        batallonTest.getListaSoldados().add(soldado1);
        batallonTest.getListaSoldados().add(soldado2);
        batallonTest.getListaSoldados().add(soldado3);
        batallonTest.getListaSoldados().add(soldado4);
        batallonTest.getListaSoldados().add(soldado5);

        LinkedList<Soldado> resultado = batallonTest.buscarSoldadoEspecialidad(Funcion.MEDICO);
        assertEquals(2, resultado.size(), "Deberían haber 2 soldados médicos");
        assertTrue(resultado.contains(soldado1), "Carlos debería estar en los resultados");
        assertTrue(resultado.contains(soldado3), "Ana debería estar en los resultados");

        LOG.info("Finalizando testBuscarSoldadoEspecialidad");
    }

    @Test
    @DisplayName("soldados Disponibles Rango")
    public void testSoldadosDisponibleRango() {
        Batallon batallonTest = new Batallon("1234","Octavo Brigada");

        Soldado soldado1 = new Soldado("ID00196", "ARCOLIA", Rango.SOLDADO, Funcion.MEDICO, 25, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado2 = new Soldado("ID00254", "LuisIANA", Rango.SARGENTO, Funcion.LOGISTICA, 30, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado3 = new Soldado("ID00321", "AnaTOLIO", Rango.SARGENTO, Funcion.MEDICO, 28, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado4 = new Soldado("ID004020", "MiguelreX", Rango.CABO, Funcion.COMUNICACIONES, 35, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado5 = new Soldado("ID00568", "SofíaneX", Rango.SOLDADO, Funcion.LOGISTICA, 32, EstadoSoldado.NO_DISPONIBLE);

        batallonTest.getListaSoldados().add(soldado1);
        batallonTest.getListaSoldados().add(soldado2);
        batallonTest.getListaSoldados().add(soldado3);
        batallonTest.getListaSoldados().add(soldado4);
        batallonTest.getListaSoldados().add(soldado5);

        LinkedList<Soldado> resultado = batallonTest.soldadosDisponiblesRango(Rango.SARGENTO);

        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(soldado2));
        assertTrue(resultado.contains(soldado3));

        LOG.info("Finalizando testSoldadosDisponiblesRango");



    }
    @Test
    @DisplayName("Test calcular Edad Promedio")
    public void testCalcularEdadPromedio() {
        LOG.info("Test QUE  Calcula el Promedio de Edad de los Soldados");
        Batallon batallonTest = new Batallon("1234","Octavo Brigada");

        Soldado soldado1 = new Soldado("ID001598", "ANNTUITOX", Rango.SOLDADO, Funcion.MEDICO, 25, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado2 = new Soldado("ID0021202", "BOTOX", Rango.SARGENTO, Funcion.LOGISTICA, 30, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado3 = new Soldado("ID00358", "LADROLLOs", Rango.SARGENTO, Funcion.MEDICO, 28, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado4 = new Soldado("ID00456", "Miguel LA PULGA", Rango.CABO, Funcion.COMUNICACIONES, 35, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado5 = new Soldado("ID00501", "Sofía LA MOLE", Rango.SOLDADO, Funcion.LOGISTICA, 32, EstadoSoldado.NO_DISPONIBLE);

        batallonTest.getListaSoldados().add(soldado1);
        batallonTest.getListaSoldados().add(soldado2);
        batallonTest.getListaSoldados().add(soldado3);
        batallonTest.getListaSoldados().add(soldado4);
        batallonTest.getListaSoldados().add(soldado5);

        double promedioEsperado = 30;
        double promedioObtenido = batallonTest.calcularEdadPromedio();

        assertEquals(promedioEsperado, promedioObtenido);
        LOG.info("finalizando prueba testCalcularEdadPromedio");


    }

    @Test
    @DisplayName("buscar IdSoldado")
    public void testBuscarIdSoldado() {
        LOG.info("Test buscar idsoldados");
        Batallon batallonTest = new Batallon("1234","Octavo Brigada");
        Soldado soldado1 = new Soldado("ID001021", "PEDRO", Rango.SOLDADO, Funcion.MEDICO, 25, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado2 = new Soldado("ID00245", "SUAREZ", Rango.SARGENTO, Funcion.LOGISTICA, 30, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado3 = new Soldado("ID00314", "RENGIFO", Rango.SARGENTO, Funcion.MEDICO, 28, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado4 = new Soldado("ID004205", "MARIO", Rango.CABO, Funcion.COMUNICACIONES, 35, EstadoSoldado.NO_DISPONIBLE);
        Soldado soldado5 = new Soldado("ID005015", "ANDRES", Rango.SOLDADO, Funcion.LOGISTICA, 32, EstadoSoldado.NO_DISPONIBLE);

        batallonTest.getListaSoldados().add(soldado1);
        batallonTest.getListaSoldados().add(soldado2);
        batallonTest.getListaSoldados().add(soldado3);
        batallonTest.getListaSoldados().add(soldado4);
        batallonTest.getListaSoldados().add(soldado5);

        Soldado soldadoEsperado = soldado3;
        assertEquals(soldadoEsperado, batallonTest.buscarIdSoldado("ID003"));

        LOG.info("finalizando prueba testBuscarIdSoldado");



    }




}