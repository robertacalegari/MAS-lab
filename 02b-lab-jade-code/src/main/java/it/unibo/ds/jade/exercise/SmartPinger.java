package it.unibo.ds.jade.exercise;

import it.unibo.ds.jade.impl.Send;
import jade.core.Agent;

public class SmartPinger extends Agent {
    @Override
    protected void setup() {
        throw new Error("not implemented");
    }

    private void log(final String format, Object... args) {
        System.out.println("[" + getAID().getLocalName() + "]: " + String.format(format, args));
    }
}
