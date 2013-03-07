#Self-Contained inti, assumes that cassandra is at /home/notroot/cassandra
echo 'setting cassandra_home'
CASSANDRA_CONF="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

CLASSPATH=$CASSANDRA_CONF

for jar in $CASSANDRA_HOME/lib/*.jar; do
    CLASSPATH=$CLASSPATH:$jar
done
