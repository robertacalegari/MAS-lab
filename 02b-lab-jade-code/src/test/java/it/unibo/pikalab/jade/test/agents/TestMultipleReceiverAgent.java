package it.unibo.pikalab.jade.test.agents;

import it.unibo.pikalab.jade.test.TestingAgent;
import it.unibo.pikalab.jade.Behaviours;
import it.unibo.pikalab.jade.Messages;
import jade.core.behaviours.Behaviour;

import static it.unibo.pikalab.jade.Performative.INFORM;
import static jade.lang.acl.MessageTemplate.*;

public class TestMultipleReceiverAgent extends TestingAgent {

    public static final String PREFERRED_NAME = "testMultipleReceiverAgent";

    @Override
    public Behaviour mainBehaviour() {
        return Behaviours.sequence(
                Behaviours.listen(
                        and(
                                MatchPerformative(INFORM.getJadeValue()),
                                MatchReceiver(Messages.localAIDs(PREFERRED_NAME))
                        ),
                        msg -> {
                            log("Received `%s` from %s", msg.getContent(), msg.getSender().getLocalName());
                            var i = Integer.parseInt(msg.getContent());
                            if (i >= 10) {
                                addBehaviour(Behaviours.stop());
                            }
                        }
                ),
                Behaviours.stop()
        );
    }
}
