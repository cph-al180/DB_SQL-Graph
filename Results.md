As it can be seen by the results in the results image, Neo4j (and even MySQL) is faster than expected (at least to me). I'm personally not entirely sure what the cause of that is, but from the results, it's clear that Neo4j handles "endorsement"-like relations better than MySQL, if not all, SQL databases.
It is also worth noting that the first Cypher query is slower than the rest, possibly because it's creating and cacheing some meta-data, that then can be reused by the others?

[<img src="https://github.com/cph-al180/DB_SQL-Graph/blob/master/Results.png">](https://github.com/cph-al180/DB_SQL-Graph/blob/master/Results.png)
