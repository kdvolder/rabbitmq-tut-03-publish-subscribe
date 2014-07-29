RabbitMQ Work Quees with Maven and Eclipse
==========================================

Code based on the [RabbitMQ Work Queues Tutorial](https://www.rabbitmq.com/tutorials/tutorial-three-java.html).

Minor modifications to make this more convenient to run from inside Eclise with the help of m2e.

Changes from the original tutorial code:

  - pom.xml added to declare dependency on rabbitmq client library.
  - 'NewTask' runs in a loop and reads tasks from System.in instead of commandline args.

Importing into Eclipse
======================

You need M2E (maven tooling for Eclipse). Simple import the code in this project as an "Existing Maven Project" and it should be good to go.

Running
=======

Like in the original tutorial, you need three consoles. In the first one you run
"NewTask" in the other two "Worker". Use "Run As >> Java Application" to run "NewTask" once and
run "Worker" twice. You can create additional Eclipse Console Views and pin the respective processes
to them.

Any stuff you type in "NewTask" will be posted to the work queue and dispatched to one of the workers.