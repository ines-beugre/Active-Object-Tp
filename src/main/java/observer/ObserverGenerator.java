package observer;

import generator.GeneratorAsync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * Represents synchronous Generic Observer in Observer Design Pattern
 * @param <T> that is a generic type
 */
public interface ObserverGenerator<T> {

    void update(GeneratorAsync generatorAsync) throws ExecutionException, InterruptedException;

}
