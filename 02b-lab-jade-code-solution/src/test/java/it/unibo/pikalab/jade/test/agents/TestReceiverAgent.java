package it.unibo.pikalab.jade.test.agents;

import it.unibo.pikalab.jade.test.TestingAgent;
import jade.core.behaviours.Behaviour;

import static it.unibo.pikalab.jade.Behaviours.*;

public class TestReceiverAgent extends TestingAgent {

    public static final String PREFERRED_NAME = "testReceiverAgent";

    @Override
    public Behaviour mainBehaviour() {
        return sequence(
                receiveMessage(msg -> log("Received `%s` from %s", msg.getContent(), msg.getSender().getLocalName())),
                stop()
        );
    }
}
