package bahrini.mobaiel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MobileDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public MobileDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertMobile(Mobile mobile) throws SQLException {
        String sql = "INSERT INTO mobile (refernce, brand, price) VALUES (?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, mobile.getRefrence());
        statement.setString(2, mobile.getBrand());
        statement.setFloat(3, mobile.getPrice());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Mobile> listAllMobile() throws SQLException {
        List<Mobile> listMobile = new ArrayList<Mobile>();

        String sql = "SELECT * FROM mobile";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int mobile_id = resultSet.getInt("mobile_id");
            String refernce = resultSet.getString("refernce");
            String brand = resultSet.getString("brand");
            float price = resultSet.getFloat("price");

            Mobile mobile = new Mobile(mobile_id, refernce, brand, price);
            listMobile.add(mobile);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listMobile;
    }

    public boolean deleteMobile(Mobile mobile) throws SQLException {

        String sql = "DELETE FROM mobile where mobile_id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, mobile.getMobile_id());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateMobile(Mobile mobile) throws SQLException {
        String sql = "UPDATE mobile SET refernce = ?, band = ?, price = ?";
        sql += " WHERE mobile_id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, mobile.getRefrence());
        statement.setString(2, mobile.getBrand());
        statement.setFloat(3, mobile.getPrice());
        statement.setInt(4, mobile.getMobile_id();

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public Mobile getMobile(int mobile_id) throws SQLException {
        Mobile mobile = null;
        String sql = "SELECT * FROM mobile WHERE mobile_id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, mobile_id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String refernce = resultSet.getString("refernce");
            String brand = resultSet.getString("brand");
            float price = resultSet.getFloat("price");

            mobile = new Mobile(mobile_id, refernce, brand, price);
        }

        resultSet.close();
        statement.close();

        return mobile;
    }
}
