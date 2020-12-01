package it.unibo.pikalab.jade.impl;

import jade.core.behaviours.OneShotBehaviour;

public class Stop extends OneShotBehaviour {
    @Override
    public void action() {
        getAgent().doDelete();
    }
}
