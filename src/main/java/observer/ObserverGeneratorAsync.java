package observer;

import generator.Generator;
import java.util.concurrent.Future;

/**
 * Represents asynchronous Generic Observer in Observer Design Pattern
 * @param <T> is a Generic Type
 */
public interface ObserverGeneratorAsync<T> {

    Future<Void> update(Generator g);

}
