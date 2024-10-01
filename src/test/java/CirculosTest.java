import cl.ipp.ic.figuras.entidades.Circulos;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CirculosTest {
    @Test
    public void testCalcularArea() {
        Circulos circulo = new Circulos(5); // Radio 5
        double areaEsperada = Math.PI * 5 * 5;
        assertEquals(areaEsperada, circulo.area(), 0.0001);
    }

    @Test
    public void testCalcularPerimetro() {
        Circulos circulo = new Circulos(5); // Radio 5
        double perimetroEsperado = 2 * Math.PI * 5;
        assertEquals(perimetroEsperado, circulo.perimetro(), 0.0001);
    }

    @Test
    public void testPintar() {
        Circulos circulo = new Circulos(5);
        circulo.pintar();  // Revisar la salida en la consola
    }
}
