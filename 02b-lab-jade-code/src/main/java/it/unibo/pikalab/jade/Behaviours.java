package it.unibo.pikalab.jade;

import it.unibo.ds.jade.impl.*;
import it.unibo.pikalab.jade.impl.DoWhile;
import it.unibo.pikalab.jade.impl.Listen;
import it.unibo.pikalab.jade.impl.Receive;
import it.unibo.pikalab.jade.impl.Send;
import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static it.unibo.pikalab.jade.Messages.message;

public class Behaviours {

    private Behaviours() {
        throw new IllegalStateException(
                String.format(
                        "Class %s cannot be instantiated: it can only contain static methods",
                        Behaviours.class
                )
        );
    }

    public static Behaviour atomic(Runnable action) {
        throw new Error("not implemented");
    }

    public static Behaviour sequence(Behaviour behaviour, Behaviour... behaviours) {
        throw new Error("not implemented");
    }

    private static Behaviour parallel(int endCondition, Behaviour behaviour, Behaviour... behaviours) {
        throw new Error("not implemented");
    }

    public static Behaviour any(Behaviour behaviour, Behaviour... behaviours) {
        return parallel(ParallelBehaviour.WHEN_ANY, behaviour, behaviours);
    }

    public static Behaviour all(Behaviour behaviour, Behaviour... behaviours) {
        return parallel(ParallelBehaviour.WHEN_ALL, behaviour, behaviours);
    }

    public static Behaviour stop() {
        throw new Error("not implemented");
    }

    public static Behaviour sendMessage(Supplier<ACLMessage> message) {
        throw new Error("not implemented. consider using " + Send.class);
    }

    public static Behaviour sendMessage(ACLMessage message) {
        return sendMessage(() -> message);
    }

    public static Behaviour sendMessage(Performative performative, Supplier<String> content, AID receiver, AID... otherReceivers) {
        return sendMessage(() -> Messages.message(performative, content, receiver, otherReceivers));
    }

    public static Behaviour sendMessage(Performative performative, String content, AID receiver, AID... otherReceivers) {
        return sendMessage(Messages.message(performative, content, receiver, otherReceivers));
    }

    public static Behaviour receiveMessage(Consumer<ACLMessage> messageReceived) {
        return receiveMessage(MessageTemplate.MatchAll(), messageReceived);
    }

    public static Behaviour receiveMessage(MessageTemplate template, Consumer<ACLMessage> messageReceived) {
        throw new Error("not implemented. consider using " + Receive.class);
    }

    public static Behaviour listen(Consumer<ACLMessage> messageReceived) {
        return listen(MessageTemplate.MatchAll(), messageReceived);
    }

    public static Behaviour listen(MessageTemplate template, Consumer<ACLMessage> messageReceived) {
        throw new Error("not implemented. consider using " + Listen.class);
    }

    public static Behaviour repeatWhile(Behaviour behaviour, Supplier<Boolean> condition) {
        throw new Error("not implemented. consider using " + DoWhile.class);
    }

    public static Behaviour repeatForEver(Behaviour behaviour) {
        throw new Error("not implemented. consider using " + DoWhile.class);
    }
}
