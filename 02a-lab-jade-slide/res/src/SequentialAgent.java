import static it.unibo.ds.jade.Behaviours.*; // notice this

public class SequentialAgent extends Agent {
    @Override protected void setup() {
        addBehaviour(mainBehaviour());
    }

    @Override public Behaviour mainBehaviour() {
        return sequence(
            atomic(() -> log("a")),
            atomic(() -> log("b")),
            atomic(() -> log("c")),
            stop()
        );
    }
}