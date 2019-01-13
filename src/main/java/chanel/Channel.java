package chanel;

import generator.Generator;
import generator.GeneratorAsync;
import observer.ObserverGenerator;
import observer.ObserverGeneratorAsync;
import observer.Subject;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Channel,implemented in order to transmit values, from Generator, to Displayer
 * Channel reprensents the Proxy in Active Object design pattern It had two
 * roles: From Displayer to Generator , channel represents GeneratorAsyn that is
 * a proxy of Generator; ie Displayer sees Channel as a Generator *
 *
 * From Generator to Displayer, channel represents Subject that get value
 *
 */
public class Channel implements ObserverGeneratorAsync<Generator>, GeneratorAsync, Subject<GeneratorAsync> {

    ScheduledExecutorService scheduled;
    Generator generator;
    ObserverGenerator<GeneratorAsync> observerGeneratorChannel;
    private int delay;

    public Channel(Generator generator, int delay) {
        this.generator = generator;
        this.delay = delay;
    }

    public void setScheduled(ScheduledExecutorService scheduled) {
        this.scheduled = scheduled;
    }

    /**
     * Get result of GetValue from GeneratorAsync in order to return and to display
     * a Future
     * 
     * @return Future of Integer of GetValue Method Invocation
     */
    public Future<Integer> getValue() {
        GetValue getValue = new GetValue(this.generator);
        return this.scheduled.schedule(getValue, this.delay, TimeUnit.MILLISECONDS);
    }

    /**
     * Get result of Update
     * 
     * @param g: the generator which notify its observers
     * @return Future of Void of Update Method Invocation
     */
    public Future<Void> update(Generator g) {
        // Update update = new Update(this.generator);
        Update update = new Update(this, this.observerGeneratorChannel);
        return this.scheduled.schedule(update, this.delay, TimeUnit.MILLISECONDS);
    }

    /**
     * Attach channel's observers: Displayer which will display value from Generator
     * 
     * @param observerGenerator
     *
     */
    public void attach(ObserverGenerator<GeneratorAsync> observerGenerator) {
        this.observerGeneratorChannel = observerGenerator;
    }

    /**
     * Detach channel's observers: Displayer
     * 
     * @param observerGenerator
     *
     */
    public void detach(ObserverGenerator<GeneratorAsync> observerGenerator) {
        this.observerGeneratorChannel = null;
    }

    public void notifyObservers() {

    }

    /**
     * Gets the value of delay attribute
     * 
     * @return value of delay attribute
     */
    public int getDelay() {
        return delay;
    }

    /**
     * Sets delay attribute
     * 
     * @param delay value set to delay attribute
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }
}
