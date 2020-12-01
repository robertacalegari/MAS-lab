## TODO

### Exercise 1

0. Inspect and understand the following classes:
    - `it.unibo.ds.jade.Behaviours`
    - `it.unibo.ds.jade.impl.*`
    - `it.unibo.ds.jade.test.TestBasicBehaivours`

1. Provide an implementation for the methods in `it.unibo.ds.jade.Behaviours` in such a way that all tests in `it.unibo.ds.jade.test.TestBasicBehaivours` succeed
    1. Focus on the `atomic` and `stop` behaviours, first
    1. Then focus on the `sequence` behaviour
    1. Then focus on the `any` and `all` behaviours
    1. Then focus on the `repeatWhile` and `repeatForEver` behaviours
    1. Then focus on the `send` behaviour
    1. Then focus on the `receive` behaviour
    
### Exercise 2

0. Inspect and understand the following classes:
    - `it.unibo.ds.jade.exercise.Pinger`
    - `it.unibo.ds.jade.test.agents.Ponger`
    - `it.unibo.ds.jade.test.TestPingPong`
    
1. Provide an implementation for the `Pinger` in such a way that all tests in `it.unibo.ds.jade.test.TestPingPong` succeed

### Exercise 3

0. Inspect and understand the following classes:
    - `it.unibo.ds.jade.exercise.SmartPinger`
    - `it.unibo.ds.jade.test.agents.Ponger`
    - `it.unibo.ds.jade.test.TestSmartPingPong`
    
    What are the main differences with exercise 2?
    
    > HINT: the `SmartPinger`'s and `Ponger`'s names are randomly generated in `TestSmartPingPong`
    
1. Provide an implementation for the `SmartPinger` in such a way that all tests in `it.unibo.ds.jade.test.TestSmartPingPong` succeed