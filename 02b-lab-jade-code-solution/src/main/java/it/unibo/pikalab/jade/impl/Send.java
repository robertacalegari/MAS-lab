package it.unibo.pikalab.jade.impl;

import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public abstract class Send extends OneShotBehaviour {
    @Override
    public void action() {
        var msg = getMessage();
        msg.setSender(getAgent().getAID());
        getAgent().send(msg);
    }

    public abstract ACLMessage getMessage();
}
