package it.unibo.ds.jade.test.agents;

import it.unibo.ds.jade.test.TestingAgent;
import jade.core.behaviours.Behaviour;

import static it.unibo.ds.jade.Behaviours.*;

public class TestSequentialAgent extends TestingAgent {
    @Override
    public Behaviour mainBehaviour() {
        return sequence(
                atomic(() -> log("a")),
                atomic(() -> log("b")),
                atomic(() -> log("c")),
                stop()
        );
    }
}
