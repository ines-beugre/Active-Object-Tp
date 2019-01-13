package main;

import chanel.Channel;
import displayer.DisplayerImpl;
import generator.Generator;
import generator.GeneratorImpl;
import strategy.Atomic;
import strategy.DiffusionStrategy;
import strategy.Sequential;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class mainDisplay {

    public static void main(String[] args){
        Generator generator = new GeneratorImpl();

        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(Integer.MAX_VALUE);


        Channel channel1 = new Channel(generator, 50);
        generator.attach(channel1);
        DisplayerImpl displayer1 = new DisplayerImpl();
        channel1.attach(displayer1);
        channel1.setScheduled(scheduled);

        Channel channel2 = new Channel(generator, 100);
        generator.attach(channel2);
        DisplayerImpl displayer2 = new DisplayerImpl();
        channel2.attach(displayer2);
        channel2.setScheduled(scheduled);

        Channel channel3 = new Channel(generator, 150);
        generator.attach(channel3);
        DisplayerImpl displayer3 = new DisplayerImpl();
        channel3.attach(displayer3);
        channel3.setScheduled(scheduled);

        Channel channel4 = new Channel(generator, 500);
        generator.attach(channel4);
        DisplayerImpl displayer4 = new DisplayerImpl();
        channel4.attach(displayer4);
        channel4.setScheduled(scheduled);

     //   generator.generateValue();


        //Cohérence Séquentielle
       /* System.out.println("Cohérence Séquentielle");
        DiffusionStrategy strategy = new Sequential();
        strategy.configure(generator);
        scheduled.scheduleAtFixedRate(() -> strategy.run(), 0, 1000, TimeUnit.MILLISECONDS);
*/
        //Cohérence atomique
        System.out.println("Cohérence Atomique");
        DiffusionStrategy sequential = new Atomic();
        sequential.configure(generator);
        scheduled.scheduleAtFixedRate(() -> sequential.run(), 0, 1000, TimeUnit.MILLISECONDS);



    }
}
