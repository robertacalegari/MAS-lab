package it.unibo.pikalab.jade.test.agents;

import it.unibo.pikalab.jade.Performative;
import it.unibo.pikalab.jade.test.TestingAgent;
import jade.core.behaviours.Behaviour;

import static it.unibo.pikalab.jade.Behaviours.*;
import static it.unibo.pikalab.jade.Messages.localAID;

public class TestSenderAgent extends TestingAgent {

    public static final String CONTENT = "message";
    public static final String PREFERRED_NAME = "testSenderAgent";

    @Override
    public Behaviour mainBehaviour() {
        return sequence(
                sendMessage(Performative.INFORM, CONTENT, localAID(TestReceiverAgent.PREFERRED_NAME)),
                atomic(() -> log("Sent `%s` to %s", CONTENT, TestReceiverAgent.PREFERRED_NAME)),
                stop()
        );
    }
}
