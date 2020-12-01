package it.unibo.pikalab.jade.test.agents;

import it.unibo.pikalab.jade.Performative;
import it.unibo.pikalab.jade.test.TestingAgent;
import it.unibo.pikalab.jade.Behaviours;
import it.unibo.pikalab.jade.Messages;
import jade.core.behaviours.Behaviour;

public class TestMultipleSenderAgent extends TestingAgent {

    public static final String PREFERRED_NAME = "testMultipleSenderAgent";

    private int i = 0;

    @Override
    public Behaviour mainBehaviour() {
        return Behaviours.sequence(
                Behaviours.repeatWhile(
                        Behaviours.sequence(
                                Behaviours.sendMessage(Performative.INFORM, () -> String.valueOf(i), Messages.localAID(TestMultipleReceiverAgent.PREFERRED_NAME)),
                                Behaviours.atomic(() -> log("Sent `%s` to %s", String.valueOf(i), TestMultipleReceiverAgent.PREFERRED_NAME)),
                                Behaviours.atomic(() -> i++)
                        ),
                        () -> i < 10
                ),
                Behaviours.stop()
        );
    }
}
