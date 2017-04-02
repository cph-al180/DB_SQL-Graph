package dk.cphbusiness.sqlandgraph;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLConnector implements IConnector {

    String name = "MySQL";

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<String> runQuery(String query) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/sqlandgraph";
        String user = "root";
        String password = "root";

        try {

            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery(query);

            List<String> names = new ArrayList<>();

            while (rs.next()) {
                names.add(rs.getString(1));
            }

            return names;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex);
            }
        }

        return null;
    }

    @Override
    public List<String> getAllNames() {
        return runQuery("SELECT name FROM t_user");
    }

    @Override
    public List<String> personEndorsementDepthOne(String personName) {
        return runQuery("SELECT DISTINCT name FROM t_user "
                + "JOIN t_endorsements ON source_node_id = (SELECT node_id FROM t_user WHERE name = '" + name + "') "
                + "AND target_node_id = node_id");
    }

    @Override
    public List<String> personEndorsementDepthTwo(String personName) {
        return runQuery("SELECT DISTINCT name FROM t_user "
                + "JOIN t_endorsements ON source_node_id = (SELECT node_id FROM t_user WHERE name = '" + name + "') "
                + "AND target_node_id IN (SELECT source_node_id FROM t_endorsements WHERE target_node_id = node_id)");
    }

    @Override
    public List<String> personEndorsementDepthThree(String personName) {
        return runQuery("SELECT DISTINCT name FROM t_user "
                + "JOIN t_endorsements ON source_node_id = (SELECT node_id FROM t_user WHERE name = '" + name + "') "
                + "AND target_node_id IN (SELECT source_node_id FROM t_endorsements WHERE target_node_id IN "
                + "(SELECT source_node_id FROM t_endorsements WHERE target_node_id = node_id))");
    }

    @Override
    public List<String> personEndorsementDepthFour(String personName) {
        return runQuery("SELECT DISTINCT name FROM t_user "
                + "JOIN t_endorsements ON source_node_id = (SELECT node_id FROM t_user WHERE name = '" + name + "') "
                + "AND target_node_id IN (SELECT source_node_id FROM t_endorsements WHERE target_node_id IN "
                + "(SELECT source_node_id FROM t_endorsements WHERE target_node_id IN "
                + "(SELECT source_node_id FROM t_endorsements WHERE target_node_id = node_id)))");
    }

    @Override
    public List<String> personEndorsementDepthFive(String personName) {
        return runQuery("SELECT DISTINCT name FROM t_user "
                + "JOIN t_endorsements ON source_node_id = (SELECT node_id FROM t_user WHERE name = '" + name + "') "
                + "AND target_node_id IN (SELECT source_node_id FROM t_endorsements WHERE target_node_id IN "
                + "(SELECT source_node_id FROM t_endorsements WHERE target_node_id IN "
                + "(SELECT source_node_id FROM t_endorsements WHERE target_node_id IN "
                + "(SELECT source_node_id FROM t_endorsements WHERE target_node_id = node_id))))");
    }

}
