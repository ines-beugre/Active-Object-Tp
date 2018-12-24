package generator;

import observer.ObserverGeneratorAsync;
import observer.SubjectAsync;

import java.util.List;

public interface Generator extends SubjectAsync<Generator> {
    Integer getValue();
    void generateValue();
    List<ObserverGeneratorAsync<Generator>> getObserversAsync();
}
