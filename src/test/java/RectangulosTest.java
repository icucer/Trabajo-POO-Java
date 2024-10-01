import cl.ipp.ic.figuras.entidades.Rectangulos;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RectangulosTest {
    @Test
    public void testCalcularArea() {
        Rectangulos rectangulo = new Rectangulos(4, 6); // Ancho 4, Largo 6
        double areaEsperada = 4 * 6;
        assertEquals(areaEsperada, rectangulo.area());
    }

    @Test
    public void testCalcularPerimetro() {
        Rectangulos rectangulo = new Rectangulos(4, 6); // Ancho 4, Largo 6
        double perimetroEsperado = 2 * (4 + 6);
        assertEquals(perimetroEsperado, rectangulo.perimetro());
    }

    @Test
    public void testPintar() {
        Rectangulos rectangulo = new Rectangulos(4, 6);
        rectangulo.pintar();  // Revisar la salida en la consola
    }
}
