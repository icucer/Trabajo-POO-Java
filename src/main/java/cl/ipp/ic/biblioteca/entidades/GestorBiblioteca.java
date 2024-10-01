package cl.ipp.ic.biblioteca.entidades;

import cl.ipp.ic.biblioteca.excepciones.LibroNoEncontradoExcepcion;
import cl.ipp.ic.biblioteca.excepciones.LibroYaExistenteExcepciones;
import java.util.HashMap;
import java.util.Map;

public class GestorBiblioteca {
    private Map<String, Libros> libros;

    public GestorBiblioteca() {
        libros = new HashMap<>();
    }

    public void agregarLibro(Libros libro) throws LibroYaExistenteExcepciones {
        if (libros.containsKey(libro.getIsbn())) {
            throw new LibroYaExistenteExcepciones("El libro con ISBN " + libro.getIsbn() + " ya existe.");
        }
        libros.put(libro.getIsbn(), libro);
    }

    public void eliminarLibro(String isbn) throws LibroNoEncontradoExcepcion {
        if (!libros.containsKey(isbn)) {
            throw new LibroNoEncontradoExcepcion("El libro con ISBN " + isbn + " no fue encontrado.");
        } else
            System.out.println("El libro con ISBN " + isbn + " fue eliminado.");
        libros.remove(isbn);
    }

    public Libros buscarLibro(String isbn) throws LibroNoEncontradoExcepcion {
        Libros libro = libros.get(isbn);
        if (libro == null) {
            throw new LibroNoEncontradoExcepcion("El libro con ISBN " + isbn + " no fue encontrado.");
        }
        return libro;
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            libros.values().forEach(System.out::println);
        }
    }
}
