** Tips **
    - Pretty print Json from the command line : cat unformatted.json | python -m json.tool > formatted.json
**

Exercise 1 :

The aim of the exercice is to make each of the unit tests pass.

For each of the model classes of these unit tests, create a static column family to store the model.
Then implement the a creation and read method.

The answers for Column Family scripts are in test/resources/solution_scripts/static_cfs

Exercise 2 :

We now want for users to be able to like things like Tracks, Artists and Venues.
We need two things :
- A wide row of counters to count hits and likes
- A wide row that indexes what a user likes

The answers for Column Family scripts are in test/resources/solution_scripts/popularity, user_likes

Exercise 3 :

So far we've been able to store things in a certain order, but we now want to go further by using composite indexes
to cluster wide rows.
We want to be able to query Venues given :
- An artist name
- A country

The answers for Column Family scripts are in test/resources/solution_scripts/venue_index.txt

Exercice 4 :

Users are being sent invitations that expire when the Venue has passed. How do we modelize that ?

Hint : you would have to maintain an index for invites, and update that index with a certain property
when adding a user.

The answers for Column Family scripts are in test/resources/solution_scripts/venue_invites.txt

Exercice 5 :

In order to understand the eventual consistency of Cassandra, we will now delete a record.
- Chose a record from the tracks table to delete.
- Make a node go offline that has the record
- Delete it, and then try to read it from both cqlsh and cassandra-cli, what do you see ?
- Make the node come back online, and then get the record from it

Exercice 6 :

We now want to monitor how users navigate our application and do some a/b testing.
- We need clicks ordered by time
- We potentially have a referer (a third party page from which the user came)

The answers for Column Family scripts are in test/resources/solution_scripts/user_click_stream.txt


