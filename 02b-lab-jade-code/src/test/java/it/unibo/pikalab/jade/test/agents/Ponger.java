package it.unibo.pikalab.jade.test.agents;

import it.unibo.pikalab.jade.Performative;
import it.unibo.pikalab.jade.test.TestingAgent;
import it.unibo.pikalab.jade.Behaviours;
import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.MessageTemplate;

import static it.unibo.pikalab.jade.Behaviours.*;
import static jade.lang.acl.MessageTemplate.MatchPerformative;

public class Ponger extends TestingAgent {

    public static final int ROUNDS = 10;

    private int round = 0;

    private MessageTemplate pingMessageTemplate() {
        return MatchPerformative(Performative.INFORM.getJadeValue());
    }

    @Override
    public Behaviour mainBehaviour() {
        return Behaviours.listen(
                pingMessageTemplate(),
                msg -> {
                    log("Received `%s` from %s", msg.getContent(), msg.getSender().getLocalName());
                    addBehaviour(sendPong(msg.getSender()));
                }
        );
    }

    private Behaviour sendPong(AID receiver) {
        return round++ < ROUNDS ? Behaviours.sequence(
                sendMessage(Performative.INFORM, "pong", receiver),
                Behaviours.atomic(() -> log("Sent `pong` to %s", receiver.getLocalName()))
        ) : Behaviours.stop();
    }
}
