package strategy;

import generator.Generator;

/**
 * Represents Coherence Model. It is the values display strategy
 * in order to have coherence of values between generator and all observers
 */
public interface DiffusionStrategy {

    /**
     * Configures the strategy with the generator
     * @param generator instance used in strategy
     */
    void configure(Generator generator);

    /**
     * Executes the strategy
     */
    void run();

}
