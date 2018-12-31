package chanel;

import generator.Generator;
import generator.GeneratorImpl;
import generator.GeneratorAsync;
import observer.ObserverGenerator;
import observer.SubjectAsync;

import java.util.concurrent.Callable;

/**
 * Represent Method Invocation Update method of Generator
 *
 * */
public class Update implements Callable<Void> {

    private GeneratorAsync generatorAsync;
    private ObserverGenerator<GeneratorAsync> observer;

    public Update(SubjectAsync<Generator> generatorSubjectAsync){

    }


    public Update(GeneratorAsync g, ObserverGenerator<GeneratorAsync> observer){
        this.generatorAsync = g;
        this.observer = observer;
    }

    /**
     * Update the displayer with new value of Generator Asynchrone reprensented by Channel
     *
     * */
    public Void call() throws Exception {
        this.observer.update(this.generatorAsync);
        return null;
    }
}
