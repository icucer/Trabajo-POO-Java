package cl.ipp.ic.figuras;

import cl.ipp.ic.biblioteca.entidades.GestorBiblioteca;
import cl.ipp.ic.biblioteca.entidades.Libros;
import cl.ipp.ic.biblioteca.excepciones.LibroNoEncontradoExcepcion;
import cl.ipp.ic.biblioteca.excepciones.LibroYaExistenteExcepciones;
import cl.ipp.ic.figuras.entidades.Figuras;
import cl.ipp.ic.figuras.entidades.Circulos;
import cl.ipp.ic.figuras.entidades.Rectangulos;
import cl.ipp.ic.figuras.interfazes.I_Figuras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        // Crear el Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Mostramos el menú de opciones
        System.out.println("\nSeleccione una opción:");
        System.out.println("1. Trabajo Nr° 3");
        System.out.println("2. Trabajo Nr° 4");

        // Leer la opción seleccionada
        System.out.print("\nIngrese su opción: ");
        int opcion = scanner.nextInt();

        // Utilizar un switch para procesar la opción
        switch (opcion) {
            case 1:
                // Crear un arreglo de figuras
                Figuras[] figuras = new Figuras[2];
                figuras[0] = new Circulos(7);  // Radio de 7
                figuras[1] = new Rectangulos(5, 8);  // Ancho de 5 y largo de 8

                // Iterar sobre el arreglo y demostrar polimorfismo
                for (Figuras figura : figuras) {
                    System.out.println("\n***********" + figura.getClass().getSimpleName() + "***********");
                    System.out.println("Área: " + figura.area());
                    System.out.println("Perímetro: " + figura.perimetro());

                    // Pintar la figura
                    ((I_Figuras) figura).pintar();
                }

                // Crear una lista de figuras
                List<Figuras> listaFiguras = new ArrayList<>();
                Circulos circulo = new Circulos(3);  // Radio de 3
                Rectangulos rectangulo = new Rectangulos(7, 10);  // Ancho de 7 y largo de 10

                listaFiguras.add(circulo);
                listaFiguras.add(rectangulo);

                // Iterar sobre el arreglo y demostrar polimorfismo
                for (Figuras figura : listaFiguras) {
                    System.out.println("\n***********" + figura.getClass().getSimpleName() + "***********");
                    System.out.println("Área: " + figura.area());
                    System.out.println("Perímetro: " + figura.perimetro());

                    // Pintar la figura
                    ((I_Figuras) figura).pintar();
                }
                break;
            case 2:
                // Crear un gestor de biblioteca
                GestorBiblioteca gestor = new GestorBiblioteca();

                boolean errorOcurrido = false;

                try {
                    System.out.println("\n********** Agregar y listar libros *************");
                    // Agregar libros
                    gestor.agregarLibro(new Libros("123456789", "El Quijote", "Miguel de Cervantes"));
                    gestor.agregarLibro(new Libros("987654321", "1984", "George Orwell"));

                    // Listar libros
                    System.out.println("Libros en la biblioteca:");
                    gestor.listarLibros();

                    // Buscar un libro
                    System.out.println("\n********** Buscar libro con ISBN 123456789: *************");
                    System.out.println(gestor.buscarLibro("123456789"));

                    // Eliminar un libro
                    System.out.println("\n********** Eliminar libro con ISBN 987654321: *************");
                    gestor.eliminarLibro("987654321");

                    // Intentar agregar un libro que ya existe
                    System.out.println("\n********** Agregar libro con ISBN 123456789 (ya existe): *************");
                    gestor.agregarLibro(new Libros("123456789", "El Quijote", "Miguel de Cervantes"));

                } catch (LibroYaExistenteExcepciones | LibroNoEncontradoExcepcion e) {
                    errorOcurrido = true;
                    System.err.println(e.getMessage());
                } finally {

                    if (!errorOcurrido) {
                        // Listar libros
                        System.out.println("\n***************Libros en la biblioteca:**************");
                        gestor.listarLibros();
                    } else {
                        System.out.println("Lo sentimos, algo salió mal. Regrese más tarde..");
                    }
                }
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}