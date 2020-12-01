package it.unibo.pikalab.jade.test;

import it.unibo.pikalab.jade.exercise.SmartPinger;
import it.unibo.pikalab.jade.test.agents.Ponger;
import org.junit.*;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Ignore
public class TestSmartPingPong {
    @BeforeClass
    public static void startPlatform() {
        JadeTestingUtils.startNewPlatform();
    }

    @Test
    public void testPingPong() throws InterruptedException {
        final Random random = new Random();
        var pongerName = "ponger_" + random.nextLong();
        var ponger = JadeTestingUtils.spawnTestAgent(pongerName, Ponger.class);

        var pingerName = "pinger_" + random.nextLong();
        JadeTestingUtils.spawnAgent(pingerName, SmartPinger.class);

        ponger.awaitTermination();

        Assert.assertEquals(
                IntStream.range(0, 2 * Ponger.ROUNDS + 1)
                        .mapToObj(i -> {
                            if (i % 2 == 0) {
                                return "Received `ping` from " + pingerName;
                            } else {
                                return "Sent `pong` to " + pingerName;
                            }
                        }).collect(Collectors.toList()),
                ponger.getLogs()
        );
    }

    @AfterClass
    public static void stopPlatform() {
        JadeTestingUtils.stopPlatform();
    }
}
