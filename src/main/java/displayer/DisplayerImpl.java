package displayer;

import generator.GeneratorAsync;

import java.util.concurrent.ExecutionException;

/**
 *  Represents the client in Active Object Pattern.
 *  It retrieves value from Channel and displays this value
 *  It considers Channel as Generator
 * */
public class DisplayerImpl implements Displayer{

    public DisplayerImpl(){

    }

    //
    @Override
    public void update(GeneratorAsync subject) {
    try {
        String value = subject.getValue().get().toString();
        System.out.println("Valeur de l'Afficheur: " + value);
    } catch (InterruptedException e) {
        e.printStackTrace();
    } catch (ExecutionException e) {
        e.printStackTrace();
    }
}

}
