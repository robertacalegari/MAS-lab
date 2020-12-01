package it.unibo.pikalab.jade.impl;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.Objects;

public class Listen extends CyclicBehaviour {

    private final MessageTemplate template;

    public Listen(MessageTemplate template) {
        this.template = Objects.requireNonNull(template);
    }

    @Override
    public void action() {
        var lastMessage = getAgent().receive(template);
        if (lastMessage == null) {
            block();
        } else {
            onMessageReceived(lastMessage);
        }
    }

    public void onMessageReceived(ACLMessage message) { /* to be overridden */ }
}
