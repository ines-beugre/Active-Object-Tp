package observer;

public interface Subject<T> {

    void attach(ObserverGenerator<T> observerGenerator);
    void detach(ObserverGenerator<T> observerGenerator);
    void notifyObservers();
}
