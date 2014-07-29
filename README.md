RabbitMQ Publish Subscribe with Maven and Eclipse
=================================================

Code based on the [RabbitMQ Pub Sub](http://www.rabbitmq.com/tutorials/tutorial-three-java.html).

Minor modifications to make this more convenient to run from inside Eclipse with the help of m2e.

Changes from the original tutorial code:

  - pom.xml added to declare dependency on rabbitmq client library.
  - 'EmitLog' runs in a loop and reads messages from System.in instead of commandline args.

Importing into Eclipse
======================

You need M2E (maven tooling for Eclipse). Simple import the code in this project as an "Existing Maven Project" and it should be good to go.

Running
=======

Run any number of "EmitLog" and "ReceiveLogs" processes by right click on the 
respective class and use "Run As >> Java Application". You can create additional Eclipse Console Views and pin one console to each process. Any messages you type
in a "EmitLog" console will be broadcast to all the "ReceiveLogs" processes.

EmitLog and ReceiveLogs processes can be started or killed at any time.