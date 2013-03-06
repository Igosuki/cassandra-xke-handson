cassandra-xke-handson
=====================

A suite of exercices to learn Cassandra using a web application for use cases

Prerequisites

You can install Cassandra 1.2.2 from the main website (http://cassandra.apache.org/download/)
But for a nicer experience install the latest version of
datastax's cassandra community (1.2.2 at the time) and opscenter (3.0.1 at the time) (which are just cassandra with
nice tools bundled) :
http://www.datastax.com/download/community

Note : I recommend using the 1.6 JDK to run if you want to run Cassandra using 1.7 JDK on MacOSX, use an updated version of snappy java :
http://code.google.com/p/snappy-java/downloads/detail?name=snappy-java-1.0.5-M2.jar&can=2&q=
But it is still buggy

- Export the bins over to your environment path and let's get started.
- Make sure cassandra, cassandra-cli, cqlsh, opscenter are working fine.
- Start the first node in the cassandra/nodes folder : ./start1 (don't forget chmod +x)
- Update the cassandra.properties to your configuration if you wish to modify it (ex: you already have another conf of Cassandra running)
- Run AstyanaxPersistorTest to test the connection

