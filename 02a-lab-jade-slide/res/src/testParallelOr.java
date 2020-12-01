@Test
public void testParallelOr() throws InterruptedException {
  var alice = spawnTestAgent("alice", TestParallelOrAgent.class);
  
  alice.awaitTermination();    // blocks the test's thread
                               // unitl the agent terminates

  Assert.assertEquals(
    List.of("a", "1", "b"), // expected list of logs
    alice.getLogs()  // actual list of logs output by the agent
  );
}
