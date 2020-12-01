public abstract class CyclicBehaviour extends SimpleBehaviour {
    public CyclicBehaviour() { }
    
    // callback performing one step of a long-lasting behaviour
    public abstract void action();

    // cyclic behaviours are never done!
    public final boolean done() {
        return false;
    }
}