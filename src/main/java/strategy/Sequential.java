package strategy;

import generator.Generator;
import observer.ObserverGeneratorAsync;

public class Sequential implements DiffusionStrategy {

    private Generator generator;

    @Override
    public void configure(Generator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        this.generator.generateValue();
        for(ObserverGeneratorAsync<Generator> observerAsync:this.generator.getObserversAsync()) {
            observerAsync.update(this.generator);
        }
    }
}
