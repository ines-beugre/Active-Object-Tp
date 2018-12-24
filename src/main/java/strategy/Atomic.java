package strategy;

import generator.Generator;
import observer.ObserverGeneratorAsync;

import java.util.concurrent.ExecutionException;

public class Atomic implements DiffusionStrategy {

    private Generator generator;

    @Override
    public void configure(Generator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        this.generator.generateValue();
        for(ObserverGeneratorAsync<Generator> observerAsync: this.generator.getObserversAsync()){
            try {
                observerAsync.update(this.generator).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
