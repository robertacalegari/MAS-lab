package it.unibo.ds.jade.impl;

import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public abstract class Send extends OneShotBehaviour {
    @Override
    public void action() {
        throw new Error("not implemented");
    }

    public abstract ACLMessage getMessage();
}
