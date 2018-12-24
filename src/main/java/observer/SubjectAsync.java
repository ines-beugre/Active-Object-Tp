package observer;

public interface SubjectAsync<T> {

    void attach(ObserverGeneratorAsync<T> observerGeneratorAsync);
    void detach(ObserverGeneratorAsync<T> observerGeneratorAsync);
    void notifyObservers();
}
