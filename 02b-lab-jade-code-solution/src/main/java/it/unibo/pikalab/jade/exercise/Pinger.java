package it.unibo.pikalab.jade.exercise;

import it.unibo.pikalab.jade.Performative;
import it.unibo.pikalab.jade.Messages;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.MessageTemplate;

import static it.unibo.pikalab.jade.Behaviours.*;

public class Pinger extends Agent {
    @Override
    protected void setup() {
        addBehaviour(sendPing());
        addBehaviour(listenForPong());
    }

    private MessageTemplate pongMessageTemplate() {
        return MessageTemplate.and(
                MessageTemplate.MatchPerformative(Performative.INFORM.getJadeValue()),
                MessageTemplate.MatchSender(Messages.localAID("ponger"))
        );
    }

    private Behaviour sendPing() {
        return sequence(
                sendMessage(Performative.INFORM, "ping", Messages.localAID("ponger")),
                atomic(() -> log("Sent `ping` to ponger"))
        );
    }

    private Behaviour listenForPong() {
        return listen(
                pongMessageTemplate(),
                msg -> {
                    log("Received `%s` from %s", msg.getContent(), msg.getSender().getLocalName());
                    addBehaviour(sendPing());
                }
        );
    }

    private void log(final String format, Object... args) {
        System.out.println("[" + getAID().getLocalName() + "]: " + String.format(format, args));
    }
}
