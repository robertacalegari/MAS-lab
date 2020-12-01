public class ExampleAgent extends Agent {

  @Override
  protected void setup() { 
    addBehaviour(risingCount()); 
    addBehaviour(fallingCount()); 
  }

  private int rising = 0;
  private int falling = 0;

  @Override 
  private Behaviour risingCount() {
    return new CyclicBehaviour() {
      @Override
      public void action() { log("Hello world! (%d)", rising++); }
    };
  }

  @Override 
  private Behaviour fallingCount() {
    return new CyclicBehaviour() {
      @Override
      public void action() { log("Hello world! (%d)", falling--); }
    };
  }
}
