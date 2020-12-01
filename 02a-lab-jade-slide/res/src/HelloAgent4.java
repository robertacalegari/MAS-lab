public class ExampleAgent extends Agent {
  @Override protected void setup() {
    addBehaviour(print("First"));
    addBehaviour(printMany("Second"));
    addBehaviour(print("Third"));
  }

  @Override private Behaviour print(String message) {
    return new OneShotBehaviour() {
      @Override public void action() { log(message); }
    };
  }

  @Override private Behaviour printMany(String message) {
    return new OneShotBehaviour() {
      @Override public void action() { while (true) log(message); }
    };
  }
}