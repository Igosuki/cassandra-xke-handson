#Self-Contained inti, assumes that cassandra is at /home/notroot/cassandra
echo 'setting cassandra_home'
CASSANDRA_CONF=/home/notroot/startup/3/

CLASSPATH=$CASSANDRA_CONF

for jar in  $CASSANDRA_HOME/lib/*.jar; do
    CLASSPATH=$CLASSPATH:$jar
done

for jar in $CASSANDRA_HOME/build/*.jar; do
    CLASSPATH=$CLASSPATH:$jar
done
