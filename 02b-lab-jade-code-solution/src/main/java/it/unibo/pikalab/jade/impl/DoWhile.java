package it.unibo.pikalab.jade.impl;

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
        if (behaviour.done()) {        // se il comportamento figlio ha finito...
            if (condition()) {         // ... e devo rimanere nel ciclo ...
                behaviour.reset();     // ... allora resetto il comportamento figlio
                return false;          // ... e rimango nel ciclo
            }
            return true;               // altrimenti interrompo il ciclo
        }
        return false;                  // in ogni altro caso rimango nel ciclo
    }

    public boolean condition() {
        return true;
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