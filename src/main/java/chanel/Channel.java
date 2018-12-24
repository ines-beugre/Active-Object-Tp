package chanel;

import generator.Generator;
import generator.GeneratorImpl;
import generator.GeneratorAsync;
import observer.ObserverGenerator;
import observer.ObserverGeneratorAsync;
import observer.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Channel implements ObserverGeneratorAsync<Generator>, GeneratorAsync, Subject<GeneratorAsync> {

    ScheduledExecutorService scheduled;
    Generator generator;
    //liste des observateurs du chanel => displayer
   ObserverGenerator<GeneratorAsync> observerGeneratorChannel;
    int delay;

    public Channel(Generator generator, int delay) {
        this.generator = generator;
        this.delay = delay;
    }

    public void setScheduled(ScheduledExecutorService scheduled) {
        this.scheduled = scheduled;
    }

    public Future<Integer> getValue() {
        GetValue getValue = new GetValue(this.generator);
        return this.scheduled.schedule(getValue, this.delay, TimeUnit.MILLISECONDS);
    }

    public Future<Void> update(Generator g) {
        //Update update = new Update(this.generator);
        Update update = new Update(this, this.observerGeneratorChannel);
        return this.scheduled.schedule(update, this.delay, TimeUnit.MILLISECONDS);
    }


    public void setDisplayer(ObserverGenerator displayer) {
    }

    public void attach(ObserverGenerator<GeneratorAsync> observerGenerator) {
        this.observerGeneratorChannel = observerGenerator;

    }

    public void detach(ObserverGenerator<GeneratorAsync> observerGenerator) {
        this.observerGeneratorChannel =null;
    }

    public void notifyObservers() {

    }
}
