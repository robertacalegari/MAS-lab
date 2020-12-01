package it.unibo.pikalab.jade.test.agents;

import it.unibo.pikalab.jade.test.TestingAgent;
import jade.core.behaviours.Behaviour;

import static it.unibo.pikalab.jade.Behaviours.*;

public class TestLoggingAgent extends TestingAgent {
    @Override
    public Behaviour mainBehaviour() {
        return sequence(
                atomic(() -> log("hello")),
                stop()
        );
    }
}
