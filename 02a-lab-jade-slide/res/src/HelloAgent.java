import jade.core.behaviours.OneShotBehaviour; // new entry!

public class ExampleAgent extends Agent {
    @Override
    protected void setup() {
        addBehaviour(mainBehaviour());
    }

    @Override
    private Behaviour mainBehaviour() {
        return new OneShotBehaviour() {  // anonymous class
            @Override                    // extending 
            public void action() {       // OneShotBehaviour
                log("Hello world!");
            } 
        };
    }
}