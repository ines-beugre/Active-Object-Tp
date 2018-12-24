package observer;

import generator.Generator;
import generator.GeneratorImpl;

import java.util.concurrent.Future;

public interface ObserverGeneratorAsync<T> {

    Future<Void> update(Generator g);
    void setDisplayer(ObserverGenerator displayer);

}
