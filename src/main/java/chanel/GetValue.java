package chanel;

import generator.Generator;
import generator.GeneratorImpl;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

public class GetValue implements Callable<Integer> {

    ScheduledExecutorService scheduled;
    private Generator generator;

    public GetValue(Generator generator) {
        this.generator = generator;
    }

    private Integer getValue(){
        return this.generator.getValue();
    }

    public Integer call() throws Exception {
        return getValue();
    }
}

