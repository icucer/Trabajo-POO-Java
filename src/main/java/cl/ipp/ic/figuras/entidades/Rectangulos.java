package cl.ipp.ic.figuras.entidades;

import cl.ipp.ic.figuras.interfazes.I_Figuras;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rectangulos extends Figuras implements I_Figuras {
    private double ancho;
    private double largo;

    public Rectangulos(double ancho, double largo) {
        this.ancho = ancho;
        this.largo = largo;
    }

    @Override
    public double area() {
        return getAncho() * getLargo();
    }

    @Override
    public double perimetro() {
        return 2 * (getAncho() + getLargo());
    }

    @Override
    public void pintar() {
        System.out.println("Pintando rectangulo");
    }
}
