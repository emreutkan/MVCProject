import java.util.ArrayList;
import java.util.List;

public interface Subject {
    List<Observer> observers = new ArrayList<>();

    default void addObserver(Observer o) {
        observers.add(o);
    }

    default void removeObserver(Observer o) {
        observers.remove(o);
    }

    void notifyObservers();
}
