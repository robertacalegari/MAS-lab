import jade.core.Agent;
import jade.core.behaviours.Behaviour;

// a number of facility methods for building behaviours
import static it.unibo.ds.jade.Behaviours.*; 

public class ExampleAgent extends Agent {
    @Override
    protected void setup() {
        addBehaviour(mainBehaviour());
        addBehaviour( /* other behaviours */ );
    }

    @Override
    private Behaviour mainBehaviour() {
    	// build behaviour here
    }
    
    private void log(String format, Object... args) {
        // outputs formatted lines
    }
}