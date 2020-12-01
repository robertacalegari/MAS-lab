package it.unibo.pikalab.jade.test.agents;

import it.unibo.pikalab.jade.test.TestingAgent;
import it.unibo.pikalab.jade.Behaviours;
import jade.core.behaviours.Behaviour;

public class TestParallelOrAgent extends TestingAgent {
    @Override
    public Behaviour mainBehaviour() {
        return Behaviours.sequence(
                Behaviours.any(
                        Behaviours.sequence(
                                Behaviours.atomic(() -> log("a")),
                                Behaviours.atomic(() -> log("b")),
                                Behaviours.atomic(() -> log("c"))
                        ),
                        Behaviours.sequence(
                                Behaviours.atomic(() -> log("1")),
                                Behaviours.atomic(() -> log("2")),
                                Behaviours.atomic(() -> log("3")),
                                Behaviours.atomic(() -> log("4")),
                                Behaviours.atomic(() -> log("5"))
                        )
                ),
                Behaviours.stop()
        );
    }
}
