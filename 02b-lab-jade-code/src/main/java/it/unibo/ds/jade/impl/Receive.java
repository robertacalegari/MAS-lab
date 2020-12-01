package it.unibo.ds.jade.impl;

import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.Objects;

public class Receive extends SimpleBehaviour {

    private final MessageTemplate template;
    private ACLMessage message;

    public Receive(MessageTemplate template) {
        this.template = Objects.requireNonNull(template);
    }

    @Override
    public void action() {
        throw new Error("not implemented");
    }

    public void onMessageReceived(ACLMessage message) { /* to be overridden */ }

    @Override
    public boolean done() {
        throw new Error("not implemented");
    }

    @Override
    public void handleRestartEvent() {
        super.handleRestartEvent();
        throw new Error("not implemented");
    }
}
