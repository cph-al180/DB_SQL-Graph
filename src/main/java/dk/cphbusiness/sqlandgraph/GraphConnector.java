package dk.cphbusiness.sqlandgraph;

import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.v1.*;

public class GraphConnector implements IConnector {

    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "password"));
    String name = "Neo4j";

    @Override
    public List<String> runQuery(String query) {
        StatementResult result;
        try (Session session = driver.session()) {
            result = session.run(query);
        }
        List<String> personNames = new ArrayList<>();
        while (result.hasNext()) {
            Record record = result.next();
            personNames.add(record.get("name").asString());
        }
        return personNames;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<String> getAllNames() {
        return runQuery("MATCH (p:Person)"
                + "RETURN DISTINCT p.name AS name");
    }

    @Override
    public List<String> personEndorsementDepthOne(String personName) {
        return runQuery("MATCH(p:Person {name: \"" + personName + "\"})"
                + "-[:ENDORSES]->(b:Person)"
                + " RETURN DISTINCT b.name as name");
    }

    @Override
    public List<String> personEndorsementDepthTwo(String personName) {
        return runQuery("MATCH(p:Person {name: \"" + name + "\"})"
                + "-[:ENDORSES]->(:Person)"
                + "-[:ENDORSES]->(b:Person)"
                + "RETURN DISTINCT b.name as name");
    }

    @Override
    public List<String> personEndorsementDepthThree(String personName) {
        return runQuery("MATCH(p:Person {name: \"" + name + "\"})"
                + "-[:ENDORSES]->(:Person)"
                + "-[:ENDORSES]->(:Person)"
                + "-[:ENDORSES]->(b:Person)"
                + "RETURN DISTINCT b.name as name");
    }

    @Override
    public List<String> personEndorsementDepthFour(String personName) {
        return runQuery("MATCH(p:Person {name: \"" + name + "\"})"
                + "-[:ENDORSES]->(:Person)"
                + "-[:ENDORSES]->(:Person)"
                + "-[:ENDORSES]->(:Person)"
                + "-[:ENDORSES]->(b:Person)"
                + "RETURN DISTINCT b.name as name");
    }

    @Override
    public List<String> personEndorsementDepthFive(String personName) {
        return runQuery("MATCH(p:Person {name: \"" + name + "\"})"
                + "-[:ENDORSES]->(:Person)"
                + "-[:ENDORSES]->(:Person)"
                + "-[:ENDORSES]->(:Person)"
                + "-[:ENDORSES]->(:Person)"
                + "-[:ENDORSES]->(b:Person)"
                + "RETURN DISTINCT b.name as name");
    }

}
