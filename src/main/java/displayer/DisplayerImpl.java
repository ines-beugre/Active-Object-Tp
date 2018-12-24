package displayer;

import generator.Generator;
import generator.GeneratorAsync;
import observer.ObserverGenerator;
import observer.ObserverGeneratorAsync;
import observer.SubjectAsync;

import java.util.concurrent.ExecutionException;

public class DisplayerImpl implements Displayer{


    public DisplayerImpl(){

    }

    @Override
    public void update(GeneratorAsync subject) {
    try {
        String value = subject.getValue().get().toString();
        System.out.println("Value à afficher: " + value);
    } catch (InterruptedException e) {
        e.printStackTrace();
    } catch (ExecutionException e) {
        e.printStackTrace();
    }
}

}
