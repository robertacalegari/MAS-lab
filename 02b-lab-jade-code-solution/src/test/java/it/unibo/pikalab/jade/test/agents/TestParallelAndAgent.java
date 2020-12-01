package it.unibo.pikalab.jade.test.agents;

import it.unibo.pikalab.jade.test.TestingAgent;
import jade.core.behaviours.Behaviour;

import static it.unibo.pikalab.jade.Behaviours.*;

public class TestParallelAndAgent extends TestingAgent {
    @Override
    public Behaviour mainBehaviour() {
        return sequence(
                all(
                        sequence(
                                atomic(() -> log("a")),
                                atomic(() -> log("b")),
                                atomic(() -> log("c"))
                        ),
                        sequence(
                                atomic(() -> log("1")),
                                atomic(() -> log("2")),
                                atomic(() -> log("3")),
                                atomic(() -> log("4")),
                                atomic(() -> log("5"))
                        )
                ),
                stop()
        );
    }
}
