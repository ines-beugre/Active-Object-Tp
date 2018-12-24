package observer;

import generator.GeneratorAsync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface ObserverGenerator<T> {
    void update(GeneratorAsync generatorAsync) throws ExecutionException, InterruptedException;

//        void update(T generatorAsync);

}
