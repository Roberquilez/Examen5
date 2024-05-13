package Ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase base para los medios digitales
abstract class Media {
    private String title;
    private String author;

    public Media(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

// Implementación para los libros
class Book extends Media {
    public Book(String title, String author) {
        super(title, author);
    }
}

// Implementación para las revistas
class Magazine extends Media {
    public Magazine(String title, String author) {
        super(title, author);
    }
}

// Implementación para los periódicos
class Newspaper extends Media {
    public Newspaper(String title, String author) {
        super(title, author);
    }
}

// Implementación para las colecciones de medios
class MediaCollection extends Media {
    private List<Media> mediaList = new ArrayList<>();

    public MediaCollection(String title, String author) {
        super(title, author);
    }

    public void addMedia(Media media) {
        mediaList.add(media);
    }

    public void displayInfo() {
        System.out.println("Colección: " + getTitle() + " (Autor: " + getAuthor() + ")");
        for (Media media : mediaList) {
            System.out.println("- " + media.getTitle());
        }
    }
}

public class BibliotecaDigital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MediaCollection library = new MediaCollection("Biblioteca Digital", "Equipo de Desarrollo");

        while (true) {
            System.out.println("1. Agregar libro");
            System.out.println("2. Agregar revista");
            System.out.println("3. Agregar periódico");
            System.out.println("4. Mostrar colección");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Título del libro: ");
                    String bookTitle = scanner.nextLine();
                    library.addMedia(new Book(bookTitle, "Autor Desconocido"));
                    break;
                case 2:
                    System.out.print("Título de la revista: ");
                    String magazineTitle = scanner.nextLine();
                    library.addMedia(new Magazine(magazineTitle, "Editorial XYZ"));
                    break;
                case 3:
                    System.out.print("Título del periódico: ");
                    String newspaperTitle = scanner.nextLine();
                    library.addMedia(new Newspaper(newspaperTitle, "Diario ABC"));
                    break;
                case 4:
                    library.displayInfo();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }
}
