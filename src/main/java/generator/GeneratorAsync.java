package generator;

import java.util.concurrent.Future;

public interface GeneratorAsync {

    Future<Integer> getValue();
}
