package dk.cphbusiness.sqlandgraph;

import java.util.List;

public interface IConnector {
    String getName();
    List<String> runQuery(String query);
    List<String> getAllNames();
    List<String> personEndorsementDepthOne(String personName);
    List<String> personEndorsementDepthTwo(String personName);
    List<String> personEndorsementDepthThree(String personName);
    List<String> personEndorsementDepthFour(String personName);
    List<String> personEndorsementDepthFive(String personName);
}
