package observer;

/**
 * Represents synchronous Generic Subject in Observer Pattern
 * @param <T> generic Type
 */
public interface Subject<T> {

    void attach(ObserverGenerator<T> observerGenerator);
    void detach(ObserverGenerator<T> observerGenerator);
    void notifyObservers();
}
