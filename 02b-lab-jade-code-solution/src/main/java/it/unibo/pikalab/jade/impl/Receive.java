package it.unibo.pikalab.jade.impl;

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
        message = getAgent().receive(template);
        if (message == null) {
            block();
        } else {
            onMessageReceived(message);
        }
    }

    public void onMessageReceived(ACLMessage message) { /* to be overridden */ }

    @Override
    public boolean done() {
        return message != null;
    }

    @Override
    public void handleRestartEvent() {
        super.handleRestartEvent();
        message = null;
    }
}
