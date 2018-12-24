package generator;

import chanel.Channel;
import observer.ObserverGeneratorAsync;
import observer.SubjectAsync;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorImpl implements Generator{

    private List<ObserverGeneratorAsync<Generator>> observers = new ArrayList<ObserverGeneratorAsync<Generator>>();
    private Integer value;

//    public void Update() throws ExecutionException, InterruptedException {
//        for(int i = 0; i < channels.size(); i++){
//            futures.set(i, channels.get(i).update(this));
//        }
//
//        for(int i = 0; i < futures.size(); i++){
//            futures.get(i).get();
//        }
//    }

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

    public void generateValue() {
        Random random = new Random();
        this.value = random.nextInt(100);
        System.out.println(this.value);
        this.notifyObservers();
    }
}
