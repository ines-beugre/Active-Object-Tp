package strategy;

import generator.Generator;

public interface DiffusionStrategy {

    void configure(Generator generator);

    void run();

}
