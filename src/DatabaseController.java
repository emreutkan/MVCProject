import java.sql.*;

class DatabaseController {
    private static final String URL = "jdbc:mysql://localhost:3306/project3313";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private DatabaseController() {
    }

    private static DatabaseController DatabaseSingleton = null;

    public static synchronized DatabaseController getInstance() {
        if (DatabaseSingleton == null)
            DatabaseSingleton = new DatabaseController();

        return DatabaseSingleton;
    }

    public void InitializeTable() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS stock_table (" +
                    "stock INT NOT NULL, " +
                    "sold INT NOT NULL);";

            statement.executeUpdate(sql);
            System.out.println("Table created or already exists.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = "INSERT INTO stock_table (stock, sold) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, 0); // Set stock to 0
            stmt.setInt(2, 0); // Set sold to 0

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Initial stock entry created successfully.");
            } else {
                System.out.println("Failed to create initial stock entry.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setStock(int stock) {
        String query = "UPDATE stock_table SET stock = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, stock);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Stock updated.");
            } else {
                System.out.println("Stock update failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getStock() {
        int stock = 0;
        String query = "SELECT stock FROM stock_table";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                stock = rs.getInt("stock");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stock;
    }

    public void setSold(int sold) {
        String query = "UPDATE stock_table SET sold = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, sold);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Sold updated.");
            } else {
                System.out.println("Sold update failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getSold() {
        int sold = 0;
        String query = "SELECT sold FROM stock_table";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                sold = rs.getInt("sold");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sold;
    }


}


