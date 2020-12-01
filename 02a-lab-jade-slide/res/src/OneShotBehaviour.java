public abstract class OneShotBehaviour extends SimpleBehaviour {
    public OneShotBehaviour() { }
    
    // callback invoked whenever the behaviour is scheduled
    public abstract void action();

    // checks whether should be re-scheduled or not
    // (behaviours which are done are NOT re-scheduled)
    public final boolean done() {
        return true;
    }
}