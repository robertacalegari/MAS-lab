package it.unibo.pikalab.jade.test.agents;

import it.unibo.pikalab.jade.test.TestingAgent;
import jade.core.behaviours.Behaviour;

import static it.unibo.pikalab.jade.Behaviours.*;

public class TestDoWhileAgent extends TestingAgent {

    private int i = 0;

    @Override
    public Behaviour mainBehaviour() {
        return sequence(
                repeatWhile(
                        sequence(
                                atomic(() -> log("%d", i)),
                                atomic(() -> log("%d", 2 * i)),
                                atomic(() -> i++)
                        ),
                        () -> i < 10
                ),
                stop()
        );
    }
}
