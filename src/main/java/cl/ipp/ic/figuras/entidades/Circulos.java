package cl.ipp.ic.figuras.entidades;

import cl.ipp.ic.figuras.interfazes.I_Figuras;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Circulos extends Figuras implements I_Figuras {
    private double radio;

    public Circulos(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(getRadio(), 2);
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * getRadio();
    }

    @Override
    public void pintar() {
        System.out.println("Pintando circulo");
    }
}
