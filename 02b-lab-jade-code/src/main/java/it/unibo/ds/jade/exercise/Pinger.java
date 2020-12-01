package it.unibo.ds.jade.exercise;

import it.unibo.ds.jade.Performative;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.MessageTemplate;

import static it.unibo.ds.jade.Behaviours.*;
import static it.unibo.ds.jade.Messages.localAID;

public class Pinger extends Agent {
    @Override
    protected void setup() {
        throw new Error("not implemented");
    }

    private void log(final String format, Object... args) {
        System.out.println("[" + getAID().getLocalName() + "]: " + String.format(format, args));
    }
}
