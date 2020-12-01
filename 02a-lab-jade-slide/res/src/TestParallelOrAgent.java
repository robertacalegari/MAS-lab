public class TestParallelOrAgent extends TestingAgent {
  @Override public Behaviour mainBehaviour() {
    return sequence(
      any(
        sequence(
          atomic(() -> log("a")),
          atomic(() -> log("b"))
        ),
        sequence(
          atomic(() -> log("1")),
          atomic(() -> log("2")),
          atomic(() -> log("3"))
        )
      ),
      stop()
    );
  }
}
