package it.unibo.pikalab.jade.test.agents;

import it.unibo.pikalab.jade.test.TestingAgent;
import it.unibo.pikalab.jade.Behaviours;
import jade.core.behaviours.Behaviour;

public class TestSequentialAgent extends TestingAgent {
    @Override
    public Behaviour mainBehaviour() {
        return Behaviours.sequence(
                Behaviours.atomic(() -> log("a")),
                Behaviours.atomic(() -> log("b")),
                Behaviours.atomic(() -> log("c")),
                Behaviours.stop()
        );
    }
}
