package generator;

import observer.ObserverGeneratorAsync;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents Generator in Active Object design pattern
 * It generates random values
 * */
public class GeneratorImpl implements Generator{

    private List<ObserverGeneratorAsync<Generator>> observers = new ArrayList<ObserverGeneratorAsync<Generator>>();
    private Integer value;

    public Integer getValue() {
        return this.value;
    }

    public List<ObserverGeneratorAsync<Generator>> getObserversAsync() {
        return this.observers;
    }

    public void attach(ObserverGeneratorAsync<Generator> observerGeneratorAsync) {
        this.observers.add(observerGeneratorAsync);
    }

    public void detach(ObserverGeneratorAsync<Generator> observerGeneratorAsync) {
        this.observers.remove(observerGeneratorAsync);
    }

    public void notifyObservers() {
        //cette methode est inclue dans les stratégies
//        for (int i = 0; i < observers.size() ; i ++) {
//            observers.get(i).update(this);
//        }
    }

    /**
     * Permits to Generator to generate values randomly
     * */
    public void generateValue() {
        Random random = new Random();
        this.value = random.nextInt(100);
        System.out.println(" ");
        System.out.println("Valeur du Generateur: " + this.value);
        this.notifyObservers();
    }
}
