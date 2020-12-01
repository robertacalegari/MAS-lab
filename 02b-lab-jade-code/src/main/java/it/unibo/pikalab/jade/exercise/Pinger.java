package it.unibo.pikalab.jade.exercise;

import jade.core.Agent;

public class Pinger extends Agent {
    @Override
    protected void setup() {
        throw new Error("not implemented");
    }

    private void log(final String format, Object... args) {
        System.out.println("[" + getAID().getLocalName() + "]: " + String.format(format, args));
    }
}
