import jade.core.behaviours.CyclicBehaviour; // new entry!

public class ExampleAgent extends Agent {
    @Override
    protected void setup() {
        addBehaviour(mainBehaviour());
    }

    private int round;

    @Override
    private Behaviour mainBehaviour() {
        return new CyclicBehaviour() {
            @Override
            public void action() {
                log("Hello world! (%d)", round++);
            } 
        };
    }
}