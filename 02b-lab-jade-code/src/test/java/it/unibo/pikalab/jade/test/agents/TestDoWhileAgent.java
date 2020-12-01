package it.unibo.pikalab.jade.test.agents;

import it.unibo.pikalab.jade.test.TestingAgent;
import it.unibo.pikalab.jade.Behaviours;
import jade.core.behaviours.Behaviour;

public class TestDoWhileAgent extends TestingAgent {

    private int i = 0;

    @Override
    public Behaviour mainBehaviour() {
        return Behaviours.sequence(
                Behaviours.repeatWhile(
                        Behaviours.sequence(
                                Behaviours.atomic(() -> log("%d", i)),
                                Behaviours.atomic(() -> log("%d", 2 * i)),
                                Behaviours.atomic(() -> i++)
                        ),
                        () -> i < 10
                ),
                Behaviours.stop()
        );
    }
}
