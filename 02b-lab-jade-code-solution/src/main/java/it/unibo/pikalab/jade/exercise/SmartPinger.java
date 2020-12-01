package it.unibo.pikalab.jade.exercise;

import jade.core.Agent;

public class SmartPinger extends Agent {
    @Override
    protected void setup() {

    }

    private void log(final String format, Object... args) {
        System.out.println("[" + getAID().getLocalName() + "]: " + String.format(format, args));
    }
}
