package Ejercicio4;


import java.util.ArrayList;
import java.util.List;

interface ElementoMultimedia {
    void mostrarDetalles();
}

// Medio.java
class Medio implements ElementoMultimedia {
    private String titulo;
    private String autor;

    public Medio(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
    }
}

// Coleccion.java
class Coleccion implements ElementoMultimedia {
    private String nombre;
    private List<ElementoMultimedia> elementos = new ArrayList<>();

    public Coleccion(String nombre) {
        this.nombre = nombre;
    }

    public void agregarElemento(ElementoMultimedia elemento) {
        elementos.add(elemento);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Colección: " + nombre);
        for (ElementoMultimedia elemento : elementos) {
            elemento.mostrarDetalles();
        }
    }
}


class BibliotecaModel {
}

// Vista (interfaz gráfica)
class BibliotecaView {
}

// Controlador (interacción del usuario)
class BibliotecaController {
}

public class BibliotecaApp {
    public static void main(String[] args) {
        // Ejemplo de uso
        Medio libro1 = new Medio("Cien años de soledad", "Gabriel García Márquez");
        Medio libro2 = new Medio("1984", "George Orwell");

        Coleccion coleccionLibros = new Coleccion("Novelas");
        coleccionLibros.agregarElemento(libro1);
        coleccionLibros.agregarElemento(libro2);

        coleccionLibros.mostrarDetalles();
    }
}
