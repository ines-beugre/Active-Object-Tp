package generator;

import java.util.concurrent.Future;

/**
 * Represents a proxy to Generator that Displayer can handle
 * */
public interface GeneratorAsync {

    Future<Integer> getValue();
}
