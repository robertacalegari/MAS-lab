package it.unibo.pikalab.jade.test.agents;

import it.unibo.pikalab.jade.test.TestingAgent;
import it.unibo.pikalab.jade.Behaviours;
import jade.core.behaviours.Behaviour;

public class TestReceiverAgent extends TestingAgent {

    public static final String PREFERRED_NAME = "testReceiverAgent";

    @Override
    public Behaviour mainBehaviour() {
        return Behaviours.sequence(
                Behaviours.receiveMessage(msg -> log("Received `%s` from %s", msg.getContent(), msg.getSender().getLocalName())),
                Behaviours.stop()
        );
    }
}
