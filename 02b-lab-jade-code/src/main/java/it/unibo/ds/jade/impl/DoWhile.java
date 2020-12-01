package it.unibo.ds.jade.impl;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CompositeBehaviour;
import jade.util.leap.ArrayList;
import jade.util.leap.Collection;

import java.util.Objects;

public class DoWhile extends CompositeBehaviour {

    private final Behaviour behaviour;

    public DoWhile(Behaviour behaviour) {
        this.behaviour = Objects.requireNonNull(behaviour);
    }

    @Override
    protected void scheduleFirst() { /* does nothing */ }

    @Override
    protected void scheduleNext(boolean b, int i) { /* does nothing */ }

    @Override
    protected boolean checkTermination(boolean b, int i) {
        throw new Error("not implemented");
    }

    public boolean condition() {
        throw new Error("not implemented");
    }

    @Override
    protected Behaviour getCurrent() {
        return behaviour;
    }

    @Override
    public Collection getChildren() {
        var list = new ArrayList();
        list.add(behaviour);
        return list;
    }
}