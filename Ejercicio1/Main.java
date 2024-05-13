package Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Media> mediaList = new ArrayList<>();

        // Solicitar entrada al usuario
        System.out.println("Bienvenido al sistema de gestión de medios digitales.");
        System.out.print("¿Cuántos medios digitales deseas agregar? ");
        int numMedia = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        // Pedir detalles para cada medio digital
        for (int i = 0; i < numMedia; i++) {
            System.out.println("\nMedio digital #" + (i + 1));
            System.out.print("Título: ");
            String title = scanner.nextLine();
            System.out.print("Autor: ");
            String author = scanner.nextLine();

            // Preguntar por el tipo de medio (libro, revista o periódico)
            System.out.print("Tipo de medio (libro, revista o periódico): ");
            String mediaType = scanner.nextLine();

            // Crear el medio digital según la elección del usuario
            Media media;
            switch (mediaType.toLowerCase()) {
                case "libro":
                    media = new Book(title, author);
                    break;
                case "revista":
                    media = new Magazine(title, author);
                    break;
                case "periódico":
                    media = new Newspaper(title, author);
                    break;
                default:
                    System.out.println("Tipo de medio no válido. Se creará como libro por defecto.");
                    media = new Book(title, author);
            }

            // Agregar el medio digital a la lista
            mediaList.add(media);
        }

        // Realizar una búsqueda por título (ejemplo)
        System.out.print("\nIntroduce el título que deseas buscar: ");
        String query = scanner.nextLine();
        SearchStrategy titleSearchStrategy = new TitleSearchStrategy();
        List<Media> filteredMediaList = titleSearchStrategy.search(mediaList, query);

        // Imprimir los resultados
        if (filteredMediaList.isEmpty()) {
            System.out.println("No se encontraron medios digitales con el título '" + query + "'.");
        } else {
            System.out.println("\nResultados de la búsqueda para '" + query + "':");
            for (Media media : filteredMediaList) {
                System.out.println("Título: " + media.getTitle() + ", Autor: " + media.getAuthor());
            }
        }
    }
}
