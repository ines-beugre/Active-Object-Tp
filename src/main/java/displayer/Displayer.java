package displayer;

import generator.GeneratorAsync;
import observer.ObserverGenerator;

public interface Displayer extends ObserverGenerator<GeneratorAsync> {

    void update(GeneratorAsync subject);
}
