package Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaDigital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Media> listaMedios = new ArrayList<>();

        while (true) {
            System.out.println("1. Agregar libro");
            System.out.println("2. Agregar revista");
            System.out.println("3. Agregar periódico");
            System.out.println("4. Buscar medio por título");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea vacía

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el título del libro: ");
                    String tituloLibro = scanner.nextLine();
                    System.out.print("Introduce el autor del libro: ");
                    String autorLibro = scanner.nextLine();
                    listaMedios.add(new Book(tituloLibro, autorLibro));
                    System.out.println("Libro agregado correctamente.");
                    break;
                case 2:
                    // Agregar revista (similar al caso 1)
                    break;
                case 3:
                    // Agregar periódico (similar al caso 1)
                    break;
                case 4:
                    System.out.print("Introduce el título a buscar: ");
                    String tituloBusqueda = scanner.nextLine();
                    buscarMedioPorTitulo(listaMedios, tituloBusqueda);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }

    private static void buscarMedioPorTitulo(List<Media> listaMedios, String tituloBusqueda) {
        SearchStrategy searchStrategy = new TitleSearchStrategy();
        List<Media> filteredMedia = searchStrategy.search(listaMedios, tituloBusqueda);
        if (filteredMedia.isEmpty()) {
            System.out.println("No se encontraron medios con ese título.");
        } else {
            System.out.println("Medios encontrados:");
            for (Media media : filteredMedia) {
                System.out.println("Título");
            }
        }
    }
}