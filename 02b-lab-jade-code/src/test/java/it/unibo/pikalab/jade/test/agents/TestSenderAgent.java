package it.unibo.pikalab.jade.test.agents;

import it.unibo.pikalab.jade.Performative;
import it.unibo.pikalab.jade.test.TestingAgent;
import it.unibo.pikalab.jade.Behaviours;
import it.unibo.pikalab.jade.Messages;
import jade.core.behaviours.Behaviour;

import static it.unibo.pikalab.jade.Behaviours.*;

public class TestSenderAgent extends TestingAgent {

    public static final String CONTENT = "message";
    public static final String PREFERRED_NAME = "testSenderAgent";

    @Override
    public Behaviour mainBehaviour() {
        return Behaviours.sequence(
                sendMessage(Performative.INFORM, CONTENT, Messages.localAID(TestReceiverAgent.PREFERRED_NAME)),
                Behaviours.atomic(() -> log("Sent `%s` to %s", CONTENT, TestReceiverAgent.PREFERRED_NAME)),
                Behaviours.stop()
        );
    }
}
