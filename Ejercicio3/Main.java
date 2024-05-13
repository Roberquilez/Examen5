package Ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Libro {
    private int codigo;
    private String titulo;
    private String autor;
    private EstadoLibro estado;

    public Libro(int codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = EstadoLibro.DISPONIBLE;
    }

    public void prestar() {
        this.estado = EstadoLibro.PRESTADO;
    }

    public void reservar() {
        this.estado = EstadoLibro.RESERVADO;
    }

    public void devolver() {
        this.estado = EstadoLibro.DISPONIBLE;
    }

    public EstadoLibro getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", estado=" + estado +
                '}';
    }

    public int getCodigo() {
        return 0;
    }
}

enum EstadoLibro {
    DISPONIBLE,
    PRESTADO,
    RESERVADO
}

public class Main {
    public static void main(String[] args) {
        List<Libro> listaLibros = new ArrayList<>();
        listaLibros.add(new Libro(1, "Cien años de soledad", "Gabriel García Márquez"));
        listaLibros.add(new Libro(2, "Don Quijote de la Mancha", "Miguel de Cervantes"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Lista de libros disponibles:");
        for (Libro libro : listaLibros) {
            System.out.println(libro);
        }

        System.out.print("Elige un libro por su código: ");
        int codigoElegido = scanner.nextInt();

        for (Libro libro : listaLibros) {
            if (libro.getCodigo() == codigoElegido) {
                System.out.println("Estado del libro seleccionado: " + libro.getEstado());
                break;
            }
        }
    }
}
