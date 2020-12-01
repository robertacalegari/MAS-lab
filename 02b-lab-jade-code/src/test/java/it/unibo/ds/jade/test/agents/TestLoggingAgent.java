package it.unibo.ds.jade.test.agents;

import it.unibo.ds.jade.test.TestingAgent;
import jade.core.behaviours.Behaviour;

import static it.unibo.ds.jade.Behaviours.*;

public class TestLoggingAgent extends TestingAgent {
    @Override
    public Behaviour mainBehaviour() {
        return sequence(
                atomic(() -> log("hello")),
                stop()
        );
    }
}
