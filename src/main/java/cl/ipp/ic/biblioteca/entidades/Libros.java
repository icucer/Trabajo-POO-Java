package cl.ipp.ic.biblioteca.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Libros {
    private String isbn;
    private String titulo;
    private String autor;

    @Override
    public String toString() {
        return "\nLibro:\n" +
                "ISBN=" + isbn + ",\n" +
                "Título=" + titulo + ",\n" +
                "Autor=" + autor + ".";
    }
}
