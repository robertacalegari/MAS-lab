package it.unibo.ds.jade.test.agents;

import it.unibo.ds.jade.test.TestingAgent;
import jade.core.behaviours.Behaviour;

import static it.unibo.ds.jade.Behaviours.*;

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
