package observer;

/**
 * Represents asynchronous Generic Subject in Observer Pattern
 * @param <T> Generic Type
 */
public interface SubjectAsync<T> {

    void attach(ObserverGeneratorAsync<T> observerGeneratorAsync);
    void detach(ObserverGeneratorAsync<T> observerGeneratorAsync);
    void notifyObservers();
}
