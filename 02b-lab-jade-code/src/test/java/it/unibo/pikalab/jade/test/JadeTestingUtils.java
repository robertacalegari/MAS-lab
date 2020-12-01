package it.unibo.pikalab.jade.test;

import jade.core.Agent;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import jade.wrapper.PlatformController;

import java.util.logging.Logger;

public class JadeTestingUtils {

    private static final Logger L = Logger.getLogger(TestBasicBehaivours.class.getName());
    private static PlatformController platform;

    private JadeTestingUtils() {
        throw new IllegalStateException(
                String.format(
                        "Class %s cannot be instantiated: it can only contain static methods",
                        JadeTestingUtils.class
                )
        );
    }

    public static synchronized void startNewPlatform() {
        if (platform == null) {
            L.info("Starting platform");
            platform = Runtime.instance().createMainContainer(new ProfileImpl());
            L.info("Started platform");
        } else {
            throw new IllegalStateException("A Jade platform is already running");
        }
    }

    public static synchronized void stopPlatform() {
        if (platform != null) {
            L.info("Shutting down platform");
            Runtime.instance().shutDown();
            L.info("Shutted down platform");
            platform = null;
        } else {
            throw new IllegalStateException("A Jade platform must be running");
        }
    }

    public static synchronized <A extends TestingAgent> A spawnTestAgent(String localName, Class<A> klass, Object... args) {
        try {
            var controller = spawnAgent(localName, klass, args);
            controller.start();
            return (A) TestingAgent.getInstanceByName(controller.getName());
        } catch (ControllerException | InterruptedException e) {
            throw new Error(e);
        }
    }

    public static synchronized <A extends Agent> AgentController spawnAgent(String localName, Class<A> klass, Object... args) {
        if (platform != null) {
            try {
                var controller = platform.createNewAgent(localName, klass.getName(), args);
                controller.start();
                return controller;
            } catch (ControllerException e) {
                throw new Error(e);
            }
        } else {
            throw new IllegalStateException("A Jade platform must be running");
        }
    }
}
