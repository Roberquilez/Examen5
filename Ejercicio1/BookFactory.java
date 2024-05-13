package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

// Clase base para los medios digitales
class Media {
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

// Implementación concreta para libros
class Book extends Media {
    public Book(String title, String author) {
        super(title, author);
    }
}

// Implementación concreta para revistas
class Magazine extends Media {
    public Magazine(String title, String author) {
        super(title, author);
    }
}

// Implementación concreta para periódicos
class Newspaper extends Media {
    public Newspaper(String title, String author) {
        super(title, author);
    }
}

// Clase para construir medios digitales
class MediaBuilder {
    private String title;
    private String author;
    private String genre;
    private String publicationDate;

    public MediaBuilder(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public MediaBuilder setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public MediaBuilder setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public Media build() {
        // Construir el objeto Ejercicio1.Media con las propiedades configuradas
        Media media = new Media(title, author);
        // Configurar propiedades adicionales (género, fecha, etc.)
        // media.setGenre(genre);
        // media.setPublicationDate(publicationDate);
        return media;
    }
}

// Interfaz para las estrategias de búsqueda y clasificación
interface SearchStrategy {
    List<Media> search(List<Media> mediaList, String query);
}

// Implementación concreta para búsqueda por título
class TitleSearchStrategy implements SearchStrategy {
    @Override
    public List<Media> search(List<Media> mediaList, String query) {
        List<Media> filteredMediaList = new ArrayList<>();
        for (Media media : mediaList) {
            if (media.getTitle().equalsIgnoreCase(query)) {
                filteredMediaList.add(media);
            }
        }
        return filteredMediaList;
    }

    // Interfaz para la fábrica de medios digitales
    static interface MediaFactory {
        Media createMedia();
    }
}
