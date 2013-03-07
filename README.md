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

Support slides are at : https://speakerdeck.com/igosuki/cassandra-hands-on-xke-march-2013

** Prepare

- Export dsc-cassandra/bin and opscenter/bin in your PATH
- Because I run 2 JDKs, you must create an env variable JAVA_HOME_7 for the Jdk 1.7 or remove them from the poms
- Make sure cassandra, cassandra-cli, cqlsh, opscenter are working fine.
- Start cassandra with cassandra -f
- Start opsCenter with opscenter

** Build the Hands On

- Execute mvn clean verify at the root
- Update the cassandra.properties in the api test resources to your configuration if you wish to modify it (ex: you already have another conf of Cassandra running)
- Run the test AstyanaxPersistorTest in the api maven module to test the connection
- The data we use is crawled from LastFM running LastFMApiParser in the parser module
- We then read the data through the LocalLastFMParser to get Data Sets to use in Cassandra

** Start on the exercies
- The exercices are unit tests that you have to pass in the api module under com.gepsens.xebia.exercice[0-8]

** Tips

- There is a UUIDGenerator in the test packages

The Cassandra 1.2 Documentation can be found here : http://www.datastax.com/docs/1.2/index
The CQL3 reference can be found here :
- http://www.datastax.com/docs/1.2/cql_cli/index
- http://cassandra.apache.org/doc/cql3/CQL.html
The Astyanax driver documentation :
- https://github.com/Netflix/astyanax/wiki/Create-keyspace-or-column-family
