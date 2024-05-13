package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

// Interfaz para los observadores
interface Observer {
    void update(String message);
}

// Clase concreta que actúa como sujeto observable
class Library {
    private List<Observer> subscribers = new ArrayList<>();
    private String latestRelease;

    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    public void setLatestRelease(String release) {
        this.latestRelease = release;
        notifySubscribers();
    }

    private void notifySubscribers() {
        for (Observer observer : subscribers) {
            observer.update("¡Nuevo lanzamiento disponible: " + latestRelease + "!");
        }
    }
}

// Clase concreta que implementa Observer
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + ": " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        User user1 = new User("Roberto");
        User user2 = new User("Rubén");

        library.subscribe(user1);
        library.subscribe(user2);

        library.setLatestRelease("Nuevo libro, revista o periódico disponible");

    }
}
